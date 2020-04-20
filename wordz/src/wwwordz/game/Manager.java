package wwwordz.game;

import java.util.concurrent.ScheduledExecutorService;

import wwwordz.puzzle.*;

public class Manager {
	
	private static Manager single_instance = null;
	static long INITIAL_TIME;
	static Manager manager;
	Round round;
	static ScheduledExecutorService worker;
	
	public static Manager getInstance() {
		if (single_instance == null)
			single_instance = new Manager();
		return single_instance;
	}
}
