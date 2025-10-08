import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Would you rather write the data into a csv or json?");
        String fileType = myScanner.nextLine();
        LocalDate currentDate = LocalDate.now();

        try (FileWriter writer = new FileWriter("src/main/resources/payroll-" + currentDate + "." + fileType)){
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine(); // Read the header
            writer.write("id|name|gross pay\n");

            String input;              // Declare variable, then read the rest of the file
            while((input = bufferedReader.readLine()) != null) {
                String[] categories = input.split("\\|"); // Splitting the string

                int id = Integer.parseInt(categories[0]);
                String name = categories[1];
                double hoursWorked = Double.parseDouble(categories[2]);
                double payRate = Double.parseDouble(categories[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                System.out.println("Employee with an ID of " + employee.getId() + " named " + employee.getName() + " made " + employee.calculateGrossPay());
                writer.write(employee.getId() + "|" + employee.getName() + "|" + employee.calculateGrossPay() + "\n");
            }


        } catch (FileNotFoundException e) { // Catches the possible exception for fileReader
            System.out.println("The requested file was not found: " + e);
        } catch (IOException ioe) {  // Catches the possible exception for readLine
            System.out.println("Some sort of IO exception occurred: " + ioe);
        }
    }
}
