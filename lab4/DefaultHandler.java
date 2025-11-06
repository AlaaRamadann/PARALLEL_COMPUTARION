
public class DefaultHandler {
    public static void main(String[] args) throws InterruptedException {
     Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {   
        System.out.println("Global handler caught exception in  " + thread.getName() );
       System.out.println("Errors: "+ exception.getMessage());
        
    });
    Thread t1 = new Thread(() -> {
        throw new RuntimeException("Thread crashed!");
    });
    Thread t2 = new Thread(() -> {
        throw new ArithmeticException("Division by zero!");
    });
     t1.start();
     t2.start();
    }
}
