package lesson19.HomeWork;

public class Controller {


    void put(Storage storage, File file) {

        // проверка формата
        // проверка размера

        // проверка id
        // имя не больше 10 символов


    }


    void delete (Storage storage, File file) {

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null) {
                if (storage.getFiles()[i].equals(file)) storage.getFiles()[i] = null;

            }
        }
    }

    File findbyId(long id, Storage storage) {
        for (File file : storage.getFiles()) {
            if (file != null) {
                if (id == file.getId()) return file;
            }
        }

        return null;
    }

    boolean checkFormat (Storage storage, File file){

        for (int i = 0; i <storage.getFormatsSupported().length; i++) {
            if (file.getFormat().equals(storage.getFormatsSupported()[i]))return true;
        }

        return false;
    }




}
