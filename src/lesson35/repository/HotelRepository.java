package lesson35.repository;

import gromcode.main.lesson4.test1;
import lesson35.model.Hotel;

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.util.Arrays;

public class HotelRepository {


    public Hotel addHotel(Hotel hotel) throws Exception {

        if (!validateId(hotel.getId())) throw new Exception("Hotel with id " + hotel.getId() + " already exists");

        writeHotelDataToFile(readHotelData(hotel));


        return hotel;
    }

    public void deleteHotel(){
        //1. 


    }

    public StringBuffer readHotelData(Hotel hotel) {

        StringBuffer hotelData = new StringBuffer();

        hotelData.append(hotel.getId() + "," + " ");
        hotelData.append(hotel.getName() + "," + " ");
        hotelData.append(hotel.getCity() + "," + " ");
        hotelData.append(hotel.getCountry() + "," + " ");
        hotelData.append(hotel.getStreet());


        return hotelData;

    }

    public void writeHotelDataToFile(StringBuffer hotelData) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TEST\\HotelDb.txt", true))) {

            bw.append(hotelData);
            bw.append("\r\n");
        } catch (IOException e) {
            System.err.println("Error");
        }
    }


    public long[] readIdFromFile() {

        StringBuffer ids = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TEST\\HotelDb.txt"))) {
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
            idsFinal[i] = Long.parseLong(idsArray[i]);
        }


        return idsFinal;


    }

    public boolean validateId(long id) {

        for (int i = 0; i < readIdFromFile().length; i++) {
            if (readIdFromFile()[i] == id) return false;
        }

        return true;
    }

}
