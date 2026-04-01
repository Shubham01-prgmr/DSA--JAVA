import java.util.HashMap;
import java.util.Set;
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 150);
        map.put("china", 180);
        map.put("nepal", 10);
        map.put("usa", 80);
        System.out.println(map);

        System.out.println(map.remove("usa"));
        System.out.println(map);

        System.out.println(map.containsKey("India"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());

        System.out.println(map);

        Set<String> keys = map.keySet();
        System.out.println(keys);
        for(String key : keys){
            System.out.println("key=" + key + ", value=" + map.get(key));
        }
    }
}
