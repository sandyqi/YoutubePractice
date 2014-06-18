package com.example.monster;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener{
Button ckB;     // if declare a variable in this field, I do not need to use key word
ToggleButton passTog; // final inside a inner class. 
EditText input;
TextView display;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		baconAndEgg();
		
		passTog.setOnClickListener(this);
		
		ckB.setOnClickListener(this);

	}
	private void baconAndEgg() {
		ckB = (Button)findViewById(R.id.bResults);
		passTog = (ToggleButton)findViewById(R.id.tbPassword);// password is with ToggleButton
		input = (EditText)findViewById(R.id.etCommands);
		display = (TextView)findViewById(R.id.tvCommands);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onClick(View v) { // when implements View.onClickListener, we can do this
		switch(v.getId()){  // it is similar with Java
		case R.id.bResults :
			String check = input.getText().toString();  //assign string value to check
			display.setText(check);
			Random crazy = new Random();
			if(check.contentEquals("left")){
			display.setGravity(Gravity.LEFT);	// if we want to set gravity,
			}else if(check.contentEquals("center")){// we should make sure there is a gravity in text.xml of EditText(input)
				display.setGravity(Gravity.CENTER);				
			}else if(check.contentEquals("right")){
				display.setGravity(Gravity.RIGHT);
			}else if (check.contentEquals("blue")){
				display.setTextColor(Color.BLUE);
	//			display.setBackgroundColor(Color.YELLOW);
			}else if(check.contains("WTF")){				
				display.setText("WTF!!!");
				display.setTextSize(crazy.nextInt(75));
				display.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(265)));  // int int int, mix three int, then get a color
				switch(crazy.nextInt(3)){  // generate 0,1,2
				case 0: display.setGravity(Gravity.LEFT);	
					break;
				case 1:display.setGravity(Gravity.RIGHT);
					break;
				case 2:display.setGravity(Gravity.CENTER);	
					break;
				}
			}else{
				display.setText("invalid");
				display.setGravity(Gravity.CENTER);
				display.setTextColor(Color.RED);
				display.setTextSize(50);
						}
			break;
		case R.id.tbPassword:
			if(passTog.isChecked()){ // set final-- passTog
				input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); // the type will hide the password
				                        // if it is on, the code starts. 
			}else{// if it is off, else starts
				input.setInputType(InputType.TYPE_CLASS_TEXT);  // the type will show the password
			}
			break;
			
		}
		// TODO Auto-generated method stub
		
	}

}
