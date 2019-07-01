package com.mycompany.a2.sound;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class SoundEffect {
	private Media m;
	
	public SoundEffect(String fileName) {
		try{
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), 
			"/"+fileName);
			//attach a runnable to run when media has finished playing 
			//as the last parameter
			m = MediaManager.createMedia(is, "audio/mpeg");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void play() {
		//start playing the sound from time zero (beginning of the sound file)
		m.setTime(0); 
		m.play();
	}

}
