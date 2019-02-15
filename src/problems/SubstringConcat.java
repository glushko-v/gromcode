package problems;

public class SubstringConcat {
    public static void main(String[] args) {


        String string = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        testMethod(string, words);




    }

    public static void testMethod (String string, String[] words){

        for (int i = 0; i <words.length-1; i++) {
            String substring1 = words[i].concat(words[i+1]);
            String substring2 = words[i+1].concat(words[i]);
            if (string.contains(substring1)) System.out.print(string.indexOf(substring1) + " ");
            if (string.contains(substring2)) System.out.print(string.indexOf(substring2));

        }


    }
}
