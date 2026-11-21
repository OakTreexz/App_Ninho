package com.example.app_ninho;

import androidx.annotation.StringRes;

/** Os 6 módulos clínicos do app (RF02 / US03). */
public enum ModuloClinico {
    FEZES(R.string.modulo_fezes, "💩"),
    PELE(R.string.modulo_pele, "🧴"),
    UMBIGO(R.string.modulo_umbigo, "🪢"),
    FEBRE_RESPIRACAO(R.string.modulo_febre, "🌡️"),
    CHORO_COLICA(R.string.modulo_choro, "😢"),
    AMAMENTACAO(R.string.modulo_amamentacao, "🤱");

    private final int titulo;
    private final String emoji;

    ModuloClinico(@StringRes int titulo, String emoji) {
        this.titulo = titulo;
        this.emoji = emoji;
    }

    @StringRes
    public int getTitulo() { return titulo; }

    public String getEmoji() { return emoji; }
}