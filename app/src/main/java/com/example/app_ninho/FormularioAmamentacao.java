package com.example.app_ninho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Conteúdo do módulo Amamentação: 10 perguntas, níveis e condutas (Amamentação_FORM.pdf).
 * Onde o PDF só traz o nível, a conduta foi escrita de forma neutra e precisa de validação.
 */
public final class FormularioAmamentacao {

    private FormularioAmamentacao() { }

    public static List<Pergunta> perguntas() {
        List<Pergunta> l = new ArrayList<>();

        l.add(new Pergunta("Amamentando",
                "Você está amamentando seu bebê atualmente?",
                null,
                Arrays.asList(
                        normal("Sim", "Amamentação em andamento."),
                        amarelo("Não",
                                "Não estar amamentando no momento pede uma conversa com a "
                                        + "equipe de saúde. Procure a Unidade Básica de Saúde "
                                        + "(UBS)."))));

        l.add(new Pergunta("Posição do bebê",
                "Você sente dificuldade para posicionar o bebê durante a amamentação?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "A dificuldade para posicionar o bebê pede orientação. "
                                        + "Procure a Unidade Básica de Saúde (UBS) para avaliar "
                                        + "a amamentação."),
                        normal("Não", "Posicionamento sem dificuldade."))));

        l.add(new Pergunta("Dor nos mamilos",
                "Você sente dor nos mamilos durante as mamadas?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Dor nos mamilos durante as mamadas precisa de avaliação. "
                                        + "Procure a Unidade Básica de Saúde (UBS)."),
                        normal("Não", "Mamadas sem dor nos mamilos."))));

        l.add(new Pergunta("Rachaduras",
                "Você percebe rachaduras ou fissuras nos mamilos?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Rachaduras ou fissuras nos mamilos precisam de avaliação. "
                                        + "Procure a Unidade Básica de Saúde (UBS)."),
                        normal("Não", "Mamilos sem rachaduras."))));

        l.add(new Pergunta("Mamas",
                "Você sente as mamas muito cheias, endurecidas ou doloridas?",
                null,
                Arrays.asList(
                        normal("Sem desconforto: não sinto as mamas cheias, endurecidas ou "
                                        + "doloridas",
                                "Mantenha os cuidados habituais com a amamentação."),
                        amarelo("Leve desconforto: sinto as mamas cheias ou um pouco "
                                        + "endurecidas, com pouco desconforto",
                                "Cuide das mamas e procure ajuda profissional se o "
                                        + "desconforto persistir ou piorar."),
                        amarelo("Desconforto intenso: sinto as mamas muito endurecidas ou "
                                        + "doloridas, dificultando a amamentação",
                                "Procure avaliação profissional. Se houver febre, calafrios ou "
                                        + "vermelhidão, busque atendimento sem demora."))));

        l.add(new Pergunta("Mama avermelhada",
                "Você percebe alguma área da mama avermelhada, inchada ou quente?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Uma área da mama avermelhada, inchada ou quente requer "
                                        + "avaliação, principalmente se houver piora. Procure a "
                                        + "Unidade Básica de Saúde (UBS)."),
                        normal("Não", "Sem áreas avermelhadas, inchadas ou quentes."))));

        l.add(new Pergunta("Febre ou calafrios",
                "Você apresentou febre ou calafrios junto com dor ou vermelhidão nas mamas?",
                null,
                Arrays.asList(
                        vermelho("Sim",
                                "Febre ou calafrios junto com dor ou vermelhidão nas mamas é "
                                        + "sinal de alerta. Busque atendimento sem demora."),
                        normal("Não", "Sem febre ou calafrios."))));

        l.add(new Pergunta("Pega",
                "Você sente dificuldade para ajudar o bebê a pegar o peito adequadamente?",
                null,
                Arrays.asList(
                        normal("Sem dificuldade: o bebê consegue pegar o peito "
                                        + "adequadamente",
                                "Mantenha os cuidados habituais com a amamentação."),
                        amarelo("Dificuldade ocasional: às vezes preciso reposicionar o bebê "
                                        + "para conseguir a pega",
                                "Peça à equipe de saúde orientações de posicionamento e pega "
                                        + "do bebê."),
                        amarelo("Dificuldade persistente: o bebê tem dificuldade frequente "
                                        + "para pegar o peito, mesmo depois de reposicionar",
                                "Procure ajuda profissional para avaliar a amamentação, "
                                        + "principalmente se o bebê não consegue mamar "
                                        + "adequadamente."))));

        l.add(new Pergunta("Ordenha",
                "Você tem dúvidas sobre como realizar a ordenha do leite materno?",
                null,
                Arrays.asList(
                        comum("Sim",
                                "Dúvidas sobre a ordenha são comuns. Converse com a equipe de "
                                        + "saúde para ser orientada."),
                        normal("Não", "Sem dúvidas sobre a ordenha."))));

        l.add(new Pergunta("Armazenamento",
                "Você tem dúvidas sobre os cuidados de higiene e armazenamento do leite "
                        + "materno ordenhado?",
                null,
                Arrays.asList(
                        comum("Sim",
                                "Dúvidas sobre higiene e armazenamento do leite ordenhado são "
                                        + "comuns. Converse com a equipe de saúde para ser "
                                        + "orientada."),
                        normal("Não", "Sem dúvidas sobre higiene e armazenamento."))));

        return l;
    }

    private static Opcao normal(String rotulo, String conduta) {
        return new Opcao(rotulo, NivelRisco.VERDE, conduta, false);
    }

    private static Opcao comum(String rotulo, String conduta) {
        return new Opcao(rotulo, NivelRisco.VERDE, conduta, true);
    }

    private static Opcao amarelo(String rotulo, String conduta) {
        return new Opcao(rotulo, NivelRisco.AMARELO, conduta, false);
    }

    private static Opcao vermelho(String rotulo, String conduta) {
        return new Opcao(rotulo, NivelRisco.VERMELHO, conduta, false);
    }
}