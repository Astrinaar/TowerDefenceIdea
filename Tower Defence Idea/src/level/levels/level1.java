/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level.levels;

import extendables.Level;
import level.Tile;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author PK
 */
public class level1 extends Level {

    public level1() {
        start = new Point(0, 5);
        end = new Point(24, 7);
        mapWidth = 25;
        mapHeight = 10;
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
        setUntouchable();
        setBlocked();

    }

    private void setUntouchable() {
        tileMap[0][0].setUntouchable(true);
        tileMap[0][1].setUntouchable(true);
        tileMap[0][2].setUntouchable(true);
        tileMap[0][3].setUntouchable(true);
        tileMap[0][4].setUntouchable(true);
        tileMap[0][6].setUntouchable(true);
        tileMap[0][7].setUntouchable(true);
        tileMap[0][8].setUntouchable(true);
        tileMap[0][9].setUntouchable(true);

        tileMap[1][0].setUntouchable(true);
        tileMap[1][1].setUntouchable(true);
        tileMap[1][2].setUntouchable(true);
        tileMap[1][7].setUntouchable(true);
        tileMap[1][8].setUntouchable(true);
        tileMap[1][9].setUntouchable(true);

    }

    private void setBlocked() {
        tileMap[5][1].setBlocked(true);
        tileMap[5][2].setBlocked(true);
        tileMap[5][3].setBlocked(true);
        tileMap[5][4].setBlocked(true);
        tileMap[5][5].setBlocked(true);
        tileMap[5][6].setBlocked(true);
        tileMap[5][7].setBlocked(true);
        tileMap[5][8].setBlocked(true);
        tileMap[5][9].setBlocked(true);

        tileMap[8][0].setBlocked(true);
        tileMap[8][1].setBlocked(true);
        tileMap[8][2].setBlocked(true);
        tileMap[8][3].setBlocked(true);
        tileMap[8][4].setBlocked(true);
        tileMap[8][5].setBlocked(true);
        tileMap[8][6].setBlocked(true);
        tileMap[8][7].setBlocked(true);
        tileMap[8][8].setBlocked(true);

    }

}
