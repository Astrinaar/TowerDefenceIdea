/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level;

import extendables.Level;
import level.levels.level1;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/**
 *
 * @author PK
 */
public class TileMap implements TileBasedMap {
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
    public static int tileSize = 20;
    /*
     A 2 dimensional array of booleans used by the A* pathfinder.
     */
    private boolean[][] visited = new boolean[mapWidth][mapHeight];
    /*
     The class handling all pathfinding.
     */
    private PathHandler pathHandler;

    public TileMap() {
        pathHandler = new PathHandler();
        loadMap(1);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        drawMap(container, game, g);
        pathHandler.render(container, game, g);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    /*
     Creates the amount of tiles specified by mapHeight and mapWidth in the tileSize.
     */
    private void populateTileMap() {
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                tileMap[x][y] = new Tile(new Rectangle(x * tileSize, y * tileSize, tileSize, tileSize));
            }
        }
    }

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

    private void updatePathHandler(Level currentLevel) {
        visited = new boolean[mapWidth][mapHeight];
        pathHandler.setVariables(currentLevel.getStartX(), currentLevel.getStartY(), currentLevel.getEndX(), currentLevel.getEndY());
        pathHandler.updatePath(this);
    }
    /*
     Draws the map as a grid for testing purposes.
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
}
