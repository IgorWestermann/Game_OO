package game;

import javax.swing.JFrame;

import game.Module.Level;

public class Container extends JFrame {

	public Container() {
		add(new Level());
		setTitle("Game OO");
		setSize(1240, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		this.setResizable(false);

	}

	public static void main(String[] args) {
		new Container();
	}

}
