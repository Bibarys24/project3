public class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // Add edges
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 6);
        graph.addEdge("C", "D", 3);

        // Perform BFS
        Vertex source = graph.getVertex("A");
        Vertex destination = graph.getVertex("D");

        Search bfs = new BreadthFirstSearch(graph, source);
        System.out.println("BFS Path: " + bfs.pathTo(destination));

        // Perform Dijkstra's algorithm
        Search dijkstra = new DijkstraSearch(graph, source);
        System.out.println("Dijkstra Path: " + dijkstra.pathTo(destination));
    }
}