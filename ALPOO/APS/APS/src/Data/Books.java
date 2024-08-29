package Data;
public class Books {

	private String title;
	private String isbn;
	private int publisher_id;
	private double price;

    public Books(String title, String isbn, int publisher_id, double price) {
        this.title = title;
        this.isbn = isbn;
        this.publisher_id = publisher_id;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" + "title=" + title + ", isbn=" + isbn + ", publisher_id=" + publisher_id + ", price=" + price + '}';
    }
}
