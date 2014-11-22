/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemy;

import comparators.ComparatorY;
import extendables.Enemy;
import extendables.UpdateRender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class EnemyManager implements UpdateRender {

    private ArrayList<Enemy> enemies;
    private Iterator<Enemy> enemyiterator;
    private ComparatorY comparatorY;

    public EnemyManager() {
        enemies = new ArrayList<>();
        comparatorY = new ComparatorY();

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        enemyiterator = enemies.iterator();
        while (enemyiterator.hasNext()) {
            Enemy e = enemyiterator.next();
            if (e.getCurrentLife() <= 0) {
                enemyiterator.remove();
            } else {
                e.update(container, game, delta);
            }
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Collections.sort(enemies, comparatorY);
        enemyiterator = enemies.iterator();
        while (enemyiterator.hasNext()) {
            Enemy e = enemyiterator.next();
            e.render(container, game, g);
        }
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        System.out.println(enemy);
    }

}
