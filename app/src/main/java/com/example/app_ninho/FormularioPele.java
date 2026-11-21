package com.example.app_ninho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Conteúdo do módulo Pele e icterícia: 10 perguntas, níveis e condutas
 * (Pele_e_Icterícia_FORM.pdf). Onde o PDF só traz o nível, a conduta foi escrita
 * de forma neutra e precisa de validação.
 */
public final class FormularioPele {

    private FormularioPele() { }

    public static List<Pergunta> perguntas() {
        List<Pergunta> l = new ArrayList<>();

        l.add(new Pergunta("Alteração na pele",
                "Você percebeu alguma alteração na pele do bebê?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Uma alteração na pele do bebê pede avaliação. Procure a "
                                        + "Unidade Básica de Saúde (UBS)."),
                        normal("Não", "Sem alterações na pele."))));

        l.add(new Pergunta("Região da fralda",
                "A pele do bebê apresenta vermelhidão na região coberta pela fralda?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Vermelhidão na região da fralda precisa de avaliação. "
                                        + "Procure a Unidade Básica de Saúde (UBS)."),
                        normal("Não", "Região da fralda sem vermelhidão."))));

        l.add(new Pergunta("Descamação",
                "Você percebeu descamação na pele do bebê?",
                null,
                Arrays.asList(
                        comum("Sim",
                                "Descamação isolada, sem outros sinais, não indica alerta. "
                                        + "Continue observando a pele do bebê."),
                        normal("Não", "Sem descamação."))));

        l.add(new Pergunta("Bolhas ou feridas",
                "O bebê apresenta bolhas ou feridas na pele?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Bolhas ou feridas na pele precisam de avaliação. Procure a "
                                        + "Unidade Básica de Saúde (UBS)."),
                        normal("Não", "Sem bolhas ou feridas."))));

        l.add(new Pergunta("Secreção ou pus",
                "Você percebeu secreção ou pus em alguma lesão da pele do bebê?",
                null,
                Arrays.asList(
                        vermelho("Sim",
                                "Secreção ou pus em uma lesão da pele é sinal de alerta. "
                                        + "Atendimento médico imediato."),
                        normal("Não", "Sem secreção ou pus nas lesões."))));

        l.add(new Pergunta("Amarelado",
                "A pele ou a parte branca dos olhos do bebê está amarelada?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Pele ou olhos amarelados precisam de avaliação, considerando "
                                        + "a idade do bebê e quando o sinal começou. Procure a "
                                        + "Unidade Básica de Saúde (UBS)."),
                        normal("Não", "Sem amarelado na pele ou nos olhos."))));

        l.add(new Pergunta("Primeiras 24 horas",
                "A coloração amarelada apareceu nas primeiras 24 horas após o nascimento?",
                null,
                Arrays.asList(
                        vermelho("Sim",
                                "Amarelado que aparece nas primeiras 24 horas após o "
                                        + "nascimento é sinal de alerta. Atendimento médico "
                                        + "imediato."),
                        normal("Não", "O amarelado não apareceu nas primeiras 24 horas."))));

        l.add(new Pergunta("Mãos e pés",
                "Você percebeu coloração amarelada nas mãos ou nas plantas dos pés do bebê?",
                null,
                Arrays.asList(
                        vermelho("Sim",
                                "Amarelado nas mãos ou nas plantas dos pés é sinal de alerta. "
                                        + "Atendimento médico imediato."),
                        normal("Não", "Sem amarelado nas mãos ou nas plantas dos pés."))));

        l.add(new Pergunta("Alteração aumentando",
                "Você percebeu que uma alteração na pele está aumentando ou se espalhando?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Uma alteração na pele que aumenta ou se espalha precisa de "
                                        + "avaliação. Procure a Unidade Básica de Saúde (UBS)."),
                        normal("Não", "Sem alterações aumentando ou se espalhando."))));

        l.add(new Pergunta("Cuidados com a pele",
                "Você tem dúvidas sobre como cuidar da pele do bebê?",
                null,
                Arrays.asList(
                        comum("Sim",
                                "Dúvidas sobre o cuidado com a pele do bebê são comuns. "
                                        + "Converse com a equipe de saúde para ser orientada."),
                        normal("Não", "Sem dúvidas sobre o cuidado com a pele."))));

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