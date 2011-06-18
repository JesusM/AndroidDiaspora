package org.jesus.Diaspora;

import org.jesus.Diaspora.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class VistaBusqueda extends Activity{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vista_busqueda);	
		Toast.makeText(getBaseContext(), "example of search view", Toast.LENGTH_LONG).show();
		((ImageView) findViewById(R.id.iconolista))
		.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(VistaBusqueda.this,
						ViewAspects.class));
				finish();
			}
		});
		((ImageView)findViewById(R.id.letrero)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(VistaBusqueda.this,PantallaPrincipal.class));
				finish();
			}});
	}
	public void onBackPressed(){
		startActivity(new Intent(VistaBusqueda.this,PantallaPrincipal.class));
		finish();
	}
}
