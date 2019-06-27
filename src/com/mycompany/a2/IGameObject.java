package com.mycompany.a2;

/**
 * Interface for GameObjects
 * Used to help keep constants out of our GameObject class.
 */
public interface IGameObject {
	public final int  	INIT_M_PS 	 = 	10, //	Number of Player missiles (default: 10)
			   		  	INIT_M_NPS 	 =   4,	//	Number of NPS missiles (default: 4)
			   		  	INIT_FUEL  	 = 	15,	//	Fuel of missiles (default: 15)
			   		  	INIT_SPEED_PS=	 0,	//	Initial Player speed (default: 0)
			   		  	INIT_DIR_PS  =	 0,	//	Initial Player direction (default: 0)
			   		  	SPEED_DELTA  =   2, //  Value for speed decrease/increase for PS (default 2)
			   		  	SPEED_MIS_PS =  15,	//	Speed increase of Player missiles (default: 10)
			   		  	SPEED_MIS_NPS=	15,	//	Speed increase of NPS missiles (default: 5)
			   		  	MAX_A_SIZE 	 =  30,	//	Maximum Asteroid size (default: 30)
			   		  	MIN_A_SIZE 	 =   6,	//	Minimum Asteroid size (default: 6)
			   		  	MIN_SPEED    =   0, //  Min Moveable object speed (default: 0)
			   		  	MAX_SPEED  	 =  20,	//	Max Moveable speed (default: 20)
			   		  	MAX_DIR	 	 = 359, //	Maximum direction in degrees (default: 359)
			   		  	MAX_RATE	 =   6, //	Maximum blink rate of SpaceStation (default: 6)
			   		  	NPS_SMALL  	 =  15, //	NPS SMALL size (default: 15)
			   		  	NPS_BIG	 	 =  25; //	NPS BIG size (default: 25)
	
	/*public final double 	MAX_X 	 = 1024.0,	//	Maximum X coordinate (default: 1024.0) 
							MAX_Y 	 =  768.0,	//	Maximum Y coordinate (default: 768.0)
						CENTER_X 	 =  512.0,	//	Center of game board X (default: 512.0)
						CENTER_Y 	 =  384.0;	//	Center of game board Y (default: 384.0)*/
	
}
