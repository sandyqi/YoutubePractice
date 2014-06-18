package com.example.monster;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyBringBackSurface extends SurfaceView implements Runnable{
	SurfaceHolder ourHolder; // manage surfaces
	Thread ourThread = null;
	boolean isRunning = true;
	public MyBringBackSurface(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		ourHolder = getHolder(); // 1 tell us if the surface is valid. 2 allow to lock the canvas so that no one can touch it

	}

	public void pause(){
		isRunning = false;
		while(true){
			try {
				ourThread.join(); //block the thread until the receiver dies
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		ourThread = null; // every time We need to create a new thread by calling resume();
	}
	
	public void resume(){
		isRunning = true;
		ourThread = new Thread(this);
		ourThread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning){
			if(!ourHolder.getSurface().isValid()){
				continue;}
			Canvas canvas = ourHolder.lockCanvas();
			canvas.drawRGB( 234, 44, 111);
			ourHolder.unlockCanvasAndPost(canvas);
		}
	}

}
