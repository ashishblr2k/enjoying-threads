package main;

import java.util.concurrent.TimeUnit;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap;

public class ThreadWithRunnable {

	public static void main(String[] args) {
		//System.out.println(Runtime.getRuntime().availableProcessors());
		runnableTestWithoutRun();
		//runnableTestWithRun();
	}
	
	private static void runnableTestWithoutRun(){
		Runnable runnable = () -> {
		    try {
		        String name = Thread.currentThread().getName();
		        System.out.println("Foo " + name);
		        TimeUnit.SECONDS.sleep(1);
		        System.out.println("Bar " + name);
		    }
		    catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};

		Thread thread = new Thread(runnable);
		thread.start();
		thread.run();
	}
	
	private static void runnableTestWithRun(){
		Runnable task = () -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		};

		task.run();

		Thread thread = new Thread(task);
		thread.start();
		//thread.run();

		System.out.println("Done!");
	}

}
