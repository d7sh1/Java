package four;
import javax.swing.JFrame;
public class App extends JFrame {
	private static final long serialVersionUID = 1855658812934113705L;
	public static int W = 600;
	public static int H = 500;


	public static void main(String[] args) {
		App jf = new App();
		jf.add(new MyPlanel());
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(W, H);
		jf.setVisible(true);
	}
}
