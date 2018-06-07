package lesson19.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        File file1 = new File(123456789, "test", "txt", 36564);
        File file2 = new File(222222222, "John", "jpg", 999999999);
        File file3 = new File(112, "guide", "txt", 99999999);
        File file4 = new File(321, "ttt1", "txt", 78798);
        File file5 = new File(111, "somefile", "doc", 97898);
        File file6 = new File(898, "ddd", "jpg", 55);

        Controller controller = new Controller();

        File[] files = {file1, file2, file3, null, null};
        File[] files1 = {null, null, file5, file4};
        String[] formatsSupported = {"txt", "jpg", "doc"};

        Storage storage = new Storage(789, files, formatsSupported, "Ukraine", Long.MAX_VALUE);
        Storage storage1 = new Storage(11, files1, formatsSupported, "USA", Long.MAX_VALUE);

        controller.transferAll(storage1, storage);
















    }
}
