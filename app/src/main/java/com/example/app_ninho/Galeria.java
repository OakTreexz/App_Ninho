package com.example.app_ninho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Conteúdo da aba Galeria: fotos de referência de cada assunto, com o nível do
 * semáforo. As imagens ainda são espaços reservados (imagem = 0). Quando houver
 * fotos com licença livre, basta colocá-las em res/drawable e informar o R.drawable.
 */
public final class Galeria {

    public static final String FONTE_PENDENTE =
            "Fonte da imagem: a definir (órgão de saúde e licença).";

    private Galeria() { }

    public static List<FotoGaleria> fotos(ModuloClinico modulo) {
        switch (modulo) {
            case FEZES:
                return coco();
            default:
                return new ArrayList<>();
        }
    }

    public static boolean temFotos(ModuloClinico modulo) {
        return !fotos(modulo).isEmpty();
    }

    // ---------------- COCÔ ----------------
    private static List<FotoGaleria> coco() {
        ModuloClinico m = ModuloClinico.FEZES;
        return Arrays.asList(
                foto(m, "Amarelado, com grumos", NivelRisco.VERDE,
                        "Cocô amarelo, castanho ou esverdeado, de aspecto pastoso e com "
                                + "grumos.",
                        "Padrão normal. Mantenha os cuidados e a amamentação."),
                foto(m, "Escuro e pegajoso (mecônio)", NivelRisco.VERDE,
                        "Cocô escuro e pegajoso, como o primeiro cocô do bebê, nos "
                                + "primeiros dias de vida.",
                        "É esperado nos primeiros dias. Se continuar escuro depois dos "
                                + "primeiros dias, faça a triagem do Cocô."),
                foto(m, "Muito líquido", NivelRisco.AMARELO,
                        "Cocô aquoso, bem líquido.",
                        "Pode ser diarreia aguda. Inicie a hidratação oral em casa e "
                                + "agende avaliação na Unidade Básica de Saúde (UBS)."),
                foto(m, "Com muco", NivelRisco.AMARELO,
                        "Cocô com muco visível, parecido com catarro ou gosma transparente "
                                + "ou esbranquiçada.",
                        "Pode indicar irritação no intestino, alergia alimentar ou "
                                + "infecção leve. Agende consulta com o pediatra."),
                foto(m, "Com sangue vivo", NivelRisco.VERMELHO,
                        "Cocô com sangue vivo (vermelho) ou raias e pintas de sangue "
                                + "visíveis.",
                        "Procure a UPA ou o Pronto-Socorro."),
                foto(m, "Branco, cinza ou bege", NivelRisco.VERMELHO,
                        "Cocô de cor branca, cinza ou bege.",
                        "Pode indicar problema no fígado ou nas vias da bile. Procure "
                                + "avaliação médica urgente."));
    }

    private static FotoGaleria foto(ModuloClinico modulo, String titulo, NivelRisco nivel,
                                    String descricao, String conduta) {
        return new FotoGaleria(modulo, titulo, nivel, descricao, conduta, FONTE_PENDENTE, 0);
    }
}