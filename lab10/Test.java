import java.util.Random;

public class Test {

    public void TestDirectedGraph(int n){
        System.out.println("Directed graph: ");
        DirectedGraph dirGraph = new DirectedGraph();
        Random random = new Random();

        for (int i = 0; i < n; i++)
            dirGraph.addVertice(i);

        for (int i = 0; i < n; i++)
            dirGraph.addEdge(dirGraph.getVertices().get(i), random.nextInt(10));

        dirGraph.printGraph();
        System.out.println();
    }

    public void TestWeightedGraph(){
        WeightedGraph wGraph = new WeightedGraph();
        for (int i = 1; i <= 5; i++)
            wGraph.addVertice(i);

        wGraph.addEdge(1,2,7);
        wGraph.addEdge(1,3,2);
        wGraph.addEdge(2,3,1);
        wGraph.addEdge(2,5,3);
        wGraph.addEdge(5,3,7);
        wGraph.addEdge(4,5,5);

        wGraph.printGraph();
    }

    public void testDijkstra(){

        int graph[][] = new int[][] {
                { 0, 5, 0, 0, 0, 0, 0, 8, 0 },
                { 5, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 10, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 10, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 3, 6 },
                { 8, 11, 0, 0, 0, 0, 3, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        WeightedGraph2 w2= new WeightedGraph2(graph);
        Dijkstra dij = new Dijkstra();
        dij.dijkstra(w2.getMatrix(), 0);
        dij.dijkstra(w2.getMatrix(),4);
    }

    public static void main(String[] args) {
        try {
            Test test = new Test();
            test.TestDirectedGraph(10);
            test.TestWeightedGraph();
            test.testDijkstra();
        }
        catch (Exception e){
            System.out.println("Illegal operation");
        }
    }
}
