package gromcode.main.lesson34.HomeWork;

import java.io.*;

public class newSolution {

    public void transferSentences(String fileFromPath, String fileToPath, String word) throws IOException {
        String fileContent = readFromFile(fileFromPath).toString();


        String[] sentences = fileContent.split("\\.");



        StringBuffer sentencesWithWord = new StringBuffer();
        for (String sentence : sentences) {
            if (sentence.contains(word) && sentence.length() > 10) {
                sentencesWithWord.append(sentence).append(".");
                fileContent = fileContent.replace(sentencesWithWord + ".", "");
            }
        }

        StringBuffer fileToBackup = readFromFile(fileToPath);
        try {
            writeToFile(fileFromPath, fileContent, false);
            writeToFile(fileToPath, sentencesWithWord, true);
        } catch (IOException e) {
            writeToFile(fileFromPath, fileContent, false);
            writeToFile(fileToPath, fileToBackup, false);
        }
    }


    private StringBuffer readFromFile(String path) throws IOException {

        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\r\n");
            }

//            res.replace(res.length() - 1, res.length(), "");
        } catch (IOException e) {
            throw new IOException("Reading from file " + path + "failed", e);
        }


        return res;
    }

    private static <T extends CharSequence> void writeToFile(String path, T contentToWrite, boolean append) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            throw new IOException("Can't write to file " + path, e);
        }
    }

}
