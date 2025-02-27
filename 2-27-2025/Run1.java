class MyRunnable implements Runnable {
  @Override
  public void run() {
    for (int i = 1; i < 10; i++) {
      System.out.println(i);
    }
  }
}

public class Run1 {
  public static void main(String[] args) {
    MyRunnable myRunnable = new MyRunnable();
    Thread thread = new Thread(myRunnable);
    thread.start();
  }
}
