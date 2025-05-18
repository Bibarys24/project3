import java.util.HashMap;
import java.util.Map;

public class Vertex {
    private final String id; // Unique identifier for the vertex
    private final Map<Vertex, Double> neighbors; // Adjacent vertices and their weights

    public Vertex(String id) {
        this.id = id;
        this.neighbors = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void addNeighbor(Vertex neighbor, double weight) {
        neighbors.put(neighbor, weight);
    }

    public Map<Vertex, Double> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return id;
    }
}