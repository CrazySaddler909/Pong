package com.crazycode.game;

/**
 * 
 * @author lukem
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class GamePlay extends JPanel implements ActionListener {

	private static final long serialVersionUID = 5143807722627587976L;

	public boolean play = false;

	private int score = 10;

	private int totalBricks = 21;

	private Timer timer;
	private int delay = 15;

	private int hits = 0;
	private int level = 1;

	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;

	private int playerX = 310;

	long startTime = System.currentTimeMillis();

	long elapsedTime = System.currentTimeMillis() - startTime;
	long elapsedSeconds = elapsedTime / 1000;
	long secondsDisplay = elapsedSeconds % 60;
	long elapsedMinutes = elapsedSeconds / 60;

	private MapGenrator map;

	static final String LEFT_KEY_PRESS = "LEFT_KEY_PRESS";
	static final String RIGHT_KEY_PRESS = "RIGHT_KEY_PRESS";
	static final String ENTER_KEY_PRESS = "ENTER_KEY_PRESS";

	public GamePlay() {
		// this.setBounds(10, 10, 700, 600);
		map = new MapGenrator(3, 7);
		// addKeyListener(this);
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), LEFT_KEY_PRESS);
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), RIGHT_KEY_PRESS);
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), ENTER_KEY_PRESS);

		this.getActionMap().put(LEFT_KEY_PRESS, new AbstractAction() {
			private static final long serialVersionUID = 5670855635008815093L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (playerX <= 10) {
					playerX = 10;
				} else {
					moveLeft();
				}

			}

			public void moveLeft() {
				play = true;
				playerX -= 20;
			}
		});

		this.getActionMap().put(RIGHT_KEY_PRESS, new AbstractAction() {
			private static final long serialVersionUID = 4936699731039254995L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (playerX >= 600) {
					playerX = 600;
				} else {
					moveRight();
				}

			}

			public void moveRight() {
				play = true;
				playerX += 20;
			}
		});
		this.getActionMap().put(ENTER_KEY_PRESS, new AbstractAction() {
			private static final long serialVersionUID = -1368441882484550270L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!play) {
					play = true;
					ballposX = 120;
					ballposY = 350;
					ballXdir = -1;
					ballYdir = -2;
					playerX = 310;
					score = 0;
					level = 1;
					totalBricks = 21;
					map = new MapGenrator(3, 7);
					repaint();
				}
			}
		});

		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();

	}

	public void paint(Graphics g) {

		// System.out.println("Paint");
		// Background
		g.setColor(Color.cyan);
		g.fillRect(1, 1, 692, 592);

		// Drawing map
		map.draw((Graphics2D) g);

		// Borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);

		// Score
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("Score:" + score, 590, 30);

		// Level
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("Level: " + level, 20, 30);

		// The paddle
		g.setColor(Color.red);
		g.fillRect(playerX, 550, 100, 8);

		// The ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20, 20);

		if (totalBricks <= 0) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.blue);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("YOU WON!", 190, 300);

			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter To Restart ", 230, 350);
		}

		if (score <= 0) {
			play = false;
			ballXdir = 2;
			ballYdir = 2;
			score = 10;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game Over,Score is: " + score, 190, 300);

			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter To Restart ", 230, 350);
		}

		if (hits == 10) {
			level += 1;
			delay -= 1;
			hits = 0;
			timer.setDelay(delay);
		}

		System.out.println(delay);

		if (level == 10) {
			play = false;
			ballXdir = 2;
			ballYdir = 2;
			score = 10;
			delay = 15;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game Over,Score is: " + score, 190, 300);

			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter To Restart ", 230, 350);
		}
	}

	// public void timerGame() {
	// boolean x = true;
	// long displayMinutes = 0;
	// long starttime = System.currentTimeMillis();
	// // System.out.println("Timer:");
	// while (x) {
	// // TimeUnit.SECONDS.sleep(1);
	// long timepassed = System.currentTimeMillis() - starttime;
	// long secondspassed = timepassed / 1000;
	//
	// if (secondspassed == 60) {
	// secondspassed = 0;
	// starttime = System.currentTimeMillis();
	// }
	// if ((secondspassed % 60) == 0)
	// displayMinutes++;
	//
	// // System.out.println(displayMinutes + "::" + secondspassed);
	// // System.out.println("Level: " + level);
	//
	// if (secondspassed == 5) {
	// level += 1;
	// reset();
	// break;
	// }
	// }
	// }

	public void reset() {
		// timerGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("Action Performed");
		// System.out.println("play:" + play);
		timer.start();

		if (play) {
			if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
				ballYdir = -ballYdir;
				hits += 1;
			}

			for (int i = 0; i < map.map.length; i++) {
				for (int j = 0; j < map.map[0].length; j++) {
					if (map.map[i][j] > 0) {
						// int brickX = j * map.brickWidth + 80;
						// int brickY = i * map.brickHeight + 50;
						// int brickWidth = map.brickWidth;
						// int brickHeight = map.brickHeight;

						// Rectangle rect = new Rectangle(brickX, brickY,
						// brickWidth, brickHeight);
						// Rectangle ballRect = new Rectangle(ballposX,
						// ballposY, 20, 20);
						// Rectangle brickRect = rect;

						// if (ballRect.intersects(brickRect)) {
						// map.setBrickValue(0, i, j);
						// totalBricks--;
						// score += 5;
						//
						// if (ballposX + 19 <= brickRect.x || ballposX + 1 >=
						// brickRect.width) {
						// ballXdir = -ballXdir;
						// } else {
						// ballYdir = -ballYdir;
						// }
						// break A;
						// }
						// }
					}
				}

				ballposX += ballXdir;
				ballposY += ballYdir;
				if (ballposX < 0) {
					ballXdir = -ballXdir;
				}

				if (ballposY < 0) {
					ballYdir = -ballYdir;
				}

				if (ballposX > 670) {
					ballXdir = -ballXdir;
				}

				if (ballposY > 550) {
					ballYdir = -ballYdir;
					score -= 1;
				}
			}
			repaint();
		}

	}

}
