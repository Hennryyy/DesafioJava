package Atividade;
import java.util.ArrayList;

public class Autor {
    private String nome;
    private ArrayList<String> livrosEscritos;

    public Autor(String nome) {
        this.nome = nome;
        this.livrosEscritos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarLivro(String titulo) {
        livrosEscritos.add(titulo);
    }

    public ArrayList<String> getLivrosEscritos() {
        return livrosEscritos;
    }

    @Override
    public String toString() {
        return nome + " - Livros escritos: " + livrosEscritos;
    }
}
