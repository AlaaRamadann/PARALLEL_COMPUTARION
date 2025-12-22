import java.util.Arrays;
import java.util.List;

class MultiExecutor{
   private final List<Runnable> tasks;
  public MultiExecutor (List<Runnable> tasks ){
    this.tasks=tasks;
  }
  public void executeAll(){
  for (Runnable task : tasks){
    Thread thread = new Thread(task);
    thread.start();
  }
  }
}



public class Lab_Exercise{
 public static void main(String[] args) throws InterruptedException {
      Runnable task1 = () -> System.out.println("task1 running in " + Thread.currentThread().getName());
      Runnable task2 = () -> System.out.println("task2 running in " + Thread.currentThread().getName());
      Runnable task3 = () -> System.out.println("task3 running in " + Thread.currentThread().getName());

      MultiExecutor Execute = new MultiExecutor(Arrays.asList(task1,task2,task3));
      Execute.executeAll();
    }   
}
 