package gromcode;

public class UniqueCount {
    public static void main(String[] args) {
        int [] newarr = {5, 16, 22, 4, 5, 6, 4, 32, 22, 176};
        System.out.println(uniqueCount(newarr));

    }


    static int uniqueCount(int[] array){
        int countAll = 0;
        int result = 0;
        int count = 0;
        for (int i = 0; i <array.length; i++) {
            countAll++;
            for (int j = i+1; j <array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                    break;
                }
            }
        }
        return result = countAll - count;

    }
}
