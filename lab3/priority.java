public class priority {
 public static void main(String[] args) throws InterruptedException {
      Thread tt1 =new Thread(() -> System.out.println("Thread1 priority: " + Thread.currentThread().getPriority()));
      Thread tt2 =new Thread(() -> System.out.println("Thread1 priority: " + Thread.currentThread().getPriority()));
        tt1.setPriority(Thread.MAX_PRIORITY);
        tt2.setPriority(Thread.MIN_PRIORITY);
        tt1.start();
        tt2.start();
      
    }   
}
