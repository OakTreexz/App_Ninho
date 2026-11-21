package com.example.app_ninho;

import android.content.Context;

import androidx.core.content.ContextCompat;

/** Nome e cor de cada nível do semáforo, para usar nas telas da galeria. */
public final class NivelUi {

    private NivelUi() { }

    public static String nome(NivelRisco nivel) {
        switch (nivel) {
            case VERDE:
                return "Verde";
            case AMARELO:
                return "Amarelo";
            default:
                return "Vermelho";
        }
    }

    public static int cor(Context contexto, NivelRisco nivel) {
        int recurso;
        switch (nivel) {
            case VERDE:
                recurso = R.color.semaforo_verde;
                break;
            case AMARELO:
                recurso = R.color.semaforo_amarelo;
                break;
            default:
                recurso = R.color.semaforo_vermelho;
                break;
        }
        return ContextCompat.getColor(contexto, recurso);
    }
}