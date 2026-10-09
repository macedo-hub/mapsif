package br.com.example.mapsif.data;

import java.util.ArrayList;
import java.util.List;

import br.com.example.mapsif.R;
import br.com.example.mapsif.model.Localizacao;
import br.com.example.mapsif.model.Sala;

public class SalaRepository {

    //lista
    private static  final List<Sala> TODAS_AS_SALAS = new ArrayList<>();

    static {

        // ==================== BLOCO A — 1º ANDAR ====================
        TODAS_AS_SALAS.add(new Sala(
                "lab_informatica_1",
                "Laboratório de Informática 1",
                "Aulas práticas de programação",
                "O Laboratório de Informática 1 possui 20 computadores disponíveis para aulas práticas e uso livre dos alunos.",
                R.drawable.ic_energias,
                R.drawable.img_lab_informatica_1,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_professores_a",
                "Sala dos Professores",
                "Uso exclusivo do corpo docente",
                "Espaço reservado para os professores realizarem planejamento de aulas e reuniões.",
                R.drawable.ic_professor,
                R.drawable.img_sala_professores,
                false,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "refeitorio",
                "Refeitório",
                "Área de alimentação",
                "Espaço destinado à alimentação dos alunos e funcionários.",
                R.drawable.ic_refeitorio,
                R.drawable.img_refeitorio,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_neabi",
                "Sala do NEABI",
                "Núcleo de Estudos Afro-Brasileiros e Indígenas",
                "Espaço destinado às atividades e ações do NEABI no campus.",
                R.drawable.ic_neabi,
                R.drawable.img_sala_neabi,
                false,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "lab_quimica",
                "Laboratório de Química",
                "Espaço para aulas práticas de química",
                "Laboratório destinado à realização de experimentos e atividades práticas relacionadas à Química.",
                R.drawable.ic_quimica,
                R.drawable.img_lab_quimica,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "lab_biologia",
                "Laboratório de Biologia",
                "Espaço para estudos de biologia",
                "Laboratório destinado ao estudo dos seres vivos e à realização de atividades práticas relacionadas à Biologia.",
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
                "Sala destinada às aulas e atividades acadêmicas do campus.",
                R.drawable.ic_sala_aula,
                R.drawable.img_sala_aula,
                true,
                Localizacao.BLOCO_A_TERREO
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_diretora_ensino",
                "Sala da Diretora de Ensino",
                "Direção de Ensino",
                "Espaço destinado ao atendimento e às atividades da Diretoria de Ensino.",
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
                "Espaço destinado à leitura, pesquisa e estudos dos alunos.",
                R.drawable.ic_biblioteca,
                R.drawable.img_biblioteca,
                true,
                Localizacao.BLOCO_B_TERREO
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_energias_renovaveis",
                "Sala de Energias Renováveis",
                "Espaço para atividades",
                "Espaço destinado às atividades e projetos relacionados às energias renováveis.",
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
                "Espaço destinado às atividades práticas e projetos relacionados à informática.",
                R.drawable.ic_energias,
                R.drawable.img_lab_informatica_2,
                true,
                Localizacao.BLOCO_B_PRIMEIRO_ANDAR
        ));


        // ==================== MENU LATERAL ====================

        TODAS_AS_SALAS.add(new Sala(
                "inicio_trilha",
                "Início da trilha",
                "Ponto de início do percurso",
                "Local de início da trilha para explorar os espaços do campus.",
                R.drawable.ic_trilha,
                R.drawable.img_trilha,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_descanso",
                "Sala de descanso",
                "Espaço para descanso",
                "Ambiente destinado ao descanso e ao bem-estar durante a rotina no campus.",
                R.drawable.ic_descanso,
                R.drawable.img_lab_informatica_1,
                true,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

        TODAS_AS_SALAS.add(new Sala(
                "sala_servidor",
                "Sala de servidor",
                "Espaço dos servidores",
                "Ambiente destinado aos equipamentos e serviços de servidores do campus.",
                R.drawable.ic_servidor,
                R.drawable.img_servidores,
                false,
                Localizacao.BLOCO_A_PRIMEIRO_ANDAR
        ));

    }
    public static List<Sala> getSalasPorLocalizacao(Localizacao localizacao) {
        List<Sala> resultado = new ArrayList<>();

        for (int i = 0; i < TODAS_AS_SALAS.size(); i++) {
            Sala sala = TODAS_AS_SALAS.get(i);

            if (sala.getLocalizacao() == localizacao) {
                resultado.add(sala);
            }
        }

        return resultado;
    }
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
