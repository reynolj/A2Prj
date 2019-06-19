package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border;

import java.util.Observable;
import java.util.Observer;

public class MapView extends Container implements Observer {
	
	
	public MapView() {
		Container myView = new Container();
		myView.getAllStyles().setPadding(Component.BOTTOM,384);
		myView.getAllStyles().setPadding(Component.TOP,384);
		myView.getAllStyles().setPadding(Component.LEFT,512);
		myView.getAllStyles().setPadding(Component.RIGHT,512);
		myView.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.BLACK));
	
		this.add(myView);
	}
	@Override
	public void update(Observable observable, Object data) {
		IGameWorld gw = (IGameWorld) data;
		gw.map();
		this.repaint();
		//System.out.println("In update - Pointsview");
		
	}
}
