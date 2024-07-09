import javax.swing.JFrame;
import javax.swing.Timer;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel bob;

	public LeagueInvaders() {
		bob = new GamePanel();

	}

	public static void main(String[] args) {
		LeagueInvaders tom = new LeagueInvaders();
		tom.setup();

	}

	void setup() {
		frame.add(bob);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
