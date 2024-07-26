public abstract class Shape {
    public abstract double getArea();
    public abstract double getPerimeter();

    public void display() {
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
