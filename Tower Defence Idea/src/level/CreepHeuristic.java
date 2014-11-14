/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level;

import org.newdawn.slick.util.pathfinding.AStarHeuristic;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/**
 *
 * @author PK
 */
public class CreepHeuristic implements AStarHeuristic{

    @Override
    public float getCost(TileBasedMap map, Mover mover, int x, int y, int tx, int ty) {
        return 50;
    }
    
}
