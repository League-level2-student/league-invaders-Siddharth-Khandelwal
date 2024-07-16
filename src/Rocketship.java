import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 25;
	}
public void draw(Graphics g) {
	g.setColor(Color.blue);
	g.fillRect(x, y, width, height);
}
public void right() {
	if(x<500-50) {
		x+=speed;
	}
}
public void left() {
	if(x>0) {
		x-=speed;
	}
}
public void up() {
	if(y>0) {
		y-=speed;
	}
			
}
public void down() {
	if(y<800-50) {
		y+=speed;
	}
}
}
