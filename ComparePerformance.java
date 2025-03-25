import java.io.*;

public class ComparePerformance {
    public static void main(String[] args) {
        compareStringBuilderVsStringBuffer();
        compareFileReaderVsInputStreamReader("large_text_file.txt");
    }

    private static void compareStringBuilderVsStringBuffer() {
        int iterations = 1_000_000;
        String text = "hello";

        // Using StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1e6 + " ms");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1e6 + " ms");
    }

    private static void compareFileReaderVsInputStreamReader(String filePath) {
        try {
            // Using FileReader
            long startTime = System.nanoTime();
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            int wordCount = countWords(br);
            br.close();
            fr.close();
            long endTime = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount + " | Time: " + (endTime - startTime) / 1e6 + " ms");

            // Using InputStreamReader
            startTime = System.nanoTime();
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            wordCount = countWords(br);
            br.close();
            isr.close();
            fis.close();
            endTime = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount + " | Time: " + (endTime - startTime) / 1e6 + " ms");
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static int countWords(BufferedReader br) throws IOException {
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        return wordCount;
    }
}
