public class LibrarySystem {
    public static void main(String[] args) {
        Item book = new Book("Java Programming", "Tech Publisher", 2021, "John Doe", "123456789");
        Item magazine = new Magazine("Tech Today", "Tech Publisher", 2023, 45);
        Item dvd = new DVD("Inception", "Warner Bros", 2010, "Christopher Nolan", 148);

        System.out.println("Book Details:");
        book.displayDetails();
        System.out.println();

        System.out.println("Magazine Details:");
        magazine.displayDetails();
        System.out.println();

        System.out.println("DVD Details:");
        dvd.displayDetails();
    }
}
