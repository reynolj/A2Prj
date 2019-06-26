package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.plaf.Border;

import java.util.Observable;
import java.util.Observer;

public class MapView extends Container implements Observer {
	
	
	public MapView() {
		Container myView = new Container();
		myView.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.BLACK));
	
		this.add(myView);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
	}
	
	@Override
	public void update(Observable observable, Object data) {
		IGameWorld gw = (IGameWorld) data;
		gw.map();
		this.repaint();
	}
}
