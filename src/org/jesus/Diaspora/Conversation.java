package org.jesus.Diaspora;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class Conversation extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conversation);
		loadInterface();
		
		((TextView)findViewById(R.id.response)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				arg0.setFocusable(true);
				//((EditText)findViewById(R.id.respon)).setFocusable(true);
			}});
		((TextView)findViewById(R.id.erase)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				((LinearLayout) findViewById(R.id.rellenar)).removeAllViews();
			}});
	}

	private void loadInterface() {
		// TODO Auto-generated method stub				
		LinearLayout lP  ;
		lP = new LinearLayout(this);
		lP.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams p2;
		for (int i = 0; i < 5; i++) {
			lP = new LinearLayout(this);
			lP.setOrientation(LinearLayout.VERTICAL);
			p2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			lP = new LinearLayout(this);
			lP.setLayoutParams(p2);
			ImageView imag = new ImageView(this);
			imag.setLayoutParams(new LinearLayout.LayoutParams(45, 45));
			imag.setImageResource(R.drawable.custom_photo);
			lP.addView(imag);
			LinearLayout lSecun = new LinearLayout(this);
			lSecun.setLayoutParams(p2);
			lSecun.setOrientation(LinearLayout.VERTICAL);
			LinearLayout lter = new LinearLayout(this);
			lter.setLayoutParams(p2);
			TextView t1 = new TextView(this);
			TextView t2 = new TextView(this);
			t1.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT, (float) 1.0));
			t2.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT, (float) 1.0));
			t1.setText("Name User");
			t1.setTextColor(Color.BLACK);			
			t2.setText("yesterday");
			t2.setTextColor(Color.GRAY);
			t2.setGravity(Gravity.RIGHT);
			lter.addView(t1);
			lter.addView(t2);
			lSecun.addView(lter);
			lSecun.setPadding(6, 0, 6, 0);
			TextView edit = new TextView(this);
			edit.setLayoutParams(p2);
			edit.setText("This is an example of a user message");
			edit.setTextColor(Color.BLACK);
			lSecun.addView(edit);
			lP.addView(lSecun);
			lP.setPadding(5, 6, 5, 6);
			//lP.setBackgroundColor(Color.BLUE);
			LinearLayout rGris = new LinearLayout(this);
			rGris.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,2));
			rGris.setBackgroundColor(Color.GRAY);			
			((LinearLayout) findViewById(R.id.rellenar)).addView(lP);
			((LinearLayout) findViewById(R.id.rellenar)).addView(rGris);
		}
		//((LinearLayout) findViewById(R.id.rellenar)).setBackgroundColor(Color.BLUE);

	}
}
