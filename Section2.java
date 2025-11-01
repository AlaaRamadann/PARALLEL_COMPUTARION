
    class MY_THREAD extends  Thread{
    @Override
    public void run(){
        System.out.println("Hello from "+ Thread.currentThread().getName());
    }

  MY_THREAD()
         {     
       super();
  }
   MY_THREAD(String name)
         {     
       super(name);
  }
}
class  MyTask implements Runnable{
@Override
public void run(){
    System.out.println("Hello from Runnable");
}}
public class Section2{
    public static void main(String[] args) throws InterruptedException {
        Runnable task =() -> System.out.println("running in: "+ Thread.currentThread().getName()); 
        Thread t = new Thread(task, "RunnableThread");
        t.start();
        
        Thread t2 = new MY_THREAD();
        t2.setName("THREAD2");
        t2.start();
        System.out.println("Thread name: " + t2.getName());
         
        Thread t3 = new MY_THREAD("THREAD3"); 
        t3.start();
        System.out.println("Thread name: " + t3.getName());
      
    }
}
