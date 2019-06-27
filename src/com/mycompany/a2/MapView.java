package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import com.codename1.ui.plaf.Border;

import java.util.Observable;
import java.util.Observer;

public class MapView extends Container implements Observer {
	private GameObjectCollection store = null;
	
	public MapView() {
		Container myView = new Container();
		myView.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.BLACK));
	
		this.add(myView);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(ColorUtil.WHITE);
		g.fillRect(getX(), getY(), GameWorld.getWidth(), GameWorld.getHeight());
		Point2D pCmpRelPrnt = new Point2D(getX(), getY());
		if (store !=null) {
			if ( !store.isEmpty() ) {
				for ( IIterator i = store.getIterator(); i.hasNext(); ) {
					GameObject o = (GameObject) i.next();
					o.draw(g, pCmpRelPrnt);
				}
			}
		}		
	}
	
	@Override
	public void update(Observable observable, Object data) {
		IGameWorld gw = (IGameWorld) data;
		store = gw.getCollection();
		gw.map();
		this.repaint();
	}
}
