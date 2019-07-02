package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class NPS_Shoots_PS_Command extends Command {
	private GameWorld gw;
	
	/**
	 * Constructor
	 * @param gw GameWorld object
	 */
	public NPS_Shoots_PS_Command(GameWorld gw) {
		super("Kill PS with NPS Missile");
		this.gw = gw;
	}
	
	/**
	 * Override action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.NPS_Shoots_PS();
	}
}