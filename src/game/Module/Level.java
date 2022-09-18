package game.Module;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Level extends JPanel implements ActionListener {

	private Image background;
	private Player player;
	private Timer timer;
	private List<Alien> alien;
	private int enemies_number = 50;

	public Level() {
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon ref = new ImageIcon("img\\graphics\\background.png");
		background = ref.getImage();

		player = new Player();
		player.load();

		addKeyListener(new KeyboardAdapter());

		create_enemies();

		timer = new Timer(5, this);
		timer.start();
	}

	public void create_enemies() {
		int pos[] = new int[enemies_number];
		alien = new ArrayList<Alien>();

		for (int i = 0; i < pos.length; i++) {
			int x = (int) (Math.random() * 8000 + 1024);
			int y = (int) (Math.random() * 650 + 30);
			alien.add(new Alien(x, y));
		}
	}

	public void paint(Graphics graphics) {
		Graphics2D graphic = (Graphics2D) graphics;
		graphic.drawImage(background, 0, 0, null);
		graphic.drawImage(player.getImage(), player.getX(), player.getY(), this);

		List<Laser> lasers = player.getLasers();
		for (int i = 0; i < lasers.size(); i++) {
			Laser bullet = lasers.get(i);
			bullet.load();
			graphic.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), this);
		}
		for (int i = 0; i < alien.size(); i++) {
			Alien enemy = alien.get(i);
			enemy.load();
			graphic.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
		}
		graphic.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// update player's sprites'
		player.update();

		// implements lasers sprite
		List<Laser> lasers = player.getLasers();
		for (int i = 0; i < lasers.size(); i++) {
			Laser bullet = lasers.get(i);
			if (bullet.isVisible()) {
				bullet.update();
			} else {
				lasers.remove(i);
			}
		}

		for (int i = 0; i < alien.size(); i++) {
			Alien enemy = alien.get(i);
			if (enemy.isVisible()) {
				enemy.update();
			} else {
				alien.remove(i);
			}
		}

		// repaint screen
		repaint();
	}

	private class KeyboardAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			player.input(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.input_release(e);
		}
	}
}
