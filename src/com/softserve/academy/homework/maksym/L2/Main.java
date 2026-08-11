import com.softserve.academy.homework.maksym.L2.BankAccount;
import com.softserve.academy.homework.maksym.L2.DigitSumCalculator;
import com.softserve.academy.homework.maksym.L2.MathOperations;
import com.softserve.academy.homework.maksym.L2.TemperatureConverter;

static void main() {

    double result1 = TemperatureConverter.fahrenheitToCelsius(90);
    double result2_1 = MathOperations.calculateSquareRoot(22);
    double result2_2 = MathOperations.calculateSquare(40);
    double result2_3 = MathOperations.calculateCube(15);
    int result3 = DigitSumCalculator.calculateDigitSum(777);
    BankAccount acc = new BankAccount("411439400", 12000.00);



    System.out.println(result1 + "\n" + result2_1 + " " + result2_2 + " " + result2_3 + "\n " + result3 + "\n");
    System.out.println("Bank account created: \nAcc #:" + acc.getAccountNumber() + "\nBalance: " + acc.getBalance());
    acc.deposit(177);
    System.out.println("Account Balance is: " + acc.getBalance());
    acc.withdraw(5000);
    System.out.println("Account Balance is: " + acc.getBalance());
}