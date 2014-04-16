package nl.plusminos.gdx.gamestates;

import nl.plusminos.harness.gdx.gamestates.Gamestate;
import nl.plusminos.harness.gdx.gamestates.GamestateAdapter;
import nl.plusminos.harness.gdx.gamestates.GamestateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Two extends GamestateAdapter {

	private OrthographicCamera camera;

	@Override
	public Gamestate instantiate() {
		return new Two();
	}

	@Override
	public String getStateID() {
		return "two";
	}
	
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public void render() {
		// Draw the map
		Main.drawMap(camera);
		
		// Draw the player position
		ShapeRenderer shape = new ShapeRenderer();
		
		shape.setProjectionMatrix(camera.combined);
		
		shape.begin(ShapeType.Filled);
		
		shape.setColor(Color.BLUE);
		shape.circle(225, 225, 20, 6);
		
		shape.end();
	}
	
	@Override
	public boolean keyDown(int keyCode) {
		GamestateManager gm = GamestateManager.get();
		
		switch (keyCode) {
			case Input.Keys.DOWN: // If down is pressed, move the player to room one
				gm.setState("one");
				break;
			case Input.Keys.SPACE: // If space is pressed, open up the inventory overlay
				gm.pushState("inventory");
				break;
		}
		
		return false;
	}

}
