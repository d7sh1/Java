package eight;

public class DieselEngine implements EngineInterface {
	public DieselEngine() {
		System.out.println("DieselEngine instance was created");
	}

	public void start() {
		System.out.println("DieselEngine was started");
	}

	public void stop() {
		System.out.println("DieselEngine was stopped");
	}
}

