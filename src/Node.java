public class Node {
    private char name;
    private int dist;  // Record distance from node to origin

    public Node(char name, int dist) {
        this.name = name;
        this.dist = dist;
    }

    public char getName() {
        return name;
    }

    public int getDist() {
        return dist;
    }

    public int hashCode() {
        final int prime = 31;
        return prime * (name - 'A');
    }
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Node other = (Node) obj;
        if(this.name != other.name) {
            return false;
        }
        return true;
    }
}
