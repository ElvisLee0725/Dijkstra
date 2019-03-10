import java.util.*;

public class Main {

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        HashMap<Character, HashMap<Character, Integer>> map = d.getGraphMap();

        map.put('A', new HashMap<Character, Integer>());
        map.get('A').put('B', 1);
        map.get('A').put('C', 1);
        map.get('A').put('D', 10);

        map.put('B', new HashMap<Character, Integer>());
        map.get('B').put('A', 1);

        map.put('C', new HashMap<Character, Integer>());
        map.get('C').put('A', 1);
        map.get('C').put('E', 1);

        map.put('D', new HashMap<Character, Integer>());
        map.get('D').put('A', 10);
        map.get('D').put('E', 1);
        map.get('D').put('F', 1);

        map.put('E', new HashMap<Character, Integer>());
        map.get('E').put('C', 1);
        map.get('E').put('D', 1);
        map.get('E').put('F', 1);

        map.put('F', new HashMap<Character, Integer>());
        map.get('F').put('D', 1);
        map.get('F').put('E', 1);
        map.get('F').put('G', 20);

        map.put('G', new HashMap<Character, Integer>());
        map.get('G').put('F', 20);

        d.printGraph();

        d.runDijkstra('K');

        d.printResult();
    }
}
