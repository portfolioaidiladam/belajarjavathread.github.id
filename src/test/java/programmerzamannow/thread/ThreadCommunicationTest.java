package programmerzamannow.thread;

import org.junit.jupiter.api.Test;

public class ThreadCommunicationTest {

  private String message = null;
  // belajar Thread Communication
  @Test
  void manual() throws InterruptedException {

    var thread1 = new Thread(() -> {
      while (message == null){
        // wait
      }
      System.out.println(message);
    });

    var thread2 = new Thread(() -> {
      message = "Aidil Adam";
    });

    thread2.start();
    thread1.start();

    thread2.join();
    thread1.join();

  }
  // Belajar Wait dan Notify, memberikan sinyal kesatu thread
  // ini cara yang sangat aman alasannya agar tidak buang-buang resource CPU dan juga jika terjadi interrupt,
  // loop akan terus berjalan tanpa henti
  @Test
  void waitNotify() throws InterruptedException {

    final var lock = new Object();

    var thread1 = new Thread(() -> {
      synchronized (lock){
        try {
          lock.wait();
          System.out.println(message);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    var thread2 = new Thread(() -> {
      synchronized (lock){
        message = "Aidil Adam Notify";
        lock.notify();
      }
    });

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

  }
  // Belajar Wait dan Notify , memberikan sinyal kesemua thread
  @Test
  void waitNotifyAll() throws InterruptedException {

    final var lock = new Object();

    var thread1 = new Thread(() -> {
      synchronized (lock){
        try {
          lock.wait();
          System.out.println(message);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    var thread3 = new Thread(() -> {
      synchronized (lock){
        try {
          lock.wait();
          System.out.println(message);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    var thread2 = new Thread(() -> {
      synchronized (lock){
        message = "Aidil Adam Notifcy all";
        lock.notifyAll();
      }
    });

    thread1.start();
    thread3.start();

    thread2.start();

    thread1.join();
    thread3.join();

    thread2.join();

  }
}
