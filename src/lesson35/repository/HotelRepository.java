package lesson35.repository;

import lesson35.model.Hotel;

import java.io.*;

public class HotelRepository {

    Hotel addHotel(Hotel hotel) {

        //1. считываем через консоль название отеля
        //2. считываем страну
        //3. считываем город
        //4. присваиваем уникальный id
        //4.1 первая цифра - порядковый номер
        //4.2 вторая цифра - страна
        //4.3 третья цифра - город
        //5. записываем все в файл


        return hotel;
    }

    public StringBuffer readHotelDataFromKeyboard() {

        StringBuffer hotelData = new StringBuffer();


        try (InputStreamReader reader = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(reader)) {
            System.out.println("Please enter name of Hotel");

            hotelData.append(br.readLine() + "," + " ");

            System.out.println("Please enter country name");

            hotelData.append(br.readLine() + "," + " ");

            System.out.println("Please enter city name");

            hotelData.append(br.readLine() + "," + " ");

            System.out.println("Please enter street name");

            hotelData.append(br.readLine() + ",");




        } catch (IOException e) {
            System.err.println("Error");
        }

        return hotelData;

    }

    public void writeHotelDataToFile(StringBuffer hotelData){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\TEST\\HotelDb.txt", true))) {
            bw.append(hotelData);
            bw.append("\r\n");
        }
        catch (IOException e){
            System.err.println("Error");
        }
    }

    public void readHotelFromFile(){

        //считываем из файла данные отеля
        //имя объекта - название отеля + название города


    }

    public void test(){
        writeHotelDataToFile(readHotelDataFromKeyboard());
    }
}
