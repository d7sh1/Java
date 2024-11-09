package six;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class App extends JFrame {
	private static final long serialVersionUID = -872240860301020083L;
	public static void main(String[] args) {
		App jf = new App();
		GameMap gmap = new GameMap();
		gmap.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				// char c = e.getKeyChar();
				// System.out.println("You pressed: " + c);
}
			public void keyPressed(KeyEvent e) {
char c = e.getKeyChar();
				int code = e.getKeyCode();
				String s = "keyPressed: [" + c + "] (" + String.valueOf(code) + ")";
				System.out.println(s);
}
			public void keyReleased(KeyEvent e) {}
});
		gmap.setFocusable(true);
		jf.add(gmap);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(GameMap.W, GameMap.H);
		jf.setVisible(true);
	}
}
