import java.util.Random;

public class main
{
    public static Car[] getCars() {
        Car[] cars=new Car[1000];

        String[] names={"peugeot", "audi", "bmw", "mercedes", "ford", "fiat", "opel", "volvo", "tesla", "ferrari"};
        Random rand=new Random();

        for (int i=0;i<1000;i++)
            cars[i]=new Car(rand.nextInt(30)+1,names[rand.nextInt(10)]);

        return cars;
    }

    private static OneWayListWithSentinel generateFirstList(Car[] cars) throws IllegalArgumentException {
        if(cars == null)
            throw new IllegalArgumentException();
        OneWayListWithSentinel resultList = new OneWayListWithSentinel();

        for(Car car : cars)
            resultList.add(car);

        return resultList;
    }

    private static OneWayCyclicListWithHead generateSecondList(Car[] cars) throws IllegalArgumentException {
        if(cars == null)
            throw new IllegalArgumentException();
        OneWayCyclicListWithHead resultList = new OneWayCyclicListWithHead();

        for(Car car : cars)
            resultList.add(car);

        return resultList;
    }

    private static ArrayList1 generateThirdList(Car[] cars) throws IllegalArgumentException {
        if(cars == null)
            throw new IllegalArgumentException();
        ArrayList1 resultList = new ArrayList1();

        for(Car car : cars)
            resultList.add(car);

        return resultList;
    }


    private static void printArray(Car[] array) {
        System.out.println("[");
        for(Car car : array) {
            if(car == null)
                continue;
            System.out.print("    ( ");
            System.out.print(car.getAge() + " " + car.getMake());
            System.out.print(" )\n");
        }
        System.out.println("]");
    }

    private static void printOneWay(OneWayListWithSentinel list, Car[] cars) {
        System.out.println("jednokierunkowa ze strażnikiem: "+"\n");
        long startTime, endTime;
        startTime = System.nanoTime();
        for(Car car : cars) {
            list.add(car);
        }
        endTime = System.nanoTime();
        System.out.println(">> reading time: " + ((endTime-startTime)) + " ns");

        long startTime2, endTime2;
        startTime2 = System.nanoTime();
        for(int i = 0; i < 1000; i++)
            list.get(i);

        endTime2 = System.nanoTime();
        System.out.println(">> adding time: " + (endTime2-startTime2) + " ns");
    }

    private static void printOneWayCyclic(OneWayCyclicListWithHead list, Car[] cars) {
        System.out.println("\n"+"jednokierunkowa posortowana bez strażnika: "+"\n");
        long startTime, endTime;
        startTime = System.nanoTime();
        for(Car car : cars) {
            list.add(car);
        }
        endTime = System.nanoTime();
        System.out.println(">> reading time: " + (endTime-startTime) + " ns");

        long startTime2, endTime2;
        startTime2 = System.nanoTime();
        for(int i = 0; i < 1000; i++)
            list.get(i);

        endTime2 = System.nanoTime();
        System.out.println(">> adding time: " + (endTime2-startTime2) + " ns");
    }

    private static void printArrayList1(ArrayList1 list, Car[] cars) {
        System.out.println("\n"+"jednokierunkowa posortowana tablicowa: "+"\n");
        long startTime, endTime;
        startTime = System.nanoTime();
        for(Car car : cars) {
            list.add(car);
        }
        endTime = System.nanoTime();
        System.out.println(">> reading time: " + ((endTime-startTime)) + " ns");

        long startTime2, endTime2;
        startTime2 = System.nanoTime();
        for(int i = 0; i < 1000; i++) {
            list.get(i);
        }
        endTime2 = System.nanoTime();
        System.out.println(">> adding time: " + ((endTime2-startTime2)) + " ns");
    }

    public static void main(String [] args) {
        OneWayListWithSentinel list1= generateFirstList(getCars());
        OneWayCyclicListWithHead list2= generateSecondList(getCars());
        ArrayList1 list3=generateThirdList(getCars());

        printArray(getCars());
        System.out.println("\n");
        printArray(list3.getArray());

        printOneWay(list1,getCars());
        printOneWayCyclic(list2,getCars());
        printArrayList1(list3,getCars());
        System.out.println("\n");
    }
}
