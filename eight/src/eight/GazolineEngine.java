package eight;

public class GazolineEngine implements EngineInterface {
	public GazolineEngine() {
		System.out.println("GazolineEngine instance was created");
	}

	public void start() {
		System.out.println("GazolineEngine was started");
	}

	public void stop() {
		System.out.println("GazolineEngine was stopped");
	}
}

