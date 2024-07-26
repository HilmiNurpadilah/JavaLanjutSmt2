public class Book extends Item {
    private String author;
    private String ISBN;    

    // Konstruktor
    public Book(String title, String publisher, int publicationYear, String author, String ISBN) {
        super(title, publisher, publicationYear);
        this.author = author;
        this.ISBN = ISBN;
    }

    // Getter dan Setter
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    // Metode untuk menampilkan detail buku
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
    }
}
