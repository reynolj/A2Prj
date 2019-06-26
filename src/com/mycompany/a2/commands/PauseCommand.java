package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.Game;
import com.mycompany.a2.GameWorld;
import com.codename1.ui.Button;

public class PauseCommand extends Command {
	private Game g;
	private GameWorld gw;
	private final boolean ON = true;
	private final boolean OFF = false;
	
	public PauseCommand(Game g, GameWorld gw) {
		super("Pause");
		this.g = g;
		this.gw = gw;
	}

	public void actionPerformed(ActionEvent e) {
		boolean timer_status = gw.getTimerStatus();
		
		if ( timer_status == ON ) {
			g.stopTimer();
			gw.setTimerStatus(OFF);
			((Button) e.getActualComponent()).setText("Unpause");
		} else {
			g.resumeTimer();
			gw.setTimerStatus(ON);
			((Button) e.getActualComponent()).setText("Pause");
		}
	}
}
