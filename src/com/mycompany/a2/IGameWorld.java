package com.mycompany.a2;

public interface IGameWorld {
	GameObjectCollection getCollection();
	String getScore();
	String getMissiles();
	String getLives();
	String getTime();
	String getSound();
	void map();
	void points();
}
