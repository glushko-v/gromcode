package lesson19.HomeWork;

import java.io.FileNotFoundException;


public class Controller {


    File[] transferAll(Storage storageFrom, Storage storageTo) throws Exception {


        File[] filesFrom = storageFrom.getFiles();
        File[] filesTo = storageTo.getFiles();
        isEnoughSpace(storageFrom, storageTo);

        for (int i = 0; i < filesFrom.length; i++) {
            if (filesFrom[i] != null) {

                validate(storageTo, filesFrom[i]);

                checkFreeSlots(storageFrom, storageTo);

                for (int j = 0; j < filesTo.length; j++) {
                    if (filesTo[j] == null) {
                        filesTo[j] = filesFrom[i];
                        filesFrom[i] = null;
                    }
                }


            }
        }


        return filesTo;
    }

    File transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {


        File[] filesFrom = storageFrom.getFiles();
        File[] filesTo = storageTo.getFiles();

        File fileToTransfer = findById(id, storageFrom);

        if (fileToTransfer == null) throw new Exception("Null is detected");

        isFileExists(storageFrom, fileToTransfer);

        validate(storageTo, fileToTransfer);


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

        validate(storage, file);


        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;
                break;
            }

        }


        return file;
    }


    void delete(Storage storage, File file) throws Exception {

        if (file == null) throw new Exception("Null is detected");

        isFileExists(storage, file);


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

    File findById(long id, Storage storage) {
        for (File file : storage.getFiles()) {
            if (file != null) {
                if (id == file.getId()) return file;

            }
        }

        return null;
    }

    void checkFormat(Storage storage, File file) throws Exception {

        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (!file.getFormat().equals(storage.getFormatsSupported()[i]))
                throw new Exception("Invalid format. Can not transfer file " + file.getId()
                        + " to Storage " + storage.getId());

        }


    }

    void checkSize(Storage storage, File file) throws Exception {

        File[] files = storage.getFiles();

        long filesTotalSize = 0;

        for (int i = 0; i < files.length; i++) {
            if (files[i] != null) filesTotalSize += files[i].getSize();
        }

        if ((storage.getStorageSize() - filesTotalSize) < file.getSize())
            throw new Exception("Not enough space. Can not transfer file " + file.getId()
                    + " to Storage " + storage.getId());


    }

    void checkFileName(Storage storage, File file) throws Exception {

        char[] syms = file.getName().toCharArray();

        if (syms.length > 9) throw new Exception("Invalid file name. Can not transfer file " + file.getId() +
                " to Storage " + storage.getId());
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

    void checkFreeSlots(Storage storageFrom, Storage storageTo) throws Exception {

        if (countFreeSlots(storageTo) >= countFiles(storageFrom))
            throw new Exception("No free slots. Can not transfer files" +
                    " from Storage " + storageFrom.getId() + " Storage " + storageTo.getId());
    }

    void checkDuplicateFiles(Storage storage, File file) throws Exception {

        File[] files = storage.getFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i] != null) {
                if (files[i].getId() == file.getId())
                    throw new Exception("File already in storage. " + "Can not transfer file "
                            + file.getId() + " to Storage " + storage.getId());
            }
        }


    }

    void isEnoughSpace(Storage storageFrom, Storage storageTo) throws Exception {
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

        if (filesFromSize > (storageTo.getStorageSize() - filesToSize))
            throw new Exception("Not enough space. Can not transfer files " +
                    "from Storage " + storageFrom.getId() + " to storage " + storageTo.getId());
        ;

    }

    void isFileExists(Storage storage, File file) throws Exception {

        if (file == null) throw new Exception("Null is detected");

        if (findById(file.getId(), storage) == null)
            throw new Exception("File not found. Can not delete file " + file.getId() +
                    " from Storage " + storage.getId());

    }

    void validate(Storage storage, File file) throws Exception {

        if (file == null) throw new Exception("Null is detected");

        checkFileName(storage, file);

        checkSize(storage, file);

        checkFormat(storage, file);

        checkDuplicateFiles(storage, file);

        if (countFreeSlots(storage) == 0) throw new Exception("No free slots. Can not transfer file "
                + file.getId() + " to Storage " + storage.getId());


    }

//    void validateBeforeDelete(Storage storage, File file) throws Exception {
//
//        if (file == null) throw new Exception("Null is detected. Can not delete file " + file.getId()
//                + " from Storage " + storage.getId());
//
//        if (!checkFileName(file)) throw new Exception("Invalid file name. Can not delete file " + file.getId() +
//                " from Storage " + storage.getId());
//
//
//        if (!checkFormat(storage, file)) throw new Exception("Invalid format. Can not delete file " + file.getId()
//                + " from Storage " + storage.getId());
//
//    }


}
