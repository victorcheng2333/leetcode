/**
 * @author victorcheng Created: 2019-08-24 11:22
 */
class NewThread implements Runnable{
  Thread t;
  NewThread() {
    t = new Thread(this, "Demo Thread");
    System.out.println("Child Thread: " + t);
    t.start();
  }

  public void run() {
    try {
      for (int i = 5; i > 0; i--) {
        System.out.println("Child Thread: " + i);
        // 暂停线程
        Thread.sleep(50);
      }
    } catch (InterruptedException e) {
      System.out.println("Child interrupted.");
    }
    System.out.println("Exiting Child Thread.");
  }
}
