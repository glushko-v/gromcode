package lesson34;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {



    public static void readFile(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
            return;
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }

    }






    static void writeFile(String path) throws InterruptedException {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true)))
        {
            bufferedWriter.append("\n");
            bufferedWriter.append(" asldkja");
        }
        catch (IOException e){
            System.err.println("Can't write to file");
        }

        
    }

    public static void writeToFileFromConsole(String path){

        InputStreamReader reader = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(reader);

        FileWriter writer = null;

        BufferedWriter bw = null;

        System.out.println("Please write something");

        try {

            writer = new FileWriter(path);
            bw = new BufferedWriter(writer);
            bw.append(br.readLine());

        } catch (IOException e) {
            System.err.println("Can't write to file");

        } finally {
            IOUtils.closeQuietly(bw);
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);

        }

    }

    public static void readFileByConsolePath(){

        InputStreamReader reader = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter file path to read");

        try {
            readFile(br.readLine());
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);

        }

    }

}
