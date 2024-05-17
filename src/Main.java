import java.util.List;
public class Main {
    public static void main(String[] args) {

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
        usuario1.curtirFilme(filme6);   
        
        Usuario usuario2 = new Usuario("Bob");
        usuario2.curtirFilme(filme1);
        usuario2.curtirFilme(filme2);
        usuario2.curtirFilme(filme4);
        
        SistemaRecomendacao sistema = new SistemaRecomendacao();
        sistema.adicionarRelacaoFilmes(filme1, filme2);
        sistema.adicionarRelacaoFilmes(filme2, filme3);
        sistema.adicionarRelacaoFilmes(filme3, filme4);
        sistema.adicionarRelacaoFilmes(filme4, filme5);
        sistema.adicionarRelacaoFilmes(filme5, filme6);
        sistema.adicionarRelacaoFilmes(filme6, filme7);
        sistema.adicionarRelacaoFilmes(filme7, filme8);
        
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