package com.crazycode.ourgame.menu;

import com.crazycode.game.BrickBreaker;
import com.crazycode.game.GamePlay;
import com.crazycode.game.MyTimer;

public class OurGameLuncher {

	/**
	 * 
	 * @param args
	 */
	
	private GamePlay gp;
	private MyTimer mt;
	
	public static void main(String[] args) {
		GamePlay p = new GamePlay();
		//MyTimer mt = new MyTimer();
		BrickBreaker brickBreaker = new BrickBreaker();
		brickBreaker.setVisible(true);
		

		//gp.timerGame();
		
		// Menu menu = new Menu();
		// menu.setVisible(true);

	}

}