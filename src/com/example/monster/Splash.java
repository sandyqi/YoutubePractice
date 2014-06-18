package com.example.monster;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{
//MediaPlayer backSong;
	@Override
	protected void onCreate(Bundle Hero) {    //THREADS from one thread to another
		// TODO Auto-generated method stub
		super.onCreate(Hero);
		setContentView(R.layout.splash); //first thread is splash
		MediaPlayer backSong  = MediaPlayer.create(Splash.this,R.raw.horse);
		//backSong.start();
		 // set the java with the layout!
	//	backSong.start();
		Thread timer = new Thread(){
			@Override
			public void run(){
				try{
					sleep(3000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMa = new Intent("com.monster.sandy.MENU");//action's name
					startActivity(openMa);   // use Intent to activate the activity. it is corresponding with 
				//	MediaPlayer	backSong = MediaPlayer.create(Splash.this, R.raw.xiangge);
				//	backSong.start();
				}							// <intent-filter> in manifest
			}
		}; 
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//backSong.release();
		finish();
	}
	

}
