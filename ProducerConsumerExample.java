import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {

    // Shared buffer
    private final Queue<String> buffer = new LinkedList<>();
    private final int capacity = 5; // Maximum buffer size

    // Producer class
    class Producer implements Runnable {
        private final String name;

        public Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int messageCount = 1;
            try {
                while (true) {
                    String message = name + "-Message" + messageCount++;
                    produce(message);
                    Thread.sleep((int)(Math.random() * 1000)); // Random delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void produce(String message) throws InterruptedException {
            synchronized (buffer) {
                while (buffer.size() == capacity) {
                    buffer.wait(); // Wait if buffer is full
                }
                buffer.add(message);
                System.out.println(name + " produced: " + message);
                buffer.notifyAll(); // Notify consumers
            }
        }
    }

    // Consumer class
    class Consumer implements Runnable {
        private final String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = consume();
                    System.out.println(name + " consumed: " + message);
                    Thread.sleep((int)(Math.random() * 1500)); // Random delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private String consume() throws InterruptedException {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    buffer.wait(); // Wait if buffer is empty
                }
                String message = buffer.poll();
                buffer.notifyAll(); // Notify producers
                return message;
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerExample example = new ProducerConsumerExample();

        // Create producers
        Thread producer1 = new Thread(example.new Producer("Producer1"));
        Thread producer2 = new Thread(example.new Producer("Producer2"));

        // Create consumers
        Thread consumer1 = new Thread(example.new Consumer("Consumer1"));
        Thread consumer2 = new Thread(example.new Consumer("Consumer2"));

        // Start threads
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
