/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.PathFinder;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/**
 *
 * @author PK
 */
public class PathHandler {

    private PathFinder pathFinder;
    private Path path;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public PathHandler(TileBasedMap map) {
        pathFinder = new AStarPathFinder(map, 500, false);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        if (path != null) {
            for (int x = 0; x < path.getLength(); x++) {
                g.setColor(Color.yellow);
                g.fillRect(path.getStep(x).getX() * 20, path.getStep(x).getY() * 20, 20, 20);
            }
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    public Path getPath() {
        return path;
    }

    public void updatePath() {
        path = pathFinder.findPath(null, startX, startY, endX, endY);
    }

    public void setVariables(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

}
