package com.example.monster;

import android.app.Activity;
import android.os.Bundle;

public class GFXSurface extends Activity {
	// extend surface view. separate thread. avoid doing both user interface and graphic stuff at the same time
	
	MyBringBackSurface ourSurfaceView; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ourSurfaceView = new MyBringBackSurface(this);
		setContentView(ourSurfaceView);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}
	
	
}
