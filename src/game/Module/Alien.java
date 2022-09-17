package game.Module;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Alien {
    private Image image;
    private int x, y;
    private float width, height;
    private boolean isVisible;

    // private static final int HEIGHT = 800;
    private static int SPEED = 2;

    public Alien(double d, float f) {
        this.x = (int) d;
        this.y = (int) f;
        isVisible = true;
    }

    public void load() {
        ImageIcon ref = new ImageIcon("img\\graphics\\monters\\alien.png");
        image = ref.getImage();

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public void update() {
        this.x -= SPEED;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public static int getSpeed() {
        return SPEED;
    }

    public static void setSpeed(int speed) {
        SPEED = speed;
    }

    public Image getImage() {
        return image;
    }

}
