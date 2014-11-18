/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemy;

import extendables.Enemy;
import helpers.ImgArchive;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class TestEnemy extends Enemy {

    public TestEnemy(float maxLife, float moveSpeed, Point position) {
        super(maxLife, moveSpeed, position);
        texture = ImgArchive.getPlayer();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        super.render(container, game, g);
        g.setColor(Color.white);
        g.draw(position);
    }

}
