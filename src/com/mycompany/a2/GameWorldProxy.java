package com.mycompany.a2;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld {
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld gw) {
		this.gw = gw;
	}
	
	@Override
	public void addNewAsteroid() {
		gw.addNewAsteroid();
	}

	@Override
	public void addNonPlayerShip() {
		gw.addNonPlayerShip();
		
	}

	@Override
	public void addPlayerShip() {
		gw.addPlayerShip();
	}

	@Override
	public void addSpaceStation() {
		gw.addSpaceStation();
	}

	@Override
	public void decreaseSpeed() {
		gw.decreaseSpeed();
	}

	@Override
	public String displayStats() {
		return gw.displayStats();
		
	}

	@Override
	public void fireMissile() {
		gw.fireMissile();	
		
	}

	@Override
	public void hyperSpaceJump() {
		gw.hyperSpaceJump();
		
	}

	@Override
	public void increaseSpeed() {
		gw.increaseSpeed();
	}

	@Override
	public void init() {
		
	}

	@Override
	public void kill_NPS_Missile_PS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kill_NPS_PS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void killAsteroidAsteroid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void killAsteroidMissile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void killAsteroidNPS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void killAsteroidPS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void killMissileNPS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void launchMissile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void map() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reloadMissiles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnPSLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnPSMissileLauncherLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnPSMissileLauncherRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnPSRight() {
		// TODO Auto-generated method stub
		
	}

}
