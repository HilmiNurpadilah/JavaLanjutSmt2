public class Item {
    private String title;
    private String publisher;
    private int publicationYear;

    // Konstruktor
    public Item(String title, String publisher, int publicationYear) {
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
    }

    // Getter dan Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Metode untuk menampilkan detail item
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Publisher: " + publisher);
        System.out.println("Publication Year: " + publicationYear);
    }
}
