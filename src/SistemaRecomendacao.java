import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
