package com.mycompany.a2;

public interface ISound {
	public final BackgroundMusic bg = new BackgroundMusic("BloodSport.mp3");
	public final SoundEffect psLaser = new SoundEffect("Laser1.mp3");
	public final SoundEffect npsLaser = new SoundEffect("Laser2.mp3");
	public final SoundEffect hyperSpace = new SoundEffect("HyperSpace.mp3");
	public final SoundEffect asteroidExplode = new SoundEffect("Explosion1.mp3");
	public final SoundEffect npsExplode = new SoundEffect("Explosion2.mp3");
	public final SoundEffect psExplode = new SoundEffect("Explosion3.mp3");
	public final SoundEffect gameOver = new SoundEffect("GameOver.mp3");
	
}
