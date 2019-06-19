package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class PointsView extends Container implements Observer {
	private Label scoreLabel;
	private Label livesLabel;
	private Label missilesLabel;
	private Label soundLabel;
	private Label timeLabel;
	
	public PointsView() {
		Label scoreTextLabel = new Label("Points: ");
		Label livesTextLabel = new Label("Lives: ");
		Label missilesTextLabel = new Label("Missiles: ");
		Label soundTextLabel = new Label("Sound: ");
		Label timeTextLabel = new Label("Time: ");
		
		scoreLabel = new Label("0");
		livesLabel = new Label("0");
		missilesLabel = new Label("0");
		soundLabel = new Label("on");
		timeLabel = new Label("0");
		
		scoreTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		
		Container myContainer = new Container();
		myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		myContainer.add(scoreTextLabel);
		myContainer.add(scoreLabel);
		myContainer.add(livesTextLabel);
		myContainer.add(livesLabel);
		myContainer.add(missilesTextLabel);
		myContainer.add(missilesLabel);
		myContainer.add(soundTextLabel);
		myContainer.add(soundLabel);
		myContainer.add(timeTextLabel);
		myContainer.add(timeLabel);
		
		this.add(myContainer);
	}
	
	
	@Override
	public void update(Observable observable, Object data) {
		IGameWorld gw = (IGameWorld) data;
		this.scoreLabel.setText(gw.getScore());
		this.livesLabel.setText(gw.getLives());
		this.missilesLabel.setText(gw.getMissiles());
		this.soundLabel.setText(gw.getSound());
		this.timeLabel.setText(gw.getTime());
		
		/*
		this.pointsValueLabel.setText(
			    "Score"  	+ gw.getScore() + 
				"\tLives" 	+ gw.getLives() +
				"\tMissiles"+ gw.getMissiles() +
				"\tSound"	+ " " +
				"\tTime"	+ gw.getTime()
				);
				*/
		this.repaint();
		System.out.println("In update - Pointsview");
	}
}