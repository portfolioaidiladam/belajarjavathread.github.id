package programmerzamannow.thread;

public class DaemonApp {
  // belajar Daemon Thread untuk kebutuhan background job yang tidak terlalu penting
  // contohnya garbage collector, jadi data yang sudah tidak terpakai di memorynya dia akan dihapus
  // dia akan dihapus menggunakan daemon thread
  public static void main(String[] args) {

    var thread = new Thread(() -> {
      try {
        Thread.sleep(3000);
        System.out.println("Run Thread");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    thread.setDaemon(true);
    thread.start();

  }
}
