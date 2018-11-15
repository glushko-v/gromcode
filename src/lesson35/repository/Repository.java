package lesson35.repository;


import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.*;

public abstract class Repository<T> {

    long id;


    public long[] readIdFromFile(String path) {

        StringBuffer ids = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;


            while ((line = br.readLine()) != null) {


                String[] lines = line.split(",");


                for (int i = 0; i < lines.length; i++) {

                    if (lines[i].matches("[0-9]+")) {

                        ids.append(lines[i]);
                        ids.append("\n");

                    }


                }


            }


        } catch (IOException e) {
            System.err.println("Error");
        }

        String stringIds = ids.toString();
        String[] idsArray = stringIds.split("\n");
        long[] idsFinal = new long[idsArray.length];

        for (int i = 0; i < idsArray.length; i++) {
            if (!idsArray[i].isEmpty()) {
                idsFinal[i] = Long.parseLong(idsArray[i]);
            } else break;
        }


        return idsFinal;


    }


    public void delete(long id, String path) {

        StringBuffer input = new StringBuffer();


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] lines = line.split(",");

                if (Long.parseLong(lines[0]) != id) {
                    input.append(line);
                    input.append("\r\n");
                }

            }


        } catch (IOException e) {
            System.err.println("Error");
        }

        writeDataToFile(input, false, path);


    }

    public void writeDataToFile(StringBuffer data, boolean append, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {

            bw.append(data);
            bw.append("\r\n");
        } catch (IOException e) {
            System.err.println("Error");
        }
    }


    boolean validateId(long id, String path) {

        for (int i = 0; i < readIdFromFile(path).length; i++) {
            if (readIdFromFile(path)[i] == id) return false;
        }

        return true;
    }


    public abstract T add(T t, String path) throws Exception;


}
