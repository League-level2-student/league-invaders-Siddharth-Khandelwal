import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rob;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;
	public ObjectManager(Rocketship r) {
		rob = r;
	}
	public int getScore() {
		return this.score;
	}
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		rob.update();
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		checkCollision();
		purgeObjects();
	}

	private void purgeObjects() {
		// TODO Auto-generated method stub
		for (int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).isActive == false) {
				aliens.remove(i);
				i--;
			}
		}
		for (int j = 0; j < projectiles.size(); j++) {
			if(projectiles.get(j).isActive == false) {
				projectiles.remove(j);
				j--;
			}
		}
	}

	void draw(Graphics g) {
		rob.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();
	}
	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).collisionBox.intersects(rob.collisionBox)) {
				rob.isActive = false;
				aliens.get(i).isActive = false;

			}
			for (int p = 0; p < projectiles.size(); p++) {
				if(aliens.get(i).collisionBox.intersects(projectiles.get(p).collisionBox)) {
					aliens.get(i).isActive = false;
					projectiles.get(p).isActive = false;
					score++;
					
				}
			}
		}

	}
}
