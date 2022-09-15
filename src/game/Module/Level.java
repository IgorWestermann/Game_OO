package game.Module;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Level extends JPanel implements ActionListener {
	
	private Image background;
	private Player player;
	private Timer timer;
	
	public Level() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon ref = new ImageIcon("img\\graphics\\background.png");
		background = ref.getImage();
		
		player = new Player();
		player.load();
		
		addKeyListener(new KeyboardAdapter());
		
		timer = new Timer(5, this);
		timer.start();
	}
	
	public void paint(Graphics graphics) {
		Graphics2D graphic = (Graphics2D) graphics;
		graphic.drawImage(background, 0, 0, null);
		graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);
		graphic.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
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
