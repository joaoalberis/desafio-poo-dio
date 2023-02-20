package br.com.dio.desafio.dominio;

import java.util.*;
import java.util.stream.Collectors;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Set<Conteudo> postagensFeitas = new LinkedHashSet<>();

    private static Map<String, Double> ranking = new HashMap();


    public void criarPostagem(Forum forum){
        this.postagensFeitas.add(forum);
        forum.getPostagens().add(forum);
    }

    public String postagensFeitas(){
        if (this.getPostagensFeitas().isEmpty()) return "O Dev " + this.getNome() + " não possui nenhuma postagem";
        String postagem = "Abaixo todas as postagens do dev: " + this.getNome() + "\n";
        for (Conteudo postage : this.getPostagensFeitas()){
            postagem += "Titulo: " + postage.getTitulo() + "\n";
            postagem += "Conteúdo: " + postage.getDescricao() + "\n";
        }
        return postagem;
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void desinscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.removeAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().remove(this);
    }

    public static Map<String, Double> getRankingOrdenadoPorXp(Bootcamp bootcamp) {
        Map<String, Double> rank = getRanking(bootcamp);
        return ranking.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }


    private static Map<String, Double> getRanking(Bootcamp bootcamp){
        for (Dev devs : bootcamp.getDevsInscritos()){
            double xp = devs.calcularTotalXp();
            ranking.put(devs.getNome(), xp);
        }
        return ranking;
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        Iterator<Conteudo> iterator1 = this.postagensFeitas.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        while (iterator1.hasNext()){
            double next = iterator1.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
    }

    public Set<Conteudo> getPostagensFeitas() {
        return postagensFeitas;
    }

    public void setPostagensFeitas(Set<Conteudo> postagensFeitas) {
        this.postagensFeitas = postagensFeitas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "" +
                "postagensFeitas={" + this.postagensFeitas +
                '}';
    }
}
