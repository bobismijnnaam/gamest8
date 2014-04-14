package nl.plusminos.gdx.gamestates;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import nl.plusminos.harness.gdx.gamestates.Gamestate;
import nl.plusminos.harness.gdx.gamestates.GamestateAdapter;
import nl.plusminos.harness.gdx.gamestates.GamestateManager;

public class One extends GamestateAdapter {

	@Override
	public Gamestate instantiate() {
		return new One();
	}

	@Override
	public String getStateID() {
		return "one";
	}
	
	public void render() {
		// Draw the map
		Main.drawMap();
		
		// Draw the player position
		ShapeRenderer shape = new ShapeRenderer();
		
		shape.setProjectionMatrix(camera.combined);
		
		shape.begin(ShapeType.Filled);
		
		shape.setColor(Color.BLUE);
		shape.circle(225, 125, 20, 6);
		
		shape.end();
	}
	
	@Override
	public boolean keyDown(int keyCode) {
		GamestateManager gm = GamestateManager.get();
		
		switch (keyCode) {
			case Input.Keys.LEFT: // When left is pressed, move the player to room main
				gm.setState("main");
				break;
			case Input.Keys.UP: // When up is pressed, move the player to room two
				gm.setState("two");
				break;
			case Input.Keys.SPACE: // When space is pressed, open the inventory overlay
				gm.pushState("inventory");
				break;
		}
		
		return false;
	}

}
