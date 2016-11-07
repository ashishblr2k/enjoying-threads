package main;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutorInvokeAll {

	public static void main(String[] args) throws InterruptedException {
		
		long start = System.currentTimeMillis();
		
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(
		        () -> "task1",
		        () -> "task2",
		        () -> "task3");

		executor.invokeAll(callables)
		    .stream()
		    .map(future -> {
		        try {
		        	System.out.println("before sleep");
		        	Thread.sleep(10000);
		        	System.out.println("after sleep");
		            return future.get();
		        }
		        catch (Exception e) {
		            throw new IllegalStateException(e);
		        }
		    })
		    .forEach(System.out::println);
		
		long end = System.currentTimeMillis();
		
		System.out.println("total time=="+(end - start));
	}

}
