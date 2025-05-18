import java.util.*;

public class DijkstraSearch implements Search {
    private final Map<Vertex, Vertex> edgeTo;
    private final Map<Vertex, Double> distTo;
    private final PriorityQueue<Vertex> pq;
    private final Set<Vertex> visited;

    public DijkstraSearch(WeightedGraph graph, Vertex source) {
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));
        visited = new HashSet<>();

        for (Vertex v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }

        distTo.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
            if (visited.contains(current)) continue;
            visited.add(current);
            relax(graph, current);
        }
    }

    private void relax(WeightedGraph graph, Vertex current) {
        for (Map.Entry<Vertex, Double> neighborEntry : current.getNeighbors().entrySet()) {
            Vertex neighbor = neighborEntry.getKey();
            double weight = neighborEntry.getValue();
            double newDist = distTo.get(current) + weight;

            if (newDist < distTo.get(neighbor)) {
                distTo.put(neighbor, newDist);
                edgeTo.put(neighbor, current);
                pq.remove(neighbor);
                pq.add(neighbor);
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex destination) {
        return distTo.get(destination) < Double.POSITIVE_INFINITY;
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