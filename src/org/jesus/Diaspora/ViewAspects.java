/**
 * 
 */
package org.jesus.Diaspora;

import java.util.ArrayList;
import java.util.List;

import org.jesus.Diaspora.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

/**
 * @author jesus
 * 
 */

public class ViewAspects extends Activity implements OnClickListener{
	private List<String> aspectos = new ArrayList<String>();
	public int ind;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.view_aspects);
		Toast.makeText(getBaseContext(), "example of view when we can see the notifications and the aspects", Toast.LENGTH_LONG).show();
		aspectos.add("Aspect 1");
		aspectos.add("Aspect 2");
		aspectos.add("Aspect 3");
		aspectos.add("Aspect 4");
		aspectos.add("Aspect 5");		
		if(((TextView)findViewById(R.id.number_of_notifications)).getText().toString().length()>1){
			//View v = ((View)this.getv)
			((TextView)findViewById(R.id.number_of_notifications)).setPadding(4, 2, 4, 2);
		}
		
		cargarInterfaz();
		// LinearLayout l = new LinearLayout(this);
		((ImageView) findViewById(R.id.iconobusqueda))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(ViewAspects.this,
								VistaBusqueda.class));
						finish();
					}
				});
		((RelativeLayout)findViewById(R.id.notify)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ViewAspects.this,ViewNotifications.class));
			}});
		((RelativeLayout)findViewById(R.id.inbox)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ViewAspects.this,ViewInbox.class));
			}});
		((ImageView)findViewById(R.id.letrero)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ViewAspects.this,PantallaPrincipal.class));
				finish();
			}});

	}

	private void cargarInterfaz() {
		// TODO Auto-generated method stub
		final List<RelativeLayout> list = new ArrayList<RelativeLayout>();
		for (int i = 0; i < aspectos.size(); i++) {

			ind = i;
			TextView t1;
			ImageView t2;
			t1 = new TextView(getBaseContext());
			t2 = new ImageView(getBaseContext());
			
			final RelativeLayout r = new RelativeLayout(getBaseContext());
			if (i == 0) {
				r
						.setBackgroundResource(R.drawable.my_border_edittext_open_bottom);
			} else if (i == aspectos.size() - 1) {
				r.setBackgroundResource(R.drawable.my_border_edittext_open_top);
			} else {
				r.setBackgroundResource(R.drawable.my_border_not_open);
			}

			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.FILL_PARENT);
			// params.setMargins(15, 0, 15, 0);
			r.setPadding(7, 7, 7, 7);
			r.setGravity(Gravity.CENTER);
			r.setLayoutParams(params);

			params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.WRAP_CONTENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
					RelativeLayout.TRUE);
			// params.setMargins(14, 14, 6, 14);
			params.addRule(RelativeLayout.CENTER_IN_PARENT);
			//params.setMargins(10, 10, 0, 6);
			
			t2.setPadding(5, 5, 5, 5);
			
			t2.setLayoutParams(params);
			
			
			// t2.setBackgroundResource(R.drawable.all_circle_notif);
			

			t2.setImageResource(R.drawable.arrow_right);
			//t2.setBackgroundResource(R.drawable.all_circle_notif);
			t2.setId(2);
			r.addView(t2);

			/*
			 * params = new RelativeLayout.LayoutParams(
			 * RelativeLayout.LayoutParams.WRAP_CONTENT,
			 * RelativeLayout.LayoutParams.WRAP_CONTENT); //
			 * params.addRule(RelativeLayout.RIGHT_OF, t1.getId());
			 * params.addRule(RelativeLayout.LEFT_OF, t2.getId());
			 * params.addRule(RelativeLayout.CENTER_IN_PARENT);
			 * t3.setTypeface(null, Typeface.BOLD);
			 * t3.setGravity(Gravity.CENTER); t3.setLayoutParams(params); if (i
			 * > 0) { t3.setTextColor(Color.parseColor("#2E9AFE")); }else{
			 * t3.setTextColor(Color.BLACK); } t3.setText(i + ""); t3.setId(1);
			 * t3.setBackgroundResource(R.drawable.circle_shape); r.addView(t3);
			 */

			params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			params.addRule(RelativeLayout.ALIGN_PARENT_LEFT,
					RelativeLayout.TRUE);
			// params.setMargins(14, 14, 6, 14);
			//params.setMargins(10, 10, 0, 6);
			//params.addRule(RelativeLayout.LEFT_OF, t3.getId());
			params.addRule(RelativeLayout.CENTER_IN_PARENT);
			t1.setPadding(0, 5, 0, 5);
			t1.setLayoutParams(params);
			t1.setText(aspectos.get(i));
			t1.setTextColor(Color.BLACK);

			t1.setTypeface(null, Typeface.BOLD);
			t1.setGravity(Gravity.LEFT);
			r.addView(t1);
			list.add(r);
			list.get(i).setId(i);
			list.get(i).setOnClickListener(this);
			((LinearLayout) findViewById(R.id.a)).addView(r);
			

		}

	}

	public void onBackPressed() {
		startActivity(new Intent(ViewAspects.this, PantallaPrincipal.class));
		finish();
	}



	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0.getId() == 0) {
			arg0
					.setBackgroundResource(R.drawable.my_border_edittext_open_bottom_selected);
		} else if (arg0.getId() == aspectos.size() - 1) {
			arg0
					.setBackgroundResource(R.drawable.my_border_edittext_open_top_selected);
		} else {
			arg0.setBackgroundResource(R.drawable.my_border_not_open_selected);
		}
		SharedPreferences settings = getSharedPreferences(
				"entrada de datos", MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();

		editor.putString("aspecto", aspectos.get(arg0.getId()));
		editor.commit();
		startActivity(new Intent(ViewAspects.this,
				PantallaPrincipal.class));
		finish();
	}
}
