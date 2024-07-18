import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	public void update() {
		y -= speed;
		if (y < LeagueInvaders.HEIGHT) {
			isActive = false;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
}
