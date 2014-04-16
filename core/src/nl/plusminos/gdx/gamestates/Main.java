package nl.plusminos.gdx.gamestates;

import nl.plusminos.harness.gdx.gamestates.Gamestate;
import nl.plusminos.harness.gdx.gamestates.GamestateAdapter;
import nl.plusminos.harness.gdx.gamestates.GamestateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Main extends GamestateAdapter {

	private OrthographicCamera camera;

	@Override
	public Gamestate instantiate() {
		return new Main();
	}

	@Override
	public String getStateID() {
		return "main";
	}
	
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public static void drawMap(Camera camera) {
		ShapeRenderer shape = new ShapeRenderer();
		
		shape.setProjectionMatrix(camera.combined);
		
		shape.begin(ShapeType.Filled);
		
		shape.setColor(Color.ORANGE);
		shape.rect(100, 100, 50, 50); // Room Mainn
		shape.rect(200, 100, 50, 50); // Room One
		shape.rect(200, 200, 50, 50); // Room Two
		
		shape.end();
	}
	
	public void render() {
		// Draw the map
		drawMap(camera);
		
		// Draw the player position
		ShapeRenderer shape = new ShapeRenderer();
		
		shape.setProjectionMatrix(camera.combined);
		
		shape.begin(ShapeType.Filled);
		
		shape.setColor(Color.BLUE);
		shape.circle(125, 125, 20, 6);
		
		shape.end();
	}
	
	@Override
	public boolean keyDown(int keyCode) {
		GamestateManager gm = GamestateManager.get();
		
		switch (keyCode) {
			case Input.Keys.RIGHT: // When right is pressed, move the player to room one
				gm.setState("one");
				break;
			case Input.Keys.SPACE: // When space is pressed, show the inventory overlay
				gm.pushState("inventory");
				break;
		}
		
		// Return false, so the gesturedetector can also do it's work
		return false;
	}
}
