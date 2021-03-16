import java.util.Iterator;
import java.util.Scanner;

public class Test {

    public static void DictionaryCheck(){
        Scanner scanner=new Scanner(System.in);
        Dictionary dict=new Dictionary();
        String [] names= {"duck","horse","cat","dog","giraffe"};
        int [] keys= {12,132,13,12,142};

        for (int i=0;i<names.length;i++)
            dict.put(names[i],keys[i]);

        System.out.println("content: \n"+dict.toString());
        System.out.println("adding data, key: ");
        String key=scanner.next();
        System.out.println("value: ");

        int value=scanner.nextInt();

        dict.put(key,value);
        System.out.println("content: \n"+dict.toString());
        System.out.println("getting value by key, enter key: ");
        key=scanner.next();
        System.out.println(dict.get(key));
        System.out.println("removing data, enter key: ");
        key=scanner.next();
        dict.remove(key);
        System.out.println("content: \n"+dict.toString());
        System.out.println("testowanie iteratora");
        Iterator keysIt=dict.getKeysIterator();
        Iterator valuesIt=dict.getValuesIterator();

        for (int i=0;i<dict.size()-1;i++)
            System.out.println(keysIt.next() +" "+ valuesIt.next());
    }

    public static void MathematicalSetCheck( ){
        Scanner scanner=new Scanner(System.in);
        MathematicalSet mathSet=new MathematicalSet();
        String [] names= {"duck", "horse", "cat" ,"dog", "giraffe"};

        for (int i = 0; i < names.length; i++)
            mathSet.add(names[i]);

        System.out.println("\ntestowanie zbioru \n");
        System.out.println("content: \n"+mathSet.toString());
        System.out.println("adding data: ");
        String key = scanner.next();
        mathSet.add(key);
        System.out.println("content: \n"+mathSet.toString());
        System.out.println("removing data, enter data to remove: ");
        key = scanner.next();
        mathSet.remove(key);
        System.out.println("content: \n"+mathSet.toString());
    }


    public static void main(String[] args){
       try {
            DictionaryCheck();
            MathematicalSetCheck();
       }
       catch(IllegalArgumentException e){
           System.out.println("illegal argument given");
       }
    }
}
