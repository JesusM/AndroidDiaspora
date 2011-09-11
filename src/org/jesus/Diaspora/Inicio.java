package org.jesus.Diaspora;

import org.jesus.Diaspora.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Inicio extends Activity {
	/** Called when the activity is first created. */
	SharedPreferences settings;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		settings = getSharedPreferences("org.jesus.diaspora.accounts",
				MODE_PRIVATE);
		String account = settings.getString("accountName", "defecto");
		if (account.equals("defecto")) {
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
							 * settings = getSharedPreferences(
							 * "entrada de datos", MODE_PRIVATE);
							 * SharedPreferences.Editor editor = settings
							 * .edit();
							 * 
							 * editor.putString("Contraseña", ((EditText)
							 * findViewById(R.id.user)) .getText().toString());
							 * editor.putString("Usuario",
							 * ((EditText)findViewById(R.
							 * id.pass)).getText().toString()); editor.commit();
							 * Intent in = ; startActivity(new
							 * Intent(Inicio.this, PantallaPrincipal.class));
							 * finish(); }
							 */
							RunAnimations();
							new CountDownTimer(5000, 1000) {

								public void onTick(long millisUntilFinished) {

								}

								public void onFinish() {

									SharedPreferences.Editor editor = settings
											.edit();

									editor.putString("accountName", "defecto");
									editor.commit();
									settings = getSharedPreferences(
											"org.jesus.Diaspora_preferences",
											MODE_PRIVATE);
									editor = settings.edit();
									editor.putString("aspecto", "all aspects");
									editor.commit();
									// startActivity(new Intent(Inicio.this,
									// PantallaPrincipal.class));
									startActivity(new Intent(Inicio.this,
											Dashboard.class));
									finish();
								}
							}.start();

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
		} else {
			startActivity(new Intent(Inicio.this, Dashboard.class));
			finish();
		}

	}

	private void RunAnimations() {
		Animation a = AnimationUtils.loadAnimation(this, R.anim.rotate);
		a.reset();
		ImageView tv = (ImageView) findViewById(R.id.asterisk_rotate);
		tv.clearAnimation();
		tv.startAnimation(a);

		// a = AnimationUtils.loadAnimation(this, R.anim.translate);
		// a.reset();
		// tv = (TextView) findViewById(R.id.secondTextView);
		// tv.clearAnimation();
		// tv.startAnimation(a);
		//	 
		// a = AnimationUtils.loadAnimation(this, R.anim.rotate);
		// a.reset();
		// tv = (TextView) findViewById(R.id.thirdTextView);
		// tv.clearAnimation();
		// tv.startAnimation(a);
	}
}