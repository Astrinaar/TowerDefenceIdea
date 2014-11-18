/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparators;

import extendables.Enemy;
import java.util.Comparator;

/**
 *
 * @author PK
 */
public class ComparatorY implements Comparator<Enemy> {

    @Override
    public int compare(Enemy o1, Enemy o2) {
        Float f = o1.getPosition().getY();
        return f.compareTo(o2.getPosition().getY());
    }
}
