/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.defence.idea;

import helpers.ImgArchive;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.PlayState;
import states.StateHandler;

/**
 *
 * @author PK
 */
public class TowerDefenceIdea extends StateBasedGame {

    private StateHandler stateHandler;
    private ImgArchive imgArchive;
    private PlayState playState;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new TowerDefenceIdea("Namae"));
        app.setDisplayMode(1280, 720, false);
        app.setShowFPS(true);
        app.setTargetFrameRate(59);
        app.setSmoothDeltas(true);
        app.setVSync(true);
        app.start();
    }

    public TowerDefenceIdea(String name) {
        super(name);
        imgArchive = new ImgArchive();
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        initHelpers(container, this);
        stateHandler = new StateHandler(this);
        stateHandler.init(container, this);
        playState = new PlayState();
        addState(playState);
        getState(StateHandler.PLAYSTATE).init(container, this);
        enterState(StateHandler.PLAYSTATE);
    }

    public void initHelpers(GameContainer container, StateBasedGame game) throws SlickException {
        imgArchive.init(container, game);
    }

}
