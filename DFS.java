
class DepthFirstSearch<T> extends Search<T> {

    public DepthFirstSearch(weiGraph<T> tWeiGraph, T origin) {
        super(new VertexPointMap<>(origin));
        dfs(tWeiGraph, origin);
    }

    private void dfs(weiGraph<T> tweiGraph, T pos) {
        mapSet.add(new VertexPointMap<>(pos));
        am++;

        VertexPointMap<T> cur = new VertexPointMap<>(pos);
        tweiGraph.map.get(tweiGraph.map.indexOf(cur)).getAdjacentVer().keySet().stream().filter(vertex -> !mapSet.contains(vertex)).forEach(vertex -> {
            vertexPointMap.put(vertex, new VertexPointMap<>(pos));
            dfs(tweiGraph, vertex.getGiven());
        });
    }

}
