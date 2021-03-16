public class Duck implements Comparable<Duck>{

    private int weight;

    public Duck(int weight) {
        this.weight = weight;
    }

    public String toString(){
        return " " + weight;
    }

    public int compareTo(Duck duck2){
        if (this.weight>duck2.weight)
            return 1;
        if (this.weight<duck2.weight)
            return -1;

        return 0;
    }
}
