public class BinarySearch {
    private double complexityCounter;

    public BinarySearch(){
        this.complexityCounter=0;
    }

    public int BinarySearch(int [] tab, int what){
        int left = 0;
        int right = tab.length - 1;
        int middle;

        while (left <= right) {
            complexityCounter++;
            middle = (left + right) / 2;
            if (what == middle)
                return middle;
            if (what > middle)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return -1;
    }

    public double getComplexityCounter() {
        return complexityCounter;
    }

    public void clearComplexity(){
        complexityCounter=0;
    }
}
