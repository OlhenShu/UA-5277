import java.util.Scanner;

public class PhoneCallCostCalculator {
    public static void main(String[] args) {
        double c1, c2, c3;
        int t1, t2, t3;
        double cost1, cost2, cost3;

        Scanner sc = new Scanner(System.in);

        System.out.println("Cost per minute of call #1: ");
        c1 = Double.parseDouble(sc.next());
        System.out.println("Duration of call #1 (min): ");
        t1 = sc.nextInt();

        System.out.println("Cost per minute of call #2: ");
        c2 = Double.parseDouble(sc.next());
        System.out.println("Duration of call #2 (min): ");
        t2 = sc.nextInt();

        System.out.println("Cost per minute of call #3: ");
        c3 = Double.parseDouble(sc.next());
        System.out.println("Duration of call #3 (min): ");
        t3 = sc.nextInt();

        sc.close();

        cost1 = c1 * t1;
        cost2 = c2 * t2;
        cost3 = c3 * t3;

        double totalCost = cost1 + cost2 + cost3;

        System.out.println("Call 1 cost: " + cost1);
        System.out.println("Call 2 cost: " + cost2);
        System.out.println("Call 3 cost: " + cost3);
        System.out.println("Total cost: " + totalCost);


//        Cost per minute of call 1: 0.5
//        Duration of call 1 (min): 10
    }
}
