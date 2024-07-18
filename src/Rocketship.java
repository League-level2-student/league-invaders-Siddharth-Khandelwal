import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
boolean left = false;
boolean right = false;
boolean down = false;
boolean up = false;
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

	
	public void update(){
		if (up&&y > 0) {
			y -= speed;
		}
		if (down&& y < 800 - 50) {
			y += speed;
		}
		if (left&&x > 0) {
			x -= speed;
		}
		if (right&&x < 500 - 50) {
			x += speed;
		}
	}
}
