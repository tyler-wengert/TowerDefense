package data;

import java.util.ArrayList;
import static halpers.Clock.*;

public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	private boolean first = true;

	public Wave(float spawnTime, Enemy enemyType) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		timeSinceLastSpawn = 0;
		enemyList = new ArrayList<Enemy>();
	}

	public void Update() {
		timeSinceLastSpawn += Delta();
		if (first) {
			Spawn();
			timeSinceLastSpawn = 0;
			first = false;
		} else {
			timeSinceLastSpawn += Delta();
		}
		if (timeSinceLastSpawn > spawnTime) {
			Spawn();
			timeSinceLastSpawn = 0;
		}
		for (Enemy e : enemyList) {
			if (e.isAlive()) {
				e.Update();
				e.Draw();
			}
		}

	}

	private void Spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType
				.getStartTile(), enemyType.getTileGrid(), 64, 64, enemyType
				.getSpeed()));

	}

}
