
class weiGraph<T> {
    private final boolean undirected;
    public ArrayList<VertexPointMap<T>> map = new ArrayList<>();
    public weiGraph() {
        this.undirected = true;
    }

    public weiGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T v) {
        map.add(new VertexPointMap<T>(v));
    }

    public void addEdge(T source, T dest, double weight) {
        if (hasVertex(source)) {
            addVertex(source);
            if (hasVertex(dest))
                addVertex(dest);
        } else if (hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest) || !map.contains(new VertexPointMap<>(source)))
            return; 
        map.get(map.indexOf(new VertexPointMap<>(source))).addAdjacentVer(new VertexPointMap<>(dest), weight);


        if (undirected)
            map.get(map.indexOf(new VertexPointMap<>(dest))).addAdjacentVer(new VertexPointMap<>(source), weight);
    }
    

    public boolean hasVertex(T v) {
        return !map.contains(new VertexPointMap<T>(v));
    }

    public boolean hasEdge(T source, T dest) {
        if (hasVertex(source)) return false;
        if (map.get(map.indexOf(new VertexPointMap<T>(source))).getAdjacentVer().containsKey(new VertexPointMap<T>(dest)))
            return true;
        else return false;
    }
}
