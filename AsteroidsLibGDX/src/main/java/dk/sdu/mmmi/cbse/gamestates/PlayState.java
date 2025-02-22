package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Bullet;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

import java.util.ArrayList;
import java.util.Random;

public class PlayState extends GameState {

	private ShapeRenderer sr;

	private Enemy enemy;
	private Player player;
	private Random random = new Random();
	private ArrayList<Bullet> bullets;

	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {

		sr = new ShapeRenderer();

		player = new Player();

		bullets = new ArrayList<Bullet>();

		enemy = new Enemy(bullets);

	}

	public void update(float dt) {

		// get user input
		handleInput();

		// update player
		player.update(dt);

		// update enemy
		enemy.update(dt);

		//update bullet
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).update(dt);
			if (bullets.get(i).shouldRemove()) {
				bullets.remove(i);
				i--;
			} 
		}

	}

	public void draw() {
		player.draw(sr);
		enemy.draw(sr);

		// draw bullets
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(sr);
		}
	}

	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));
		enemy.setLeft(random.nextBoolean());
		enemy.setRight(random.nextBoolean());
		enemy.setUp(random.nextBoolean());
		enemy.shoot();
	}

	public void dispose() {}

}









