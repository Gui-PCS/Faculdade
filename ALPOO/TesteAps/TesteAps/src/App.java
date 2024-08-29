import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.Authors;
import data.Book;
import data.BookAuthor;
import data.Publisher;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Pesquisar livros");
        System.out.println("3 - excluir livro");
        System.out.println("4 - editar livro");
        System.out.println("5 - Cadastrar autor");
        System.out.println("6 - Pesquisar autores");
        System.out.println("7 - excluir autor");
        System.out.println("8 - editar autor");
        System.out.println("9 - Cadastrar publicadora");
        System.out.println("10 - Pesquisar publicadoras");
        System.out.println("11 - excluir publicadora");
        System.out.println("12 - editar publicadora");
        System.out.println("0 - Sair");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        //int opcao = 7;

        switch (opcao) {
            case 1:
                System.out.println("Cadastrar livro");
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Título:");
                String title = scanner1.nextLine();
                System.out.println("ISBN:");
                String ISBN = scanner1.nextLine();
                boolean conc = false;
                int j = 1;
                List<BookAuthor> books_authors = new ArrayList<BookAuthor>();
                while (!conc) {
                    System.out.println("Nome do autor (deixe em branco para encerrar):");
                    String name = scanner1.nextLine();
                    if (name.equals("")) {
                        conc = true;
                    } else {
                        List<Authors> res;
                        if (name.contains(" ")) {
                            String[] nomes = name.split(" ");
                            res = Database.pesquisarAutor(nomes[0], nomes[1], 0);
                        } else {
                            res = Database.pesquisarAutor(name, "", 0);
                        }

                        books_authors.add(new BookAuthor(ISBN, res.get(0).getId(), j));
                        j++;
                    }
                }
                System.err.println(books_authors);
                System.out.println("Qual o nome da publicadora?");
                String publisher_name = scanner1.nextLine();
                int publisherID = Database.pesquisarPublicadora(publisher_name, 0).get(0).getId();
                System.out.println("Qual o preço?");
                float price = scanner1.nextFloat();

                Book bookn = new Book(title, ISBN, publisherID, price);

                Database.cadastrarLivro(bookn);
                for (BookAuthor ba : books_authors) {
                    System.out.println(ba);
                    Database.cadastrarLivroAutor(ba);
                }
                System.out.println("Livro cadastrado com sucesso!");
                break;
            case 2:
                System.out.println("Digite o nome do livro:");
                Scanner scanner2 = new Scanner(System.in);
                String nome = scanner2.nextLine();
                //String nome = "unix";
                List<Book> books = Database.pesquisarLivro(nome, 0);
                int i = 1;
                System.out.println("N | Title | Authors | Publisher | Price");
                for (Book book : books) {
                    List<BookAuthor> authors = Database.pesquisarLivroAutor(book.getISBN(), 0);
                    String authorsString = "";
                    for (BookAuthor bAuthor : authors) {
                        Authors author = Database.pesquisarAutor("","", bAuthor.getAuthor_id()).get(0);
                        authorsString += author.getFname() + " " + author.getName() + ", ";
                    }
                    System.out.println(i + " | " + book.getTitle() + " | " + authorsString + " | "
                            + Database.pesquisarPublicadora("",book.getPublisher_id()).get(0).getName() + " | " + book.getPrice());
                    i++;
                }
                break;
            case 3:
                List<Book> books2 = Database.pesquisarLivro(null, 0);
                int i2 = 1;
                System.out.println("N | Title | ISBN");
                for (Book book : books2) {
                    System.out.println(i2 + " | " + book.getTitle() + " | " + book.getISBN());
                    i2++;
                }
                System.out.println("Digite o número do livro que deseja excluir:");
                Scanner scanner3 = new Scanner(System.in);
                int num = scanner3.nextInt();
                String ISBN2 = books2.get(num-1).getISBN();
                System.out.println(ISBN2);

                List<BookAuthor> books_authors2 = Database.pesquisarLivroAutor(ISBN2, 0);
                for (BookAuthor ba : books_authors2) {
                    Database.excluirLivroAutor(ISBN2, ba.getAuthor_id());
                }

                Database.excluirLivro(ISBN2);
                break;
            case 5:
                System.out.println("Cadastrar autor");
                Scanner scanner5 = new Scanner(System.in);
                System.out.println("Digite o nome do autor:");
                String fname = scanner5.nextLine();
                System.out.println("Digite o sobrenome do autor:");
                String name = scanner5.nextLine();
                Database.cadastrarAutor(new Authors(0, fname, name));
                System.out.println("Autor cadastrado com sucesso!");
                break;
            case 6:
                System.out.println("Digite o nome do autor:");
                Scanner scanner6 = new Scanner(System.in);
                String nome2 = scanner6.nextLine();
                if (nome2.contains(" ")) {
                    String[] nomes = nome2.split(" ");
                    List<Authors> res = Database.pesquisarAutor(nomes[0], nomes[1], 0);
                    System.out.println(res);
                } else {
                    List<Authors> res = Database.pesquisarAutor(nome2, "", 0);
                    System.out.println(res);
                }
                break;
            case 7:
                List<Authors> authors = Database.pesquisarAutor("", "", 0);
                int i3 = 1;
                System.out.println("N | FName | Name");
                for (Authors author : authors) {
                    System.out.println(i3 + " | " + author.getFname() + " | " + author.getName());
                    i3++;
                }
                System.out.println("Digite o número do autor que deseja excluir:");
                Scanner scanner7 = new Scanner(System.in);
                int num2 = scanner7.nextInt();
                int id = authors.get(num2-1).getId();

                List<BookAuthor> books_authors3 = Database.pesquisarLivroAutor("", id);

                if (books_authors3.size() > 0) {
                    System.out.println("Esse autor possui livros cadastrados, deseja excluí-los também? (S/N)");  
                    Scanner scanner72 = new Scanner(System.in);
                    String resp = scanner72.nextLine();
                    scanner72.close();
                    if (resp.equals("s") || resp.equals("S")) {
                        System.out.println(books_authors3);
                        for (BookAuthor ba : books_authors3) {
                            System.out.println(ba);
                            Database.excluirLivroAutor(ba.getISBN(), id);
                            Database.excluirLivro(ba.getISBN());
                        }
                    } else {
                        System.out.println("Cancelando exclusão do autor.");
                        break;
                    }
                }

                Database.excluirAutor(id);
                break;
            case 9:
                System.out.println("Cadastrar publicadora");
                Scanner scanner9 = new Scanner(System.in);
                System.out.println("Digite o nome da publicadora:");
                String name2 = scanner9.nextLine();
                System.out.println("Digite o URL da publicadora:");
                String url = scanner9.nextLine();

                Database.cadastrarPublicadora(new Publisher(0, name2, url));
                System.out.println("Publicadora cadastrada com sucesso!");
                break;
            case 10:
                System.out.println("Digite o nome da publicadora:");
                Scanner scanner10 = new Scanner(System.in);
                String nome3 = scanner10.nextLine();
                System.out.println(Database.pesquisarPublicadora(nome3, 0));
                break;
            case 11:
                List<Publisher> publishers = Database.pesquisarPublicadora("", 0);
                int i4 = 1;
                System.out.println("N | Name | URL");
                for (Publisher publisher : publishers) {
                    System.out.println(i4 + " | " + publisher.getName() + " | " + publisher.getURL());
                    i4++;
                }
                System.out.println("Digite o número da publicadora que deseja excluir:");
                Scanner scanner11 = new Scanner(System.in);
                int num3 = scanner11.nextInt();
                int id2 = publishers.get(num3-1).getId();

                List<Book> books3 = Database.pesquisarLivro(null, id2);
                if (books3.size() > 0) {
                    System.out.println("Essa publicadora possui livros cadastrados, deseja excluí-los também? (S/N)");  
                    Scanner scanner112 = new Scanner(System.in);
                    String resp2 = scanner112.nextLine();
                    scanner112.close();
                    if (resp2.equals("s") || resp2.equals("S")) {
                        for (Book book : books3) {
                            List<BookAuthor> books_authors4 = Database.pesquisarLivroAutor(book.getISBN(), 0);
                            for (BookAuthor ba : books_authors4) {
                                Database.excluirLivroAutor(book.getISBN(), ba.getAuthor_id());
                            }
                            Database.excluirLivro(book.getISBN());
                        }
                    } else {
                        System.out.println("Cancelando exclusão da publicadora.");
                        break;
                    }
                }

                Database.excluirPublicadora(id2);
                break;
            case 0:
                System.out.println("Sair");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
        
        scanner.close();
    }
}
