package com.example.app_ninho;

import java.util.ArrayList;
import java.util.List;

/** Entrega o formulário de cada módulo clínico e informa quais já estão disponíveis. */
public final class Formularios {

    private Formularios() { }

    public static boolean disponivel(ModuloClinico modulo) {
        return !para(modulo).isEmpty();
    }

    public static List<Pergunta> para(ModuloClinico modulo) {
        switch (modulo) {
            case FEZES:
                return FormularioCoco.perguntas();
            case PELE:
                return FormularioPele.perguntas();
            case UMBIGO:
                return FormularioUmbigo.perguntas();
            case FEBRE_RESPIRACAO:
                return FormularioFebre.perguntas();
            case CHORO_COLICA:
                return FormularioChoro.perguntas();
            case AMAMENTACAO:
                return FormularioAmamentacao.perguntas();
            default:
                return new ArrayList<>();
        }
    }
}