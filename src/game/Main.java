package game;

import javax.swing.JFrame;

// import game.Graphics.Spritesheet;
import game.Module.Level;

public class Main extends JFrame {

	// public static Spritesheet spritesheet;

	public Main() {
		add(new Level());
		setTitle("Game OO");
		setSize(1240, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		this.setResizable(false);

	}

	public static void main(String[] args) {
		new Main();
	}

}
