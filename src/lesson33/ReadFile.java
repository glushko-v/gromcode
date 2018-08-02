package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadFile {

    public static void main(String[] args) {

        readFile("C:\\TEMP\\test.txt");


    }

    private static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        }
        catch (FileNotFoundException e){
            System.err.println("File doesn't exist");
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.err.println("Reading from file " + path + " failed");
        } finally {
            IOUtils.closeQuietly(br);
        }


    }

    private static void writeFile (String path){
        
    }

}
