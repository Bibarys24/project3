public interface Search {
    boolean hasPathTo(Vertex destination);
    Iterable<Vertex> pathTo(Vertex destination);
}