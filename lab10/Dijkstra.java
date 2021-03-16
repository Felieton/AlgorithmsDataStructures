class Dijkstra {
    private static final int gSize = 9;
    private int source;

    private int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < gSize; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    public void dijkstra(int graph[][], int src) {
        int dist[] = new int[gSize];
        this.source=src;
        Boolean sptSet[] = new Boolean[gSize];

        for (int i = 0; i < gSize; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int i = 0; i < gSize - 1; i++) {
            int minDist = minDistance(dist, sptSet);
            sptSet[minDist] = true;

            for (int v = 0; v < gSize; v++)
                if (!sptSet[v] && graph[minDist][v] != 0 &&
                        dist[minDist] != Integer.MAX_VALUE && dist[minDist] + graph[minDist][v] < dist[v])
                    dist[v] = dist[minDist] + graph[minDist][v];
        }

        printResults(dist, gSize);
    }

    private void printResults(int dist[], int n) {
        System.out.println("Distance from "+this.source);
        for (int i = 0; i < gSize; i++)
            System.out.println("distance to vertice "+i + ": " + dist[i]);
        System.out.println();
    }
}
