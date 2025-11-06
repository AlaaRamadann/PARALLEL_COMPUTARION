 class Worker extends Thread{
  public void run(){
    try{ 
    System.out.println(Thread.currentThread().getName() + " started ");
    int result = 10 /0 ;
  } catch(Exception e) {
    System.out.println(Thread.currentThread().getName() + " caught: " + e);
  }
      System.out.println(Thread.currentThread().getName() + " finished ");

   
  }
 }
 public class Try_catch{
   public static void main(String[] args) throws InterruptedException {
     Worker t1 = new Worker();
     Worker t2 = new Worker();
     Worker t3 = new Worker();

     t1.start();
     t2.start();
     t3.start();
    }
 }
