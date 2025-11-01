public class group {
     public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("MyGroup");
        Thread t1 = new Thread(group,() -> {System.out.println(Thread.currentThread().getName() + " in "
         + Thread.currentThread().getThreadGroup().getName());},"Thread-1");
         Thread t2 = new Thread(group,() -> {System.out.println(Thread.currentThread().getName() + " in "
         + Thread.currentThread().getThreadGroup().getName());},"Thread-2");
         t1.start();
         t2.start();
        //Thread.sleep(100); // wait for them to start
         System.out.println("Active Threads in Group: " +group.activeCount() );
         group.list();// prints details of threads in group
     }
}
