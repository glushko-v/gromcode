package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {



    public static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }


    }

    static void writeFile(String path) {

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.append("\n");
            bufferedWriter.append(" asldkja");

        } catch (IOException e) {
            System.err.println("Can't write to file");
            return;
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
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
