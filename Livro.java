package Atividade;
import java.time.LocalDate;
import java.util.Scanner;


public class Livro {
    Scanner scanner = new Scanner(System.in);
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private double MULTA_POR_DIA = 2.0; 

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        autor.adicionarLivro(titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar(LocalDate dataDevolucaoPrevista) {
        if (disponivel) {
            disponivel = false;
            this.dataEmprestimo = LocalDate.now();
            this.dataDevolucaoPrevista = dataDevolucaoPrevista;
            System.out.println("Livro '" + titulo + "' emprestado com sucesso!");
        } else {
            System.out.println("Livro " + titulo + " não está disponível.");
        }
    }

    public void devolver() {
        disponivel = true;
        System.out.println("Digite os dias de atraso do livro.");
        int diasDeAtraso = scanner.nextInt();
        
        if (diasDeAtraso > 0) {
            double multa = diasDeAtraso * MULTA_POR_DIA;
            System.out.println("Livro " + titulo + " devolvido com atraso de " + diasDeAtraso + " dias. Multa: " + multa + " unidades monetárias.");
        } else {
            System.out.println("Livro " + titulo + " devolvido dentro do prazo.");
        }
    }

    @Override
    public String toString() {
        return titulo + " - " + autor.getNome() + " | Disponível: " + disponivel;
    }
}
