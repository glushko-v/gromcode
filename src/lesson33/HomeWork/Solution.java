package lesson33.HomeWork;

import lesson33.ReadWriteFile;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {

    static void writeToFileFromConsole(String path){

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

    static void readFileByConsolePath(){

        InputStreamReader reader = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter file path to read");

        try {
            br.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);

        }

    }

}
