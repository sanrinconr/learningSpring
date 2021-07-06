import com.practice.abstraction.Circle;
import com.practice.errors.FileManipulator;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(2);
        System.out.println(circle.getArea());
        FileManipulator.writeFile("Hi.txt");
    }
}
