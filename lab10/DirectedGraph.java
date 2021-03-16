import java.util.ArrayList;

public class DirectedGraph {

    private ArrayList<Integer []> edgeList;
    private ArrayList<Integer> vertices;

    public DirectedGraph() {
        edgeList = new ArrayList<>();
        vertices = new ArrayList<>();
    }

    public void addVertice(int v) throws IllegalArgumentException {
        for (int ver : vertices){
            if (v == ver)
                throw new IllegalArgumentException();
        }
        vertices.add(v);
    }

    public void addEdge(int from, int to) throws IllegalArgumentException {
        boolean check1 = false;
        boolean check2 = false;

        for (int v : vertices){
            if (from == v)
                check1=true;
            if (to == v)
                check2 = true;
        }

        if (!(check1 && check2))
            throw new IllegalArgumentException();

        Integer[] edge = {from,to};
        edgeList.add(edge);
    }

    public void printGraph(){
        for (Integer[] edgel : edgeList){
            System.out.println("["+edgel[0]+", "+edgel[1]+"]");
        }
    }

    public ArrayList<Integer> getVertices() {
        return vertices;
    }
}
