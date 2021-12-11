
public class Book implements Cloneable, Comparable<Book> {
    private String title;
    private String author;
    private int price;
    private int isbn;
    private static int edition;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(String title, String author, int price, int isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        int hashTitle = (title != null) ? title.hashCode() : 0;
        int hashAuthor = (author != null) ? author.hashCode() : 0;
        return hashTitle + hashAuthor + 31 * price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Book book = (Book) o;
        return title.equals(book.getTitle()) && author.equals(book.getAuthor()) && price == book.getPrice();
    }

    @Override
    public String toString() {
        return "Book {title = " + getTitle() + ", author = " + getAuthor() + ", price = " + getPrice() + " isbn = " + isbn + "}";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Book o) {
        return this.isbn - o.isbn;
    }
}
