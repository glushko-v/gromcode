package lesson19.HomeWork;

import java.io.FileNotFoundException;


public class Controller {


    File[] transferAll(Storage storageFrom, Storage storageTo) throws Exception {


        File[] filesFrom = storageFrom.getFiles();
        File[] filesTo = storageTo.getFiles();
        if (!isEnoughSpace(storageFrom, storageTo)) throw new Exception("Not enough space");

        for (int i = 0; i < filesFrom.length; i++) {
            if (checkFreeSlots(storageFrom, storageTo)) {
                if (filesFrom[i] != null) {
                    for (int j = 0; j < filesTo.length; j++) {
                        if (filesTo[j] == null) {

                            filesTo[j] = checkFile(storageTo, filesFrom[i]);

                            filesFrom[i] = null;
                        }
                    }

                } else throw new NullPointerException();
            }
        }

        if (!checkFreeSlots(storageFrom, storageTo)) throw new IndexOutOfBoundsException("No free slots");


        return filesTo;
    }

    File transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {


        File[] filesFrom = storageFrom.getFiles();
        File[] filesTo = storageTo.getFiles();

        File fileToTransfer = findById(id, storageFrom);


        if (!isFileExists(storageFrom, fileToTransfer)) {
            throw new Exception("File not found");
        }
        if (fileToTransfer == null) return null;


        fileToTransfer = checkFile(storageTo, fileToTransfer);


        if (!checkFreeSlots(storageFrom, storageTo)) throw new IndexOutOfBoundsException("Can not transfer file " +
                fileToTransfer.getName() + " ID " + fileToTransfer.getId() + " to storage " + storageTo.getId());


        for (int i = 0; i < filesTo.length; i++) {
            if (filesTo[i] == null) {
                filesTo[i] = fileToTransfer;
                break;
            }
        }


        for (int i = 0; i < filesFrom.length; i++) {
            if (filesFrom[i] == fileToTransfer) {
                filesFrom[i] = null;
                break;
            }
        }


        return fileToTransfer;

    }


    File put(Storage storage, File file) throws Exception {

        File[] files = storage.getFiles();


        file = checkFile(storage, file);


        if (countFreeSlots(storage) == 0) throw new IndexOutOfBoundsException("No free slots");
        if (!checkDuplicateFiles(storage, file)) throw new Exception("File already in storage");

        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;
                break;
            }

        }


        return file;
    }


    void delete(Storage storage, File file) throws Exception {

        if (!isFileExists(storage, file)) throw new Exception("File not found");

        File[] files = storage.getFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i] != null) {
                if (files[i] == file) {
                    files[i] = null;
                    break;
                }
            }
        }


    }

    File findById(long id, Storage storage) throws Exception {
        for (File file : storage.getFiles()) {
            if (file != null) {
                if (id == file.getId()) return file;
                else throw new Exception("Wrong ID");
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

        for (int i = 0; i < files.length; i++) {
            if (files[i] != null) filesTotalSize += files[i].getSize();
        }

        return ((storage.getStorageSize() - filesTotalSize) > file.getSize());



    }

    boolean checkFileName(File file) {

        char[] syms = file.getName().toCharArray();

        return (syms.length <= 9);
    }

//    boolean checkId(long id, File file) {
//
////        File[] files = storage.getFiles();
////
////        for (File file1 : files) {
////            if (file1 != null) {
////                if (file1.getId() == file.getId()) return false;
////            }
////        }
////        return true;
//        if (file == null) return false;
//
//        return (id == file.getId());
//
//    }

    private File checkFile(Storage storage, File file) throws Exception {


        if (file == null) return null;

        if (!checkFileName(file)) throw new Exception("Invalid file name");

        if (!checkSize(storage, file)) throw new Exception("Not enough space");

        if (!checkFormat(storage, file)) throw new Exception("Invalid format");


        return file;
    }

    private int countFiles(Storage storage) {
        File[] files = storage.getFiles();
        int count = 0;

        for (File file : files) {
            if (file != null) count++;
        }

        return count;
    }

    int countFreeSlots(Storage storage) {
        int count = 0;
        File[] files = storage.getFiles();

        for (File file : files) {
            if (file == null) count++;
        }

        return count;
    }

    boolean checkFreeSlots(Storage storageFrom, Storage storageTo) {

        return (countFreeSlots(storageTo) >= countFiles(storageFrom));
    }

    boolean checkDuplicateFiles(Storage storage, File file) {

        File[] files = storage.getFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i] != null) {
                if (files[i].equals(file)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean isEnoughSpace(Storage storageFrom, Storage storageTo) {
        File[] filesFrom = storageFrom.getFiles();
        File[] filesTo = storageTo.getFiles();
        long filesFromSize = 0;
        long filesToSize = 0;

        for (int i = 0; i < filesFrom.length; i++) {
            if (filesFrom[i] != null) filesFromSize += filesFrom[i].getSize();
        }
        for (int i = 0; i < filesTo.length; i++) {
            if (filesTo[i] != null) filesToSize += filesTo[i].getSize();
        }

        return (filesFromSize <= (storageTo.getStorageSize() - filesToSize));

    }

    boolean isFileExists(Storage storage, File file) throws Exception {

        if (file == null) return false;

        return (findById(file.getId(), storage) != null);

    }


}
