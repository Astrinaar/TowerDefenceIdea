/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendables;

import level.Tile;
import level.TileMap;
import org.newdawn.slick.geom.Point;

/**
 *
 * @author PK
 */
public abstract class Level {

    protected Point start;
    protected Point end;
    protected int mapWidth;
    protected int mapHeight;
    protected int tileSize = TileMap.tileSize;
    protected Tile[][] tileMap;

    public abstract void createMap();

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
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
