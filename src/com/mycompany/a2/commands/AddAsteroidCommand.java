package com.mycompany.a2.commands;

import com.codename1.ui.Command;

public class AddAsteroidCommand extends Command {

	private Gameworld gw;
	
	public AddAsteroidCommand(Gameworld gw) {
		super( "Add Asteroid");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}

}
