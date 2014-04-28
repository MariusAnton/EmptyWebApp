package web.thread;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author MariusAnton
 *
 */
@Component
public class MyThread {
	public void dummyTask() {
		System.out.println("This is my dummy task " + new Date());
	}
}
