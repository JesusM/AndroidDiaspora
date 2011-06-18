package org.jesus.Diaspora;

import java.util.ArrayList;
import java.util.List;

import org.jesus.Diaspora.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class VistaEscribir extends Activity implements OnCheckedChangeListener{
	/** Called when the activity is first created. */
	public List<String> servicios = new ArrayList<String>();
	public List<LinearLayout> lCheck = new ArrayList<LinearLayout>();
	public List<CheckBox> checks = new ArrayList<CheckBox>();
	int ind_check = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast.makeText(getBaseContext(), "example of write view",
				Toast.LENGTH_LONG).show();
		setContentView(R.layout.vista_escribir);
		servicios.add("twitter");
		servicios.add("facebook");
		generarInterfaz();
		((ImageView) findViewById(R.id.iconolista))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(VistaEscribir.this,
								ViewAspects.class));
						finish();
					}
				});
		((ImageView) findViewById(R.id.iconobusqueda))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(VistaEscribir.this,
								VistaBusqueda.class));
						finish();
					}
				});
		((CheckBox) findViewById(R.id.make_public))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {

						// TODO Auto-generated method stub
						if (arg1 == true) {
							((LinearLayout) findViewById(R.id.make_public_layout))
									.setBackgroundResource(R.drawable.my_border_white_open_all_selected);
						} else {
							((LinearLayout) findViewById(R.id.make_public_layout))
									.setBackgroundResource(R.drawable.my_border_white_open_all);
						}
					}
				});
		for (int i = 0; i < checks.size(); i++) {
			ind_check = i;
			checks.get(i).setOnCheckedChangeListener(this);				
		}
		((ImageView)findViewById(R.id.letrero)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(VistaEscribir.this,PantallaPrincipal.class));
				finish();
			}});
	}

	private void generarInterfaz() {
		// TODO Auto-generated method stub

		for (int i = 0; i < servicios.size(); i++) {
			CheckBox c1 = new CheckBox(this);
			LinearLayout l = new LinearLayout(this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			l.setLayoutParams(params);
			if (i == 0) {
				l
						.setBackgroundResource(R.drawable.my_border_white_open_bottom);
			} else if (i == servicios.size() - 1) {
				l.setBackgroundResource(R.drawable.my_border_white_open_top);
			} else {
				l.setBackgroundResource(R.drawable.my_border_white_not_open);
			}
			//l.setPadding(7, 0, 7, 0);
			//c1.setPadding(5, 5, 5, 5);
			c1.setLayoutParams(params);
			c1.setText(servicios.get(i));
			c1.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
			c1.setTextColor(Color.BLACK);
			lCheck.add(l);
			checks.add(c1);
			c1.setId(i);
			l.addView(c1);
			((LinearLayout) findViewById(R.id.layoutaAnadir)).addView(l);
		}

	}

	public void onBackPressed() {
		startActivity(new Intent(VistaEscribir.this, PantallaPrincipal.class));
		finish();
	}
	

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		if (arg0.getId() == 0) {
			if(arg1==true){
				lCheck
				.get(arg0.getId())
				.setBackgroundResource(
						R.drawable.my_border_edittext_open_bottom_selected);
			}else{
				lCheck
				.get(arg0.getId())
				.setBackgroundResource(
						R.drawable.my_border_edittext_open_bottom);
			}
		} else if (arg0.getId() == lCheck.size() - 1) {
			if(arg1==true){
				lCheck
				.get(arg0.getId())
				.setBackgroundResource(
						R.drawable.my_border_edittext_open_top_selected);
			}else{
				lCheck
				.get(arg0.getId())
				.setBackgroundResource(
						R.drawable.my_border_edittext_open_top);
			}
		} else {
			if(arg1==true){
				lCheck
				.get(arg0.getId())
				.setBackgroundResource(
						R.drawable.my_border_not_open_selected);
			}else{
				lCheck
				.get(arg0.getId())
				.setBackgroundResource(
						R.drawable.my_border_not_open);
			}
		}
	}

}
