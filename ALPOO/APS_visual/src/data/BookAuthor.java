/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author ribru
 */
public class BookAuthor {
    private String ISBN;
    private int author_id;
    private int seq_no;

    public BookAuthor(String IBSN, int author_id, int seq_no) {
        this.ISBN = IBSN;
        this.author_id = author_id;
        this.seq_no = seq_no;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setIBSN(String IBSN) {
        this.ISBN = IBSN;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getSeq_no() {
        return seq_no;
    }

    public void setSeq_no(int seq_no) {
        this.seq_no = seq_no;
    }

    @Override
    public String toString() {
        return "BookAuthor{" + "ISBN=" + ISBN + ", author_id=" + author_id + ", seq_no=" + seq_no + '}';
    }
    
}

