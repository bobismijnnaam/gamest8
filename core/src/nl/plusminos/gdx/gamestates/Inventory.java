package nl.plusminos.gdx.gamestates;

import nl.plusminos.harness.gdx.gamestates.Gamestate;
import nl.plusminos.harness.gdx.gamestates.GamestateAdapter;
import nl.plusminos.harness.gdx.gamestates.GamestateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Inventory extends GamestateAdapter {

	@Override
	public Gamestate instantiate() {
		return new Inventory();
	}

	@Override
	public String getStateID() {
		return "inventory";
	}
	
	@Override
	public boolean isTransparent() {
		return true;
	}
	
	public void render() {
		ShapeRenderer shape = new ShapeRenderer();
		
		// To enable transparency for shaperenderer
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		shape.setProjectionMatrix(camera.combined);
		
		shape.begin(ShapeType.Filled);
		
		shape.setColor(0, 0, 0, 0.5f);
		
		// Draw a fading rectangle so map fades away
		shape.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// Just a symbol
		shape.setColor(Color.BLUE);
		shape.triangle(190, 190, 240, 290, 290, 190);
		shape.setColor(Color.ORANGE);
		shape.triangle(350, 290, 400, 190, 450, 290);
		
		shape.end();
		
		// Stack Overflow told me I needed this
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}
	
	@Override
	public boolean keyDown(int keyCode) {
		GamestateManager gm = GamestateManager.get();
		
		switch (keyCode) {
			case Input.Keys.SPACE: // When space is pressed again, remove the overlay and return to the previous state
				gm.popState();
				break;
		}
		
		return false;
	}
}
