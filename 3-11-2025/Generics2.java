class Test25<T> {
    T obj;
    Test25(T obj) { this.obj = obj; }
    public T getObject() { return this.obj; }
}

public class Generics2 {
    public static void main(String[] args)
    {
        Test25<Integer> iObj = new Test25<>(25);
        System.out.println(iObj.getObject());
        
        Test25<String> sObj = new Test25<>("Generic Programs");
        System.out.println(sObj.getObject());
    }
}
