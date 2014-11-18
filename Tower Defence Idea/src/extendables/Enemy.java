/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendables;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.StateBasedGame;

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

    public Enemy(float maxLife, float moveSpeed, Point position) {
        this.maxLife = maxLife;
        currentLife = maxLife;
        this.moveSpeed = moveSpeed;
        this.position = position;
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
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        texture.draw(position.getX() - (texture.getWidth() / 2), position.getY() - (texture.getHeight() / 2));
        drawHealthBar(g);
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

}
