package com.example.monster;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{

	String[] classes = {"Main  111","Splash","TextPlay","Sandy","Email","Cart","Camera","GFX","ImageButton","GFXSurface"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_expandable_list_item_1,classes));  //0 is equal to blalalalala; means single elements. some constant
	}      //set button, when click the string, call onListItemClick // cont est    int  can be 0                                        string[]
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String cheese = classes[position];
		try{
		Class ourClass = Class.forName("com.example.monster."+cheese);
		Intent ourIntent = new Intent(Menu.this,ourClass);  // BY Class to find the responding activity
		startActivity(ourIntent);
		
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			
		}
		
	}

	

}
