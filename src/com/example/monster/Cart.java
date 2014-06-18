package com.example.monster;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class Cart extends Activity implements View.OnClickListener{
Button add, sub, add2, submit, cancel;
TextView title, product, input1, input2;
EditText num;		int count =0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cart);
		initialize();
		add.setOnClickListener(this);
		sub.setOnClickListener(this);
		add2.setOnClickListener(this);
		//submit.setOnClickListener(this);
		//cancel.setOnClickListener(this);
	
	}
	
	public void initialize(){
		add = (Button)findViewById(R.id.cartAdd);
		sub = (Button)findViewById(R.id.cartSub);
		add2= (Button)findViewById(R.id.cartADD);
	    submit= (Button)findViewById(R.id.cartSubmit);
		cancel = (Button)findViewById(R.id.cartCancel);
		title = (TextView)findViewById(R.id.cartTittle);
		product = (TextView)findViewById(R.id.cartSelectedProduct);
	    input2 = (TextView)findViewById(R.id.cartInputNumber);
		input1 = (TextView)findViewById(R.id.cartInputNumberAuto);
		num = (EditText)findViewById(R.id.cartInputEditNumber); 
		
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()){
		case R.id.cartAdd: 
			count++;input1.setText("buy "+count);
			Toast.makeText(getApplicationContext(),"Add "+count,Toast.LENGTH_LONG).show();
			break;
		case R.id.cartSub: 
			if(count>0){count--;
			input1.setText("buy "+count);
			Toast.makeText(getApplicationContext(),"Sub "+count,Toast.LENGTH_LONG).show();}
			else{break;}
			break;
		case R.id.cartADD:  
				 			
				count=Integer.parseInt(num.getText().toString());
				input1.setText("buy "+count); // should be string, int does not work
				Toast.makeText(getApplicationContext(),"Add "+count,Toast.LENGTH_LONG).show();
				
			break;
		
		}
		
		// TODO Auto-generated method stub
		
	}

}
