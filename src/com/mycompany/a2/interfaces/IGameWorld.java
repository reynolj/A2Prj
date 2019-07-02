package com.mycompany.a2.interfaces;

import com.mycompany.a2.GameObjectCollection;

public interface IGameWorld {
	public GameObjectCollection getCollection();
	public String getScore();
	public String getMissiles();
	public String getLives();
	public String getTime();
	public String getSound();
	public void map();
	public void points();
}
