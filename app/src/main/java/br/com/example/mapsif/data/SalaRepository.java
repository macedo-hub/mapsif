package br.com.example.mapsif.data;

import java.util.ArrayList;
import java.util.List;
import br.com.example.mapsif.R;
import br.com.example.mapsif.model.Localizacao;
import br.com.example.mapsif.model.Sala;

public class SalaRepository {

    // Lista com todas as salas do aplicativo.
    private static  final List<Sala> TODAS_AS_SALAS = new ArrayList<>();
    static {

        // ==================== BLOCO A — 1º ANDAR ====================
        TODAS_AS_SALAS.add(new Sala(
                "lab_informatica_1",
                "Laboratório de Informática 1",
                "Aulas práticas de programação",
                "O Laboratório de Informática 1 é um ambiente voltado para aulas práticas, pesquisas e atividades que envolvem tecnologia e informática, contribuindo para o aprendizado e o desenvolvimento dos alunos.",
                R.drawable.ic_computador,
                R.drawable.img_lab_informatica_1,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_professores_a",
                "Sala dos Professores",
                "Uso exclusivo do corpo docente",
                "A Sala dos Professores é um ambiente destinado ao planejamento de aulas, à organização das atividades escolares e à realização de reuniões entre os docentes.",
                R.drawable.ic_professor,
                R.drawable.img_sala_professores,
                false,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "refeitorio",
                "Refeitório",
                "Área de alimentação",
                "O Refeitório é um espaço destinado às refeições dos alunos, oferecendo um ambiente para se alimentar e fazer uma pausa durante a rotina escolar.",
                R.drawable.ic_refeitorio,
                R.drawable.img_refeitorio,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_neabi",
                "Sala do NEABI",
                "Núcleo de Estudos Afro-Brasileiros e Indígenas",
                "O espaço do NEABI é dedicado à realização de atividades e ações que valorizam a história e a cultura afro-brasileira e indígena, promovendo o respeito à diversidade e o combate ao preconceito.",
                R.drawable.ic_neabi,
                R.drawable.img_sala_neabi,
                false,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "lab_quimica",
                "Laboratório de Química",
                "Espaço para aulas práticas de química",
                "O Laboratório de Química é um ambiente voltado à realização de experimentos e atividades práticas que permitem aos alunos explorar conceitos químicos e relacionar a teoria com a prática.",
                R.drawable.ic_quimica,
                R.drawable.img_lab_quimica,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "lab_biologia",
                "Laboratório de Biologia",
                "Espaço para estudos de biologia",
                "O Laboratório de Biologia é um ambiente dedicado ao estudo dos seres vivos, onde os alunos podem explorar conceitos da área e realizar atividades práticas que complementam o aprendizado em sala de aula.",
                R.drawable.ic_biologia,
                R.drawable.img_lab_biologia,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        // ==================== BLOCO A — TÉRREO ====================
        TODAS_AS_SALAS.add(new Sala(
                "sala_aula",
                "Sala de aula",
                "Espaço para aulas",
                "Ambiente destinado às aulas e atividades acadêmicas, proporcionando um espaço para o aprendizado, a troca de conhecimentos e o desenvolvimento dos alunos.",
                R.drawable.ic_sala_aula,
                R.drawable.img_sala_aula,
                true,
                Localizacao.BLOCO_A_TERREO
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_diretora_ensino",
                "Sala da Diretora de Ensino",
                "Direção de Ensino",
                "A Diretoria de Ensino é responsável por acompanhar e organizar as atividades acadêmicas do campus, contribuindo para o funcionamento do ensino e o atendimento às demandas escolares.",
                R.drawable.ic_diretoria,
                R.drawable.img_diretoria,
                false,
                Localizacao.BLOCO_A_TERREO
        ));

        // ==================== BLOCO B — TÉRREO ====================
        TODAS_AS_SALAS.add(new Sala(
                "biblioteca",
                "Biblioteca",
                "Acervo e sala de estudos",
                "A biblioteca é um ambiente dedicado à leitura, à pesquisa e aos estudos, oferecendo aos alunos um espaço para ampliar conhecimentos e aprofundar o aprendizado.",
                R.drawable.ic_biblioteca,
                R.drawable.img_biblioteca,
                true,
                Localizacao.BLOCO_B_TERREO
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_energias_renovaveis",
                "Sala de Energias Renováveis",
                "Espaço para atividades",
                "O espaço de Energias Renováveis é voltado ao desenvolvimento de atividades e projetos relacionados a fontes de energia sustentáveis, incentivando o aprendizado e a exploração de tecnologias que contribuem para um futuro mais sustentável.",
                R.drawable.ic_energias,
                R.drawable.img_energias_renovaveis,
                true,
                Localizacao.BLOCO_B_TERREO
        ));

        // ==================== BLOCO B — 1º ANDAR ====================
        TODAS_AS_SALAS.add(new Sala(
                "lab_informatica_2",
                "Laboratório de Informática 2",
                "Espaço para atividades de informática",
                "O Laboratório de Informática é um ambiente voltado ao desenvolvimento de atividades práticas e projetos na área de tecnologia, permitindo aos alunos aplicar conhecimentos e explorar diferentes recursos da informática.",
                R.drawable.ic_computador,
                R.drawable.img_lab_informatica_2,
                true,
                Localizacao.BLOCO_B_PRIMEIRO_ANDAR
        ));


        // ==================== MENU LATERAL ====================

        TODAS_AS_SALAS.add(new Sala(
                "inicio_trilha",
                "Início da trilha",
                "Ponto de início do percurso",
                "Ponto de partida da trilha ecológica do campus, onde os visitantes podem explorar a natureza e conhecer um pouco mais da vegetação local.",
                R.drawable.ic_trilha,
                R.drawable.img_trilha,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_descanso",
                "Sala de descanso",
                "Espaço para descanso",
                "Espaço reservado para descanso e relaxamento, oferecendo aos alunos um momento de pausa e tranquilidade durante a rotina no campus.",
                R.drawable.ic_descanso,
                R.drawable.img_lab_informatica_1,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_servidor",
                "Sala de servidor",
                "Espaço dos servidores",
                "Espaço destinado aos equipamentos e serviços de servidores do campus, essenciais para o funcionamento dos sistemas e da infraestrutura tecnológica do IF.",
                R.drawable.ic_servidor,
                R.drawable.img_servidores,
                false,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "frente_escola",
                "Frente da escola",
                "Entrada principal do campus",
                "Seja bem-vindo ao IFPB Campus Santa Luzia! Este é o ponto de partida para explorar o campus e conhecer seus espaços, ambientes e tudo o que faz parte da nossa instituição. Vamos começar essa visita?",
                R.drawable.ic_escola,
                R.drawable.img_frente_escola,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

    }

    // Busca as salas do andar escolhido.
    public static List<Sala> getSalasPorLocalizacao(Localizacao localizacao) {
        List<Sala> resultado = new ArrayList<>();
        for (int i = 0; i < TODAS_AS_SALAS.size(); i++) {
            Sala sala = TODAS_AS_SALAS.get(i);
            if (sala.getId().equals("inicio_trilha") || sala.getId().equals("sala_descanso") || sala.getId().equals("frente_escola") || sala.getId().equals("sala_servidor")) {
                continue;
            }
            if (sala.getLocalizacao() == localizacao) {
                resultado.add(sala);
            }
        }
        return resultado;
    }

    // Encontra uma sala pelo seu ID.
    public static Sala getSalaPorId(String id) {
        for (int i = 0; i < TODAS_AS_SALAS.size(); i++) {
            Sala sala = TODAS_AS_SALAS.get(i);
            if (sala.getId().equals(id)) {
                return sala;
            }
        }
        return null;
    }
}
