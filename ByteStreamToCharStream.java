import java.io.*;

public class ByteStreamToCharStream {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            // Specify the file to read
            String fileName = "example.txt";

            // Create a FileInputStream to read binary data from the file
            FileInputStream fis = new FileInputStream(fileName);

            // Wrap FileInputStream in InputStreamReader to convert byte stream to character stream
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            // Wrap InputStreamReader in BufferedReader for efficient reading
            reader = new BufferedReader(isr);

            String line;
            System.out.println("File contents:");

            // Read the file line by line and print to console
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        finally {
            try {
                if (reader != null) {

                    // Close the reader
                    reader.close();
                }
            }
            catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}
