package data;

import static halpers.Artist.*;

import halpers.Clock;

import org.lwjgl.opengl.Display;

public class Boot {

	public Boot() {
		
		BeginSession();
		
		int[][] map = {
				{0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
				{0, 0, 2, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
				{0, 0, 2, 2, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0 ,0},
				{0, 0, 2, 2, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0 ,0},
				{0, 0, 2, 2, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1 ,1},
				{0, 0, 2, 2, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0 ,0},
				{1, 0, 2, 2, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0 ,0},
				{1, 0, 2, 2, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0 ,0},
				{1, 0, 2, 2, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0 ,0},
				{1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 ,0},
				{0, 0, 2, 2, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 ,0},
				
		};
		
		TileGrid grid = new TileGrid(map);
		grid.SetTile(3, 4, grid.GetTile(5, 7).getType());
		Enemy e = new Enemy(QuickLoad("enemytex"), grid.GetTile(4, 8), grid,  64, 64, 5);
		Wave wave = new Wave(30, e);
		Player player = new Player(grid);
		while (!Display.isCloseRequested()) {
			Clock.Update();
			
			
			grid.Draw();
			wave.Update();
			player.Update();
			
			
			Display.update();
			Display.sync(60);

		}

		Display.destroy();
	}

	public static void main(String[] args) {
		new Boot();

	}
}
