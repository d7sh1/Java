package seven;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameMap extends JPanel implements KeyListener {
	private static final long serialVersionUID = -6839529341001166798L;
	public static int W = 600;
	public static int H = 500;
	private Ball ball;

	public GameMap() {
		this.ball = new Ball();
		this.ball.x = this.W / 2 - ball.H / 2;
		this.ball.y = this.H / 2 - ball.H / 2;
	}

	public void keyTyped(KeyEvent e) {
		// char c = e.getKeyChar();
		// System.out.println("You pressed: " + c);
	}

	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		int code = e.getKeyCode();
		String s = "keyPressed: [" + c + "] (" + String.valueOf(code) + ")";
		System.out.println(s);

		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			System.out.println("W pressed");
			this.ball.y -= this.ball.v;
			break;
		case KeyEvent.VK_A:
			System.out.println("A pressed");
			this.ball.x -= this.ball.v;
			break;
		case KeyEvent.VK_S:
			System.out.println("S pressed");
			this.ball.y += this.ball.v;
			break;
		case KeyEvent.VK_D:
			System.out.println("D pressed");
			this.ball.x += this.ball.v;
			break;
		}
		System.out.println("ball (x: " + ball.x + ", y: " + ball.y + ")");
		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawCircle(g, ball.x, ball.y);				
	}
	
	protected void drawCircle(Graphics g, int x, int y) {
		g.setColor(Color.RED);
		g.fillOval(x, y, ball.H, ball.H);
		g.setColor(Color.BLACK);
		g.drawArc(x, y, ball.H, ball.H, 0, 360);
	}
}

