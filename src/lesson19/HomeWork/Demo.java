package lesson19.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        File file1 = new File(123456789, "test", "txt", 545);
        File file2 = new File(222222222, "John", "jpeg", 4545);
        File file3 = new File(112, "guide", "doc", 788);
        File file4 = new File(321, "ttttt", "txt", 211);

        Controller controller = new Controller();

        File[] files = {file1, file2, file3};
        String[] formatsSupported = {"txt", "jpg", "doc"};

        Storage storage = new Storage(789, files, formatsSupported, "Ukraine", 999999999);

        controller.delete(storage, file1);
        controller.put(storage, file4);



        System.out.println(Arrays.toString(files));


    }
}
