package Atividade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        

        Autor A1 = new Autor("Henry");
        Autor A2 = new Autor("Dívany");
        Autor A3 = new Autor("Karl Marx");

        Livro l1 = new Livro("Manual do ectomorfo", A2);
        Livro l2 = new Livro("Algo sobre sentimentalismo", A1);
        Livro l3 = new Livro("Microfisico do Poder", A3);

        Membro m1 = new Membro("João");
        Membro m2 = new Membro("Maria");

        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(l1);
        livros.add(l2);
        livros.add(l3);

        boolean rodando = true;
        System.out.println("\nBem-vindo à Biblioteca!");

        while (rodando) {
            
            System.out.println("\nMENU DA BIBLIOTECA:");
            System.out.println("1. Listar todos os livros");
            System.out.println("2. Pegar um livro emprestado");
            System.out.println("3. Devolver um livro");
            System.out.println("4. Ver livros de um autor");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    
                    System.out.println("\nLivros disponíveis na biblioteca:");
                    for (Livro livro : livros) {
                        System.out.println(livro);
                    }

                    System.out.println("");
                    while (true) { 
                    System.out.println("Pressione '5' para voltar ao menu principal:");
                        
                        int chose = input.nextInt();
                        
                        if (chose == 5) {
                            break;
                        } else {
                            System.out.println("Escolha inválida!");
                        }
                        
                    }
                    break;
                case 2:
                    
                    System.out.println("\nLivros disponíveis na biblioteca:");
                    for (Livro livro : livros) {
                        System.out.println(livro);
                    }

                    System.out.print("\nDigite o número do livro que você deseja pegar emprestado (1 para o primeiro, etc.): ");
                    while (true) { 
                        
                    
                    int numEmprestimo = input.nextInt();
                    

                    if (numEmprestimo > 0 && numEmprestimo <= livros.size()) {
                        System.out.print("Digite a data de devolução prevista (AAAA-MM-DD): ");
                        String dataStr = input.next();
                        LocalDate dataDevolucaoPrevista = LocalDate.parse(dataStr);
                        m1.emprestarLivro(livros.get(numEmprestimo - 1), dataDevolucaoPrevista);
                        break;
                    } else {
                        System.out.println("Livro não encontrado. Escolha entre 1 e " + livros.size());
                    }
                    
                    }

                    break;

                case 3:

                    for (Livro livro : livros) {
                        System.out.println(livro);
                    }
                    System.out.print("\nDigite o número do livro que deseja devolver (1 para o primeiro, etc.): ");
                    while (true) { 
                        
                    int numDevolucao = input.nextInt();

                    if (numDevolucao > 0 && numDevolucao <= livros.size()) {
                        m1.devolverLivro(livros.get(numDevolucao - 1));
                        break;
                    } else {
                        System.out.println("Livro não encontrado. Escolha entre 1 e " + livros.size());
                    }

                    }
                    break;

                case 4:

                    System.out.print("\nDigite o número do autor: ");

                    while(true){

                        int numAutor = input.nextInt();
                        
                        if (numAutor > livros.size()) {
                            System.out.println("Autor não selecionado. Escolha entre 1 e " + livros.size());
                        }else if (numAutor < 1) {
                            System.out.println("Autor não selecionado. Escolha entre 1 e " + livros.size());
                            
                        }
                        else{
                            Autor autorEscolhido = (numAutor == 1) ? A1 : A2;
                            System.out.println("Livros de " + autorEscolhido.getNome() + ": " + autorEscolhido.getLivrosEscritos());

                            break;
                            
                        }
                        
                    }
                    
                    break;

                case 5:
                    System.out.println("Obrigado por ter vindo na nossa Biblioteca!");
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
