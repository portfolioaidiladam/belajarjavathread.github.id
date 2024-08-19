package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {
// belajar Thrad Utama
  @Test
  void mainThread() {
    var name = Thread.currentThread().getName();
    System.out.println(name);
  }
// belajar membuat Thread
  @Test
  void createThread() {
    Runnable runnable = () -> {
      System.out.println("Hello from thread : " + Thread.currentThread().getName());
    };

    var thread = new Thread(runnable);
    thread.start();

    System.out.println("Program Selesai");
  }
  // belajar thread sleep
  @Test
  void threadSleep() throws InterruptedException {
    Runnable runnable = () -> {
      try {
        Thread.sleep(2_000L);
        System.out.println("Hello from thread : " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    var thread = new Thread(runnable);
    thread.start();

    System.out.println("Program Selesai");

    Thread.sleep(3_000L);
  }
  // belajar Thread Join
  @Test
  void threadJoin() throws InterruptedException {
    Runnable runnable = () -> {
      try {
        Thread.sleep(2_000L);
        System.out.println("Hello from thread : " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    var thread = new Thread(runnable);
    thread.start();
    System.out.println("Menunggu Selesai");
    thread.join();
    System.out.println("Program Selesai");
  }
  // belajar thread Interrupt yang salah
  @Test
  void threadInterrupt() throws InterruptedException {
    Runnable runnable = () -> {
      for (int i = 0; i < 10; i++) {
        System.out.println("Runnable : " + i);
        try {
          Thread.sleep(1_000L);
        } catch (InterruptedException e) {
          // print errornya
          e.printStackTrace();
        }
      }
    };

    var thread = new Thread(runnable);
    thread.start();
    Thread.sleep(5_000);
    thread.interrupt();
    System.out.println("Menunggu Selesai");
    thread.join();
    System.out.println("Program Selesai");
  }
  // belajar thread Interrupt yang benar
  @Test
  void threadInterruptCorrect() throws InterruptedException {
    Runnable runnable = () -> {
      for (int i = 0; i < 10; i++) {
        // manual check interrupted
        if(Thread.interrupted()){
          return;
        }
        System.out.println("Runnable : " + i);
        try {
          Thread.sleep(1_000L);
        } catch (InterruptedException e) {
          return;
        }
      }
    };

    var thread = new Thread(runnable);
    thread.start();
    Thread.sleep(5_000);
    thread.interrupt();
    System.out.println("Menunggu Selesai");
    thread.join();
    System.out.println("Program Selesai");
  }
  // belajar thread name untuk kebutuhan debuging
  @Test
  void threadName() {
    var thread = new Thread(() -> {
      System.out.println("Run in thread : " + Thread.currentThread().getName());
    });
    thread.setName("Eko");
    thread.start();
  }
  // belajar thread State
  @Test
  void threadState() throws InterruptedException {
    var thread = new Thread(() -> {
      System.out.println(Thread.currentThread().getState());
      System.out.println("Run in thread : " + Thread.currentThread().getName());
    });
    thread.setName("Eko");
    System.out.println(thread.getState());

    thread.start();
    thread.join();
    System.out.println(thread.getState());
  }
}
