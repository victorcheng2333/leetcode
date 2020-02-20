/**
 * @author victorcheng Created: 2019-08-24 11:30
 */
public class ThreadDemo {
  public static void main(String[] args) {
    new NewThread();
    try {
      for (int i = 5; i > 0; i--) {
        System.out.println("Main Thread: " + i);
        // 暂停线程
        Thread.sleep(100);
      }
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted.");
    }
    System.out.println("Main thread exiting.");
  }
}
