package lesson31;

import java.util.HashMap;
import java.util.Map;

public class MapIntro {
    public static void main(String[] args) {
        Map<String, Building> map = new HashMap<>();

        Building building1 = new Building("school", 5);
        Building building2 = new Building("hospital", 8);

        map.put("TTT222", building1);
        map.put("TGP321", building2);

        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(map.get("TGP321"));
    }
}
