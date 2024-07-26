public class Magazine extends Item {
    private int issueNumber;

    // Konstruktor
    public Magazine(String title, String publisher, int publicationYear, int issueNumber) {
        super(title, publisher, publicationYear);
        this.issueNumber = issueNumber;
    }

    // Getter dan Setter
    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    // Metode untuk menampilkan detail majalah
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Issue Number: " + issueNumber);
    }
}
