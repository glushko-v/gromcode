package lesson8.HomeWork2;

public class Demo {

    //test


    Student createHighestParent() {
        Course[] coursesTaken = new Course[5];
        Student student = new Student("Ivan", "Ivanov", 6, coursesTaken);
        return student;

    }

    SpecialStudent createLowestChild() {
        Course[] coursesTaken = new Course[5];
        SpecialStudent specialStudent = new SpecialStudent("Denis", "Petrov", 2, coursesTaken, 97534, "den@mail.com");
        return specialStudent;
    }


}
