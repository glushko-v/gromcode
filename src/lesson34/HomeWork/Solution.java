package lesson34.HomeWork;

import java.io.*;

public class Solution {

    public void transferFileContent (String fileFromPath, String fileToPath) throws Exception {



        validate(fileFromPath, fileToPath);


        writeToFile(fileToPath, readFromFile(fileFromPath));
        deleteFromFile(fileFromPath);




    }

    private void validate (String fileFromPath, String fileToPath) throws Exception {

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

    private StringBuffer readFromFile (String path){
        StringBuffer content = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();

            while(line != null) {
                content.append(line);
                content.append("\r\n");
            }

        }
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        catch (IOException e){
            System.err.println("Can't read file from " + path);
        }


        return content;
    }

    private void writeToFile (String path, StringBuffer content){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            bw.append(content);
        }
        catch (IOException e){
            System.err.println("Can't write to file");
        }
    }

    void deleteFromFile(String path){



        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))){
            bw.append("");
        }
        catch (IOException e){
            System.err.println("Error");
        }
    }

    public void transferSentences (String fileFromPath, String fileToPath, String word){
        //считать текст из файла1
        //если файлы содержат слово записать их в возвращаемый стринг
        //записать возвращаемый стринг в файл2
    }

    private StringBuffer readSentences (String path){
        StringBuffer content = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();

            while(line != null) {
                if (line.endsWith(".") && line.length() > 10 && line.startsWith(".")) {

                    content.append(line);
                    content.append("\r\n");
                }
            }

        }
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        catch (IOException e){
            System.err.println("Can't read file from " + path);
        }

        return content;
    }
}
