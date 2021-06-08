class BreadthFirstSearch<T> extends Search<T>{

    public BreadthFirstSearch(weiGraph<T> graph, T source) {
        super(new VertexPointMap<>(source));
        bfs(graph, source);
    }

    private void bfs(weiGraph<T> graph, T current) {
        mapSet.add(new VertexPointMap<>(current));
        Queue<VertexPointMap<T>> mapQueue = new LinkedList<>();
        mapQueue.add(new VertexPointMap<>(current));
        if (!mapQueue.isEmpty()) {
            do {
                VertexPointMap<T> v = mapQueue.remove();
                graph.map.get(graph.map.indexOf(v)).getAdjacentVer().keySet().stream().filter(vertex -> !mapSet.contains(vertex)).forEachOrdered(vertex -> {
                    mapSet.add(vertex);
                    vertexPointMap.put(vertex, v);
                    mapQueue.add(vertex);
                });
            } while (!mapQueue.isEmpty());
        }
    }
}
