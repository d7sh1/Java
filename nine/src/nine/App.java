package nine;

import javax.swing.JFrame;

public class App extends JFrame{
	private static final long serialVersionUID = -872240860301020083L;


	public void run() {
		System.out.println("Hello Tetris....");
	}

	public static void main(String[] args) {
		App app = new App();

		GameMap gmap = new GameMap();
		gmap.addKeyListener(gmap);
		gmap.setFocusable(true); // don't forget

		app.add(gmap);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(GameMap.WIDTH, GameMap.HEIGHT);
		app.setVisible(true);
		app.run();
		
	}
}

