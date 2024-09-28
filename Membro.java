package Atividade;
import java.time.LocalDate;
import java.util.ArrayList;

public class Membro {
    private String nome;
    private ArrayList<Livro> livrosEmprestados;

    public Membro(String nome) {
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void emprestarLivro(Livro livro, LocalDate dataDevolucaoPrevista) {
        if (livro.isDisponivel()) {
            livro.emprestar(dataDevolucaoPrevista); 
            livrosEmprestados.add(livro);
        } else {
            System.out.println("O livro já está emprestado.");
        }
    }

    public void devolverLivro(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            livro.devolver(); 
            livrosEmprestados.remove(livro);
        } else {
            System.out.println("Perdão, este livro ainda está disponível.");
        }
    }

    public void listarLivrosEmprestados() {
        if (livrosEmprestados.isEmpty()) {
            System.out.println(nome + " não tem livros emprestados.");
        } else {
            System.out.println("Livros emprestados por " + nome + ":");
            for (Livro livro : livrosEmprestados) {
                System.out.println(livro.getTitulo());
            }
        }
    }
}

