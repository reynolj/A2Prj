package com.mycompany.a2;

public class Missile extends MoveableGameObject{
	private int fuelLevel;
	private Ship owner;
	
	/**
	 * Missile constructor
	 * Creates a missile with the location, direction and speed inherited from it's ship's missile launcher
	 * It also contains an object of it's owner so we can tell what ship fired the missile.
	 * @param _owner Ship object used to identify NPS vs PS.
	 */
	public Missile(Ship _owner) {
		super();
		this.fuelLevel = INIT_FUEL;
		this.owner = _owner;
		this.setLocation(owner.getLocation().getX(), this.owner.getLocation().getY());
		this.setDirection( owner instanceof PlayerShip ? PlayerShip.getInstance().getLauncherDirection() : owner.getDirection() );
		this.setSpeed(owner.getSpeed() +
					   (owner instanceof PlayerShip ? INIT_M_PS : INIT_M_NPS)
					  );
		this.setColor(owner.getColor());
	}
	
	/**
	 * Returns the amount of fuel left in the missile. Used for removing 'spent' missiles from the game board.
	 * @return remaining fuel
	 */
	public int getFuel() {
		return this.fuelLevel;
	}

	/**
	 * toString override method
	 */
	public String toString() {
		String parentDesc = super.toString();
		String localDesc = " fuel = " + this.fuelLevel;
		String header = "";
		
		if (this.owner instanceof PlayerShip)
		{
			header += "PS's Missile: ";
		}
		else
		{
			header += "NPS's Missile: ";
		}
		
		return header + parentDesc + localDesc;
	}
	
	/**
	 * Returns owner of missile. Useful for determining who's missile struck an item
	 * @return owner (Ship object)
	 */
	public Ship getOwner() {
		return this.owner;
	}
	
	/**
	 * Decrements or 'uses' a unit of fuel. Used for every tick of movement of a Missile.
	 * An optional unit of fuel-use could be distance traveled.
	 */
	public void useFuel() {
		this.fuelLevel--;
	}
	
}