import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine(); // Read the header

            String input;              // Declare variable, then read the rest of the file
            while((input = bufferedReader.readLine()) != null) {
                String[] categories = input.split("\\|"); // Splitting the string

                int id = Integer.parseInt(categories[0]);
                String name = categories[1];
                double hoursWorked = Double.parseDouble(categories[2]);
                double payRate = Double.parseDouble(categories[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                System.out.printf("Employee with an ID of \"%d\" named %s made $%.2f\n", employee.getId(), employee.getName(), employee.calculateGrossPay());
            }


        } catch (FileNotFoundException e) { // Catches the possible exception for fileReader
            System.out.println("The requested file was not found: " + e);
        } catch (IOException ioe) {  // Catches the possible exception for readLine
            System.out.println("Some sort of IO exception occurred: " + ioe);
        }
    }
}
