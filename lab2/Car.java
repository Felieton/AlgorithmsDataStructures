public class Car implements Comparable <Car>
{
    private int age;
    private String make;

    public Car(int age, String make) {
        this.age=age;
        this.make=make;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public int compareTo(Car o) {
        if (this.age > o.age)
            return 1;
        if (this.age < o.age)
            return -1;

        return 0;
    }
}
