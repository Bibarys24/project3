import java.util.HashMap;
import java.util.Map;

public class WeightedGraph {
    private final Map<String, Vertex> vertices; // Map of vertex IDs to Vertex objects

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(String id) {
        vertices.putIfAbsent(id, new Vertex(id));
    }

    public void addEdge(String fromId, String toId, double weight) {
        Vertex from = vertices.get(fromId);
        Vertex to = vertices.get(toId);

        if (from == null || to == null) {
            throw new IllegalArgumentException("One or both vertices do not exist.");
        }

        from.addNeighbor(to, weight);
        to.addNeighbor(from, weight); // For undirected graphs
    }

    public Vertex getVertex(String id) {
        return vertices.get(id);
    }

    public Iterable<Vertex> getVertices() {
        return vertices.values();
    }
}