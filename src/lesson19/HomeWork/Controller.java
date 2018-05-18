package lesson19.HomeWork;

public class Controller {


    File put(Storage storage, File file) {

        File[] files = storage.getFiles();

        //1. проверка имени на количество букв+++
        //2. проверка размера+++
        //3. проверка Id+++
        //4. проверка формата+++
        //5. Файлы равны, если  одинаковый Id и имя
        //6. null check+++

        if (!checkFileName(file)) return null;
        if (file == null) return null;
        if (!checkSize(storage, file)) return null;
        if (!checkId(storage, file)) return null;
        if (!checkFormat(storage, file)) return null;

        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) files[i] = file;
        }


        return file;
    }


     void delete(Storage storage, File file) {

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

    boolean checkFormat(Storage storage, File file) {

        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (file.getFormat().equals(storage.getFormatsSupported()[i])) return true;
        }

        return false;
    }

    boolean checkSize(Storage storage, File file) {

        File[] files = storage.getFiles();

        long filesTotalSize = 0;

        for (int i = 0; i <files.length; i++) {
            if (files[i] != null) filesTotalSize += files[i].getSize();
        }
//
        return ((storage.getStorageSize() - filesTotalSize) > file.getSize());

//        return (storage.getStorageSize() >= file.getSize());

    }

    boolean checkFileName(File file) {
        char[] syms = file.getName().toCharArray();

        return (syms.length <= 9);
    }

    boolean checkId(Storage storage, File file) {

        File[] files = storage.getFiles();

        for (File file1 : files) {
            if (file1 != null) {
                if (file1.getId() == file.getId()) return false;
            }
        }
        return true;
    }


}
