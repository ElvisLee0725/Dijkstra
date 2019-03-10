import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    // graphMap stores the <point, <connect point, distance>>
    private HashMap<Character, HashMap<Character, Integer>> graphMap;
    private HashMap<Character, Integer> resultMap;
    private PriorityQueue<Node> minHeap;

    public Dijkstra() {
        this.graphMap = new HashMap<Character, HashMap<Character, Integer>>();
        this.resultMap = new HashMap<Character, Integer>();
        this.minHeap = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                if(n1.getDist() == n2.getDist()) {
                    return 0;
                }
                return n1.getDist() < n2.getDist() ? -1 : 1;
            }
        });
    }

    public HashMap<Character, HashMap<Character, Integer>> getGraphMap() {
        return graphMap;
    }

    // Select a start point to find the distance to each other points in graphMap
    public void runDijkstra(char start) {
        if(!graphMap.containsKey(start)) {
            System.out.println("Sorry, your input is not in the graph.");
            return ;
        }

        // Initial State, choose any node from the map to start:
        minHeap.offer(new Node(start, 0));

        // Terminate when the resultMap reaches total node numbers
        while(!minHeap.isEmpty()) {
            // Expand from the top of minHeap
            Node cur = minHeap.poll();
            // Prevent longer distance in minHeap being generated again
            if(!resultMap.containsKey(cur.getName())) {
                int distToStart  = cur.getDist();
                char nodeName = cur.getName();
                resultMap.put(nodeName, distToStart);

                HashMap<Character, Integer> neighborMap = graphMap.get(nodeName);
                for(Map.Entry<Character, Integer> neighbor : neighborMap.entrySet()) {
                    // Only consider to generate keys that's not expanded yet
                    if(!resultMap.containsKey(neighbor.getKey())) {
                        minHeap.offer(new Node(neighbor.getKey(), distToStart + neighbor.getValue()));
                    }
                }
            }
        }
    }

    public void printGraph() {
        for(Map.Entry<Character, HashMap<Character, Integer>> entry: graphMap.entrySet()) {
            System.out.println(entry.getKey());
            HashMap<Character, Integer> neighborMap = entry.getValue();
            for(Map.Entry<Character, Integer> e : neighborMap.entrySet()) {
                System.out.print(e.getKey() + " " + e.getValue() + ", ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public void printResult() {
        if(resultMap.size() == 0) {
            System.out.println("There is no result yet.");
            return;
        }
        for(Map.Entry<Character, Integer> e : resultMap.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
