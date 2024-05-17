import java.util.List;

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
