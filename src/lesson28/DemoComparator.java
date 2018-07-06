package lesson28;

import java.util.*;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "test", "asas", true, new Date());
        Capability capability2 = new Capability(1005, "test", "asas", false, new Date());
        Capability capability3 = new Capability(900, "test", "asas", true, new Date());

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);

        System.out.println(capabilities);

        capabilities.sort(new IsActiveComparator());

        System.out.println(capabilities);

        Comparator<Capability> comparator = new Comparator<Capability>() {
            @Override
            public int compare(Capability o1, Capability o2) {
                //если поле channelName не равно - сравниваю по нему
                //если равно - перехожу к fingerPrint
                //если fingerprint равно перехожу к dateCreated
                //если dateCreated равно возвращаем 0


                if (!o1.getChannelName().equals(o2.getChannelName()))
                return o1.getChannelName().compareTo(o2.getChannelName());

                return 0;
            }
        };


    }
}
