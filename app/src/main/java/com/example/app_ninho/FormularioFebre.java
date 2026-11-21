package com.example.app_ninho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Conteúdo do módulo Febre e respiração: 10 perguntas, níveis e condutas
 * (Modulo 4 - Febre Respiração.pdf). Os textos foram simplificados para linguagem
 * comum e precisam de validação clínica.
 */
public final class FormularioFebre {

    private FormularioFebre() { }

    public static List<Pergunta> perguntas() {
        List<Pergunta> l = new ArrayList<>();

        l.add(new Pergunta("Febre",
                "Como está a temperatura do bebê?",
                "Meça com termômetro digital na axila.",
                Arrays.asList(
                        vermelho("38,0 °C ou mais, ou entre 37,5 °C e 37,9 °C que não passa "
                                        + "e com o bebê prostrado (muito mole)",
                                "Febre em recém-nascido ou prematuro pode ser sinal inicial de "
                                        + "infecção grave. Avaliação médica imediata."),
                        amarelo("Febrícula: entre 37,5 °C e 37,9 °C, sem outros sintomas",
                                "Tire o excesso de roupa, mantenha o ambiente fresco, ofereça o "
                                        + "peito com mais frequência e meça de novo em 30 a 60 "
                                        + "minutos. Se continuar, agende avaliação médica."),
                        normal("Temperatura normal: entre 36,5 °C e 37,4 °C",
                                "Temperatura dentro do esperado."))));

        l.add(new Pergunta("Temperatura baixa",
                "O bebê parece muito frio ao toque, ou a temperatura na axila está baixa?",
                "Meça com termômetro digital na axila.",
                Arrays.asList(
                        vermelho("Menos de 36,0 °C, ou bebê “geladinho” e prostrado",
                                "Temperatura baixa é um sinal grave de infecção em "
                                        + "recém-nascido e prematuro. Enquanto vai ao "
                                        + "atendimento, aqueça o bebê com contato pele a pele "
                                        + "(método canguru) e agasalhe-o."),
                        amarelo("Entre 36,0 °C e 36,4 °C",
                                "Aqueça o bebê agora, com roupas adequadas, touca de algodão e "
                                        + "contato pele a pele com a mãe. Meça de novo a "
                                        + "temperatura em 30 minutos."),
                        normal("36,5 °C ou mais",
                                "Temperatura sem sinal de frio."))));

        l.add(new Pergunta("Respiração por minuto",
                "Com o bebê calmo e descoberto, quantas vezes a barriguinha ou o peito sobe "
                        + "em 1 minuto completo?",
                null,
                Arrays.asList(
                        vermelho("60 ou mais por minuto (muito rápida), ou menos de 30 por "
                                        + "minuto (muito lenta)",
                                "Risco de dificuldade grave para respirar, pneumonia ou "
                                        + "infecção grave. Atendimento de emergência imediato."),
                        amarelo("Entre 51 e 59 por minuto, com o bebê acordado ou depois de "
                                        + "chorar",
                                "Acalme o bebê, espere 10 minutos com ele relaxado e conte de "
                                        + "novo a respiração por 1 minuto completo."),
                        normal("Entre 30 e 50 por minuto, em repouso",
                                "Respiração normal para um recém-nascido."))));

        l.add(new Pergunta("Costelas afundando",
                "As costelas do bebê afundam com força, ou a barriguinha “puxa para dentro” "
                        + "abaixo das costelas, a cada respiração?",
                null,
                Arrays.asList(
                        vermelho("Sim",
                                "É o sinal de tiragem, que mostra que o bebê está fazendo "
                                        + "força demais para respirar. Avaliação médica "
                                        + "imediata."),
                        normal("Não", "Peito sem afundamento ao respirar."))));

        l.add(new Pergunta("Narinas",
                "As narinas do bebê abrem e fecham com força (inflando) cada vez que ele "
                        + "puxa o ar?",
                null,
                Arrays.asList(
                        vermelho("Sim",
                                "As narinas batendo mostram que o bebê está com “fome de ar”. "
                                        + "Requer atendimento de urgência."),
                        normal("Não", "Narinas sem movimento forte ao respirar."))));

        l.add(new Pergunta("Barulho ao respirar",
                "O bebê faz algum barulho ao respirar (um “gemidinho” a cada vez que solta o "
                        + "ar, ou um chiado agudo ao puxar o ar)?",
                null,
                Arrays.asList(
                        vermelho("Gemido a cada vez que solta o ar, ou barulho constante de "
                                        + "“engasgo” ao respirar",
                                "O gemido é uma tentativa do pulmão de se manter aberto e é "
                                        + "sinal de gravidade. Exige atendimento imediato."),
                        amarelo("Ronco leve no nariz por secreção, que melhora depois de "
                                        + "lavar o nariz",
                                "Limpe o nariz com soro fisiológico 0,9% em gotas e aspire "
                                        + "com suavidade, se necessário."),
                        normal("Respiração silenciosa, sem gemidos ou ruídos estranhos",
                                "Sem ruídos graves ao respirar."))));

        l.add(new Pergunta("Pausas na respiração",
                "O bebê tem pausas em que para completamente de respirar?",
                null,
                Arrays.asList(
                        vermelho("Pausas longas (mais de 15 a 20 segundos), ou pausas com "
                                        + "lábios roxos ou corpo mole",
                                "Pausas longas na respiração (apneia) são risco para a vida. "
                                        + "Vá com urgência a um serviço de emergência."),
                        comum("Pausas curtas (menos de 10 segundos), seguidas de respiração "
                                        + "mais rápida, com a cor corada",
                                "Pausas curtas seguidas de respiração mais rápida são comuns "
                                        + "no recém-nascido. Continue observando, sem alarde."),
                        normal("Não tem pausas na respiração",
                                "Sem pausas respiratórias."))));

        l.add(new Pergunta("Cor dos lábios",
                "Qual é a cor dos lábios, da língua e do interior da boca do bebê?",
                null,
                Arrays.asList(
                        vermelho("Lábios, língua ou interior da boca roxos, azulados ou "
                                        + "acinzentados, ou palidez extrema",
                                "Sinal de pouco oxigênio no sangue ou de má circulação. "
                                        + "Requer atendimento médico imediato."),
                        comum("Só as pontas das mãos e dos pés um pouco arroxeadas ou frias, "
                                        + "com lábios e língua bem rosados",
                                "Pontas das mãos e dos pés arroxeadas são comuns nos "
                                        + "primeiros dias de vida. Aqueça as extremidades."),
                        normal("Lábios, boca e corpo inteiramente rosados",
                                "Boa oxigenação e circulação."))));

        l.add(new Pergunta("Mamada e energia",
                "Como está o comportamento do bebê para mamar e o seu nível de energia?",
                null,
                Arrays.asList(
                        vermelho("Recusa total do peito ou da mamadeira, não consegue mamar, "
                                        + "está largado, pálido, muito mole ou vomita tudo",
                                "São sinais gerais de perigo. O bebê tem risco alto de piorar "
                                        + "e de ficar com açúcar baixo no sangue. Avaliação "
                                        + "médica urgente."),
                        amarelo("Mama com pausas mais frequentes para respirar, ou está mais "
                                        + "sonolento, mas ainda aceita mamar",
                                "Limpe o nariz com soro fisiológico antes das mamadas, "
                                        + "ofereça o peito em tomadas menores e mais frequentes "
                                        + "e agende consulta no posto de saúde."),
                        normal("Mama com vontade, ativo e com boa sucção",
                                "Bom estado geral e boa aceitação da mamada."))));

        l.add(new Pergunta("Chiado e tosse",
                "O bebê tem chiado (“peito chiando” ou “piando”), tosse frequente, ou saiu "
                        + "da UTI neonatal (prematuro com histórico pulmonar)?",
                null,
                Arrays.asList(
                        vermelho("Chiado intenso no peito com cansaço visível, tosse com "
                                        + "engasgos, ou bebê que saiu da UTI neonatal e piorou "
                                        + "rápido",
                                "Risco de bronquiolite, de piora da doença pulmonar do "
                                        + "prematuro ou de pneumonia. Avaliação médica urgente."),
                        amarelo("Tosse ocasional ou leve chiadinho de vez em quando, sem "
                                        + "esforço para respirar e com o bebê mamando bem",
                                "Agende consulta na Unidade Básica de Saúde (UBS) para ouvir "
                                        + "o pulmão e reavaliar o bebê."),
                        normal("Sem tosse e sem chiado no peito",
                                "Sem sinais de problema nas vias aéreas."))));

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