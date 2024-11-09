package seven;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class App extends JFrame {
	private static final long serialVersionUID = -872240860301020083L;
	private GameMap map;

	public App(GameMap m) {
		this.map = m;
	}

	public void run() {
		this.map.addKeyListener(this.map);
		this.map.setFocusable(true);
	}

	public static void main(String[] args) {
		GameMap gmap = new GameMap();

		App jf = new App(gmap);
		jf.add(gmap);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(GameMap.W, GameMap.H);
		jf.setVisible(true);
		jf.run();
	}
}
