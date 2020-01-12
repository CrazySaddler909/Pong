package com.crazycode.ourgame.menu;

/**
 * 
 * @author lukem
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.crazycode.game.GamePlay;

public class Action1 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame obj = new JFrame();
		GamePlay gamePlay = new GamePlay();

		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Brick Braker");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);

	}

}
