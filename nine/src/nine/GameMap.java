package nine;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class GameMap extends JPanel implements KeyListener {
	private static final long serialVersionUID = -6839529341001166798L;
	public static int WIDTH = 600;
	public static int HEIGHT = 500;
	public static int H = 20;
	public static int M = 20;
	public static int N = 10;
	protected ArrayList<Tank> items;
	protected Tank tank;
	protected Timer timer;
	protected HashMap<Integer, Boolean> pressedKeys;

	public GameMap() {
		System.out.println("GameMap instance created...");
		this.tank = new Tank(5, M-2);
		this.tank.setColor(Color.BLUE);

		this.items = new ArrayList<Tank>();
		this.items.add(new Tank(5, Randomizer.getInt(1, 3)));
		this.items.add(new Tank(2, Randomizer.getInt(1, 3)));
		this.items.add(new Tank(2, Randomizer.getInt(1, 3)));
		this.items.add(new Tank(2, Randomizer.getInt(1, 3)));
		this.items.add(new Tank(2, Randomizer.getInt(1, 3)));

		this.pressedKeys = new HashMap<Integer, Boolean>();
		this.pressedKeys.put(KeyEvent.VK_W, false);
		this.pressedKeys.put(KeyEvent.VK_A, false);
		this.pressedKeys.put(KeyEvent.VK_S, false);
		this.pressedKeys.put(KeyEvent.VK_D, false);

		timer = new Timer(1000 / 18, e -> {
            update();
            repaint();
        });
        timer.start();
	}

	protected void update() {
		if (pressedKeys.get(KeyEvent.VK_W)) { // up
			if (tank.y > 1) tank.y--;
		}
		if (pressedKeys.get(KeyEvent.VK_A)) { // left
			if (tank.x > 1) tank.x--;
		}
		if (pressedKeys.get(KeyEvent.VK_S)) { // down
			if (tank.y < M) tank.y++;
		}
		if (pressedKeys.get(KeyEvent.VK_D)) { // right
			if (tank.x < N) tank.x++;
		}

		for (Tank item : items) {
			if (item.y < M) {
				item.y++;
			}
			else if (item.y == M) { // enemy reached the bottom
				item.y = Randomizer.getInt(1, 3);
				item.x = Randomizer.getInt(1, N);
			}
		}
	}

	protected void render(Graphics g) {
		int y = 0;
		for (int j = 1; j <= M; j++) { // up->down

			y = j;
			for (int i = 1; i <= N; i++) { // left->right
				int x = i;
				drawSquare(g, x, y, Color.YELLOW, Color.BLACK);
			}
		}
		for (Tank item : items) {
			item.render(g);
		}
		this.tank.render(g);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.render(g);
	}

	protected void drawSquare(Graphics g, int x, int y, Color lineColor, Color fillColor) {
		g.setColor(lineColor);
		g.fillRect(x * H, y * H, H, H);
		g.setColor(fillColor);
		g.drawRect(x * H, y * H, H, H);
	}

	public void keyPressed(KeyEvent e) {
		// char c = e.getKeyChar();
		// int code = e.getKeyCode();
		// String s = "keyPressed: [" + c + "] (" + String.valueOf(code) + ")";
		// System.out.println(s);
		
		int code = e.getKeyCode();
		System.out.println("keyCode: " + code);

		switch (code) {
		case KeyEvent.VK_W:
			this.pressedKeys.put(KeyEvent.VK_W, true);
			System.out.println(pressedKeys);
			break;
		case KeyEvent.VK_A:
			this.pressedKeys.put(KeyEvent.VK_A, true);
			break;
		case KeyEvent.VK_S:
			this.pressedKeys.put(KeyEvent.VK_S, true);
			break;
		case KeyEvent.VK_D:
			this.pressedKeys.put(KeyEvent.VK_D, true);
			break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		// char c = e.getKeyChar();
		// System.out.println("keyReleased: " + c);

		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_W:
			this.pressedKeys.put(KeyEvent.VK_W, false);
			break;
		case KeyEvent.VK_A:
			this.pressedKeys.put(KeyEvent.VK_A, false);
			break;
		case KeyEvent.VK_S:
			this.pressedKeys.put(KeyEvent.VK_S, false);
			break;
		case KeyEvent.VK_D:
			this.pressedKeys.put(KeyEvent.VK_D, false);
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
		// char c = e.getKeyChar();
		// System.out.println("keyTyped: " + c);
	}
}

