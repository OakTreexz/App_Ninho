package com.example.app_ninho;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Formulário de triagem, uma pergunta por tela. Serve para qualquer módulo:
 * o módulo escolhido na Home define as perguntas.
 */
public class TriagemFezesActivity extends AppCompatActivity {

    private static final String EXTRA_MODULO = "modulo";
    private static final String ESTADO_ATUAL = "atual";
    private static final String ESTADO_RESPOSTAS = "respostas";

    private ModuloClinico modulo;
    private List<Pergunta> perguntas;
    private int[] respostas;   // índice da opção escolhida em cada pergunta (-1 = sem resposta)
    private int atual = 0;

    private TextView tvContador;
    private TextView tvPergunta;
    private TextView tvDica;
    private RadioGroup rgOpcoes;
    private MaterialButton btnVoltar;
    private MaterialButton btnProxima;
    private LinearProgressIndicator progresso;

    public static void abrir(Context contexto, ModuloClinico modulo) {
        Intent intent = new Intent(contexto, TriagemFezesActivity.class);
        intent.putExtra(EXTRA_MODULO, modulo.name());
        contexto.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_triagem_fezes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.raiz), (v, insets) -> {
            Insets barras = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, barras.top, 0, barras.bottom);
            return insets;
        });

        String nome = getIntent().getStringExtra(EXTRA_MODULO);
        modulo = (nome == null) ? ModuloClinico.FEZES : ModuloClinico.valueOf(nome);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(modulo.getTitulo()));
        toolbar.setNavigationOnClickListener(v -> finish());

        perguntas = Formularios.para(modulo);
        respostas = new int[perguntas.size()];
        Arrays.fill(respostas, -1);
        if (savedInstanceState != null) {
            int[] salvas = savedInstanceState.getIntArray(ESTADO_RESPOSTAS);
            if (salvas != null && salvas.length == respostas.length) {
                respostas = salvas;
                atual = savedInstanceState.getInt(ESTADO_ATUAL, 0);
            }
        }

        tvContador = findViewById(R.id.tv_contador);
        tvPergunta = findViewById(R.id.tv_pergunta);
        tvDica = findViewById(R.id.tv_dica);
        rgOpcoes = findViewById(R.id.rg_opcoes);
        btnVoltar = findViewById(R.id.btn_voltar);
        btnProxima = findViewById(R.id.btn_proxima);
        progresso = findViewById(R.id.progresso);
        progresso.setMax(perguntas.size());

        btnVoltar.setOnClickListener(v -> {
            if (atual > 0) {
                atual--;
                mostrarPergunta();
            }
        });
        btnProxima.setOnClickListener(v -> avancar());

        mostrarPergunta();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ESTADO_ATUAL, atual);
        outState.putIntArray(ESTADO_RESPOSTAS, respostas);
    }

    private void mostrarPergunta() {
        Pergunta pergunta = perguntas.get(atual);
        List<Opcao> opcoes = pergunta.getOpcoes();
        int total = perguntas.size();

        tvContador.setText("Pergunta " + (atual + 1) + " de " + total);
        progresso.setProgressCompat(atual + 1, true);
        tvPergunta.setText(pergunta.getTexto());
        if (pergunta.getDica() == null) {
            tvDica.setVisibility(View.GONE);
        } else {
            tvDica.setText(pergunta.getDica());
            tvDica.setVisibility(View.VISIBLE);
        }

        rgOpcoes.setOnCheckedChangeListener(null);
        rgOpcoes.removeAllViews();
        LayoutInflater inflater = getLayoutInflater();
        for (int i = 0; i < opcoes.size(); i++) {
            RadioButton rb = (RadioButton) inflater.inflate(R.layout.item_opcao, rgOpcoes, false);
            rb.setId(View.generateViewId());
            rb.setText(opcoes.get(i).getRotulo());
            rb.setTag(i);
            rgOpcoes.addView(rb);
        }
        if (respostas[atual] >= 0 && respostas[atual] < opcoes.size()) {
            ((RadioButton) rgOpcoes.getChildAt(respostas[atual])).setChecked(true);
        }

        btnProxima.setEnabled(respostas[atual] >= 0);
        btnProxima.setText(atual == total - 1 ? "Ver resultado" : "Próxima");
        btnVoltar.setEnabled(atual > 0);

        rgOpcoes.setOnCheckedChangeListener((grupo, checkedId) -> {
            RadioButton marcado = grupo.findViewById(checkedId);
            if (marcado == null) return;
            respostas[atual] = (Integer) marcado.getTag();
            btnProxima.setEnabled(true);

            // Regra de curto-circuito: sinal vermelho interrompe o formulário na hora
            Opcao escolhida = perguntas.get(atual).getOpcoes().get(respostas[atual]);
            if (escolhida.getNivel() == NivelRisco.VERMELHO) {
                mostrarAlertaEmergencia(perguntas.get(atual), escolhida);
            }
        });
    }

    private void avancar() {
        if (atual < perguntas.size() - 1) {
            atual++;
            mostrarPergunta();
        } else {
            concluir();
        }
    }

    private void mostrarAlertaEmergencia(Pergunta pergunta, Opcao opcao) {
        String mensagem = "Uma das respostas indica sinal de alerta:\n\n"
                + pergunta.getRotuloCurto() + ": " + opcao.getRotulo() + "\n\n"
                + opcao.getConduta() + "\n\n"
                + "Vá à UPA ou ao Pronto-Socorro mais próximo.";

        new MaterialAlertDialogBuilder(this)
                .setTitle("Procure a emergência")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(mensagem)
                .setCancelable(false)
                .setPositiveButton("Entendi", (dialogo, qual) -> finish())
                .show();
    }

    private void concluir() {
        boolean temAmarelo = false;
        ArrayList<String> titulos = new ArrayList<>();
        ArrayList<String> condutas = new ArrayList<>();

        for (int i = 0; i < perguntas.size(); i++) {
            if (respostas[i] < 0) continue;
            Pergunta pergunta = perguntas.get(i);
            Opcao opcao = pergunta.getOpcoes().get(respostas[i]);

            if (opcao.getNivel() == NivelRisco.AMARELO) {
                temAmarelo = true;
            }
            // Entram na lista as respostas amarelas e as verdes "processo comum"
            if (opcao.getNivel() == NivelRisco.AMARELO || opcao.isDestacar()) {
                titulos.add(pergunta.getRotuloCurto() + ": " + opcao.getRotulo());
                condutas.add(opcao.getConduta());
            }
        }

        NivelRisco nivel = temAmarelo ? NivelRisco.AMARELO : NivelRisco.VERDE;
        ResultadoActivity.abrir(this, modulo, nivel, titulos, condutas);
        finish();
    }
}