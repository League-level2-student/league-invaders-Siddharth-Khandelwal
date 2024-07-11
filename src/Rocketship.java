import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
public void draw(Graphics g) {
	g.setColor(Color.blue);
	g.fillRect(x, y, width, height);
}
}
