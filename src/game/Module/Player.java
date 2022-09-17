package game.Module;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {

	private int x, y, dx, dy;
	private float width, height;
	private Image image;
	private List<Laser> lasers;

	public Player() {
		this.x = 100;
		this.y = 100;

		lasers = new ArrayList<Laser>();
	}

	public void load() {
		ImageIcon ref = new ImageIcon("img\\graphics\\ship.png");
		image = ref.getImage();
		height = image.getHeight(null);
		width = image.getWidth(null);

	}

	public void update() {
		x += dx;
		y += dy;

	}

	public void basicLaser() {
		this.lasers.add(new Laser(x + (width), (float) (y + (height / 2.3))));
	}

	public void input(KeyEvent input) {
		int key = input.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			dy = -4;
		} else if (key == KeyEvent.VK_DOWN) {
			dy = 4;
		} else if (key == KeyEvent.VK_RIGHT) {
			dx = 4;
		} else if (key == KeyEvent.VK_LEFT) {
			dx = -4;
		} else if (key == KeyEvent.VK_A) {
			basicLaser();
		}
	}

	public void input_release(KeyEvent input) {
		int key = input.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			dy = 0;
		} else if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		} else if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		} else if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image;
	}

	public List<Laser> getLasers() {
		return lasers;
	}

}
