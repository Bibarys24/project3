import java.util.*;

public class BreadthFirstSearch implements Search {
    private final Map<Vertex, Vertex> edgeTo; // Tracks the path
    private final Set<Vertex> visited; // Tracks visited vertices

    public BreadthFirstSearch(WeightedGraph graph, Vertex source) {
        edgeTo = new HashMap<>();
        visited = new HashSet<>();
        bfs(graph, source);
    }

    private void bfs(WeightedGraph graph, Vertex source) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Map.Entry<Vertex, Double> neighborEntry : current.getNeighbors().entrySet()) {
                Vertex neighbor = neighborEntry.getKey();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
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