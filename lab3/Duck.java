public class Duck
{
    private int weight;
    private String name;

    public Duck(int weight){
        this.weight=weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "duck weighing : " + this.weight + " lbs";
    }
}
