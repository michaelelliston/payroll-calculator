import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = myScanner.nextLine();

        System.out.println("Enter the number of hours you've worked:");
        String input = myScanner.nextLine();
        float hoursWorked = Float.parseFloat(input);

        System.out.println("Enter your pay rate:");
        input = myScanner.nextLine();
        float payRate = Float.parseFloat(input);

        float grossPay = hoursWorked * payRate;
        if (hoursWorked > 40) {
            int overtimeHours = (int)hoursWorked - 40;
            float overtimePay = (float) (overtimeHours * payRate * 1.5);
            float finalPay = 40 * payRate + overtimePay;
            System.out.printf("Hello, %s. Your gross pay with overtime is $%.2f.", name, finalPay);
        }
        else System.out.printf("Hello, %s. Your gross pay is $%.2f.", name, grossPay);
    }
}
