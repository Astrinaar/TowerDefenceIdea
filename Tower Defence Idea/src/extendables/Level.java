/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendables;

import level.Tile;
import level.TileMap;

/**
 *
 * @author PK
 */
public abstract class Level {

    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;
    protected int mapWidth;
    protected int mapHeight;
    protected int tileSize = TileMap.tileSize;
    protected Tile[][] tileMap;

    public abstract void createMap();

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public Tile[][] getTileMap() {
        return tileMap;
    }

}
