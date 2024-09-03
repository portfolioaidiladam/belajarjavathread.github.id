package programmerzamannow.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadLocalRandomTest {
  // kalau temen temen mau bikin random , temen temen cukup gunakan thread local random
  // jadi intinya tiap threadnya akan dibuatkan object random masing masing jadi lebih aman dari  rest condition
  @Test
  void test() throws InterruptedException {

    final var executor = Executors.newFixedThreadPool(100);

    for (int i = 0; i < 100; i++) {
      executor.execute(() -> {
        try {
          Thread.sleep(1000);
          var number = ThreadLocalRandom.current().nextInt();
          System.out.println(number);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }

    executor.awaitTermination(1, TimeUnit.DAYS);

  }
 // Fitur lainnya di ThreadLocalRandom adalah, dia memiliki fitur untuk membuat random number secara stream
  // Hal ini mempermudah kita ketika ingin melakukan random number tanpa harus pusing membuat perulangan secara manual
  @Test
  void stream() throws InterruptedException {
    final var executor = Executors.newFixedThreadPool(10);

    executor.execute(() -> {
      ThreadLocalRandom.current().ints(1000, 0, 1000)
          .forEach(System.out::println);
    });

    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.DAYS);
  }
}
