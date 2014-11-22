/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendables;

import java.util.ArrayList;
import level.Tile;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.pathfinding.Path;

/**
 *
 * @author PK
 */
public class Enemy implements UpdateRender {

    protected float maxLife;
    protected float currentLife;
    protected float moveSpeed;
    protected Image texture;
    protected Point position;
    protected ArrayList<Tile> path;
    protected int previousStep = -1;
    protected Point nextDestination;

    public Enemy(float maxLife, float moveSpeed, Point position, ArrayList<Tile> path) {
        this.maxLife = maxLife;
        currentLife = maxLife;
        this.moveSpeed = moveSpeed;
        this.position = position;
        this.path = path;
        getNextDestination();
    }

    public void receiveDmg(float damage) {
        currentLife -= damage;
    }

    public void receiveHeal(float heal) {
        if (currentLife + heal > maxLife) {
            currentLife = maxLife;
        } else {
            currentLife += heal;
        }
    }

    private void drawHealthBar(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(position.getX() - (texture.getWidth() / 2) + 2, position.getY() - (texture.getHeight() / 2) - 10, texture.getWidth() - 2, 5);
        g.setColor(Color.red);
        g.fillRect(position.getX() - (texture.getWidth() / 2) + 3, position.getY() - (texture.getHeight() / 2) - 9, (texture.getWidth() - 2) * (currentLife / maxLife), 3);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        move(delta);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        texture.draw(position.getX() - (texture.getWidth() / 2), position.getY() - (texture.getHeight() / 2));
        drawHealthBar(g);
    }

    /*
     Moves towards the nextDestination and updates the next destination when reached.
     */
    private void move(int delta) {
        int errorMargin = 1;
        if (position.getX() - nextDestination.getX() < errorMargin && position.getX() - nextDestination.getX() > -errorMargin) {
            if (position.getY() > nextDestination.getY()) {
                //move up
                position.setY(position.getY() - moveSpeed * delta);
            } else {
                //move down
                position.setY(position.getY() + moveSpeed * delta);
            }
        } else if (position.getX() > nextDestination.getX()) {
            //move left
            position.setX(position.getX() - moveSpeed * delta);
        } else {
            //move right
            position.setX(position.getX() + moveSpeed * delta);
        }
        //Check if we have reached the next destination
        if (position.getX() - nextDestination.getX() < errorMargin && position.getX() - nextDestination.getX() > -errorMargin) {
            if (position.getY() - nextDestination.getY() < errorMargin && position.getY() - nextDestination.getY() > -errorMargin) {
                try {
                    getNextDestination();
                } catch (IndexOutOfBoundsException ex) {
                    //Reached destination
                }
            }
        }
    }

    private void getNextDestination() {
        previousStep++;
        nextDestination = path.get(previousStep + 1).getPosition();
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public float getCurrentLife() {
        return currentLife;
    }

    public Image getTexture() {
        return texture;
    }

    @Override
    public String toString() {
        return "Enemy{" + "position=" + position.getX() + "," + position.getY();
    }

}
