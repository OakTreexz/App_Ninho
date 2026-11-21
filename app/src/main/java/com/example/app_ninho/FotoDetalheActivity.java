package com.example.app_ninho;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

import java.util.List;

/** Tela 3 da Galeria: uma foto em detalhe, com a cor do semáforo e a orientação. */
public class FotoDetalheActivity extends AppCompatActivity {

    private static final String EXTRA_MODULO = "modulo";
    private static final String EXTRA_INDICE = "indice";

    public static void abrir(Context contexto, ModuloClinico modulo, int indice) {
        Intent intent = new Intent(contexto, FotoDetalheActivity.class);
        intent.putExtra(EXTRA_MODULO, modulo.name());
        intent.putExtra(EXTRA_INDICE, indice);
        contexto.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_foto_detalhe);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.raiz), (v, insets) -> {
            Insets barras = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, barras.top, 0, barras.bottom);
            return insets;
        });

        String nome = getIntent().getStringExtra(EXTRA_MODULO);
        final ModuloClinico modulo =
                (nome == null) ? ModuloClinico.FEZES : ModuloClinico.valueOf(nome);
        int indice = getIntent().getIntExtra(EXTRA_INDICE, 0);

        List<FotoGaleria> fotos = Galeria.fotos(modulo);
        if (indice < 0 || indice >= fotos.size()) {
            finish();
            return;
        }
        FotoGaleria foto = fotos.get(indice);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(modulo.getTitulo()));
        toolbar.setNavigationOnClickListener(v -> finish());

        // Foto grande: se ainda não há imagem, mostra o quadro reservado
        ImageView imagem = findViewById(R.id.iv_foto);
        TextView rotulo = findViewById(R.id.tv_rotulo);
        if (foto.getImagem() != 0) {
            imagem.setImageResource(foto.getImagem());
            imagem.setContentDescription(foto.getTitulo());
            imagem.setVisibility(View.VISIBLE);
            rotulo.setVisibility(View.GONE);
        } else {
            imagem.setVisibility(View.GONE);
            rotulo.setVisibility(View.VISIBLE);
        }

        // Etiqueta com a cor do semáforo
        ((TextView) findViewById(R.id.tv_nivel)).setText(NivelUi.nome(foto.getNivel()));
        findViewById(R.id.v_ponto).setBackgroundTintList(
                ColorStateList.valueOf(NivelUi.cor(this, foto.getNivel())));

        ((TextView) findViewById(R.id.tv_titulo)).setText(foto.getTitulo());
        ((TextView) findViewById(R.id.tv_descricao)).setText(foto.getDescricao());
        ((TextView) findViewById(R.id.tv_conduta)).setText(foto.getConduta());
        ((TextView) findViewById(R.id.tv_fonte)).setText(foto.getFonte());

        // Atalho para a triagem do mesmo assunto
        MaterialButton botao = findViewById(R.id.btn_triagem);
        if (Formularios.disponivel(modulo)) {
            botao.setOnClickListener(v -> TriagemFezesActivity.abrir(this, modulo));
        } else {
            botao.setVisibility(View.GONE);
        }
    }
}