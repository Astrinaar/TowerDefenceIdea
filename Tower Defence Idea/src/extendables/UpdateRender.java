/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendables;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public interface UpdateRender {

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException;

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException;

}
