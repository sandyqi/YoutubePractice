package com.example.monster;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfacePracticeSurface extends SurfaceView implements Runnable {
	Thread thread= null;
	SurfaceHolder holder;
	boolean isRunning;
	Bitmap image;
	Typeface font;

	public SurfacePracticeSurface(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		holder = getHolder();
		image = BitmapFactory.decodeResource(getResources(),
				R.drawable.tuyapcicon_20);
		font = Typeface.createFromAsset(context.getAssets(), "Animated.ttf");
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			if (!holder.getSurface().isValid()) {
				continue;
			}
			Canvas canvas = holder.lockCanvas();
			canvas.drawARGB(44, 223, 244, 13);
			Paint paint = new Paint();
			paint.setTypeface(font);
			paint.setARGB(33,111, 11, 222);
			paint.setTextAlign(Align.CENTER);
			paint.setTextSize(50);
			canvas.drawText("This is from SurfaceView", canvas.getWidth() / 2,
					canvas.getHeight() / 2, paint);
			canvas.drawBitmap(image, canvas.getWidth()/4, canvas.getHeight()/4, null);
			
			holder.unlockCanvasAndPost(canvas);
		}
	}

	public void pause() {
		isRunning = false;
		while (true) {
			try {
				thread.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		thread = null;
	}

	public void resume() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

}
