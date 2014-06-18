package com.example.monster;

import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main111 extends ActionBarActivity {
	int counter;
	Button add,sub,clear;
	TextView display;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main111);
		MediaPlayer	backSong = MediaPlayer.create(Main111.this, R.raw.xiangge);
		backSong.start();
		counter = 0;
		add = (Button)findViewById(R.id.Addone);
		sub = (Button)findViewById(R.id.Subone);
		clear = (Button)findViewById(R.id.Clear);
		display = (TextView)findViewById(R.id.score);
		
		clear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				counter =0;
				// TODO Auto-generated method stub
				
			}
		});
		
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				counter++;
				if(counter==1){
					display.setText("Miss u "+ "1 time");
				}
				else{
					display.setText("Miss u "+ counter+ " times");
				}
			
				// TODO Auto-generated method stub
				
			}
		});
		
		sub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				counter--;
				if(counter==1){
					display.setText("Miss u "+ "1 time");
				}
				else{
					display.setText("Miss u "+ counter+ " times");
				}
				// TODO Auto-generated method stub
				
			}
		});
		
	
	}

}
