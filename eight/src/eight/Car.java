package eight;

public class Car {
	private String model;
	private EngineInterface engine;
	private Wheel[] wheels;
	private CarBody carBody;

	public Car(String m, EngineInterface ng, Wheel[] ws, CarBody cb) {
		this.model = m;
		this.engine = ng;
		this.wheels = ws;
		this.carBody = cb;
		System.out.println("Car instance was created");
		System.out.println("Hello! I'm " + this.model);
	}

	public void stopEngine() {
		System.out.println("Car engine was stopped");
		this.engine.stop();
	}

	public void startEngine() {
		System.out.println("Car engine was started");
		this.engine.start();
	}

	public void turnLeft() {
		System.out.println("Car is turning left");
	}
	public void turnRight() {
		System.out.println("Car is turning right");
	}
	public void driveBack() {
		System.out.println("Car is driving backward");
	}
	public void drive() {
		System.out.println("Car is driving forward");
	}
	
}
