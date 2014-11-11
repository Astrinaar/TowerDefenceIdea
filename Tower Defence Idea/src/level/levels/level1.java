/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level.levels;

import extendables.Level;
import level.Tile;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author PK
 */
public class level1 extends Level {

    public level1() {
        startX = 1;
        startY = 5;
        endX = 5;
        endY = 7;
        mapWidth = 20;
        mapHeight = 15;
        createMap();
    }

    @Override
    public void createMap() {
        tileMap = new Tile[mapWidth][mapHeight];
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                tileMap[x][y] = new Tile(new Rectangle(x * tileSize, y * tileSize, tileSize, tileSize));
            }
        }
        setBlocked();
    }

    private void setBlocked() {
        tileMap[5][1].setBlocked(true);
        tileMap[5][2].setBlocked(true);
        tileMap[5][3].setBlocked(true);
        tileMap[5][4].setBlocked(true);
        tileMap[5][5].setBlocked(true);
    }

}
