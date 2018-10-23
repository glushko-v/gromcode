package gromcode.main.lesson19.HomeWork;

public class Controller {


    File[] transferAll(Storage storageFrom, Storage storageTo) throws Exception {


        File[] filesFrom = storageFrom.getFiles();
        File[] filesTo = storageTo.getFiles();
        Validator.isEnoughSpace(storageFrom, storageTo);

        for (int i = 0; i < filesFrom.length; i++) {
            if (filesFrom[i] != null) {


                Validator.validate(storageTo, filesFrom[i]);


                Validator.checkFreeSlots(storageFrom, storageTo);


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


        Validator.validate(storageTo, fileToTransfer);


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


        Validator.validate(storage, file);


        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                break;
            }

        }


        return file;
    }


    void delete(Storage storage, File file) throws Exception {

        if (file == null) throw new Exception("Null is detected. Can not delete file from Storage " + storage.getId());
        if (findById(file.getId(), storage) == null)
            throw new Exception("File not found. Can not delete file " + file.getId() +
                    " from Storage " + storage.getId());




        for (int i = 0; i <storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null) {
                if (findById(file.getId(), storage).equals(storage.getFiles()[i])) {
                    storage.getFiles()[i] = null;
                    break;
                }
            }
        }

//        for (int i = 0; i < storage.getFiles().length; i++) {
//            if (storage.getFiles()[i] != null) {
//                if (storage.getFiles()[i].equals(file)) {
//                    storage.getFiles()[i] = null;
//                    break;
//                }
//            }
//
//        }




    }

    File findById(long id, Storage storage) {
        for (File file : storage.getFiles()) {
            if (file != null) {
                if (id == file.getId()) return file;
            }
        }

        return null;
    }


}
