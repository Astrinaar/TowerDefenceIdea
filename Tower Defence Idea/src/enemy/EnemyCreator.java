/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemy;

import java.util.ArrayList;
import level.Tile;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.util.pathfinding.Path;

/**
 *
 * @author PK
 */
public class EnemyCreator {

    private Point startPosition;
    private ArrayList<Tile> path;
    private EnemyManager enemyManager;

    public EnemyCreator(EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
    }

    public void setStartPosition(Point startPosition) {
        this.startPosition = startPosition;
    }

    public void setPath(ArrayList<Tile> path) {
        this.path = path;
    }

    public void createTestEnemy() {
        enemyManager.addEnemy(new TestEnemy(startPosition, path));
    }

}
