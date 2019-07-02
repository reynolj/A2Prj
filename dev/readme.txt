CSC 133: Assignment 1
Jake Reynolds & Samuel Hendryx 

readme explaining additions and changes to given specifications.

------------------------------------------------------------------
Sound
------------------------------------------------------------------
1. ISound:
This interface contains all the sound variables.
GameObject and Game implement this ISound.

2. Extra Sounds
Asteroid exploding
PlayerShip exploding
NPS exploding
Jumping to hyperspace
NPS fire missile

3. Game Over sound
When the game ends the background music pauses, then the game over
sound plays.

------------------------------------------------------------------
Commands
------------------------------------------------------------------
1. Pause Command 
This command is only partially implemented and it wasn't required
in the first place. We implemented this so we could pause the 
game and still view the screen.
Pause/Unpause and Sound On/Off works as expected.
Pause/Unpause and using other commands is not advised.

------------------------------------------------------------------
MapView
------------------------------------------------------------------
1. We painted the MapView white instead of no color
2. Invokes 'm' command to print to console

------------------------------------------------------------------
PointView
------------------------------------------------------------------
1. Invokes 'p' command to print to console

