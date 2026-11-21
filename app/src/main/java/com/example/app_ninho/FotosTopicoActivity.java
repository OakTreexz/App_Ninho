package com.example.app_ninho;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

/** Tela 2 da Galeria: fotos de um assunto, com filtro por cor do semáforo. */
public class FotosTopicoActivity extends AppCompatActivity {

    private static final String EXTRA_MODULO = "modulo";

    private List<FotoGaleria> todas;
    private FotoAdapter adapter;
    private TextView tvVazio;

    public static void abrir(Context contexto, ModuloClinico modulo) {
        Intent intent = new Intent(contexto, FotosTopicoActivity.class);
        intent.putExtra(EXTRA_MODULO, modulo.name());
        contexto.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fotos_topico);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.raiz), (v, insets) -> {
            Insets barras = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, barras.top, 0, barras.bottom);
            return insets;
        });

        String nome = getIntent().getStringExtra(EXTRA_MODULO);
        ModuloClinico modulo = (nome == null) ? ModuloClinico.FEZES : ModuloClinico.valueOf(nome);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(modulo.getTitulo()));
        toolbar.setNavigationOnClickListener(v -> finish());

        todas = Galeria.fotos(modulo);
        tvVazio = findViewById(R.id.tv_vazio);

        adapter = new FotoAdapter(foto ->
                FotoDetalheActivity.abrir(this, modulo, todas.indexOf(foto)));

        RecyclerView lista = findViewById(R.id.rv_fotos);
        lista.setLayoutManager(new GridLayoutManager(this, 2));
        lista.setAdapter(adapter);

        ChipGroup chips = findViewById(R.id.chips_nivel);
        chips.setOnCheckedStateChangeListener((grupo, ids) -> {
            int id = ids.isEmpty() ? R.id.chip_todas : ids.get(0);
            if (id == R.id.chip_verde) {
                filtrar(NivelRisco.VERDE);
            } else if (id == R.id.chip_amarelo) {
                filtrar(NivelRisco.AMARELO);
            } else if (id == R.id.chip_vermelho) {
                filtrar(NivelRisco.VERMELHO);
            } else {
                filtrar(null);
            }
        });

        filtrar(null);
    }

    /** nivel = null mostra todas as fotos. */
    private void filtrar(NivelRisco nivel) {
        List<FotoGaleria> lista = new ArrayList<>();
        for (FotoGaleria foto : todas) {
            if (nivel == null || foto.getNivel() == nivel) {
                lista.add(foto);
            }
        }
        adapter.setFotos(lista);
        tvVazio.setVisibility(lista.isEmpty() ? View.VISIBLE : View.GONE);
    }
}