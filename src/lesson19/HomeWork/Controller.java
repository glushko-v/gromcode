package lesson19.HomeWork;

import java.sql.SQLOutput;

public class Controller {


    File[] transferAll(Storage storageFrom, Storage storageTo) {


        File[] filesFrom = storageFrom.getFiles();
        File[] filesTo = storageTo.getFiles();

        for (int i = 0; i < filesFrom.length; i++) {
            if (checkFreeSlots(storageFrom, storageTo)) {
                if (filesFrom[i] != null) {
                    for (int j = 0; j < filesTo.length; j++) {
                        if (filesTo[j] == null) {
                            try {
                                filesTo[j] = checkFile(storageTo, filesFrom[i]);
                            } catch (Exception e) {
                                System.out.println("Invalid file");
                            }
                            filesFrom[i] = null;
                        }
                    }

                }
            }
        }

        if (!checkFreeSlots(storageFrom, storageTo)) throw new IndexOutOfBoundsException("No free slots");


        return filesTo;
    }

    File transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {


        File[] filesFrom = storageFrom.getFiles();
        File[] filesTo = storageTo.getFiles();
        File fileToTransfer = findById(id, storageFrom);

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

        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;
                break;
            }



        }


        return file;
    }


    void delete(Storage storage, File file) throws Exception {

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null)

                if (storage.getFiles()[i].equals(file)) {
                    storage.getFiles()[i] = null;
                    break;
                }
                else throw new Exception("Nothing to delete");


        }
    }

    private File findById(long id, Storage storage) {
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

        for (int i = 0; i < files.length; i++) {
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

    File checkFile(Storage storage, File file) throws Exception {


        if (file == null) throw new NullPointerException();

        if (!checkFileName(file)) throw new Exception("Invalid file name");

        if (!checkSize(storage, file)) return null;
        if (!checkId(storage, file)) return null;
        if (!checkFormat(storage, file)) return null;


        return file;
    }

    int countFiles(Storage storage) {
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
            if (files[i].equals(file)) {
                return false;
            }
        }

        return true;
    }


}
