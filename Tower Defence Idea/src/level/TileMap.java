/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level;

import enemy.EnemyCreator;
import extendables.Level;
import extendables.UpdateRender;
import level.levels.level1;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/**
 *
 * @author PK
 */
public class TileMap implements TileBasedMap, UpdateRender {
    /*
     2 dimensional array of Tiles, which will be the tilemap.
     */

    private static Tile[][] tileMap;
    /*
     Amount of tiles on the y axis.
     */
    private int mapHeight = 10;
    /*
     Amount of tiles on the x axis.
     */
    private int mapWidth = 30;
    /*
     The size of each tile.
     */
    public static int tileSize = 45;
    /*
     A 2 dimensional array of booleans used by the A* pathfinder.
     */
    private boolean[][] visited = new boolean[mapWidth][mapHeight];
    /*
     The class handling all pathfinding.
     */
    private PathHandler pathHandler;
    private EnemyCreator enemyCreator;

    public TileMap(EnemyCreator enemyCreator) {
        pathHandler = new PathHandler(this);
        this.enemyCreator = enemyCreator;
        loadMap(1);
        enemyCreator.createTestEnemy();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        drawMap(container, game, g);
        pathHandler.render(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    /**
     * Loads a new map, setting new variables and updating the pathHandler.
     *
     * @param level The level to load.
     */
    public void loadMap(int level) {
        Level currentLevel = null;
        switch (level) {
            case 1:
                currentLevel = new level1();
                setMapVariables(currentLevel);
                break;
            default:
                return;
        }
        updatePathHandler(currentLevel);
    }

    private void setMapVariables(Level currentLevel) {
        mapWidth = currentLevel.getMapWidth();
        mapHeight = currentLevel.getMapHeight();
        tileMap = currentLevel.getTileMap();
    }

    /**
     * Updates the pathHandler when loading a new level, setting the starting
     * point and the end point and updating the enemyCreator.
     *
     * @param currentLevel The new level that the pathHandler should use.
     */
    public void updatePathHandler(Level currentLevel) {
        visited = new boolean[mapWidth][mapHeight];
        pathHandler.setVariables(currentLevel.getStart(), currentLevel.getEnd());
        pathHandler.updatePath();
        enemyCreator.setStartPosition(tileMap[(int) currentLevel.getStart().getX()][(int) currentLevel.getStart().getY()].getPosition());
        enemyCreator.setPath(pathHandler.getCurrentPath());
    }

    /**
     * Updates the path when a change to the map happens and updates the
     * enemyCreator;
     */
    public void updatePath() {
        visited = new boolean[mapWidth][mapHeight];
        pathHandler.updatePath();
        enemyCreator.setPath(pathHandler.getCurrentPath());
    }

    /**
     * Draws the map as a grid for testing purposes.
     */
    public void drawMap(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.white);
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                g.setColor(Color.white);
                Tile t = tileMap[x][y];
                t.render(container, game, g);
            }
        }
    }

    public Tile getTileAtPoint(float x, float y) {
        for (Tile[] ta : tileMap) {
            for (Tile t : ta) {
                if (t.getBounds().contains(new Point(x, y))) {
                    return t;
                }
            }
        }
        return null;
    }

    @Override
    public int getWidthInTiles() {
        return mapWidth;
    }

    @Override
    public int getHeightInTiles() {
        return mapHeight;
    }

    @Override
    public void pathFinderVisited(int x, int y) {
        visited[x][y] = true;
    }

    @Override
    public boolean blocked(PathFindingContext context, int tx, int ty) {
        if (tileMap[tx][ty].isBlocked() || tileMap[tx][ty].isUntouchable()) {
            return true;
        }
        return false;
    }

    @Override
    public float getCost(PathFindingContext context, int tx, int ty) {
        return tileMap[tx][ty].getMoveCost();
    }

    public Tile getTile(int x, int y) {
        return tileMap[x][y];
    }
}
