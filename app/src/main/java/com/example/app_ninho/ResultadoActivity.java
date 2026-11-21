package com.example.app_ninho;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

/** Resultado final do formulário (verde ou amarelo). O vermelho é tratado por pop-up. */
public class ResultadoActivity extends AppCompatActivity {

    private static final String EXTRA_MODULO = "modulo";
    private static final String EXTRA_NIVEL = "nivel";
    private static final String EXTRA_TITULOS = "titulos";
    private static final String EXTRA_CONDUTAS = "condutas";

    public static void abrir(Context contexto, ModuloClinico modulo, NivelRisco nivel,
                             ArrayList<String> titulos, ArrayList<String> condutas) {
        Intent intent = new Intent(contexto, ResultadoActivity.class);
        intent.putExtra(EXTRA_MODULO, modulo.name());
        intent.putExtra(EXTRA_NIVEL, nivel.name());
        intent.putStringArrayListExtra(EXTRA_TITULOS, titulos);
        intent.putStringArrayListExtra(EXTRA_CONDUTAS, condutas);
        contexto.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        View painel = findViewById(R.id.painel);
        final int p = dp(24);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.raiz), (v, insets) -> {
            Insets barras = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            painel.setPadding(p, barras.top + p, p, p);
            v.setPadding(0, 0, 0, barras.bottom);
            return insets;
        });

        String nomeModulo = getIntent().getStringExtra(EXTRA_MODULO);
        final ModuloClinico modulo = (nomeModulo == null)
                ? ModuloClinico.FEZES : ModuloClinico.valueOf(nomeModulo);
        NivelRisco nivel = NivelRisco.valueOf(getIntent().getStringExtra(EXTRA_NIVEL));

        int corFundo;
        String nome;
        String titulo;
        String resumo;
        String conduta;
        if (nivel == NivelRisco.VERDE) {
            corFundo = R.color.semaforo_verde;
            nome = "Verde";
            titulo = "Cuidados em casa";
            resumo = "Nenhum sinal de alerta foi encontrado nas respostas.";
            conduta = "Mantenha os cuidados normais em casa e continue observando o bebê. "
                    + "Se algo mudar, refaça a triagem.";
        } else {
            corFundo = R.color.semaforo_amarelo;
            nome = "Amarelo";
            titulo = "Procure a UBS";
            resumo = "Algumas respostas indicam alterações que merecem avaliação.";
            conduta = "Leia as orientações abaixo e agende avaliação na Unidade Básica de "
                    + "Saúde (UBS). Se o bebê piorar ou surgir algum sinal de alerta, vá à UPA.";
        }

        painel.setBackgroundColor(ContextCompat.getColor(this, corFundo));
        int texto = ContextCompat.getColor(this, R.color.tinta);
        TextView tvTopo = findViewById(R.id.tv_topo);
        TextView tvNivel = findViewById(R.id.tv_nivel);
        TextView tvTitulo = findViewById(R.id.tv_titulo);
        tvTopo.setTextColor(texto);
        tvNivel.setTextColor(texto);
        tvTitulo.setTextColor(texto);
        tvTopo.setText("Resultado da triagem: " + getString(modulo.getTitulo()));
        tvNivel.setText(nome);
        tvTitulo.setText(titulo);

        ((TextView) findViewById(R.id.tv_explicacao)).setText(resumo);
        ((TextView) findViewById(R.id.tv_conduta)).setText(conduta);

        montarLista(getIntent().getStringArrayListExtra(EXTRA_TITULOS),
                getIntent().getStringArrayListExtra(EXTRA_CONDUTAS));

        findViewById(R.id.btn_inicio).setOnClickListener(v -> finish());
        findViewById(R.id.btn_refazer).setOnClickListener(v -> {
            TriagemFezesActivity.abrir(this, modulo);
            finish();
        });
    }

    /** Uma entrada por resposta que gerou orientação: título em negrito + conduta. */
    private void montarLista(ArrayList<String> titulos, ArrayList<String> condutas) {
        TextView rotulo = findViewById(R.id.tv_rotulo_lista);
        LinearLayout lista = findViewById(R.id.lista_pontos);

        if (titulos == null || condutas == null || titulos.isEmpty()) {
            rotulo.setVisibility(View.GONE);
            lista.setVisibility(View.GONE);
            return;
        }

        for (int i = 0; i < titulos.size(); i++) {
            TextView tvTitulo = new TextView(this);
            tvTitulo.setText(titulos.get(i));
            tvTitulo.setTextSize(15);
            tvTitulo.setTypeface(tvTitulo.getTypeface(), android.graphics.Typeface.BOLD);
            tvTitulo.setTextColor(ContextCompat.getColor(this, R.color.tinta));
            if (i > 0) tvTitulo.setPadding(0, dp(16), 0, 0);

            TextView tvConduta = new TextView(this);
            tvConduta.setText(condutas.get(i));
            tvConduta.setTextSize(15);
            tvConduta.setLineSpacing(0, 1.15f);
            tvConduta.setTextColor(ContextCompat.getColor(this, R.color.tinta_suave));
            tvConduta.setPadding(0, dp(2), 0, 0);

            lista.addView(tvTitulo);
            lista.addView(tvConduta);
        }
    }

    private int dp(int valor) {
        return (int) (valor * getResources().getDisplayMetrics().density);
    }
}