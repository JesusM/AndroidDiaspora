package org.jesus.Diaspora;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
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
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.conversation);
		loadInterface();

	}

	private void loadInterface() {
		// TODO Auto-generated method stub
		LinearLayout lP;
		lP = new LinearLayout(this);
		lP.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams p2;
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for (int i = 0; i < 5; i++) {
			View v = null;
			if (i % 2 == 0) {
				v = inflater.inflate(R.layout.message_element_received, null);
			} else {
				v = inflater.inflate(R.layout.message_element_sent, null);
			}
			
			LinearLayout rGris = new LinearLayout(this);
			rGris.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT, 2));
			rGris.setBackgroundColor(Color.GRAY);
			((LinearLayout) findViewById(R.id.rellenar)).addView(v);
			((LinearLayout) findViewById(R.id.rellenar)).addView(rGris);
		}
		// ((LinearLayout)
		// findViewById(R.id.rellenar)).setBackgroundColor(Color.BLUE);

	}
}
