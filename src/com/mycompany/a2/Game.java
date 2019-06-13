package com.mycompany.a2;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class Game extends Form {
	private GameWorld gw;	
	
	public Game() {
		gw = GameWorld.getInstance();
		gw.init();
		play();
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