package com.example.monster;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
//passing data between activities.

public class Camera extends Activity implements OnClickListener{
Button set;
ImageButton take;
ImageView pic;
Intent i;
Bitmap bmp;
final static int cameraData = 0;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initial();
	}
	public void initial(){
		set = (Button)findViewById(R.id.photoSetWall);
		take = (ImageButton)findViewById(R.id.photoTakePicture);
		pic = (ImageView)findViewById(R.id.photoPic);
		set.setOnClickListener(this);
		take.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.photoSetWall:
			try {
				getApplicationContext().setWallpaper(bmp);  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case R.id.photoTakePicture:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);  //point to the android phone's basic action
			startActivityForResult(i,cameraData);  // a number. 
			
			break;
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK){
			Bundle extras = data.getExtras();   //backside of email stuff (putExtras)
			bmp = (Bitmap)extras.get("data");
			pic.setImageBitmap(bmp);
		}
	
	}
	

}
