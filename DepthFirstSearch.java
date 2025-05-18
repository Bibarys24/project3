import java.util.*;

public class DepthFirstSearch implements Search {
    private final Map<Vertex, Vertex> edgeTo; // Tracks the path
    private final Set<Vertex> visited; // Tracks visited vertices

    public DepthFirstSearch(WeightedGraph graph, Vertex source) {
        edgeTo = new HashMap<>();
        visited = new HashSet<>();
        dfs(graph, source);
    }

    private void dfs(WeightedGraph graph, Vertex current) {
        visited.add(current);
        for (Map.Entry<Vertex, Double> neighborEntry : current.getNeighbors().entrySet()) {
            Vertex neighbor = neighborEntry.getKey();
            if (!visited.contains(neighbor)) {
                edgeTo.put(neighbor, current);
                dfs(graph, neighbor);
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex destination) {
        return visited.contains(destination);
    }

    @Override
    public Iterable<Vertex> pathTo(Vertex destination) {
        if (!hasPathTo(destination)) return null;

        List<Vertex> path = new ArrayList<>();
        for (Vertex v = destination; v != null; v = edgeTo.get(v)) {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }
}