package main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
public class FixedThreadPoolExample {
    public static void main(String[] args) throws Exception {
        // Create a fixed thread pool containing one thread
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
 
        // Create a Callable object of anonymous class
        Callable<String> aCallable = new Callable<String>(){
            String result = "Callable done !";
            @Override
            public String call() throws Exception {
                // Print a value
                System.out.println("Callable at work !");
                // Sleep for 5 sec
                Thread.sleep(5 * 1000);
                return result;
            }
        };
 
        // Create a Runnable object of anonymous class
        Runnable aRunnable = new Runnable(){
            @Override
            public void run() {
                try {
                    // Print a value
                    System.out.println("Runnable at work !");
                    // Sleep for 5 sec
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
 
        // Submit two tasks for running
        Future<String> callableFuture = fixedPool.submit(aCallable);
        Future<?> runnableFuture = fixedPool.submit(aRunnable);
        
        System.out.println("======"+callableFuture.get());
        System.out.println("======"+runnableFuture.get());
 
        fixedPool.shutdown(); // shut down
 
    }
}