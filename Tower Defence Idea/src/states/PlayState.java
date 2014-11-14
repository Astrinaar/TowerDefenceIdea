/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import build.BuildTool;
import input.InputReceiver;
import level.TileMap;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class PlayState extends BasicGameState {

    private final int id = StateHandler.PLAYSTATE;
    private InputReceiver inputReceiver;
    private TileMap tileMap;
    private BuildTool buildTool;

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        tileMap = new TileMap();
        buildTool = new BuildTool(tileMap);
        inputReceiver = new InputReceiver(buildTool);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        tileMap.render(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        inputReceiver.reactToInput(container, delta);
        tileMap.update(container, game, delta);
    }

}
