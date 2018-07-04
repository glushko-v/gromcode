package lesson25;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();
//        Order order = new Order(1);
//
//        generalDAO.validate(order);
//
//        TestClass<String, Order, Long> testClass = new TestClass();
//        testClass.doSomething1("111");
//
//        Long variable2 = new Long(222);
//
//        generalDAO.validate(variable2);

        generalDAO.save("Word");
        generalDAO.save(123);
        generalDAO.save(11L);
        generalDAO.save("lkfjslgdvksl");
        generalDAO.save("11");
        generalDAO.save(0);


        System.out.println(Arrays.toString(generalDAO.getAll()));

    }
}
