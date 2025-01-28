
public class cond8 {

    public static void main(String[] args) {
        int[] mark = {67, 67, 78, 89, 91, 77};
        int total = 0;
        double avg;

        for (int x : mark) {
            total += x;
        }
        avg = total / 6.0;
        System.out.println("total: " + total);
        System.out.println("avg: " + avg);
    }
}
