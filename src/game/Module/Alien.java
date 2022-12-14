package game.Module;

import java.awt.Image;

import javax.swing.ImageIcon;

// Mesma ideia da classe laser porem com spawn aleatorio em um range fora da tela e andando de direita para a esquerda
public class Alien {
    private Image image;
    private int x, y;
    private float width, height;
    private boolean isVisible;

    private static int SPEED = 2;

    public Alien(double d, float f) {
        this.x = (int) d;
        this.y = (int) f;
        isVisible = true;
    }

    public void load() {
        ImageIcon ref = new ImageIcon("img\\graphics\\monsters\\alien.png");
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
