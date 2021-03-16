import java.util.ArrayList;

public class WeightedGraph {
    private ArrayList<ArrayList<Integer[]>> adjList;
    private ArrayList<Integer> vertices;

    public WeightedGraph(){
        adjList = new ArrayList<>();
        vertices = new ArrayList<>();
    }

    public void addVertice(int v) throws IllegalArgumentException{
        for (int ver : vertices){
            if (v == ver)
                throw new IllegalArgumentException();
        }

        vertices.add(v);
        adjList.add(new ArrayList<>());
    }

    public void addEdge(int v1, int v2, int weight) throws IllegalArgumentException {
        boolean check1 = false;
        boolean check2 = false;

        for (int v : vertices){
            if (v1 == v)
                check1=true;
            if (v2 == v)
                check2=true;
        }

        if (!(check1&&check2))
            throw new IllegalArgumentException();

        Integer[] t1 = {v2, weight};
        Integer[] t2 = {v1, weight};
        adjList.get(vertices.indexOf(v1)).add(t1);
        adjList.get(vertices.indexOf(v2)).add(t2);
    }

    public void printGraph(){
        for (int i = 0; i < adjList.size(); i++){
            System.out.println("edges of vertice " + vertices.get(i) + ": ");
            for (int j = 0; j < adjList.get(i).size(); j++)
                System.out.println(adjList.get(i).get(j)[0]+ "(" +adjList.get(i).get(j)[1] + ")");
        }
        System.out.println();
    }


    public ArrayList<Integer> getVertices() {
        return vertices;
    }
}
