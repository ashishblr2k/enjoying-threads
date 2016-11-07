package main;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ThreadCallable {

	public static void main(String[] args) {
		Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};
	}

}
