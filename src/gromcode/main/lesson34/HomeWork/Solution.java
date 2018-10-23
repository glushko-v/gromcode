package gromcode.main.lesson34.HomeWork;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\r\n");
            }

            res.replace(res.length() - 1, res.length(), "");
        } catch (IOException e) {
            System.err.println("Can't read from file" + path);
        }

        return res;
    }

//    private StringBuffer readFromFile(String path) {
//        StringBuffer content = new StringBuffer();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                content.append(line);
//                content.append("\r\n");
//
//            }
//            content.replace(content.length() - 1, content.length(), "");
//        } catch (FileNotFoundException e) {
//            System.err.println("File not found");
//        } catch (IOException e) {
//            System.err.println("Can't read file from " + path);
//        }
//
//
//        return content;
//    }

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

    void removeContent(String path, StringBuffer content) {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {

            bw.append(content + ".");

        } catch (IOException e) {
            System.err.println("Error");
        }


    }


    public void transferSentences(String fileFromPath, String fileToPath, String word) throws IOException {


//            String fileContent = readFromFile(fileFromPath).toString();
//
//            String[] sentences = fileContent.split("\\.");
//
//            StringBuffer sentencesWithWord = new StringBuffer();
//            for (String sentence : sentences) {
//                if (sentence.contains(word) && sentence.length() > 10) {
//                    sentencesWithWord.append(sentence).append(".");
//                    fileContent = fileContent.replace(sentencesWithWord + ".", "");
//                }
//            }
//
//            StringBuffer fileToBackup = readFromFile(fileToPath);
//            try {
//                writeToFile(fileFromPath, fileContent, false);
//                writeToFile(fileToPath, sentencesWithWord, true);
//            } catch (IOException e) {
//                writeToFile(fileFromPath, fileContent, false);
//                writeToFile(fileToPath, fileToBackup, false);
//            }



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

            if (sentences[i].length() > 10 && !sentences[i].isEmpty()) count++;


        }

        String[] res = new String[count];

        int index = 0;
        for (int i = 0; i < sentences.length; i++) {

            if (sentences[i].length() > 10 && sentences[i].isEmpty()) {
                res[index] = sentences[i];
                index++;
            }


        }

        return res;

    }

    String[] deleteSentences(String line) {

        String[] sentences = line.split("\\.");

        int count = 0;

        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].length() < 10) count++;
        }

        String[] res = new String[count];

        int index = 0;

        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].length() < 10) {
                res[index] = sentences[i].replaceAll("\\.", "");
                index++;
            }

        }
        return res;


    }

    StringBuffer deleteContent(String path) {

        StringBuffer content = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;


            while ((line = br.readLine()) != null) {
                for (int i = 0; i < deleteSentences(line).length; i++) {
                    content.append(deleteSentences(line)[i]);
                }
            }

        } catch (IOException e) {
            System.err.println("Error");
        }

        return content;
    }

    void copyFileContent(String fileFromPath, String fileToPath) throws Exception {


        validate(fileFromPath, fileToPath);

        Path fileFrom, fileTo;
        fileFrom = Paths.get(fileFromPath).toAbsolutePath();
        fileTo = Paths.get(fileToPath).toAbsolutePath();


        Files.copy(fileFrom, fileTo);


    }

    void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        FileUtils.copyFile(fileFrom, fileTo);

    }

//    private static <T extends CharSequence> void writeToFile(String path, T contentToWrite, boolean append) throws IOException {
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
//            bufferedWriter.append(contentToWrite);
//        } catch (IOException e) {
//            throw new IOException("Can't write to file " + path, e);
//        }
//    }


}
