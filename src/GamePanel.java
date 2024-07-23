import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Rocketship rock = new Rocketship(250, 700, 50, 50);
	ObjectManager obj = new ObjectManager(rock);
	JLabel label = new JLabel();
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Timer alienSpawn;
	Timer frameDraw;
	public GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
			loadImage ("space (2).png");
		}
	}
	void startGame(){
		alienSpawn = new Timer(1000 , obj);
		alienSpawn.start();
	}
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font basicFont = new Font("Arial", Font.PLAIN, 24);
	Font justforscore = new Font("Courier New", Font.PLAIN, 24);

	void updateMenuState() {

	}

	void updateGameState() {
		obj.update();
		if(rock.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("LEAGUE INVADERS", 25, 150);
		g.setFont(basicFont);
		g.drawString("Press ENTER to start", 140, 300);
		g.drawString("Press SPACE for instructions", 100, 450);
		obj.score = 0;
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		obj.draw(g);
		g.setFont(justforscore);
		g.setColor(Color.GREEN);
		g.drawString("Score: "+obj.getScore(), 50, 100);
		

	}
	void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.yellow);
		g.drawString("Game Over", 125, 150);
		g.setFont(basicFont);
		g.drawString("You killed " +obj.getScore()+ " enemies", 150, 300);
		g.drawString("Press ENTER to restart", 125, 450);

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);

		} else if (currentState == END) {
			drawEndState(g);
			alienSpawn.stop();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();

		}
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				rock = new Rocketship(250, 700, 50, 50);
				obj = new ObjectManager(rock);
				currentState = MENU;
			} else {
				currentState++;
			}
			if(currentState == GAME) {
				startGame();
			}
			
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rock.up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			rock.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			rock.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			rock.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			obj.addProjectile(rock.getProjectile());
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE&&currentState==MENU) {
			JOptionPane.showMessageDialog(null, "Use arrow keys to move. Press SPACE to fire. Try not to die");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rock.up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			rock.down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			rock.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			rock.right = false;
		}
	}
	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
