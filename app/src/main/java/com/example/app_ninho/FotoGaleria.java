package com.example.app_ninho;

import androidx.annotation.DrawableRes;

/** Uma foto de referência da galeria, com o nível do semáforo e a orientação. */
public class FotoGaleria {

    private final ModuloClinico modulo;
    private final String titulo;
    private final NivelRisco nivel;
    private final String descricao;
    private final String conduta;
    private final String fonte;
    private final int imagem; // 0 = ainda sem foto (a tela mostra o espaço reservado)

    public FotoGaleria(ModuloClinico modulo, String titulo, NivelRisco nivel,
                       String descricao, String conduta, String fonte,
                       @DrawableRes int imagem) {
        this.modulo = modulo;
        this.titulo = titulo;
        this.nivel = nivel;
        this.descricao = descricao;
        this.conduta = conduta;
        this.fonte = fonte;
        this.imagem = imagem;
    }

    public ModuloClinico getModulo() { return modulo; }
    public String getTitulo() { return titulo; }
    public NivelRisco getNivel() { return nivel; }
    public String getDescricao() { return descricao; }
    public String getConduta() { return conduta; }
    public String getFonte() { return fonte; }

    @DrawableRes
    public int getImagem() { return imagem; }
}