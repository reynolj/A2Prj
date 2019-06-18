package com.mycompany.a2;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.a2.commands.*;

public class Game extends Form {
	private GameWorld gw;	
	
	public Game() {
		gw = GameWorld.getInstance();
		gw.init();
		
		
		//TODO: add aesthetics
		Button addAsteroid		= 		new Button("Add Asteroid");
		Button addNPS			= 		new Button("Add Enemy Ship");
		Button addSpaceStation	=	 	new Button("Add Space Station");
		Button addPlayerShip	=		new Button("Add Player Ship");
		Button fireMissile		=		new Button("Fire Player Missile");
		Button jump				=		new Button("Jump To Hyperspace");
		//Add aesthetics below
		
		
		//ALL COMMANDS
		//Control Panel Buttons
		AddAsteroidCommand myaddAsteroid = new AddAsteroidCommand(gw);
		addAsteroid.setCommand( myaddAsteroid );
		
		AddNPSCommand myaddNPS = new AddNPSCommand(gw);
		addNPS.setCommand(myaddNPS);
		
		AddSpaceStationCommand myaddST = new AddSpaceStationCommand(gw);
		addNPS.setCommand(myaddST);
		
		AddPlayerShipCommand myaddPS = new AddPlayerShipCommand(gw);
		addPlayerShip.setCommand(myaddPS);
		
		FirePSMissileCommand myFireMissile = new FirePSMissileCommand(gw);
		fireMissile.setCommand(myFireMissile);
		addKeyListener(-90, myFireMissile); //spacebar
		
		JumpToHyperspaceCommand myJump = new JumpToHyperspaceCommand(gw);
		jump.setCommand(myJump);
		addKeyListener('j', myJump);
		
		//Key bindings
		IncreasePSSpeedCommand myIncrease = new IncreasePSSpeedCommand(gw);
		addKeyListener('i', myIncrease);
		addKeyListener(-91, myIncrease); //up arrow
		
		DecreasePSSpeedCommand myDecrease = new DecreasePSSpeedCommand(gw);
		addKeyListener('d', myDecrease);
		addKeyListener(-92, myDecrease); //down arrow
		
		TurnPSLeftCommand myTurnLeft = new TurnPSLeftCommand(gw);
		addKeyListener('l', myTurnLeft);
		addKeyListener(-93, myTurnLeft); //left arrow
		
		TurnPSRightCommand myTurnRight = new TurnPSRightCommand(gw);
		addKeyListener('r', myTurnRight);
		addKeyListener(-94, myTurnRight); //right arrow
		
		TurnLauncherLeftCommand myTurnLauncherLeft = new TurnLauncherLeftCommand(gw);
		addKeyListener(44, myTurnLauncherLeft);
		
		TurnLauncherRightCommand myTurnLauncherRight = new TurnLauncherRightCommand(gw);
		addKeyListener(46, myTurnLauncherRight);
		
		LaunchNPSMissileCommand myLaunchMissile = new LaunchNPSMissileCommand(gw);
		addKeyListener('L', myLaunchMissile);
		
		ReloadCommand myReload = new ReloadCommand(gw);
		addKeyListener('n', myReload);
		
		KillAsteroidMissileCommand myKAM = new KillAsteroidMissileCommand(gw);
		addKeyListener('k', myKAM);
		
		KillMissileNPS myKMN = new KillMissileNPS(gw);
		addKeyListener('e', myKMN);
		
		Kill_NPS_Missile_PSCommand myKNMP = new Kill_NPS_Missile_PSCommand(gw);
		addKeyListener('E', myKNMP);
		
		KillAsteroidPSCommand myKAP = new KillAsteroidPSCommand(gw);
		addKeyListener('c', myKAP);
		
		Kill_NPS_PSCommand myKNP = new Kill_NPS_PSCommand(gw);
		addKeyListener('h', myKNP);
		
		KillAsteroidAsteroidCommand myKAA = new KillAsteroidAsteroidCommand(gw);
		addKeyListener('x', myKAA);
		
		KillAsteroidNPSCommand myKAN = new KillAsteroidNPSCommand(gw);
		addKeyListener('I', myKAN);
		
		TickCommand myTick = new TickCommand(gw);
		addKeyListener('t', myTick);
		
		QuitCommand myQuit = new QuitCommand(gw);
		addKeyListener('Q', myQuit);
		
		//Side menu
		/*
		 * AboutCommand myAbout = new AboutCommand(gw);
		 * SoundCommand mySound = new SoundCommand(gw);
		 * NewCommand myNew = new NewCommand(gw);
		 * SaveCommand mySave = new SaveCommand(gw);
		 * UndoCommand myUndo = new UndoCommand(gw);
		 */
		//
		play();
		//getCommand();
	}
	
	/**
	 * Initiate play
	 */
	private void play()
	{
		Label myLabel=new Label("Enter a Command:"); 
		this.addComponent(myLabel);
		final TextField myTextField = new TextField(); 
		this.addComponent(myTextField);
		this.show();
		// Test input as long as something has been input
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String sCommand=myTextField.getText().toString(); myTextField.clear();
				if (!sCommand.isEmpty()) {
					switch (sCommand.charAt(0)){ 
					case 'a' :
						gw.addNewAsteroid();
						break;
					case 'b':
						gw.addSpaceStation();
						break;
					case 'c':
						gw.killAsteroidPS();
						break;	
					case 'd':
						gw.decreaseSpeed();
						break;
					case 'e':
						gw.killMissileNPS();
						break;	
					case 'f':
						gw.fireMissile();
						break;	
					case 'h':
						gw.kill_NPS_PS();
						break;	
					case 'i':
						gw.increaseSpeed();
						break;
					case 'j':
						gw.hyperSpaceJump();
						break;
					case 'k':
						gw.killAsteroidMissile();
						break;	
					case 'l':
						gw.turnPSLeft();
						break;
					case 'm':
						gw.map();
						break;
					case 'n':
						gw.reloadMissiles();
						break;
					case 'p':
						gw.displayStats();
						break;	
					case 'q':
						break;
					case 'r':
						gw.turnPSRight();
						break;
					case 's':
						gw.addPlayerShip();
						break;	
					case 't':
						gw.tick();
						break;
					case 'x':
						gw.killAsteroidAsteroid();
						break;
					case 'y':
						gw.addNonPlayerShip();
						break;
					case 'E':
						gw.kill_NPS_Missile_PS();
						break;	
					case 'I':
						gw.killAsteroidNPS();
						break;	
					case 'L':
						gw.launchMissile();
						break;
					case '<':
						gw.turnPSMissileLauncherLeft();
						break;
					case '>':
						gw.turnPSMissileLauncherRight();
						break;
					default:
						System.out.println();
						System.out.println("Error: " + sCommand.charAt(0) + " is not a command.");
						break;
					}	
				}
				
			}
		});
	}
}