class MyThread extends Thread {
  @Override
  public void run() {
    System.out.println("Thread: " + Thread.currentThread().getId());
  }
}

public class Multithreading {
  public static void main(String[] args) {
    MyThread t1 = new MyThread();
    MyThread t2 = new MyThread();
    t1.start();
    t2.start();
  }
}
