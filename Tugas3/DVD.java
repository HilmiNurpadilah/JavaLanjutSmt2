public class DVD extends Item {
    private String director;
    private int duration; // duration in minutes

    // Konstruktor
    public DVD(String title, String publisher, int publicationYear, String director, int duration) {
        super(title, publisher, publicationYear);
        this.director = director;
        this.duration = duration;
    }

    // Getter dan Setter
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Metode untuk menampilkan detail DVD
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Director: " + director);
        System.out.println("Duration: " + duration + " minutes");
    }
}
