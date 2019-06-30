package com.mycompany.a2;

public interface IGameWorld {
	public final SoundEffect psLaser = new SoundEffect("Laser1.mp3");
	public final SoundEffect npsLaser = new SoundEffect("Laser2.mp3");
	
	GameObjectCollection getCollection();
	String getScore();
	String getMissiles();
	String getLives();
	String getTime();
	String getSound();
	void map();
	void points();
}
