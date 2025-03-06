import java.util.TreeSet;

public class TreeSetExample {
   public static void main(String[] args) {
       TreeSet<Integer> numbers = new TreeSet<>();
       
       numbers.add(5);
       numbers.add(2);
       numbers.add(8);
       numbers.add(1);
       numbers.add(10);
       
       System.out.println("TreeSet elements: " + numbers);
       
       System.out.println("First element: " + numbers.first());
       System.out.println("Last element: " + numbers.last());
       System.out.println("Subset: " + numbers.subSet(2, 8));
       System.out.println("Ceiling: " + numbers.ceiling(3));
       System.out.println("Floor: " + numbers.floor(6));
   }
}