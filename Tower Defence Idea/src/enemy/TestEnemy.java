/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemy;

import extendables.Enemy;
import helpers.ImgArchive;
import java.util.ArrayList;
import level.Tile;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.pathfinding.Path;

/**
 *
 * @author PK
 */
public class TestEnemy extends Enemy {

    public TestEnemy(Point position, ArrayList<Tile> path) {
        super(100, 5, position, path);
        texture = ImgArchive.getPlayer();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        super.render(container, game, g);
        g.setColor(Color.white);
        g.draw(position);
    }

}
