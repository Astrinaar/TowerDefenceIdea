/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class Tile {

    protected Rectangle bounds;
    protected boolean occupied = false;
    protected boolean blocked = false;
    protected boolean untouchable = false;
    protected float moveCost;
    protected int id;

    /*
     This number is used to determine what graphic a Tile should use if it is part of the path.
     0 means not part of the path. The other numbers indicate which direction the next step in the path is, which determines which graphic to use
     1 is up, 2 is right, 3 is down, 4 is left.
     */
    protected int pathFindingGraphic = 0;

    public Tile(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.white);
        if (untouchable) {
            return;
        } else if (blocked) {
            g.fillRect(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
        } else {
            g.drawRect(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
        }
        drawPathGraphic(container, game, g);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    private void drawPathGraphic(GameContainer container, StateBasedGame game, Graphics g) {
        if (pathFindingGraphic == 0) {
            return;
        } else if (pathFindingGraphic == 1) {
            g.setColor(Color.red);
            g.fillRect(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isUntouchable() {
        return untouchable;
    }

    public void setUntouchable(boolean untouchable) {
        this.untouchable = untouchable;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public float getMoveCost() {
        return moveCost;
    }

    public void setMoveCost(float moveCost) {
        this.moveCost = moveCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPathFindingGraphic() {
        return pathFindingGraphic;
    }

    public void setPathFindingGraphic(int pathFindingGraphic) {
        this.pathFindingGraphic = pathFindingGraphic;
    }

}
