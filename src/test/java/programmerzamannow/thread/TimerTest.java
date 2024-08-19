package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
// belajar Timer Delayed Job
  @Test
  void delayedJob() throws InterruptedException {

    var task = new TimerTask(){
      @Override
      public void run() {
        System.out.println("Delayed Job");
      }
    };

    var timer = new Timer();
    timer.schedule(task, 2000);

    Thread.sleep(3000L);

  }
  // belajar Timer Periodic Job,ini sama bedanya ada parameter period
  @Test
  void periodicJob() throws InterruptedException {

    var task = new TimerTask(){
      @Override
      public void run() {
        System.out.println("Periodic Job");
      }
    };

    var timer = new Timer();
    timer.schedule(task, 2000, 2000);

    Thread.sleep(10_000L);

  }
}
