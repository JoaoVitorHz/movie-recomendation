/*
Qual tipo de grafo foi usado? 
ChatGPT
No exemplo fornecido, foi usado um tipo de grafo não direcionado, onde os filmes são representados como vértices e as relações entre eles (por exemplo, "filme A é similar ao filme B") são representadas pelas arestas. Cada filme é conectado aos outros filmes aos quais está relacionado por meio dessas arestas. Essa abordagem permite que você explore as conexões entre os filmes de maneira bidirecional, ou seja, se o filme A está relacionado ao filme B, então o filme B também está relacionado ao filme A.


Objetivo do Projeto: Desenvolver um sistema de recomendação de filmes baseado em preferências dos usuários e relações entre filmes.

Qual seria essa situação problema? 
ChatGPT
A situação problema para o desenvolvimento desse projeto poderia ser a seguinte:

Suponha que você trabalhe para uma plataforma de streaming de filmes e séries e a empresa deseja melhorar a experiência do usuário, aumentando o engajamento e a satisfação dos clientes. Uma maneira de alcançar esse objetivo é desenvolver um sistema de recomendação de filmes personalizado, que sugira conteúdo relevante com base nas preferências dos usuários e nas relações entre os filmes.

Atualmente, a plataforma enfrenta o desafio de fornecer recomendações precisas e personalizadas, o que pode levar a uma experiência de usuário insatisfatória e até mesmo à perda de clientes para concorrentes que oferecem recomendações mais eficazes.

Portanto, o objetivo do projeto é desenvolver um sistema de recomendação de filmes que utilize as preferências dos usuários e as relações entre os filmes para sugerir conteúdo relevante e aumentar o engajamento dos usuários com a plataforma. Isso inclui a coleta e análise de dados de avaliações de filmes, a modelagem desses dados em um grafo, a implementação de algoritmos de recomendação e a criação de uma interface do usuário interativa para fornecer as recomendações aos usuários de forma amigável e compreensível.
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Scanner;

// Classe para representar um filme
class Filme {
    private String nome;
    private List<String> generos;
    
    public Filme(String nome, List<String> generos) {
        this.nome = nome;
        this.generos = generos;
    }
    
    public String getNome() {
        return nome;
    }
    
    public List<String> getGeneros() {
        return generos;
    }
}

// Classe para representar um usuário
class Usuario {
    private String nome;
    private List<Filme> filmesCurtidos;
    
    public Usuario(String nome) {
        this.nome = nome;
        this.filmesCurtidos = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public void curtirFilme(Filme filme) {
        filmesCurtidos.add(filme);
    }
    
    public List<Filme> getFilmesCurtidos() {
        return filmesCurtidos;
    }
}

// Classe para representar o sistema de recomendação
class SistemaRecomendacao {
    private Map<Filme, List<Filme>> grafoFilmes;
    
    public SistemaRecomendacao() {
        this.grafoFilmes = new HashMap<>();
    }
    
    public void adicionarRelacaoFilmes(Filme filme1, Filme filme2) {
        if (!grafoFilmes.containsKey(filme1)) {
            grafoFilmes.put(filme1, new ArrayList<>());
        }
        grafoFilmes.get(filme1).add(filme2);
        
        // Considerando a relação como bidirecional
        if (!grafoFilmes.containsKey(filme2)) {
            grafoFilmes.put(filme2, new ArrayList<>());
        }
        grafoFilmes.get(filme2).add(filme1);
    }
    
    public List<Filme> recomendarFilmes(Usuario usuario) {
        List<Filme> recomendacoes = new ArrayList<>();
        
        for (Filme filme : usuario.getFilmesCurtidos()) {
            if (grafoFilmes.containsKey(filme)) {
                recomendacoes.addAll(grafoFilmes.get(filme));
            }
        }
        
        // Remover filmes que o usuário já curtiu
        recomendacoes.removeAll(usuario.getFilmesCurtidos());
        
        return recomendacoes;
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Filme filme1 = new Filme("Matrix", List.of("Ação", "Ficção Científica"));
        Filme filme2 = new Filme("Inception", List.of("Ação", "Ficção Científica"));
        Filme filme3 = new Filme("Interstellar", List.of("Ação", "Ficção Científica"));
        Filme filme4 = new Filme("Gente grande", List.of("Comédia", "Drama"));
        Filme filme5 = new Filme("A Freira", List.of("Terror", "Suspense"));
        Filme filme6 = new Filme("A orfã", List.of("Terror", "Suspense"));
        Filme filme7 = new Filme("Maze Runner", List.of("Ação", "Ficção Científica"));
        Filme filme8 = new Filme("A culpa é das estrelas", List.of("Drama", "Romance"));
        
        Usuario usuario1 = new Usuario("Alice");
        usuario1.curtirFilme(filme1);   
        
        Usuario usuario2 = new Usuario("Bob");
        usuario2.curtirFilme(filme1);
        usuario2.curtirFilme(filme2);
        
        SistemaRecomendacao sistema = new SistemaRecomendacao();
        sistema.adicionarRelacaoFilmes(filme1, filme2);
        sistema.adicionarRelacaoFilmes(filme2, filme3);
        
        List<Filme> recomendacoesUsuario1 = sistema.recomendarFilmes(usuario1);
        System.out.println("Recomendações para " + usuario1.getNome() + ":");
        for (Filme filme : recomendacoesUsuario1) {
            System.out.println("- " + filme.getNome());
        }
        
        List<Filme> recomendacoesUsuario2 = sistema.recomendarFilmes(usuario2);
        System.out.println("\nRecomendações para " + usuario2.getNome() + ":");
        for (Filme filme : recomendacoesUsuario2) {
            System.out.println("- " + filme.getNome());
        }
    }
}