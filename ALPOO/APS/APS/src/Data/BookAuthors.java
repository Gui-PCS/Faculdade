package Data;

public class BookAuthors {

    private String isbn;
    private int author_id;
    private int seqNo;

    public BookAuthors(String isbn, int author_id, int seqNo) {
        this.isbn = isbn;
        this.author_id = author_id;
        this.seqNo = seqNo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    @Override
    public String toString() {
        return "BookAuthors{" + "isbn=" + isbn + ", author_id=" + author_id + ", seqNo=" + seqNo + '}';
    }

}
