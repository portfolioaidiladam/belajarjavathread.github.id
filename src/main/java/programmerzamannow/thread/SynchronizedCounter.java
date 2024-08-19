package programmerzamannow.thread;

public class SynchronizedCounter {

  private Long value = 0L;

  // belajar intrinsic lock
  // menentukan lock pakai this, kalau ada thread lain yang melakukan lock lagi maka dia harus nunggu sampe locknya dilepas
  // jadi ada dua cara agar tidak terjadi race condition syncronized method dan synchronized statement
  public void increment() {
    synchronized (this) {
      value++;
    }
  }

  public Long getValue() {
    return value;
  }
}
