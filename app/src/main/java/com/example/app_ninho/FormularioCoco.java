package com.example.app_ninho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Conteúdo do Módulo 1 (Cocô): 10 perguntas, níveis e condutas (COCO_FORM.pdf). */
public final class FormularioCoco {

    private FormularioCoco() { }

    public static List<Pergunta> perguntas() {
        List<Pergunta> l = new ArrayList<>();

        l.add(new Pergunta("Sangue",
                "O cocô apresenta sangue vivo (vermelho) ou raias/pintas de sangue visíveis?",
                null,
                Arrays.asList(
                        vermelho("Sim",
                                "Avaliação médica imediata (PS/UPA). Risco de disenteria, "
                                        + "infecção bacteriana grave ou intussuscepção intestinal."),
                        normal("Não",
                                "Sem sinais de sangramento visível. Prossegue na avaliação."))));

        l.add(new Pergunta("Cor",
                "Qual é a cor predominante do cocô na fralda?",
                null,
                Arrays.asList(
                        vermelho("Branco, cinza ou bege",
                                "Suspeita de Colestase Neonatal / Atresia de Vias Biliares. "
                                        + "Requer avaliação médica urgente em até 24-48 horas "
                                        + "para investigação hepática."),
                        amarelo("Preto escuro",
                                "Rastreio de sangramento digestivo alto tratado ou "
                                        + "dieta/suplementação. Agendar consulta ambulatorial."),
                        normal("Amarelo, castanho, marrom ou esverdeado",
                                "Pigmentação biliar preservada e adequada."))));

        l.add(new Pergunta("Consistência",
                "Como está a textura/formato do cocô do seu bebê?",
                null,
                Arrays.asList(
                        amarelo("Aquoso / líquido",
                                "Suspeita de Diarreia Aguda. Iniciar hidratação oral em casa e "
                                        + "agendar avaliação na Unidade Básica de Saúde."),
                        normal("Pastoso / mole",
                                "Consistência fisiológica normal para lactentes e crianças "
                                        + "pequenas."),
                        amarelo("Duro / em bolinhas",
                                "Indicativo de Constipação Intestinal. Requer readequação "
                                        + "dietética/hídrica e consulta ambulatorial."))));

        l.add(new Pergunta("Muco",
                "O cocô contém muco visível (aspecto de “catarro”, gosma transparente ou "
                        + "esbranquiçada)?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Pode indicar irritação na mucosa intestinal, alergia alimentar "
                                        + "(ex: APLV) ou infecção leve. Agendar consulta com "
                                        + "pediatra."),
                        normal("Não", "Ausência de secreção mucosa anormal."))));

        l.add(new Pergunta("Odor",
                "Como está o cheiro do cocô em comparação ao normal?",
                null,
                Arrays.asList(
                        normal("Normal / habitual", "Odor característico fisiológico."),
                        amarelo("Alterado / ácido",
                                "Frequentemente associado a assaduras por acidez (fermentação "
                                        + "de açúcares/lactose). Manter cuidados locais e "
                                        + "observar."),
                        amarelo("Fétido / podre",
                                "Indicativo de disbiose, má absorção ou infecção "
                                        + "gastrointestinal. Orientar consulta médica."))));

        l.add(new Pergunta("Frequência",
                "Como está o número de fraldas sujas de cocô por dia?",
                null,
                Arrays.asList(
                        amarelo("Muito aumentada",
                                "Aumento importante de trânsito intestinal. Aumentar oferta de "
                                        + "líquidos e agendar consulta."),
                        normal("Normal / habitual", "Ritmo intestinal preservado."),
                        amarelo("Muito reduzida",
                                "Atraso evacuatório significativo. Investigar constipação se "
                                        + "acompanhado de fezes duras."))));

        l.add(new Pergunta("Restos de alimento",
                "É possível ver pedaços inteiros de comida não digerida (ex: grãos, vegetais "
                        + "intactos) com frequência?",
                null,
                Arrays.asList(
                        comum("Sim",
                                "Processo benigno comum na fase de introdução alimentar "
                                        + "(mastigação incompleta e imaturidade enzimática). "
                                        + "Apenas orientação parental."),
                        normal("Não", "Digestão habitual."))));

        l.add(new Pergunta("Espuma",
                "O cocô sai com aspecto espumoso, cheio de bolhas de ar ou parecendo "
                        + "“fermentado”?",
                null,
                Arrays.asList(
                        amarelo("Sim",
                                "Sinal de fermentação intestinal de açúcares (ex: excesso de "
                                        + "leite de início na mamada com muita lactose). Orientar "
                                        + "pega correta do peito e esvaziamento da mama."),
                        normal("Não", "Sem sinais de hiperfermentação."))));

        l.add(new Pergunta("Esforço ao evacuar",
                "Qual é a reação do bebê no momento em que tenta evacuar?",
                null,
                Arrays.asList(
                        normal("Sem sofrimento",
                                "Evacuação fisiológica sem desconforto."),
                        comum("Esforço, com fezes moles",
                                "Disquezia do Lactente (condição benigna e fisiológica em "
                                        + "menores de 6 meses). Orientar que é normal e não usar "
                                        + "supositórios sem prescrição médica."),
                        amarelo("Dor / choro, com fezes duras",
                                "Constipação dolorosa com risco de fissura anal. Requer "
                                        + "orientação médica e manejo alimentar/laxativo se "
                                        + "indicado."))));

        l.add(new Pergunta("Mecônio",
                "Quando nasceu, o bebê demorou mais de 48 horas para soltar o primeiro cocô "
                        + "preto/escuro (mecônio)?",
                "Responda apenas se o bebê tem menos de 2 meses.",
                Arrays.asList(
                        vermelho("Sim",
                                "Sinal de alerta para anomalias neuromusculares/obstrutivas "
                                        + "congênitas (ex: Doença de Hirschsprung ou Íleo "
                                        + "Meconial). Encaminhar para avaliação "
                                        + "pediátrica/cirúrgica urgente."),
                        normal("Não",
                                "Trânsito meconial inicial fisiológico mantido."),
                        normal("Não se aplica (bebê com 2 meses ou mais)",
                                "Pergunta válida apenas para bebês com menos de 2 meses."))));

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