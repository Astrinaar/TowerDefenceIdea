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
        startX = 0;
        startY = 5;
        endX = 19;
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
        tileMap[0][10].setUntouchable(true);
        tileMap[0][11].setUntouchable(true);
        tileMap[0][12].setUntouchable(true);
        tileMap[0][13].setUntouchable(true);
        tileMap[0][14].setUntouchable(true);

        tileMap[1][0].setUntouchable(true);
        tileMap[1][1].setUntouchable(true);
        tileMap[1][2].setUntouchable(true);
        tileMap[1][12].setUntouchable(true);
        tileMap[1][13].setUntouchable(true);
        tileMap[1][14].setUntouchable(true);

        
        tileMap[11][9].setUntouchable(true);
        tileMap[11][10].setUntouchable(true);
        tileMap[11][11].setUntouchable(true);
        tileMap[11][12].setUntouchable(true);
        tileMap[11][13].setUntouchable(true);
        tileMap[11][14].setUntouchable(true);
        tileMap[12][9].setUntouchable(true);
        tileMap[12][10].setUntouchable(true);
        tileMap[12][11].setUntouchable(true);
        tileMap[12][12].setUntouchable(true);
        tileMap[12][13].setUntouchable(true);
        tileMap[12][14].setUntouchable(true);
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
        tileMap[5][10].setBlocked(true);
        tileMap[5][11].setBlocked(true);
        tileMap[5][12].setBlocked(true);
        tileMap[5][13].setBlocked(true);
        tileMap[5][14].setBlocked(true);

        tileMap[8][0].setBlocked(true);
        tileMap[8][1].setBlocked(true);
        tileMap[8][2].setBlocked(true);
        tileMap[8][3].setBlocked(true);
        tileMap[8][4].setBlocked(true);
        tileMap[8][5].setBlocked(true);
        tileMap[8][6].setBlocked(true);
        tileMap[8][7].setBlocked(true);
        tileMap[8][8].setBlocked(true);
        tileMap[8][9].setBlocked(true);
        tileMap[8][10].setBlocked(true);
    }

}
