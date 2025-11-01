public class GetState {
    public static void main(String[] args) throws InterruptedException {
      Thread tt1 =new Thread(() -> System.out.println("State inside run: " + Thread.currentThread().getState()));
       System.out.println("before start(): " + tt1.getState()); // new
       tt1.start();
       System.out.println("after start: " + tt1.getState()); // runnable
       tt1.join(); //wait untill thread finish
       System.out.println("after completion: " + tt1.getState()); //terminated
    }   
}
