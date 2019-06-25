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
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.commands.*;

public class Game extends Form {
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
		
		//Form definition
		this.setLayout(new BorderLayout());
		
		//Create a Toolbar
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		
		// Create a Toolbar Title
		Label myTitleLabel = new Label("CSc133 A2Prj");
		myToolbar.setTitleComponent(myTitleLabel);
		
		//Side menu
		Label menuHeaderLabel = new Label("File");
		//menuHeaderLabel.setTextPosition(Component.CENTER);
		menuHeaderLabel.getAllStyles().setFgColor(ColorUtil.WHITE);
		myToolbar.addComponentToSideMenu(menuHeaderLabel);
		
		// Sidemenu Sound Command Checkbox
		SoundCommand setSound = new SoundCommand(gw);
		CheckBox checkSoundOn = new CheckBox("Sound On");
		checkSoundOn.getAllStyles().setBgTransparency(255);
		checkSoundOn.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		checkSoundOn.getAllStyles().setFgColor(ColorUtil.WHITE);
		//set "SideComponent" property of the command object to the check box
		setSound.putClientProperty("Sound On", checkSoundOn);
		checkSoundOn.setSelected(true);
		checkSoundOn.setCommand(setSound);
		
		AboutCommand myAbout	 = new AboutCommand(gw);
		NewCommand myNew	 	 = new NewCommand(gw);
		SaveCommand mySave	 	 = new SaveCommand(gw);
		UndoCommand myUndo  	 = new UndoCommand(gw);
		QuitCommand sideMenuQuit = new QuitCommand(gw);
		
		// Add commands to Sidemenu
		myToolbar.addCommandToSideMenu(myNew);
		myToolbar.addCommandToSideMenu(mySave);
		myToolbar.addCommandToSideMenu(myUndo);
		myToolbar.addComponentToSideMenu(checkSoundOn);		// Sound checkbox
		myToolbar.addCommandToSideMenu(myAbout);
		myToolbar.addCommandToSideMenu(sideMenuQuit);		// Quit command
		
		
		//Create some buttons to put in the West Side
		Button addAsteroid		= 		new Button("Add Asteroid");
		Button addNPS			= 		new Button("Add Enemy Ship");
		Button addSpaceStation	=	 	new Button("Add Space Station");
		Button addPlayerShip	=		new Button("Add Player Ship");
		Button fireMissile		=		new Button("Fire Player Missile");
		Button jump				=		new Button("Jump To Hyperspace");
		//Add aesthetics below
		addAsteroid.getAllStyles().setBgColor(ColorUtil.BLUE);
		addAsteroid.getAllStyles().setBgTransparency(128);
		addAsteroid.getAllStyles().setFgColor(ColorUtil.WHITE);
		addAsteroid.getAllStyles().setBorder(Border.createBevelRaised());
		addAsteroid.getAllStyles().setBorder(Border.createBevelLowered());
		
		addNPS.getAllStyles().setBgColor(ColorUtil.BLUE);
		addNPS.getAllStyles().setBgTransparency(128);
		addNPS.getAllStyles().setFgColor(ColorUtil.WHITE);
		addNPS.getAllStyles().setBorder(Border.createBevelRaised());
		addNPS.getAllStyles().setBorder(Border.createBevelLowered());
		
		addSpaceStation.getAllStyles().setBgColor(ColorUtil.BLUE);
		addSpaceStation.getAllStyles().setBgTransparency(128);
		addSpaceStation.getAllStyles().setFgColor(ColorUtil.WHITE);
		addSpaceStation.getAllStyles().setBorder(Border.createBevelRaised());
		addSpaceStation.getAllStyles().setBorder(Border.createBevelLowered());
		
		addPlayerShip.getAllStyles().setBgColor(ColorUtil.BLUE);
		addPlayerShip.getAllStyles().setBgTransparency(128);
		addPlayerShip.getAllStyles().setFgColor(ColorUtil.WHITE);
		addPlayerShip.getAllStyles().setBorder(Border.createBevelRaised());
		addPlayerShip.getAllStyles().setBorder(Border.createBevelLowered());
		
		fireMissile.getAllStyles().setBgColor(ColorUtil.BLUE);
		fireMissile.getAllStyles().setBgTransparency(128);
		fireMissile.getAllStyles().setFgColor(ColorUtil.WHITE);
		fireMissile.getAllStyles().setBorder(Border.createBevelRaised());
		fireMissile.getAllStyles().setBorder(Border.createBevelLowered());
		
		jump.getAllStyles().setBgColor(ColorUtil.BLUE);
		jump.getAllStyles().setBgTransparency(128);
		jump.getAllStyles().setFgColor(ColorUtil.WHITE);
		jump.getAllStyles().setBorder(Border.createBevelRaised());
		jump.getAllStyles().setBorder(Border.createBevelLowered());
		
		/////////////////////////
		// BorderLayout
		// North: PlayerView
		// West: Controls (command buttons)
		// Center: MapView
		// East and South are unused.
		
		//North
		//
		//Container exists inside PointView
		
		//West
		Container westContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		westContainer.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.BLACK));
		Label commandLabel = new Label("Commands");
		commandLabel.getAllStyles().setAlignment(CENTER);
		westContainer.add(commandLabel);
		
		westContainer.add(addAsteroid);
		westContainer.add(addNPS);
		westContainer.add(addSpaceStation);
		westContainer.add(addPlayerShip);
		westContainer.add(fireMissile);
		westContainer.add(jump);
		
		//Center
		//
		//Container exists inside MapView
		
		this.add(BorderLayout.NORTH,pv);
		this.add(BorderLayout.WEST,westContainer);
		this.add(BorderLayout.CENTER,mv);
		
		this.show();
		
		//ALL COMMANDS
		//Control Panel Buttons
		AddAsteroidCommand myaddAsteroid = new AddAsteroidCommand(gw);
		addAsteroid.setCommand( myaddAsteroid );
		
		AddNPSCommand myaddNPS = new AddNPSCommand(gw);
		addNPS.setCommand(myaddNPS);
		
		AddSpaceStationCommand myaddST = new AddSpaceStationCommand(gw);
		addSpaceStation.setCommand(myaddST);
		
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
		
		QuitCommand myQuit = new QuitCommand(gw);
		addKeyListener('Q', myQuit);
		
	}

}