package lesson19.HomeWork;

public class Validator {

    static void validate(Storage storage, File file) throws Exception{

        if (file == null) throw new Exception("Null is detected");

        checkSize(storage, file);

        if (!checkFormat(storage, file)) throw new Exception("Format is not acceptable. Can not transfer file "
                + file.getId() + " to Storage " + storage.getId());

        checkDuplicateFiles(storage, file);

        if (countFreeSlots(storage) == 0) throw new Exception("No free slots. Can not transfer file "
                + file.getId() + " to Storage " + storage.getId());

    }

    static void checkSize(Storage storage, File file) throws Exception {


        long filesTotalSize = 0;

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null) filesTotalSize += storage.getFiles()[i].getSize();
        }

        if ((storage.getStorageSize() - filesTotalSize) < file.getSize())
            throw new Exception("Not enough space. Can not transfer file " + file.getId()
                    + " to Storage " + storage.getId());


    }

    static int countFreeSlots(Storage storage) {
        int count = 0;
        File[] files = storage.getFiles();

        for (File file : files) {
            if (file == null) count++;
        }

        return count;
    }

    static int countFiles(Storage storage) {
        File[] files = storage.getFiles();
        int count = 0;

        for (File file : files) {
            if (file != null) count++;
        }

        return count;
    }

    static void checkFreeSlots(Storage storageFrom, Storage storageTo) throws Exception {

        if (countFreeSlots(storageTo) < countFiles(storageFrom))
            throw new Exception("No free slots. Can not transfer files" +
                    " from Storage " + storageFrom.getId() + " Storage " + storageTo.getId());
    }

   static void checkDuplicateFiles(Storage storage, File file) throws Exception {

        File[] files = storage.getFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i] != null) {
                if (files[i].getId() == file.getId())
                    throw new Exception("File already in storage. " + "Can not transfer file "
                            + file.getId() + " to Storage " + storage.getId());
            }
        }


    }

    static void isEnoughSpace(Storage storageFrom, Storage storageTo) throws Exception {
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


    }

   static boolean checkFormat(Storage storage, File file) throws Exception {

        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (file.getFormat().equals(storage.getFormatsSupported()[i])) return true;


        }
        return false;

    }

}
