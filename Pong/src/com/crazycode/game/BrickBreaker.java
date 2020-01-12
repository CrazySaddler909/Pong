package com.crazycode.game;

/**
 * 
 * @author lukem
 *
 */

import java.awt.CardLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.crazycode.ourgame.menu.Menu;

public class BrickBreaker extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2543805004846633150L;

	JPanel cards;
	final static String MENU = "MENU";
	final static String GAME = "GAME";

	public BrickBreaker() throws HeadlessException {
		super();

		this.setTitle("Pong");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(700, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		Menu menu = new Menu(this);
		GamePlay game = new GamePlay();

		cards = new JPanel(new CardLayout());
		cards.add(menu, MENU);
		cards.add(game, GAME);

		setContentPane(cards);
		// this.add(menu);
		// getContentPane().add(menu);
		// getContentPane().revalidate();
		// getContentPane().repaint();
	}

	public BrickBreaker(GraphicsConfiguration gc) {
		super(gc);
	}

	public BrickBreaker(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

	public BrickBreaker(String title) throws HeadlessException {
		super(title);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action Performed");
		System.out.println("Content Pane:" + getContentPane().toString());

		CardLayout cl = (CardLayout) cards.getLayout();
		cl.show(cards, GAME);
		// GamePlay gamePlay = new GamePlay();
		// removeAll();
		// revalidate();
		// setContentPane(gamePlay);
		System.out.println("Content Pane:" + getContentPane().toString());

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Key Typed");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("key Pressed");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Key Released");

	}

}
