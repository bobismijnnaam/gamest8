package nl.plusminos.gdx.gamestates;

import nl.plusminos.harness.gdx.gamestates.GamestateManager;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStates extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	
	GamestateManager gm;
	
	@Override
	public void create () {
		// Create Gamestatemanager with a framerate of 60
		gm = new GamestateManager(1/60.0f, new Main());
		
		// Add each individual gamestate
		gm.addState(new One());
		gm.addState(new Two());
		gm.addState(new Inventory());
		
		// Start the gamestate with the ID "main"
		gm.setState("main");
	}

	@Override
	public void render () {
		// Update GamestateMachine
		gm.update();
	}
	
	public void dispose() {
		// Dispose GamestateMachine
		gm.dispose();
	}
}
