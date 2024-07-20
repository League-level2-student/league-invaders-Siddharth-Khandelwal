import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	boolean left = false;
	boolean right = false;
	boolean down = false;
	boolean up = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
			loadImage("rocket (1).png");
		}
	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	public Projectile getProjectile() {
		return new Projectile(x + width / 2, y, 10, 10);
	}

	public void update() {
		if (up && y > 0) {
			y -= speed;
		}
		if (down && y < 800 - 50) {
			y += speed;
		}
		if (left && x > 0) {
			x -= speed;
		}
		if (right && x < 500 - 50) {
			x += speed;
		}
		super.update();
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
