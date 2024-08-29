package data;

public class Book {
    private String title;
    private String ISBN;
    private int publisher_id;
    private float price;

    public Book(String title, String ISBN, int publisher_id, float price) {
        this.title = title;
        this.ISBN = ISBN;
        this.publisher_id = publisher_id;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", ISBN=" + ISBN + ", publisher_id=" + publisher_id + ", price=" + price + '}';
    }
    
}
