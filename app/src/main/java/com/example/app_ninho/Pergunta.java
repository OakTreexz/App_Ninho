package com.example.app_ninho;

import java.util.List;

/** Uma pergunta do formulário com suas alternativas. */
public class Pergunta {

    private final String rotuloCurto; // usado no resultado e no pop-up (ex.: "Cor")
    private final String texto;
    private final String dica;        // pode ser null
    private final List<Opcao> opcoes;

    public Pergunta(String rotuloCurto, String texto, String dica, List<Opcao> opcoes) {
        this.rotuloCurto = rotuloCurto;
        this.texto = texto;
        this.dica = dica;
        this.opcoes = opcoes;
    }

    public String getRotuloCurto() { return rotuloCurto; }
    public String getTexto() { return texto; }
    public String getDica() { return dica; }
    public List<Opcao> getOpcoes() { return opcoes; }
}