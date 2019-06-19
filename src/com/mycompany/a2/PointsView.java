package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class PointsView extends Container implements Observer {
	private Label pointsValueLabel;
	
	public PointsView() {
		Label pointsTextLabel = new Label("Points:");
		
		pointsValueLabel = new Label("empty");
		
		pointsTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		
		Container myContainer = new Container();
		myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		myContainer.add(pointsTextLabel);
		this.add(myContainer);
	}
	
	
	@Override
	public void update(Observable observable, Object data) {
		IGameWorld gw = (IGameWorld) data;
		this.pointsValueLabel.setText(
			    "Score"  	+ gw.getScore() + 
				"\tLives" 	+ gw.getLives() +
				"\tMissiles"+ gw.getMissiles() +
				"\tSound"	+ " " +
				"\tTime"	+ gw.getTime()
				);
		this.repaint();
		System.out.println("In update - Pointsview");
	}
}