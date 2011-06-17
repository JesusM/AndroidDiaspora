package org.jesus.Diaspora;

import org.jesus.Diaspora.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inicio extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		((Button) findViewById(R.id.Entrar))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						/*
						 * if (!((EditText)
						 * findViewById(R.id.user)).getText().toString()
						 * .equals("") &&
						 * !((EditText)findViewById(R.id.pass)).getText
						 * ().toString().equals("")) { SharedPreferences
						 * settings = getSharedPreferences( "entrada de datos",
						 * MODE_PRIVATE); SharedPreferences.Editor editor =
						 * settings .edit();
						 * 
						 * editor.putString("Contraseña", ((EditText)
						 * findViewById(R.id.user)) .getText().toString());
						 * editor.putString("Usuario",
						 * ((EditText)findViewById(R.
						 * id.pass)).getText().toString()); editor.commit();
						 * Intent in = ; startActivity(new Intent(Inicio.this,
						 * PantallaPrincipal.class)); finish(); }
						 */
						SharedPreferences settings = getSharedPreferences(
								"entrada de datos", MODE_PRIVATE);
						SharedPreferences.Editor editor = settings.edit();

						editor.putString("aspecto", "all aspects");
						editor.commit();

						startActivity(new Intent(Inicio.this,
								PantallaPrincipal.class));

					}
				});
		((TextView) findViewById(R.id.cartel2))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(Inicio.this,
								VistaRecuperarContrasena.class));
					}
				});
	}
}