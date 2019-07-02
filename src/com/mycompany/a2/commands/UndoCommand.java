package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class UndoCommand extends Command {
	private GameWorld gw;

	/**
	 * Constructor
	 * @param gw GameWorld object
	 */
	public UndoCommand(GameWorld gw) {
		super("Undo");
		this.gw = gw;
	}
	
	/**
	 * Override action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.undo();
	}
}