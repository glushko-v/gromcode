package lesson19.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        File file1 = new File(123456789, "test", "txt", 545);
        File file2 = new File(222222222, "John", "jpg", 4545);
        File file3 = new File(112, "guide", "doc", 788);
        File file4 = new File(321, "ttt1234567890", "txt", 99999);
        File file5 = new File(111, "somefile", "doc", 97898);

        Controller controller = new Controller();

        File[] files = {file1, file2, file3};
        File[] files1 = {null, null, file5, null};
        String[] formatsSupported = {"txt", "jpg", "doc"};

        Storage storage = new Storage(789, files, formatsSupported, "Ukraine", Long.MAX_VALUE);
        Storage storage1 = new Storage(11, files1, formatsSupported, "USA", 999999999);


        try {
            controller.put(storage, file5);
        }

        catch (NullPointerException npe){
            System.out.println(npe.getMessage());
        }

        catch(Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            controller.delete(storage1, file3);
        }
        catch (Exception e) {
            System.err.println("File not found");
        }



    }
}
