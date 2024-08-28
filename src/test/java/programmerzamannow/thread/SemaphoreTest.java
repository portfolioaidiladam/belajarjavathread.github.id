package programmerzamannow.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
// membatasi berapa task yang jalan , pekerjaan yang dieksekusi
  // ini buat ngejaga biar gak terlalu banyak query yang dikirim kedatabase
  // atau nembak aplikasi lain , dia ngajak agar gak terlalu banyak request aplikasi lain
  @Test
  void test() throws InterruptedException {

    final var semaphore = new Semaphore(10);
    final var executor = Executors.newFixedThreadPool(100);

    for (int i = 0; i < 1000; i++) {
      executor.execute(() -> {
        try {
          // memastikan bole menaikan counter atau tidak
          semaphore.acquire();
          Thread.sleep(1000);
          System.out.println("Finish");
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          semaphore.release();
        }
      });
    }

    executor.awaitTermination(1, TimeUnit.DAYS);

  }
}
