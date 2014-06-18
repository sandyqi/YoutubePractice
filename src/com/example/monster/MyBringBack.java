package com.example.monster;
import android.content.Context;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.view.MotionEvent;
import android.view.View;
// could put MyBringBack into an Activity Class. setContentView(new MyBringBcik(this));
public class MyBringBack extends View{

	Bitmap gBall;
	Random r;
	Typeface font;
	float changingY,changingX,random=10,random2=20;
	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		gBall = BitmapFactory.decodeResource(getResources(), R.drawable.poorowl);
		changingY = 30;
		changingX = 30;
		font = Typeface.createFromAsset(context.getAssets(), "TropicDisco.ttf");
	}
/*
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int eaction = event.getAction();
		switch(eaction){
		case MotionEvent.ACTION_DOWN:
			this.updateDrawings();
			break;
		case MotionEvent.ACTION_MOVE:
			this.updateDrawings();
			break;
		case MotionEvent.ACTION_UP:
			//gBall.setPixel(30, 30, Color.GREEN);
			this.updateDrawings();
			break;
		}
		
		return true;
	}*/

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		
		
		// it is a kind of loop
		super.onDraw(canvas);
		
		canvas.drawColor(Color.GRAY);
		Paint textPaint = new Paint();
		textPaint.setAlpha(50);
		textPaint.setARGB(165, 234, 0, 22);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(100);
		textPaint.setTypeface(font);
		
		canvas.drawText("How are you?", canvas.getWidth()/2, canvas.getHeight()/2, textPaint);
		
		canvas.drawBitmap(gBall, changingX, changingY, null);
		
		if(changingY<canvas.getHeight() && changingX<canvas.getWidth()){
		
			changingY+=10;
			changingX+=5;
		}else if(changingY>=canvas.getHeight()){
		
			changingY =0;
		}else if(changingX>=canvas.getWidth()){
		
			changingX = 0;
		}
		//create a rectangle
		Rect rUp= new Rect(0, 50, canvas.getWidth(), 220);
		Rect rDown= new Rect(0, 400, canvas.getWidth(), 550);
		Rect rLeft = new Rect(350, 0, 500, canvas.getHeight());
		Rect rRight = new Rect(50, 0, 150,canvas.getHeight());
		
		Rect[] rects = {rUp,rDown,rLeft,rRight};
		// create a paint
		Paint setRandomColor = new Paint();
		
			setRandomColor.setColor(Color.BLUE);
		canvas.drawRect(rects[0], setRandomColor);
		
		invalidate();
		
	}

	
	
	
	
	

}
