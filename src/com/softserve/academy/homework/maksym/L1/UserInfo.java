import java.util.Scanner;

public class UserInfo {
    public static void main(String[] args) {
        String firstName;
        String secondName;
        String addressLine;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your first name:");
        firstName = sc.nextLine();
        System.out.print("Enter your second name:");
        secondName = sc.nextLine();
        System.out.print("Where do you live " + firstName + "?");
        addressLine = sc.nextLine();

        System.out.println("Name: [" + firstName + " " + secondName + "], Address: [" + addressLine + "]");
        sc.close();
    }
}
