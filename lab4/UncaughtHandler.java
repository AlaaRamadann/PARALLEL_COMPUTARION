 class Worker extends Thread{
  public void run(){

    System.out.println(Thread.currentThread().getName() + " started ");
    int result = 10 /0 ;
  }
 }
 public class UncaughtHandler{
   public static void main(String[] args) throws InterruptedException {
     Worker t1 = new Worker();
     t1.setUncaughtExceptionHandler((thread, exception) -> {   
        System.out.println("Exception in  " + thread.getName() + ": "+
        exception.getMessage());
    });

     t1.start();
    }
 }
