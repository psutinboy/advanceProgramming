class Generic<T> {

    T obj;

    Generic(T o1) {
        obj = o1;
    }

    T getObject() {
        return obj;
    }
}

class Generic2<T, V> extends Generic<T> {

    V obj2;

    Generic2(T o1, V o2) {
        super(o1);
        obj2 = o2;
    }

    V getObject2() {
        return obj2;
    }
}

public class Hierarchy1 {

    public static void main(String[] args) {
        Generic2<String, Integer> x = new Generic2<String, Integer>("ID : ", 100);
        System.out.println(x.getObject());
        System.out.println(x.getObject2());

    }
}
