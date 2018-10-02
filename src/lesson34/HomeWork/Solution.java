package lesson34.HomeWork;

import java.io.*;
import java.util.Arrays;

public class Solution {

    public void transferFileContent(String fileFromPath, String fileToPath) throws Exception {


        validate(fileFromPath, fileToPath);


        writeToFile(fileToPath, readFromFile(fileFromPath));
        deleteFromFile(fileFromPath);


    }

    private void validate(String fileFromPath, String fileToPath) throws Exception {

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

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

    private StringBuffer readFromFile(String path) {
        StringBuffer content = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;

            while ((line = br.readLine()) != null) {
                content.append(line);
                content.append("\r\n");

            }
            content.replace(content.length() - 1, content.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Can't read file from " + path);
        }


        return content;
    }

    private void writeToFile(String path, StringBuffer content) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            bw.append(content);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    void deleteFromFile(String path) {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            bw.append("");
        } catch (IOException e) {
            System.err.println("Error");
        }
    }

    public void transferSentences(String fileFromPath, String fileToPath) {

        writeToFile(fileToPath, readSentences(fileFromPath));

    }

    private StringBuffer readSentences(String path) {
        StringBuffer content = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;


            while ((line = br.readLine()) != null) {

                for (int i = 0; i < validateSentence(line).length; i++) {
                    content.append(validateSentence(line)[i] + ".");

                }


            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Can't read file from " + path);
        }

        return content;
    }

    String[] validateSentence(String line) {

        String[] sentences = line.split("\\.");
        int count = 0;
        for (int i = 0; i < sentences.length; i++) {

            if (sentences[i].length() > 10) count++;

        }

        String[] res = new String[count];

        int index = 0;
        for (int i = 0; i < sentences.length; i++) {

            if (sentences[i].length() > 10) {
                res[index] = sentences[i];
                index++;
            }


        }

        return res;

    }

    void deleteSentences(String path, String line) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            for (int i = 0; i < validateSentence(line).length; i++) {
                bw.append("");
            }
        } catch (IOException e) {
            System.err.println("Error");
        }
    }
}
