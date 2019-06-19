package com.mycompany.a2;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld {
	private GameWorld gw;

	public GameWorldProxy (GameWorld gw) {
		this.gw = gw;
	}
	
	@Override
	public String getScore() {
		return gw.getScore();
	}

	@Override
	public String getMissiles() {
		return gw.getMissiles();
	}

	@Override
	public String getLives() {
		return gw.getLives();
	}

	@Override
	public String getTime() {
		return gw.getTime();
	}

	@Override
	public String getSound() {
		return gw.getSound();
	}
}