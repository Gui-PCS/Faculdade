package DAO;

import data.Authors;
import data.Book;
import data.BookAuthor;
import data.Publisher;
import java.sql.SQLException;
import java.util.List;

public interface DAO {
    List<Book> pesquisarLivro(String nome, int publisher_id) throws SQLException;
    List<Authors> pesquisarAutor(String fname, String name, int author_id, boolean exatli) throws SQLException;
    List<Publisher> pesquisarPublicadora(String name, int publisher_id, boolean exatli) throws SQLException;
    List<BookAuthor> pesquisarLivroAutor(String ISBN, int abook_author) throws SQLException;
    int cadastrarLivro(Book book) throws SQLException;
    int cadastrarAutor(Authors authors) throws SQLException;
    int cadastrarPublicadora(Publisher publisher) throws SQLException;
    int cadastrarLivroAutor(BookAuthor bookAuthor) throws SQLException;
    int atualizarLivro(Book book) throws SQLException;
    int atualizarAutor(Authors authors) throws SQLException;
    int atualizarPublicadora(Publisher publisher) throws SQLException;
    int atualizarLivroAutor(BookAuthor bookAuthor) throws SQLException;
    int excluirLivro(String ISBN) throws SQLException;
    int excluirAutor(int author_id) throws SQLException;
    int excluirPublicadora(int publisher_id) throws SQLException;
    int excluirLivroAutor(String ISBN, int author_id) throws SQLException;
}
