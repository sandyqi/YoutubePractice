package com.example.monster;

import android.app.Activity;
import android.os.Bundle;

public class SurfacePractice extends Activity{
	SurfacePracticeSurface surface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		surface = new SurfacePracticeSurface(this);
		setContentView(surface);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		surface.resume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		surface.pause();
	}

	
}
