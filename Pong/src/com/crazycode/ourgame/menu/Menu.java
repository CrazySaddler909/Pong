package com.crazycode.ourgame.menu;

/**
 * 
 * @author lukem
 *
 */

import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.crazycode.game.MyGraphics;

public class Menu extends JPanel {

	private static final long serialVersionUID = -5664900959962217782L;
	
	public Menu(ActionListener actionListener) throws HeadlessException {
		super();

		MyGraphics myGraphics = new MyGraphics();
		this.add(myGraphics);

		JButton button = new JButton("Play Game");
		button.setSize(100, 40);
		button.addActionListener(actionListener);
		this.add(button);
	}

}
