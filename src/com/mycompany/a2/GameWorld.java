package com.mycompany.a2;

import java.util.Observable;
import java.util.Vector;

/**
 * Defines a GameWorld Object.
 */
public class GameWorld extends Observable implements IGameWorld{	
	private final int   INIT_LIVES = 3,
		  				SCORE_A	   = 100,
		  				SCORE_NPS  = 300;
	
	private static GameWorld gw = null;
	
	private Vector<GameObject> store = new Vector<GameObject>();
	private int playerScore, playerLives, clock;

	
	private GameWorld() {}
	
	/**
	 * Creates a new singleton instance of GameWorld if none exists.
	 * @return GameWorld Object
	 */
	public static GameWorld getInstance() {
		if (gw == null)
			gw = new GameWorld();
		return gw;
	}
	
	/**
	 * Initializes game statistics: Score, Lives and Clock
	 */
	public void init() {
		playerScore = 0;
		playerLives = INIT_LIVES;
		clock = 0;
	}

/******************************** Commands for Second Delivery **************************/ 	
	/**
	 * Command 'a'
	 * Creates a new Asteroid object in the GameWorld. Adds it to the GameObject vector
	 */
	public void addNewAsteroid() {
		Asteroid asteroid = new Asteroid();
		store.add(asteroid);
		//Display
		System.out.println("- ADD ASTEROID");
		System.out.println("A new asteroid has spawned.");
		System.out.println( asteroid + "\n");
	}
	
	/**
	 * Command 'y'
	 * Creates a new NonPlayerShip object in the GameWorld. Adds it to the GameObject vector
	 */
	public void addNonPlayerShip() {
		NonPlayerShip NPS = new NonPlayerShip();
		store.add(NPS);
		//Display
		System.out.println("- ADD NPS");
		System.out.println("An enemy ship has spawned.");
		System.out.println( NPS + "\n");
	}  
	
	/**
	 * Command 'b'
	 * Creates a new SpaceStation object in the GameWorld. Adds it to the GameObject vector
	 */
	public void addSpaceStation() {
		SpaceStation BSS = new SpaceStation();
		store.add(BSS);
		//Display
		System.out.println("- ADD BLINKING SPACE STATION");
		System.out.println("A blinking space station has spawned");
		System.out.println("ID = " + BSS.getID());
		System.out.println( BSS + "\n" );
	}
	
