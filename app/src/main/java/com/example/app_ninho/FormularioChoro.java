package com.example.app_ninho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Conteúdo do módulo Choro e cólica: 10 perguntas, níveis e condutas
 * (MÓDULO 5 - Choro e Cólica.pdf). Os textos foram simplificados para linguagem
 * comum e precisam de validação clínica.
 */
public final class FormularioChoro {

    private FormularioChoro() { }

    public static List<Pergunta> perguntas() {
        List<Pergunta> l = new ArrayList<>();

        l.add(new Pergunta("Padrão do choro",
                "Com que frequência e duração o bebê tem episódios de choro intenso sem "
                        + "causa aparente?",
                null,
                Arrays.asList(
                        amarelo("Choro intenso todos os dias, por mais de 3 horas por dia, "
                                        + "mais de 3 dias por semana, há semanas (pico entre a 3ª "
                                        + "e a 6ª semana de vida), sem febre ou outros sintomas",
                                "Quadro compatível com a cólica do lactente. Tente manobras de "
                                        + "conforto: contato pele a pele (canguru), ambiente "
                                        + "tranquilo e calor local suave na barriguinha. Agende "
                                        + "avaliação na Unidade Básica de Saúde (UBS) para "
                                        + "descartar outros problemas."),
                        normal("Choro ocasional e de curta duração, que passa logo depois de "
                                        + "mamar, trocar a fralda ou receber aconchego",
                                "Choro é a forma natural de o bebê se comunicar."),
                        amarelo("Choro contínuo, sem pausa, por várias horas seguidas e sem "
                                        + "horário definido",
                                "Agende consulta pediátrica para avaliação presencial."))));

        l.add(new Pergunta("Tipo de choro",
                "Qual é o som e o comportamento do bebê durante o choro?",
                null,
                Arrays.asList(
                        vermelho("Choro agudo, estridente (“em grito”) ou inconsolável por "
                                        + "horas, com muita agitação, tremores ou rigidez, e que "
                                        + "não melhora com nenhum consolo",
                                "Sinal de alerta neurológico ou metabólico, ou de dor aguda "
                                        + "severa. Avaliação médica imediata."),
                        vermelho("Choro muito fraco, rouco, em gemido contínuo, ou bebê muito "
                                        + "prostrado",
                                "Sinal de perigo grave (infecção grave ou sofrimento "
                                        + "respiratório ou neurológico). Avaliação médica "
                                        + "imediata."),
                        normal("Choro forte que se acalma ao ouvir a voz dos pais, ao ser "
                                        + "embalado ou ao ser colocado no peito",
                                "Boa reação emocional e neurológica."))));

        l.add(new Pergunta("Barriguinha",
                "A barriguinha do bebê está visivelmente muito estufada e dura, e ele chora "
                        + "forte ou grita ao ser tocado na barriga?",
                null,
                Arrays.asList(
                        vermelho("Sim",
                                "Barriga muito estufada e dura, com choro forte ao ser tocada, "
                                        + "é sinal de alerta de problema grave no abdômen, como "
                                        + "obstrução intestinal. Avaliação médica urgente."),
                        normal("Não", "Barriga sem sinais de dor intensa ao toque."))));

        l.add(new Pergunta("Vômitos",
                "O choro está acompanhado de vômitos esverdeados ou amarelo-escuros, ou de "
                        + "vômitos volumosos em jacto?",
                null,
                Arrays.asList(
                        vermelho("Vômitos esverdeados (com bile) ou em jacto, que acontecem "
                                        + "a cada mamada",
                                "Vômitos com bile ou em jacto indicam possível obstrução "
                                        + "intestinal, que é uma urgência cirúrgica."),
                        comum("Regurgitações leves e ocasionais (golfadas de leite sem "
                                        + "esforço) depois de mamar, com ganho de peso e bom "
                                        + "humor",
                                "Regurgitação leve é comum e benigna no bebê."),
                        amarelo("Vômitos frequentes de leite coalhado, com perda de peso ou "
                                        + "muita irritação ao golfar",
                                "Pede avaliação para investigar refluxo gastroesofágico. "
                                        + "Agende consulta médica."),
                        normal("Não há vômitos", "Sem vômitos."))));

        l.add(new Pergunta("Mamadas",
                "O bebê chora intensamente durante ou logo depois das mamadas, arqueia o "
                        + "corpo para trás (estica o pescoço) ou recusa o peito por dor?",
                null,
                Arrays.asList(
                        amarelo("Choro forte, corpo arqueado para trás, irritação ao engolir "
                                        + "e recusa para mamar",
                                "Pode indicar doença do refluxo, esofagite ou alergia à "
                                        + "proteína do leite. Agende consulta médica."),
                        normal("O bebê mama tranquilo, aceita bem o peito ou a mamadeira e "
                                        + "relaxa durante a mamada",
                                "Sucção, deglutição e esvaziamento do estômago normais."))));

        l.add(new Pergunta("Energia do bebê",
                "Como está o nível de energia e a resposta do bebê entre os episódios de "
                        + "choro?",
                null,
                Arrays.asList(
                        vermelho("Alterna choro sem parar com períodos de muita moleza, "
                                        + "sonolência profunda em que não acorda para mamar, ou "
                                        + "olhar vago",
                                "Sinal geral de perigo: moleza e pouca reação alternadas com "
                                        + "irritação. Avaliação médica imediata."),
                        normal("Fica irritado nos momentos de cólica, mas nos intervalos fica "
                                        + "desperto, interage com a mãe e faz contato visual",
                                "Estado de vigília e tônus muscular adequados."))));

        l.add(new Pergunta("Choro de fome",
                "O choro acontece principalmente perto dos horários de mamar e melhora "
                        + "logo que o bebê pega o peito de forma contínua?",
                null,
                Arrays.asList(
                        amarelo("Choro constante por fome, com pega incorreta (bochechas "
                                        + "encovadas, dor no mamilo da mãe), mamadas muito curtas "
                                        + "e baixo ganho de peso",
                                "Dificuldade na amamentação. Peça orientação sobre pega e "
                                        + "posição na UBS e acompanhe o ganho de peso do bebê."),
                        normal("Choro de fome que passa com a mamada em livre demanda, com "
                                        + "pega correta (boca bem aberta, lábio inferior virado "
                                        + "para fora) e boa diurese",
                                "Aleitamento em livre demanda adequado."))));

        l.add(new Pergunta("Corpo durante o choro",
                "O que acontece com o corpo do bebê durante o episódio de choro?",
                null,
                Arrays.asList(
                        comum("Dobra as perninhas sobre a barriga, fica vermelho, solta "
                                        + "gases e se acalma em seguida",
                                "Eliminação normal de gases. Auxilie com massagens abdominais "
                                        + "e com a posição de pernas dobradas sobre a barriga."),
                        amarelo("Fica com o corpo esticado e rígido, como uma “tábua”, por "
                                        + "muito tempo, sem conseguir relaxar mesmo depois de "
                                        + "soltar gases",
                                "Pede avaliação para investigar rigidez ou desconforto que "
                                        + "não passa. Agende consulta médica."),
                        normal("Corpo relaxado durante o choro, sem rigidez",
                                "Tônus do corpo sem sinais de alerta."))));

        l.add(new Pergunta("Cansaço do cuidador",
                "A mãe ou o cuidador sente exaustão extrema, desespero ou impulso de "
                        + "chacoalhar ou sacudir o bebê para ele parar de chorar?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Sacudir o bebê pode causar lesões graves no cérebro e nos "
                                        + "olhos. Coloque o bebê em local seguro (berço, de "
                                        + "barriga para cima), afaste-se por alguns minutos para "
                                        + "respirar e peça ajuda à família ou ao serviço de "
                                        + "saúde."),
                        normal("Não", "Suporte emocional do cuidador preservado."))));

        l.add(new Pergunta("Temperatura",
                "O choro vem acompanhado de alteração na temperatura do bebê?",
                "Meça com o termômetro na axila.",
                Arrays.asList(
                        vermelho("Com febre (37,5 °C ou mais) ou com temperatura baixa "
                                        + "(menos de 36,0 °C)",
                                "Febre ou temperatura baixa junto com choro em bebê pequeno "
                                        + "podem indicar infecção grave. Avaliação médica "
                                        + "imediata."),
                        normal("Temperatura normal na axila (entre 36,5 °C e 37,4 °C)",
                                "Temperatura dentro do esperado."))));

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