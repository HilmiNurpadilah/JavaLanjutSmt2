public class GeometrySystem {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 7);
        Shape triangle = new Triangle(3, 4, 3, 4, 5);

        System.out.println("Circle Details:");
        circle.display();
        System.out.println();

        System.out.println("Rectangle Details:");
        rectangle.display();
        System.out.println();

        System.out.println("Triangle Details:");
        triangle.display();
    }
}
