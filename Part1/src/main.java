import java.util.HashMap;
import java.util.Iterator;

public class main {
    public static void main(String[] argv){

        try {
            MSHashMap<Integer, String> hm = new MSHashMap<>();
            hm.put(10, Integer.toBinaryString(10));
            hm.put(20, Integer.toBinaryString(20));
            hm.put(30, Integer.toBinaryString(30));
            hm.put(40, Integer.toBinaryString(40));
            hm.put(50, Integer.toBinaryString(50));
            hm.put(60, Integer.toBinaryString(60));

            System.out.println("\nMapIterator with default constructor");
            Iterator<Integer> iter = hm.mapIterator();
            System.out.println("Size: " + hm.size());
            for (int i = 0; i < hm.size() + 2; i++) {
                System.out.println("Iteration: " + i + " Key: " + iter.next());
            }


            System.out.println("\nMapIterator with present key value");
            iter = hm.mapIterator(40);
            System.out.println("Size: " + hm.size());
            for (int i = 0; i < hm.size() + 2; i++) {
                System.out.println("Iteration: " + i + " Key: " + iter.next());
            }

            System.out.println("\nMapIterator with key value(non present)");
            iter = hm.mapIterator(80);
            System.out.println("Size: " + hm.size());
            for (int i = 0; i < hm.size() + 2; i++) {
                System.out.println("Iteration: " + i + " Key: " + iter.next());
            }

            MSHashMap<Integer, String> hm1 = new MSHashMap<>();
            System.out.println("\nSize: " +hm1.size());
            iter = hm1.mapIterator();
            iter.next();

        }
        catch (Exception e){
            System.out.println(e.toString());
        }


    }
}
