class VertexPointMap<V>{
    private V given;
    private Map<VertexPointMap<V>, Double> adjacentVer = new HashMap<>();

    public VertexPointMap(V data) {
        this.given = data;
    }

    public void addAdjacentVer(VertexPointMap<V> pMapDest, double wei){
        adjacentVer.put(pMapDest, wei);

    }

    public Map<VertexPointMap<V>, Double> getAdjacentVer() {
        return adjacentVer;
    }

    public V getGiven() {
        return given;
    }
}
