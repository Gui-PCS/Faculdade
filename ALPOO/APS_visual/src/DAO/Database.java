package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Authors;
import data.Book;
import data.BookAuthor;
import data.Publisher;

public class Database implements DAO{
    static private String USER = "sa";
    static private String PASSWORD = "Imgroot35";
    static private String URL = "jdbc:mysql://bd.rian.ml:3306/aps";

    @Override
    public List<Book> pesquisarLivro(String nome, int publisher_id) throws SQLException {
        String query;
        if (nome == null) {
            query = "SELECT * FROM books WHERE publisher_id = '" + publisher_id + "'";
        } else {
            if (publisher_id == 0) {
                query = "SELECT * FROM books WHERE title LIKE '%" + nome + "%'";
            } else {
                query = "SELECT * FROM books WHERE title LIKE '%" + nome + "%' AND publisher_id = '" + publisher_id + "'";
            }
        }

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(query);

            List<Book> books = new ArrayList<Book>();

            while (rs.next()) {
                Book book = new Book(rs.getString("title"), rs.getString("ISBN"), rs.getInt("publisher_id"),
                        rs.getFloat("price"));
                books.add(book);
            }

            return books;
        }
    }

    @Override
    public List<Authors> pesquisarAutor(String fname, String name, int author_id, boolean exatli) throws SQLException {
        String query = "";
        if (author_id != 0) {
            query = "SELECT * FROM authors WHERE author_id = " + author_id;
        } else {
            if (exatli){
                query = "SELECT * FROM authors WHERE fname = '" + fname + "' and name = '" + name + "'";
            } else {
                query = "SELECT * FROM authors WHERE fname like '%" + fname + "%' and name like '%" + name + "%'";
            }
        }

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(query);

            List<Authors> authors = new ArrayList<Authors>();

            while (rs.next()) {
                Authors author = new Authors(rs.getInt("author_id"), rs.getString("fname"), rs.getString("name"));
                authors.add(author);
            }

            return authors;
        }
    }
    
    @Override
    public List<Publisher> pesquisarPublicadora(String name, int publisher_id, boolean exatli) throws SQLException {
        String query = "";

        if (publisher_id != 0) {
            query = "SELECT * FROM publishers WHERE publisher_id = " + publisher_id;
        } else {
            if (exatli){
                query = "SELECT * FROM publishers WHERE name = '" + name + "'";
            } else {
                query = "SELECT * FROM publishers WHERE name like '%" + name + "%'";
            }
        }

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(query);

            List<Publisher> publishers = new ArrayList<Publisher>();

            while (rs.next()) {
                Publisher publisher = new Publisher(rs.getInt("publisher_id"), rs.getString("name"), rs.getString("URL"));
                publishers.add(publisher);
            }

            return publishers;
        }
    }
    
    @Override
    public List<BookAuthor> pesquisarLivroAutor(String ISBN, int abook_author) throws SQLException {
        String query = "";

        if (abook_author != 0) {
            query = "SELECT * FROM BooksAuthors WHERE author_id = " + abook_author;
        } else {
            query = "SELECT * FROM BooksAuthors WHERE ISBN = '" + ISBN + "'";
        }

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(query);

            List<BookAuthor> books_authors = new ArrayList<BookAuthor>();

            while (rs.next()) {
                BookAuthor book_author = new BookAuthor(rs.getString("isbn"), rs.getInt("author_id"), rs.getInt("seq_no"));
                books_authors.add(book_author);
            }

            return books_authors;
        }
    }
    
    
    @Override
    public int cadastrarLivro(Book book) throws SQLException {
        String query = "INSERT INTO books (title, ISBN, publisher_id, price) VALUES (?, ?, ?, ?)";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            
            PreparedStatement stm = c.prepareStatement(query);
            stm.setString(1, book.getTitle());
            stm.setString(2, book.getISBN());
            stm.setInt(3, book.getPublisher_id());
            stm.setDouble(4, book.getPrice());

            return stm.executeUpdate();
        }
    }

    @Override
    public int cadastrarAutor(Authors author) throws SQLException {
        String query = "INSERT INTO authors (fname, name) VALUES (?, ?)";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stm = c.prepareStatement(query);
            stm.setString(1, author.getFname());
            stm.setString(2, author.getName());

            return stm.executeUpdate();
        }
    }

    @Override
    public int cadastrarPublicadora(Publisher publisher) throws SQLException {
        String query = "INSERT INTO publishers (name, URL) VALUES (?, ?)";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stm = c.prepareStatement(query);
            stm.setString(1, publisher.getName());
            stm.setString(2, publisher.getURL());

            return stm.executeUpdate();
        }
    }
    
    @Override
    public int cadastrarLivroAutor(BookAuthor book_author) throws SQLException {
        String query = "INSERT INTO booksAuthors (isbn, author_id, seq_no) VALUES (?, ?, ?)";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stm = c.prepareStatement(query);
            stm.setString(1, book_author.getISBN());
            stm.setInt(2, book_author.getAuthor_id());
            stm.setInt(3, book_author.getSeq_no());

            return stm.executeUpdate();
        }
    }

    @Override
    public int excluirLivro(String ISBN) throws SQLException {
        System.out.println("Excluindo livro com ISBN: " + ISBN);
        String query = "DELETE FROM books WHERE ISBN = '" + ISBN + "'";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stm = c.createStatement();
            return stm.executeUpdate(query);

        }
    }
    
    @Override
    public int excluirAutor(int author_id) throws SQLException {
        String query = "DELETE FROM authors WHERE author_id = ?";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stm = c.prepareStatement(query);
            stm.setInt(1, author_id);

            return stm.executeUpdate();
        }
    }

    @Override
    public int excluirPublicadora(int publisher_id) throws SQLException {
        String query = "DELETE FROM publishers WHERE publisher_id = ?";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stm = c.prepareStatement(query);
            stm.setInt(1, publisher_id);

            return stm.executeUpdate();
        }
    }

    @Override
    public int excluirLivroAutor(String ISBN, int author_id) throws SQLException {
        String query = "DELETE FROM booksAuthors WHERE isbn = ? and author_id = ?";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stm = c.prepareStatement(query);
            stm.setString(1, ISBN);
            stm.setInt(2, author_id);

            return stm.executeUpdate();
        }
    }

    @Override
    public int atualizarLivro(Book book) throws SQLException {
        String query = "UPDATE books SET title = ?, publisher_id = ?, price = ? WHERE ISBN = ?";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stm = c.prepareStatement(query);
            stm.setString(1, book.getTitle());
            stm.setInt(2, book.getPublisher_id());
            stm.setDouble(3, book.getPrice());
            stm.setString(4, book.getISBN());

            return stm.executeUpdate();
        }
    }

    @Override
    public int atualizarAutor(Authors author) throws SQLException {
        String query = "UPDATE authors SET fname = ?, name = ? WHERE author_id = ?";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stm = c.prepareStatement(query);
            stm.setString(1, author.getFname());
            stm.setString(2, author.getName());
            stm.setInt(3, author.getId());

            return stm.executeUpdate();
        }
    }

    @Override
    public int atualizarPublicadora(Publisher publisher) throws SQLException {
        String query = "UPDATE publishers SET name = ?, URL = ? WHERE publisher_id = ?";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stm = c.prepareStatement(query);
            stm.setString(1, publisher.getName());
            stm.setString(2, publisher.getURL());
            stm.setInt(3, publisher.getId());

            return stm.executeUpdate();
        }
    }

    @Override
    public int atualizarLivroAutor(BookAuthor book_author) throws SQLException {
        String query = "UPDATE booksAuthors SET seq_no = ? WHERE isbn = ? and author_id = ?";

        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stm = c.prepareStatement(query);
            stm.setInt(1, book_author.getSeq_no());
            stm.setString(2, book_author.getISBN());
            stm.setInt(3, book_author.getAuthor_id());

            return stm.executeUpdate();
        }
    }
}
