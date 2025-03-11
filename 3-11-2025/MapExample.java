import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("alice", 30);
        ages.put("bob", 25);
        ages.put("charlie", 35);

        int aliceAge = ages.get("alice");
        System.out.println("Alice's age: " + aliceAge);

        boolean hasBob = ages.containsKey("bob");
        System.out.println("Has Bob: " + hasBob);

        ages.remove("charlie");

        int size = ages.size();
        System.out.println("Size of map: " + size);
    }
}
