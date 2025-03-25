import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Create InputStreamReader to read from console
            InputStreamReader isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);

            // Create FileWriter to write to a file
            FileWriter fw = new FileWriter("user_input.txt");
            writer = new BufferedWriter(fw);

            System.out.println("Enter text (type 'exit' to stop):");
            String input;

            // Read user input and write to file
            while (!(input = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(input);
                // Write new line in file
                writer.newLine();
            }

            System.out.println("User input successfully saved to 'user_input.txt'.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            }
            catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
