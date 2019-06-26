package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.mycompany.a2.commands.*;

public class Game extends Form implements Runnable{
	private GameWorld gw;	
	private MapView mv;
	private PointsView pv;
	
	public Game() {
		gw = GameWorld.getInstance();
		gw.init();
		pv = new PointsView();
		mv = new MapView();
		gw.addObserver(pv);
		gw.addObserver(mv);

		this.setLayout(new BorderLayout());
		
		//*************************Toolbar***********************************************//
		
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		Label myTitleLabel = new Label("CSc133 A2Prj");
		myToolbar.setTitleComponent(myTitleLabel);
		
		//*************************End of Toolbar***************************************//
		
		//**************************Side menu*******************************************//
		
		Label menuHeaderLabel = new Label("File");
		myToolbar.addComponentToSideMenu(menuHeaderLabel);
		menuHeaderLabel.getAllStyles().setFgColor(ColorUtil.WHITE);

		// Add commands to Sidemenu, appear in order on gui as written below
		
		// New command
		NewCommand myNew = new NewCommand(gw);
		myToolbar.addCommandToSideMenu(myNew);
		
		// Save Command
		SaveCommand mySave = new SaveCommand(gw);
		myToolbar.addCommandToSideMenu(mySave);
		
		// Undo Command
		UndoCommand myUndo = new UndoCommand(gw);
		myToolbar.addCommandToSideMenu(myUndo);
		
		//Sound on Command
		SoundCommand setSound = new SoundCommand(gw);
		CheckBox checkSoundOn = new CheckBox("Sound On");
		setSound.putClientProperty("Sound On", checkSoundOn);
		checkSoundOn.setSelected(true);
		checkSoundOn.setCommand(setSound);
		
		//Sound Checkbox Aesthetics
		checkSoundOn.getAllStyles().setBgTransparency(255);
		checkSoundOn.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		checkSoundOn.getAllStyles().setFgColor(ColorUtil.WHITE);
		myToolbar.addComponentToSideMenu(checkSoundOn);		
		
		//About Command
		AboutCommand myAbout = new AboutCommand(gw);
		myToolbar.addCommandToSideMenu(myAbout);
		
		//Quit Command
		QuitCommand sideMenuQuit = new QuitCommand(gw);
		myToolbar.addCommandToSideMenu(sideMenuQuit);		
		QuitCommand myQuit = new QuitCommand(gw);
		addKeyListener('Q', myQuit);
		
		//*********************************End of Side Menu*************************************//
		
		//*********************************West Container (buttons)*****************************//
		
		Container westContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		westContainer.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.BLACK));
		Label commandLabel = new Label("Commands");
		commandLabel.getAllStyles().setAlignment(CENTER);
		westContainer.add(commandLabel);

		// Add buttons with commands to West Container, appear in order on gui as written below
		// Add asteroid
		Button addAsteroid = new Button("Add Asteroid");
		setButton(addAsteroid);
		AddAsteroidCommand myaddAsteroid = new AddAsteroidCommand(gw);
		addAsteroid.setCommand( myaddAsteroid );
		westContainer.add(addAsteroid);
		
		// Add NPS
		Button addNPS = new Button("Add Enemy Ship");
		setButton(addNPS);
		AddNPSCommand myaddNPS = new AddNPSCommand(gw);
		addNPS.setCommand(myaddNPS);
		westContainer.add(addNPS);
		
		// Add Space Station
		Button addSpaceStation = new Button("Add Space Station");
		setButton(addSpaceStation);
		AddSpaceStationCommand myaddST = new AddSpaceStationCommand(gw);
		addSpaceStation.setCommand(myaddST);
		westContainer.add(addSpaceStation);

		//Add Player Ship
		Button addPlayerShip = new Button("Add Player Ship");
		setButton(addPlayerShip);
		AddPlayerShipCommand myaddPS = new AddPlayerShipCommand(gw);
		addPlayerShip.setCommand(myaddPS);
		westContainer.add(addPlayerShip);
		
		// Fire Missile
		Button fireMissile = new Button("Fire Player Missile");
		setButton(fireMissile);
		FirePSMissileCommand myFireMissile = new FirePSMissileCommand(gw);
		fireMissile.setCommand(myFireMissile);
		addKeyListener(-90, myFireMissile); //spacebar
		westContainer.add(fireMissile);
		
		// Hyperspace Jump
		Button jump	= new Button("Jump To Hyperspace");
		setButton(jump);
		JumpToHyperspaceCommand myJump = new JumpToHyperspaceCommand(gw);
		jump.setCommand(myJump);
		addKeyListener('j', myJump);
		westContainer.add(jump);
		
		//****************************End of West Container*********************************//
		
		//****************************Commands with only KeyListeners***********************//
		
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
		
		PS_Shoots_Asteroid_Command myKAM = new PS_Shoots_Asteroid_Command(gw);
		addKeyListener('k', myKAM);
		
		PS_Shoots_NPS_Command myKMN = new PS_Shoots_NPS_Command(gw);
		addKeyListener('e', myKMN);
		
		NPS_Shoots_PS_Command myKNMP = new NPS_Shoots_PS_Command(gw);
		addKeyListener('E', myKNMP);
		
		Collision_Asteroid_PS_Command myKAP = new Collision_Asteroid_PS_Command(gw);
		addKeyListener('c', myKAP);
		
		Collision_NPS_PS_Command myKNP = new Collision_NPS_PS_Command(gw);
		addKeyListener('h', myKNP);
		
		Collision_Asteroid_Asteroid_Command myKAA = new Collision_Asteroid_Asteroid_Command(gw);
		addKeyListener('x', myKAA);
		
		Collision_Asteroid_NPS_Command myKAN = new Collision_Asteroid_NPS_Command(gw);
		addKeyListener('I', myKAN);
		
		TickCommand myTick = new TickCommand(gw);
		addKeyListener('t', myTick);
		
		//****************************End of Commands with only KeyListeners******************//
		
		this.add(BorderLayout.NORTH,pv);
		this.add(BorderLayout.CENTER,mv);
		this.add(BorderLayout.WEST,westContainer);
		
		//create timer and provide a runnable (which is this form)
		UITimer timer = new UITimer(this);
		//make the timer tick every second and bind it to this form
		timer.schedule(1000, true, this);
		
		this.show();
		
		gw.setWidth(mv.getWidth());
		gw.setHeight(mv.getHeight());
	}
	
	private void setButton(Button button) {
		button.getAllStyles().setBgColor(ColorUtil.BLUE);
		button.getAllStyles().setBgTransparency(128);
		button.getAllStyles().setFgColor(ColorUtil.WHITE);
		button.getAllStyles().setBorder(Border.createBevelRaised());
		button.getAllStyles().setBorder(Border.createBevelLowered());
	}

	@Override
	public void run() {
		gw.tick();
		System.out.println("Map Width: " + gw.getWidth() + " Height: " + gw.getHeight());
		
	}
}