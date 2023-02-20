import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());
        System.out.println(bootcamp.getPorcetagemConcluida(devCamila.getConteudosInscritos(), devCamila.getConteudosConcluidos(), devCamila));
        devCamila.criarPostagem(new Forum("Como funciona os bootcamop?", "Estou com bastante duvidas, se alguem poder me explicar como funciona o bootcamp!", LocalDate.now(), devCamila));

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());
        System.out.println(bootcamp.getPorcetagemConcluida(devJoao.getConteudosInscritos(), devJoao.getConteudosConcluidos(), devJoao));

        System.out.println("-------");

        Dev devJose = new Dev();
        devJose.setNome("Jose");
        devJose.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Jose:" + devJose.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Jose:" + devJose.getConteudosConcluidos());
        System.out.println("XP:" + devJose.calcularTotalXp());
        System.out.println(bootcamp.getPorcetagemConcluida(devJose.getConteudosInscritos(), devJose.getConteudosConcluidos(), devJose));
        devJose.desinscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Jose:" + devJose.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Jose:" + devJose.getConteudosConcluidos());
        System.out.println(bootcamp.getPorcetagemConcluida(devJose.getConteudosInscritos(), devJose.getConteudosConcluidos(), devJose));

        System.out.println("-------");

        Dev devMaria = new Dev();
        devMaria.setNome("Maria");
        devMaria.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Maria:" + devMaria.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Maria:" + devMaria.getConteudosConcluidos());
        devMaria.progredir();
        System.out.println("XP:" + devMaria.calcularTotalXp());
        System.out.println(bootcamp.getPorcetagemConcluida(devMaria.getConteudosInscritos(), devMaria.getConteudosConcluidos(), devMaria));
        devMaria.desinscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Maria:" + devMaria.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Maria:" + devMaria.getConteudosConcluidos());
        System.out.println(bootcamp.getPorcetagemConcluida(devMaria.getConteudosInscritos(), devMaria.getConteudosConcluidos(), devMaria));

        System.out.println("-------");

        Dev devSeverino = new Dev();
        devSeverino.setNome("Severino");
        devSeverino.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Severino:" + devSeverino.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Severino:" + devSeverino.getConteudosConcluidos());
        devSeverino.progredir();
        devSeverino.progredir();
        devSeverino.progredir();
        System.out.println("XP:" + devSeverino.calcularTotalXp());
        System.out.println(bootcamp.getPorcetagemConcluida(devSeverino.getConteudosInscritos(), devSeverino.getConteudosConcluidos(), devSeverino));
        devSeverino.criarPostagem(new Forum("Meu Primeiro Projeto",
                "Nesse topico venho falar sobre meu primeiro projeto, fiz algumas implementações que achei que eram necessarias para o programa e que estava faltando",
                LocalDate.now(), devSeverino));
        devSeverino.criarPostagem(new Forum("Qual Linguagem aprender?", "Qual Linguagem de programação eu devo aprender primeiro, tem alguma ordem que devo seguir?", LocalDate.now(), devSeverino));

        System.out.println("-------");

        System.out.println(devSeverino.postagensFeitas());
        System.out.println(devJoao.postagensFeitas());

        System.out.println("-------");

        System.out.println(forum.verPostagens());

        System.out.println(Dev.getRankingOrdenadoPorXp(bootcamp));
        System.out.println("-------");
        System.out.println(bootcamp.getDevsInscrito(bootcamp));

        System.out.println("-------");



        System.out.println("-------");

        System.out.println(Dev.getRankingOrdenadoPorXp(bootcamp));

    }

}
