package two;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {
	public static void main(String[] args) {
		Scanner sc;
		try {
			sc = new Scanner(new File("input.txt"));
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int sum = a + b;
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}