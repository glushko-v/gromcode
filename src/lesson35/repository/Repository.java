package lesson35.repository;


import lesson35.UserType;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

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

    public Collection<?> returnObjects(String path){

        ArrayList<Object> objectList = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;



            while((line = br.readLine()) != null){

                Object object = new Object();




                String[] lines = line.split(",");

                if (object instanceof Hotel) {

                    for (int i = 0; i < lines.length; i++) {

                        ((Hotel) object).setId(Long.parseLong(lines[0]));
                        ((Hotel) object).setName(lines[1]);
                        ((Hotel) object).setCity(lines[2]);
                        ((Hotel) object).setCountry(lines[3]);
                        ((Hotel) object).setStreet(lines[4]);
                    }
                }

                else if (object instanceof User) {
                    for (int i = 0; i <lines.length; i++) {
                        ((User) object).setId(Long.parseLong(lines[0]));
                        ((User) object).setUserName(lines[1]);
                        ((User) object).setPassword(lines[2]);
                        ((User) object).setCountry(lines[3]);
                        ((User) object).setUserType(UserType.valueOf(lines[4]));
                    }
                }

                else if (object instanceof Room){
                    for (int i = 0; i <lines.length; i++) {
                        ((Room) object).setId(Long.parseLong(lines[0]));
                        ((Room) object).setNumberOfGuests(Integer.parseInt(lines[1]));
                        ((Room) object).setPrice(Double.parseDouble(lines[2]));
                        ((Room) object).setBreakfastIncluded(Boolean.getBoolean(lines[3]));
                        ((Room) object).setPetsAllowed(Boolean.getBoolean(lines[4]));
                        ((Room) object).setDateAvailableFrom(Date.valueOf(lines[5]));
                        ((Room) object).setHotel(Hotel.findById(Long.parseLong(lines[6])));
                    }
                }
                objectList.add(object);




            }


        }
        catch (Exception e){
            System.err.println("Can't read file");
        }






        return objectList;

    }



}
