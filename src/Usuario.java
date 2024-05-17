import java.util.ArrayList;
import java.util.List;

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
