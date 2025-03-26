import java.io.*;
        import java.util.Scanner;

public class Large_File_Reading_Effeciency {

    // Read using FileReader
    public static long readFileUsingFileReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        FileReader fileReader = new FileReader(filePath);
        int ch;
        while ((ch = fileReader.read()) != -1) {
            // Read character by character
        }
        fileReader.close();
        return System.nanoTime() - startTime;
    }

    // Read using InputStreamReader
    public static long readFileUsingInputStreamReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        int ch;
        while ((ch = inputStreamReader.read()) != -1) {
            // Read byte by byte and convert to characters
        }
        inputStreamReader.close();
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        try {
            // Calculate performance
            long fileReaderTime = readFileUsingFileReader(filePath);
            long inputStreamReaderTime = readFileUsingInputStreamReader(filePath);

            System.out.println("File Size: " + new File(filePath).length() / (1024 * 1024) + " MB");
            System.out.println("FileReader Time: " + fileReaderTime / 1_000_000.0 + " ms");
            System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1_000_000.0 + " ms");

        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }
}
