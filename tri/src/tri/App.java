package tri;
import javax.swing.JFrame;


public class App extends JFrame {
	public static void main(String[] args) {
		System.out.println("[*] Trying to create Window using JFrame...");


		App jf = new App();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(450, 450);
		jf.setVisible(true);
	}
}
