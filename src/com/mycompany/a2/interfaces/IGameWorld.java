package com.mycompany.a2.interfaces;

import com.mycompany.a2.GameObjectCollection;

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
