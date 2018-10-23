package gromcode.main.lesson25;

import java.util.Arrays;

public class GeneralDAO<T> {

    private T[] dBase = (T[]) new Object[10];

    public T[] getdBase() {
        return dBase;
    }

    T save(T t) throws Exception {

        checkFreeSlots(t);


        for (int i = 0; i < dBase.length; i++) {
            if (dBase[i] == null) {
                dBase[i] = t;
                break;
            }
        }

        return t;
    }

    T[] getAll() {
        int count = 0;

        for (T el : dBase) {
            if (el != null) count++;
        }

        T[] res = (T[]) new Object[count];

        int index = 0;
        for (T el : dBase) {
            if (el != null) {
                res[index] = el;
                index++;
            }
        }


        return res;
    }


    private void print(Order order) {
        System.out.println(order.toString());
    }

    public <T extends IdEntity> void validate(T t) throws Exception {


        if (t.getId() <= 0) throw new Exception("id can't be nagative");

    }

    public <K> void validate(K k) {
        if (k.equals(100)) System.out.println("true");
        else System.out.println("false");
    }

    void checkFreeSlots(T t) throws Exception {
        int countFreeSlots = 0;

        for (T el : dBase) {
            if (el == null) countFreeSlots++;
        }

        if (countFreeSlots == 0) throw new Exception("No free slots. " + t + " can't be saved");
    }

    @Override
    public String toString() {
        return "GeneralDAO{" +
                "dBase=" + Arrays.toString(dBase) +
                '}';
    }
}
