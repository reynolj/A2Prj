package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PS_Shoots_NPS_Command extends Command {
private GameWorld gw;
	
	/**
	 * Constructor
	 * @param gw GameWorld object
	 */
	public PS_Shoots_NPS_Command(GameWorld gw) {
		super("Kill NPS with PS Missile");
		this.gw = gw;
	}
	
	/**
	 * Override action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.PS_Shoots_NPS();
	}
}