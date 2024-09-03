package programmerzamannow.thread;

public class UserService {
 // kalau butuh kalau memang variable tersebut kalau scopenya pengen tread itu doang ketika ke tread lain itu beda
  // temen temen butuh menggunakan thread local
  // jadi thread local memastikan variable tsb cuma nempelnya di thread itu , jika threadnya berbeda variable isinya akan berbeda juga
  final ThreadLocal<String> threadLocal = new ThreadLocal<>();
  // private String user;

  public void setUser(String user) {
    threadLocal.set(user);
    // this.user = user;
  }

  public void doAction() {
    var user = threadLocal.get();
    System.out.println(user + " do action");
  }

}
