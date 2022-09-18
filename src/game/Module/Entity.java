package game.Module;

import java.awt.Rectangle;

import game.Main;

import java.awt.Graphics;

public class Entity {
    private double x, y;
    private int width, height;

    public Entity(double x, double y, float width2, float height2) {
        this.x = x;
        this.y = y;
        this.width = (int) width2;
        this.height = (int) height2;
    }

    public int getX() {
        return (int) this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return (int) this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static boolean collision(Entity entity1, Entity entity2) {
        Rectangle entity1_hitbox = new Rectangle(entity1.getX(), entity1.getY(), entity1.getWidth(),
                entity1.getHeight());
        Rectangle entity2_hitbox = new Rectangle(entity2.getX(), entity2.getY(), entity2.getWidth(),
                entity2.getHeight());
        return entity1_hitbox.intersects(entity2_hitbox);
    }

}
