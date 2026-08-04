import java.util.Scanner;

public class FlowerBedCalculator {
    public static void main(String[] args) {
        double radius;

        Scanner InputScanner = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        radius = InputScanner.nextDouble();
        double Perimeter = 2 * Math.PI * radius;
        System.out.println("Perimeter = " + Perimeter);
        double Area = Math.PI * (radius * radius);
        System.out.println("Area = " + Area);
        InputScanner.close();
    }
}
