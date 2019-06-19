package com.mycompany.a2;

public interface IGameWorld {
	void addNewAsteroid();
	void addNonPlayerShip();
	void addPlayerShip();
	void addSpaceStation();
	void decreaseSpeed();
	String displayStats();
	void fireMissile();
	void hyperSpaceJump();
	void increaseSpeed();
	void init();
	void kill_NPS_Missile_PS();
	void kill_NPS_PS();
	void killAsteroidAsteroid();
	void killAsteroidMissile();
	void killAsteroidNPS();
	void killAsteroidPS();
	void killMissileNPS();
	void launchMissile();
	void map();
	void quit();
	void reloadMissiles();
	void tick();
	void turnPSLeft();
	void turnPSMissileLauncherLeft();
	void turnPSMissileLauncherRight();
	void turnPSRight();
}
