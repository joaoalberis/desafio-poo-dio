package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Forum extends Conteudo{

    private LocalDate dataPostagem;
    private Dev autor;
    private static Set<Forum> postagens = new LinkedHashSet<>();

    public Forum(String titulo, String descricao, LocalDate dataPostagem, Dev autor) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setDataPostagem(dataPostagem);
        this.setAutor(autor);
    }

    public Forum() {
    }

    public String verPostagens(){
        String postagem = "Abaixo todas as postagens de nosso forum: \n";
        for (Forum postage : this.getPostagens()){
            postagem += "Titulo: " + postage.getTitulo() + "\n";
            postagem += "Conteúdo: " + postage.getDescricao() + "\n";
            postagem += "Autor: " + postage.getAutor().getNome() +"\n\n";
        }

        return postagem;
    }

    public Dev getAutor() {
        return autor;
    }

    public void setAutor(Dev autor) {
        this.autor = autor;
    }

    public Set<Forum> getPostagens() {
        return postagens;
    }

    public void setPostagens(Set<Forum> postagensFeitas) {
        this.postagens = postagensFeitas;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDate dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * 40d;
    }


}
