package four;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class MyPlanel extends JPanel {
	public static int X = 100;
	public static int Y = 100;
	public static int W = 200;
	public static int H = 150;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(X, Y, W, H);
		g.setColor(Color.BLACK);
		g.drawRect(X, Y, W, H);
	}
}
