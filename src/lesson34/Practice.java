package lesson34;

import java.io.*;

public class Practice {

    public static void main(String[] args) throws Exception {

        copyFileContent("C:\\TEST\\test.txt", "C:\\TEST\\test2.txt");

    }


    public static void copyFileContent (String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);

        writeToFile(fileToPath, readFromFile(fileFromPath));


    }

    private static StringBuffer readFromFile(String path) {

        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                res.append(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");

        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }

        return res;

    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true)))
        {
            bufferedWriter.append(contentToWrite);

        }
        catch (IOException e){
            System.err.println("Can't write to file");
        }

    }

    private static void validate (String fileFromPath, String fileToPath) throws Exception {

        File fileFrom = new File(fileFromPath);
        File fileTo = new File (fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + "does not have permission to read");
        }

        if (!fileFrom.canWrite()) {
            throw new Exception("File " + fileTo + "does not have permission to write");
        }

    }
}
