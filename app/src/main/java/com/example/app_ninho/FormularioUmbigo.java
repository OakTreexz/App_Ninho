package com.example.app_ninho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Conteúdo do módulo Umbigo (coto umbilical): 10 perguntas, níveis e condutas
 * (UMBIGO_FORM.pdf). Os textos foram simplificados para linguagem comum e
 * precisam de validação clínica.
 */
public final class FormularioUmbigo {

    private FormularioUmbigo() { }

    public static List<Pergunta> perguntas() {
        List<Pergunta> l = new ArrayList<>();

        l.add(new Pergunta("Vermelhidão",
                "A pele ao redor do umbigo ou na barriguinha do bebê está vermelha ou "
                        + "inchada?",
                null,
                Arrays.asList(
                        vermelho("Sim, a vermelhidão está espalhada pela pele da barriga "
                                        + "(com ou sem inchaço)",
                                "Sinal de alarme de infecção grave do umbigo (onfalite). "
                                        + "Avaliação médica imediata."),
                        comum("Sim, mas é só uma vermelhidão leve bem na borda do umbigo, "
                                        + "principalmente depois da limpeza",
                                "Vermelhidão passageira, comum com o uso do álcool 70%. "
                                        + "Mantenha a higiene e observe se a vermelhidão se "
                                        + "espalha."),
                        normal("Não",
                                "Pele ao redor do umbigo com aspecto saudável."))));

        l.add(new Pergunta("Pus ou mau cheiro",
                "O umbigo tem secreção amarelada ou esverdeada (pus) ou mau cheiro forte?",
                null,
                Arrays.asList(
                        vermelho("Muito pus junto com vermelhidão espalhada pela pele da "
                                        + "barriga (com ou sem mau cheiro)",
                                "Sinal de perigo. Avaliação médica urgente."),
                        amarelo("Pouco pus ou secreção amarelada só no umbigo, sem "
                                        + "vermelhidão na barriga",
                                "Pode indicar infecção localizada. Agende avaliação na "
                                        + "Unidade Básica de Saúde (UBS) em até 48 horas. Lave "
                                        + "com água e sabão, seque bem e use antibiótico local "
                                        + "apenas se for prescrito."),
                        normal("Não, sem pus e sem mau cheiro",
                                "Sem secreção com pus ou sinal de infecção."))));

        l.add(new Pergunta("Queda do coto",
                "Qual é a situação atual do umbigo do seu bebê?",
                null,
                Arrays.asList(
                        normal("O coto já caiu",
                                "O coto caiu normalmente."),
                        comum("O coto ainda não caiu e o bebê tem 21 dias de vida ou menos",
                                "O coto costuma cair entre 6 e 15 dias, mas pode levar até 21 "
                                        + "dias com segurança. Mantenha a região limpa e seca, "
                                        + "usando apenas álcool 70% pelo menos 1 vez ao dia, "
                                        + "depois do banho ou se sujar de cocô ou xixi."),
                        amarelo("O coto ainda não caiu e o bebê já passou de 21 dias de vida",
                                "Queda tardia do coto. Agende consulta na UBS para o pediatra "
                                        + "avaliar o umbigo e a cicatrização."))));

        l.add(new Pergunta("Carocinho depois da queda",
                "Depois que o umbigo caiu, ficou uma “bolinha” ou carne vermelha ou rosada no "
                        + "fundo, que solta um líquido claro?",
                "Se o coto ainda não caiu, responda Não.",
                Arrays.asList(
                        amarelo("Sim",
                                "Pode ser um granuloma umbilical (um pedacinho de carne macia "
                                        + "e esponjosa). Agende consulta na UBS para avaliação "
                                        + "e possível tratamento."),
                        normal("Não",
                                "Cicatrização depois da queda dentro do esperado."))));

        l.add(new Pergunta("Amarelado na pele",
                "Olhe a cor da pele abaixo da linha do umbigo, em direção às perninhas, "
                        + "coxas ou pés. Ela está amarelada?",
                null,
                Arrays.asList(
                        vermelho("Sim, o amarelado já chegou às pernas, coxas ou pés",
                                "Amarelado que chegou às pernas, coxas ou pés indica icterícia "
                                        + "avançada, com nível alto de bilirrubina no sangue, e "
                                        + "exige avaliação médica urgente. Depois do "
                                        + "atendimento, veja o módulo Pele e amarelão."),
                        amarelo("Sim, mas o amarelado está só acima do umbigo (rosto ou peito)",
                                "Icterícia leve a moderada. Procure a UBS para acompanhar se a "
                                        + "cor amarela não está descendo. Ao terminar, faça "
                                        + "também o formulário Pele e amarelão."),
                        normal("Não, sem nenhum tom amarelado na pele",
                                "Pele com a cor habitual, sem sinais de icterícia."))));

        l.add(new Pergunta("Objetos ou substâncias",
                "Você está colocando faixas, moedas, esparadrapo, pós, cremes, óleos, extratos "
                        + "ou outras substâncias caseiras em cima do umbigo do bebê?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Essa prática não é recomendada pelo Ministério da Saúde, "
                                        + "porque aumenta o risco de infecção grave (onfalite). "
                                        + "Retire os objetos e as faixas agora, lave com água e "
                                        + "sabão e use apenas álcool 70%."),
                        normal("Não",
                                "Higiene e cuidados com o coto feitos de forma correta."))));

        l.add(new Pergunta("Umbigo estufado",
                "O umbigo estufa para fora, formando uma “bolha” macia que fica maior quando "
                        + "o bebê chora ou faz força?",
                null,
                Arrays.asList(
                        amarelo("Sim, o umbigo forma uma pequena bolha coberta por pele normal",
                                "Provável hérnia umbilical benigna. Agende consulta de rotina "
                                        + "na UBS. Atenção: não aplique nada no local e não use "
                                        + "faixas, moedas, esparadrapo ou tecidos para segurar a "
                                        + "hérnia, pois isso pode machucar a pele e causar "
                                        + "infecção grave."),
                        normal("Não",
                                "Região do umbigo sem estufamento anormal."))));

        l.add(new Pergunta("Cirurgia na barriga",
                "O bebê nasceu com alguma condição na parede da barriga ou do umbigo (como "
                        + "onfalocele ou gastrosquise) e já fez a cirurgia de correção?",
                null,
                Arrays.asList(
                        amarelo("Sim, o bebê já fez a cirurgia de correção",
                                "Cuide da cicatriz: mantenha-a limpa e seca, lavando com água e "
                                        + "sabão neutro no banho, e não aplique cremes, pomadas "
                                        + "ou pós sem prescrição médica. Se a cicatriz tiver "
                                        + "vermelhidão que se espalha, inchaço, pus, cheiro forte, "
                                        + "ou se o bebê tiver febre ou chorar de dor ao toque, "
                                        + "procure a emergência imediatamente. Mantenha as "
                                        + "consultas de acompanhamento em dia."),
                        normal("Não",
                                "Parede da barriga e umbigo sem histórico de cirurgia no "
                                        + "local."))));

        l.add(new Pergunta("Aspecto do coto",
                "Qual é a cor e o aspecto atual do coto umbilical do seu bebê?",
                null,
                Arrays.asList(
                        normal("O coto já caiu",
                                "Coto já desprendido."),
                        comum("Escuro (castanho, preto ou marrom) e bem seco",
                                "Aspecto normal da secagem gradual do cordão. Mantenha limpo e "
                                        + "seco com álcool 70%."),
                        vermelho("Escuro ou amarelado, com pus ou líquido grudento e cheiro "
                                        + "muito forte ou de podre",
                                "Sinal de tecido morto com infecção grave do umbigo "
                                        + "(onfalite). Avaliação médica imediata."),
                        normal("Nenhuma dessas: sem pus e sem cheiro forte",
                                "Sem sinais de infecção no coto."))));

        l.add(new Pergunta("Sangramento",
                "O umbigo do bebê sangra?",
                null,
                Arrays.asList(
                        vermelho("Sangramento em grande quantidade ou escorrendo sem parar",
                                "Sangramento forte no umbigo precisa de atendimento imediato "
                                        + "para ser controlado e tratado."),
                        comum("Só um pingo ou pontinho de sangue seco na fralda, ou logo "
                                        + "depois de o coto cair",
                                "Pequeno sangramento é comum quando o coto cai. Limpe com "
                                        + "álcool 70%, mantenha seco e observe."),
                        normal("Não, sem nenhum sangramento",
                                "Sem sangramento no umbigo."))));

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