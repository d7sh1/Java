package eight;

public class App {

	public App() {
		System.out.println("App instance was created");
	}

	public void run() {
		System.out.println("Method App.run() was called");

		// EngineInterface ng = new HybridEngine();
		// EngineInterface ng = new DieselEngine();
		EngineInterface ng = new GazolineEngine();


		CarBody cb = new CarBody();
		Wheel[] wheels = {
			new Wheel(),
			new Wheel(),
			new Wheel(),
			new Wheel(),
		};
		Car car = new Car(
			"Toyota Camry",
			ng,
			wheels,
			cb
		);
		car.startEngine();
		car.drive();
		car.turnLeft();
		car.turnLeft();
		car.driveBack();
		car.stopEngine();
	}

	public static void main(String[] args) {
		App app = new App();
		app.run();
	}

}