	/**
	 * Command 's'
	 * Creates a new singleton PlayerShip object in the GameWorld. Adds it to the GameObject vector
	 */
	public void addPlayerShip() {
		System.out.println("- ADD PS");
		
		if (PlayerShip.isMissing() == true) {
			PlayerShip PS = PlayerShip.getInstance();
			store.add(PS);
			System.out.println("Your ship has spawned.");
			System.out.println( PS );
		}
		else {
			System.out.println("ERROR: Only one player ship allowed at one time.");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'f'
	 * Creates a new Player Missile object in the GameWorld only if the Player Ship exists and 
	 * the Player Ship has remaining missiles. Adds it to GameObject vector
	 */
	public void fireMissile() {
		System.out.println("- FIRE MISSILE");
		
		if ( PlayerShip.isMissing() != true ) {
			if ( PlayerShip.getInstance().getMissiles() > 0 ) { 
				Missile missile = new Missile((Ship) PlayerShip.getInstance());
				store.add(missile);
				PlayerShip.getInstance().decrementMissileCount();
				System.out.println("The player ship has fired a missile");
				System.out.println(missile);
			}
			else {
				System.out.println("ERROR: Missiles depleted.");
			}
		}
		else {
			System.out.println("ERROR: No ship to shoot missile.");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'L'
	 * Creates a new NonPlayer Missile object in the GameWorld. Adds it to the GameObject vector
	 * Only creates NonPlayer missile if a NonPlayerShip exists in the GameWorld
	 * and if the NonPlayerShip has missiles left in it's inventory.
	 */
	public void launchMissile() {
		NonPlayerShip NPS = null;
		
		System.out.println("- LAUNCH NPS MISSILE");
		
		for (GameObject i : store) {			
			if (i instanceof NonPlayerShip) {
				NPS = (NonPlayerShip) i;
				if ( ((NonPlayerShip) i).getMissiles() > 0 ) {
					break;
				}
			}
		}
		
		if ( NPS != null) {
			if ( NPS.getMissiles() > 0 ) { 
				Missile missile = new Missile((Ship) NPS);
				store.add(missile);
				NPS.decrementMissileCount();
				System.out.println("The enemy ship has fired a missile");
				System.out.println(missile);
			}
			else {
				System.out.println("ERROR: Missiles depleted.");
			}
		}
		else {
			System.out.println("ERROR: No existing enemy ship.");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'm'
	 * Outputs GameObject information such as location, direction, speed and number of missiles remaining.
	 */
	public void map() {
		String toPrint = "- MAP\n";
		
		if (store.isEmpty()) {
			toPrint += "Game World is devoid of Game objects and happiness. The player wept.\n";
		}
		else {
			for (GameObject i : store) {
				toPrint += i.toString() +"\n";
			}
		}
		
		System.out.print(toPrint);
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'p'
	 * Prints out the game stats (score, missile count, game time and lives left).
	 */
	public void displayStats() {
		String missiles = "";
		System.out.println("- PRINT GAME STATS");
		
		if ( PlayerShip.isMissing() != true ){
			missiles += String.valueOf(PlayerShip.getInstance().getMissiles());
		}
		else {
			missiles += "N/A";
		}
		
		System.out.println(
			"Player Score: " + playerScore + "\n" +
			"PS Missile Count: " + missiles + "\n" +
			"Game time: " + clock + "\n" +
			"Remaining lives: " + playerLives
		);
		System.out.println(); //for readability
	}

/******************************** Commands for Third Delivery **************************/
	
	/**	
	 *  Helper Function for Commands: 'e', 'c', 'h'
	 * Removes a life from the player ship. Ends the game if no lives are left.
	 * Resets the location of the player ship to the center of the game board.
	 */
	private void killPS() {
		if ( --playerLives != 0 ) {
			System.out.println("Player Lives: " + playerLives);
			for (GameObject i : store) {
				if (i instanceof PlayerShip) {
					store.remove(i);
					PlayerShip.deleteShip();
					this.addPlayerShip();
					break;
				}
			}
			//PlayerShip.getInstance().resetPlayerShip();
		} else {
			gameOver();
		}
	}
	
	/**
	 * Helper function for killPS
	 * Displays game stats (score, missile count, time) and removes player ship from the GameObject vector.
	 * Prints "Game Over"
	 */
	private void gameOver() {
		displayStats();
		for (GameObject i : store)
		{
			if (i instanceof PlayerShip)
			{
				store.remove(i);
				PlayerShip.deleteShip();
				break;
			}
		}
		System.out.println("Game Over!");
	}

	/**
	 * Command '<'
	 * Turns the player's missile launcher to the left only if a PlayerShip exists in the GameObject vector
	 * Displays an error if a PlayerShip does not exist. 
	 */
	public void turnPSMissileLauncherLeft() {
		System.out.println("- TURN MISSILE LAUNCHER LEFT");
		
		if (PlayerShip.isMissing() != true) {
			PlayerShip.getInstance().turnLauncherLeft();
			System.out.println("Player Missile Launcher turned Left. New direction: " 
			                    + PlayerShip.getInstance().getLauncherDirection());
		}
		else {
			System.out.println("ERROR: Cannot turn missile launcher. Player ship does not exist!");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command '>'
	 * Turns the player's missile launcher to the right only if a PlayerShip exists in the GameObject vector
	 * Displays an error if a PlayerShip does not exist. 
	 */
	public void turnPSMissileLauncherRight() {
		System.out.println("- TURN MISSILE LAUNCHER RIGHT");
		
		if (PlayerShip.isMissing() != true) {
			PlayerShip.getInstance().turnLauncherRight();
			System.out.println("Player Missile Launcher turned right. New direction: " 
			                    + PlayerShip.getInstance().getLauncherDirection());
		}
		else {
			System.out.println("ERROR: Cannot turn missile launcher. Player ship does not exist!");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'n'
	 * Reloads a PlayerShip with it's maximum amount of missiles.
	 * Prints an error if a PlayerShip does not exist in the GameObject vector
	 * Note: Proximity preconditions not yet implemented
	 */
	public void reloadMissiles() {
		boolean spaceStationExist = false;
		System.out.println("- RELOAD MISSILES");
		for (GameObject i : store) {
			if (i instanceof SpaceStation) {
				spaceStationExist = true;
				break;
			}
		}
		if (!spaceStationExist) {
			System.out.println("ERROR: No space station in Game World");
		}
		if (PlayerShip.isMissing()) {
			System.out.println("ERROR: No player ship in Game World");
		}
		if (PlayerShip.isMissing() != true && spaceStationExist) {
			PlayerShip.getInstance().reloadMissiles();
			System.out.println("The player ship's missile supply has been restored to maximum.\n" + PlayerShip.getInstance() );
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'k'
	 * Kills an Asteroid by a Player Missile. Removes both from the GameObject vector. 
	 * Increases the player's score.
	 * Verifies that both exist before doing so.
	 * Note: Proximity preconditions not yet implemented
	 */
	public void killAsteroidMissile() {
		Asteroid asteroid = null;
		Missile missile = null;
		
		System.out.println("- PLAYER KILLS ASTEROID");
		
		for (GameObject i : store) {
			if (i instanceof Asteroid) {
				asteroid = (Asteroid) i;
				break;
			}
		}
		
		if (asteroid == null) {
			System.out.println("ERROR: No asteroid in Game World.");
		}
		
		for (GameObject i : store) {
			if (i instanceof Missile) {
				missile = (Missile) i;
				if ( missile.getOwner() instanceof PlayerShip ) {
					break;
				}
			}
		}
		
		if (missile == null || !(missile.getOwner() instanceof PlayerShip)) {
			System.out.println("ERROR: No missile belonging to player ship in Game World.");
		}
		
		if (missile == null || asteroid == null) {
			//Do nothing
		} else {
			playerScore += SCORE_A;
			store.removeElement(asteroid);
			store.removeElement(missile);
			System.out.println("A player ship's missile has killed an asteroid.\nPlayer Score: " + playerScore);
		}
		System.out.println(); //for readability
		
	}
	
	/**
	 * Command 'e'
	 * Kills a NonPlayerShip with a Player Missile only if a NonPlayerShip and a Player Missile exists
	 * in the GameObject vector.
	 * Increases the Player Score.
	 * Note: Proximity preconditions not yet implemented
	 */
	public void killMissileNPS() {
		NonPlayerShip NPS = null;
		Missile missile = null;
		
		System.out.println("- PS KILLED NPS");
		
		for (GameObject i : store) {
			if (i instanceof NonPlayerShip) {
				NPS = (NonPlayerShip)i;
				break;
			}
		}
		
		if (NPS == null) {
			System.out.println("ERROR: No enemy ship in Game World.");
		}
		
		for (GameObject i : store) {
			if (i instanceof Missile) {
				if ( ((Missile) i).getOwner() instanceof PlayerShip ) {
					missile = (Missile) i;
					break;
				}
			}
		}
		
		if (missile == null) {
			System.out.println("ERROR: No missile belonging to player ship in Game World.");
		}
		
		if (missile == null || NPS == null) {
			//Do nothing
		} else {
			playerScore += SCORE_NPS;
			store.removeElement(NPS);
			store.removeElement(missile);
			System.out.println("A player ship's missile has killed an enemy ship.\nPlayer Score: " + playerScore);
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'E'
	 * Kills a PlayerShip with a NonPlayer Missile.
	 * Checks to make sure a PlayerShip and NonPlayer Missile exist before doing so.
	 * Removes a life from Player. Ends Game if the Player has no more lives left.
	 * Note: Proximity preconditions not yet implemented
	 */
	public void kill_NPS_Missile_PS () {
		Missile NPSmissile = null;
		PlayerShip PS = null;
		
		System.out.println("- A NPS KILLED PS");
		
		if (PlayerShip.isMissing() != true) {
			PS = PlayerShip.getInstance();
		}
		else {
			System.out.println("ERROR: No player ship in Game World.");
		}
		
		for (GameObject i : store) {
			if (i instanceof Missile) {
				if ( ((Missile) i).getOwner() instanceof NonPlayerShip ) {
					NPSmissile = (Missile) i;
					break;
				}
			}
		}
		
		if (NPSmissile == null) {
			System.out.println("ERROR: No missile belonging to enemy ship in Game World.");
		}
			
		
		if (NPSmissile == null || PS == null) {
			//Do nothing
		} else {
			store.removeElement(NPSmissile);
			System.out.println ("An enemy ship's missile has killed the player ship.");
			killPS();
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'c'
	 * Kills a PlayerShip with an Asteroid. Checks to make sure both exist in the GameObject vector first.
	 * If both exists it removes the Asteroid from the GameWorld, resets the PlayerShip's location to the center
	 * of the game board and removes a life.
	 * Note: Proximity preconditions not yet implemented
	 */
	public void killAsteroidPS() {
		Asteroid asteroid = null;
		PlayerShip PS = null;
		
		System.out.println("- PS CRASHED INTO ASTEROID");
		
		for (GameObject i : store) {
			if (i instanceof Asteroid) {
				asteroid = (Asteroid) i;
				break;
			}
		}
		
		if (asteroid == null) {
			System.out.println("ERROR: No asteroid in Game World.");
		}
		
		if (PlayerShip.isMissing() != true) {
			PS = PlayerShip.getInstance();
		}else{
			System.out.println("ERROR: No player ship in Game World.");
		}
		
		if (asteroid == null || PS == null) {
			//Do nothing
		} else {
			store.removeElement(asteroid);
			System.out.println("An asteroid has collided with the player ship, killing each other");
			killPS();
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'h'
	 * Kills a NonPlayerShip and PlayerShip due to them striking each other. Checks first to insure they
	 * both exist in the GameObject vector. Removes the NonPlayerShip from the game board.
	 * Resets PlayerShip's location and removes a life.
	 * Note: Proximity preconditions not yet implemented
	 */
	public void kill_NPS_PS() {
		PlayerShip PS = null;
		NonPlayerShip NPS = null;
		
		System.out.println("- PS CRASHED INTO NPS");
		
		for (GameObject i : store){
			if (i instanceof NonPlayerShip) {
				NPS = (NonPlayerShip) i;
				break;
			}
		}
		
		if (NPS == null) {
			System.out.println("ERROR: No enemy ship in Game World.");
		}
		
		if (PlayerShip.isMissing() != true) {
			PS = PlayerShip.getInstance();
		}else{
			System.out.println("ERROR: No player ship in Game World.");
		}
		
		if (NPS == null || PS == null) {
			//Do nothing
		} else {
			store.removeElement(NPS);
			System.out.println("An enemy ship has collided with the player ship, killing each other.");
			killPS();
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'x'
	 * Kills two asteroids due to them striking each other. Checks to make sure two asteroids exist in
	 * the GameObject vector before doing so. Removes both asteroids from the game board.
	 * Note: Proximity preconditions not yet implemented
	 */
	public void killAsteroidAsteroid() {
		Asteroid asteroid1 = null;
		Asteroid asteroid2 = null;
		
		System.out.println("- TWO ASTEROIDS COLLIDED");
		
		for (GameObject i : store) {
			if (i instanceof Asteroid) {
				if ( asteroid1 == null) {
					asteroid1 = (Asteroid) i;
				}
				else if (asteroid2 == null) {
					asteroid2 = (Asteroid) i;
					break;
				}
			}
		}
		
		if (asteroid1 == null ) { 
			System.out.println("ERROR: No asteroids exist in Game World.");
		}
		else if ( asteroid2 == null ) {
			System.out.println("ERROR: Only one asteroid exists in Game World.");
		}
		
		if (asteroid1 == null || asteroid2 == null) {
			//Do nothing
		} else {
			store.removeElement(asteroid1);
			store.removeElement(asteroid2);
			System.out.println("Two asteroids have collided and killed each other.");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'I' 
	 * Kills an Asteroid and NonPlayerShip due to them striking each other. Checks to make sure both exist
	 * in the GameObject vector first. Removes both from the game board.
	 * Note: Proximity preconditions not yet implemented
	 */
	public void killAsteroidNPS() {
		Asteroid asteroid = null;
		NonPlayerShip NPS = null;

		System.out.println("- ASTEROID COLLIDED WITH NPS");
		
		for (GameObject i : store){
			if (i instanceof Asteroid) {
				asteroid = (Asteroid) i;
				break;
			}
		}
		
		if (asteroid == null) {
			System.out.println("ERROR: No asteroid in Game World.");
		}
		
		for (GameObject i : store){
			if (i instanceof NonPlayerShip) {
				NPS = (NonPlayerShip) i;
				break;
			}
		}
		
		if (NPS == null) {
			System.out.println("ERROR: No enemy ship in Game World.");
		}
		
		if (NPS == null || asteroid == null) {
			//Do nothing
		} else {
			store.removeElement(asteroid);
			store.removeElement(NPS);
			System.out.println("An enemy ship has colided with an asteroid, killing each other.\n");
		}
		System.out.println(); //for readability
	}
	
	/******************************** Commands for Fourth Delivery **************************/
	/**
	 * Command 'i'
	 * If PlayerShip exists and speed increase will not exceed maximum, its speed will increase
	 */
	public void increaseSpeed() {
		System.out.println("- INCREASE SPEED");
		
		if (PlayerShip.isMissing() != true) {
			if (PlayerShip.getInstance().increaseSpeed() == true) {
				System.out.println("The PlayerShip speed has increased to: " + 
									PlayerShip.getInstance().getSpeed());
			} else {
				System.out.println("ERROR: The PlayerShip speed cannot go above the maximum!, speed is: " + 
						PlayerShip.getInstance().getSpeed());
			}
		} else {
			System.out.println("ERROR: No player ship in Game World.");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'd'
	 * If PlayerShip exists and speed increase will not exceed maximum, its speed will decrease
	 */
	public void decreaseSpeed() {
		System.out.println("- DECREASE SPEED");
		
		if (PlayerShip.isMissing() != true) {
			if (PlayerShip.getInstance().decreaseSpeed() == true) {
				System.out.println("The PlayerShip speed has decreased to: " + 
									PlayerShip.getInstance().getSpeed());
			} else {
				System.out.println("ERROR: The PlayerShip speed cannot go below the minimum!, speed is: " + 
						PlayerShip.getInstance().getSpeed());
			}
		} else {
			System.out.println("ERROR: No player ship in Game World.");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'l'
	 */
	public void turnPSLeft() {
		System.out.println("- TURN PS LEFT");
		
		if (PlayerShip.isMissing() != true) {
			PlayerShip.getInstance().turnLeft();
			System.out.println("The PlayerShip has turned, direction is now: " +
			                    PlayerShip.getInstance().getDirection());
		} else {
			System.out.println("ERROR: No player ship in Game World.");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'r'
	 */
	public void turnPSRight() {
		System.out.println("- TURN PS RIGHT");
		
		if (PlayerShip.isMissing() != true) {
			PlayerShip.getInstance().turnRight();
			System.out.println("The PlayerShip has turned, direction is now: " +
			                    PlayerShip.getInstance().getDirection());
		} else {
			System.out.println("ERROR: No player ship in Game World.");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 'j'
	 */
	public void hyperSpaceJump() {
		System.out.println("- JUMP PS TO HYPER SPACE");
		
		if (PlayerShip.isMissing() != true) {
			PlayerShip.getInstance().jump();
			System.out.println("The PlayerShip has jumped to hyperspace:\n" +
			                    PlayerShip.getInstance());
		} else {
			System.out.println("ERROR: No player ship in Game World.");
		}
		System.out.println(); //for readability
	}
	
	/**
	 * Command 't'
	 * Ticks the game forward one turn.
	 * Moves all objects.
	 * Removes missiles with depleted fuel.
	 */
	public void tick() {
		System.out.println("- TICK");
		// "tick" the clock
		++clock;
		
		// We need another Vector to hold GameObjects that must be removed at the same time.
		// We can't remove GameObjects inside of the foreach loop because it throws exceptions.
		Vector<GameObject> removeItems = new Vector<GameObject>();
		// Move all the MoveableObjects
		for (GameObject i : store) {
			if (i instanceof IMoveable) {
				((IMoveable) i).move();
				
				// If the MoveableObject is a Missile and it has run out of fuel,
				// add it to the removeItems Vector for disposal outside of the loop.
				if (i instanceof Missile && ((Missile) i).getFuel() <= 0) {
					removeItems.add(i);
				}
			}
			// Blink the SpaceStation if the proper amount of time has elapsed
			else if (i instanceof SpaceStation) {
				int blinkRate = ((SpaceStation) i).getBlinkRate();
				if (blinkRate != 0 && clock % blinkRate == 0) {
					((SpaceStation) i).toggleLight();
				}
			}
		}
		// Remove all the GameObjects that needed to be removed all at once.
		store.removeAll(removeItems);
		// Empty out our temporary GameObject Vector.
		removeItems.clear();
		
		System.out.println("Game clock: " + clock);
		System.out.println(); //for readability
	}
}