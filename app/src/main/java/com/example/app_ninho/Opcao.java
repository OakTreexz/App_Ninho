package com.example.app_ninho;

/** Uma alternativa de resposta, com o nível de risco e a conduta associados. */
public class Opcao {

    private final String rotulo;
    private final NivelRisco nivel;
    private final String conduta;
    private final boolean destacar; // verde "processo comum": a orientação aparece no resultado

    public Opcao(String rotulo, NivelRisco nivel, String conduta, boolean destacar) {
        this.rotulo = rotulo;
        this.nivel = nivel;
        this.conduta = conduta;
        this.destacar = destacar;
    }

    public String getRotulo() { return rotulo; }
    public NivelRisco getNivel() { return nivel; }
    public String getConduta() { return conduta; }
    public boolean isDestacar() { return destacar; }
}