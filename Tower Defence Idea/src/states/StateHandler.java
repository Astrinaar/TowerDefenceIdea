/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tower.defence.idea.TowerDefenceIdea;

/**
 *
 * @author PK
 */
public class StateHandler {

    private static TowerDefenceIdea main;
    public static final int MAINMENUSTATE = 0;
    public static final int RESERVED = 1;
    public static final int PLAYSTATE = 2;

    public StateHandler(TowerDefenceIdea main) {
        StateHandler.main = main;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }

    public static void enterState(int id) {
        main.enterState(id);
    }

}
