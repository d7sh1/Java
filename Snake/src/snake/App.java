package snake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class App extends JPanel implements ActionListener {

    private final int CELL_SIZE = 20; // Размер клетки
    private final int WIDTH = 20; // Ширина поля в клетках
    private final int HEIGHT = 20; // Высота поля в клетках
    private final LinkedList<Point> snake; // Змейка
    private Point food; // Еда
    private char direction; // Направление движения
    private boolean gameOver; // Флаг окончания игры
    private final Timer timer; // Таймер для обновления игры
    private int score;
    

    public App() {
        this.snake = new LinkedList<>();
        this.direction = 'R'; // Начальное направление - вправо
        this.gameOver = false;
        this.score = 0;

        // Начальная позиция змейки
        snake.add(new Point(5, 5));
        spawnFood();

        // Настройка панели
        setPreferredSize(new Dimension(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE));
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                changeDirection(e);
            }
        });

        timer = new Timer(100, this); // Таймер обновления игры
        timer.start();
    }

    // Метод для изменения направления змейки
    private void changeDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (direction != 'D') direction = 'U';
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') direction = 'D';
                break;
            case KeyEvent.VK_LEFT:
                if (direction != 'R') direction = 'L';
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') direction = 'R';
                break;
        }
    }

    // Метод для генерации еды в случайной позиции
    private void spawnFood() {
        Random rand = new Random();
        int x, y;

        do {
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(HEIGHT);
        } while (snake.contains(new Point(x, y))); // Убедитесь, что еда не появляется на змейке

        food = new Point(x, y);
    }

    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);

    	// Рисуем сетку с границами клеток
    	drawGrid(g);

    	if (gameOver) {
    		g.setColor(Color.RED);
    		g.setFont(new Font("Arial", Font.BOLD, 50));
    		g.drawString("Game Over!", 50, 200);
    		g.drawString("Score: " +score ,10, 50);
    	} else{
    		g.drawString("Score: " +score ,10, 50);
    		// Рисуем змейку
    		g.setColor(Color.GREEN);
    		for (Point p : snake) {
    			g.fillRect(p.x * CELL_SIZE, p.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    			}
    		// Рисуем фрукт
    		g.setColor(Color.RED);
    		g.fillRect(food.x * CELL_SIZE, food.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    		}
    	}
    private void drawGrid(Graphics g) {
    	// Цвет для линий клеток
    	g.setColor(Color.LIGHT_GRAY);
    	// Рисуем линии сетки (контуры клеток)
    	for (int i = 0; i < WIDTH; i++) {
    		for (int j = 0; j < WIDTH; j++) {
    			g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    			}
    		}
    	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            moveSnake();
            checkCollision();
            repaint();
        }
    }

    // Метод для перемещения змейки
    private void moveSnake() {
        Point head = snake.getFirst();
        Point newHead = new Point(head);

        switch (direction) {
            case 'U':
                newHead.y--;
                break;
            case 'D':
                newHead.y++;
                break;
            case 'L':
                newHead.x--;
                break;
            case 'R':
                newHead.x++;
                break;
        }

        snake.addFirst(newHead);

        // Проверка на поедание еды
        if (newHead.equals(food)) {
        	score++;
            spawnFood(); // Генерируем новую еду
        } else {
            snake.removeLast(); // Удаляем последний сегмент змейки
        }
    }

    // Проверка на столкновение со стенами и самой собой
    private void checkCollision() {
        Point head = snake.getFirst();

        // Проверка на столкновение со стенами
        if (head.x < 0 || head.x >= WIDTH || head.y < 0 || head.y >= HEIGHT) {
            gameOver = true;
        }

        // Проверка на столкновение с самой собой
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                gameOver = true;
                break;
            }
        }
    }

    // Метод для перезапуска игры
    public void restart() {
        snake.clear();
        score = 0;
        snake.add(new Point(5, 5));
        direction = 'R';
        gameOver = false;
        spawnFood();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        App gamePanel = new App();

        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        gamePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R && gamePanel.gameOver) {
                    gamePanel.restart(); // Перезапуск игры при нажатии R
                }
            }
        });
    }
}
