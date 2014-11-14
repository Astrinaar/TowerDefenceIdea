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
    private TileMap tileMap;
    private ArrayList<Tile> currentPath;

    public PathHandler() {
        currentPath = new ArrayList<>();
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        if (path != null) {
            for (int x = 0; x < path.getLength(); x++) {
                g.setColor(Color.yellow);
                //g.fillRect(path.getStep(x).getX() * 20, path.getStep(x).getY() * 20, 20, 20);
                tileMap.getTile(path.getStep(x).getX(), path.getStep(x).getY());
            }
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    public Path getPath() {
        return path;
    }

    public void updatePathNewMap(TileBasedMap map) {
        tileMap = (TileMap) map;
        pathFinder = new AStarPathFinder(tileMap, 500, false, new CreepHeuristic());
        path = pathFinder.findPath(null, startX, startY, endX, endY);
        if (path != null) {
            resetPathFindingGraphicForTiles();
            setPathFindingGraphicForTiles();
        }
    }

    public void updatePath() {
        pathFinder = new AStarPathFinder(tileMap, 500, false, new CreepHeuristic());
        path = pathFinder.findPath(null, startX, startY, endX, endY);
        if (path != null) {
            resetPathFindingGraphicForTiles();
            setPathFindingGraphicForTiles();
        }
        System.out.println(path.getLength());
    }

    private void setPathFindingGraphicForTiles() {
        for (int x = 0; x < path.getLength(); x++) {
            Tile t = tileMap.getTile(path.getStep(x).getX(), path.getStep(x).getY());
            t.setPathFindingGraphic(1);
            currentPath.add(t);
        }
    }

    private void resetPathFindingGraphicForTiles() {
        for (Tile t : currentPath) {
            t.setPathFindingGraphic(0);
        }
        currentPath.clear();
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
