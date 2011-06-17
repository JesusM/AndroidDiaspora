package org.jesus.Diaspora;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
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

public class ViewInbox extends Activity implements OnClickListener{
	List<List<Notify>> inbox = new ArrayList<List<Notify>>();
	List<LinearLayout> list = new ArrayList<LinearLayout>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inbox);
		Toast.makeText(getBaseContext(), "example of the inbox view",
				Toast.LENGTH_LONG).show();
		// load the simulated notifications
		loadSimulatedNotifys();

		loadInterface();
		((Button)findViewById(R.id.new_message)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ViewInbox.this,NewMessage.class));
				finish();
			}});
		((ImageView)findViewById(R.id.letrero)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ViewInbox.this,PantallaPrincipal.class));
				finish();
			}});

	}

	private void loadInterface() {
		// TODO Auto-generated method stub

		for (int i = 0; i < inbox.size(); i++) {
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			LinearLayout lprincipal = new LinearLayout(this);
			lprincipal.setOrientation(LinearLayout.VERTICAL);
			// params.setMargins(0, 0, 0, 20);
			// lprincipal.setPadding(0, 0, 0, 10);
			lprincipal.setLayoutParams(params);
			LinearLayout ldate = new LinearLayout(this);
			params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.WRAP_CONTENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			ldate.setLayoutParams(new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT));

			// lprin.addView(ldate);
			// TextView day = new TextView(this);
			TextView month = new TextView(this);
			params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.WRAP_CONTENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			// day.setLayoutParams(params);
			month.setLayoutParams(params);

			month.setText("12 May");
			month.setTextSize((float) 15.0);
			month.setPadding(7, 2, 7, 3);
			month.setTextColor(Color.BLACK);

			month.setGravity(Gravity.CENTER);

			// month.setBackgroundResource(R.drawable.square_notification);
			month.setTypeface(null, Typeface.BOLD);
			ldate.addView(month);
			ldate.setPadding(0, 0, 0, 7);
			lprincipal.addView(ldate);

			rellenarNotificacion(inbox.get(i));
			for(int j =0;j<list.size();j++){
				list.get(j).setOnClickListener(this);
			}
				
			

			/*((LinearLayout) findViewById(R.id.layout_notif_a_rellenar))
					.addView(lprincipal);*/
		}

	}

	private void rellenarNotificacion(List<Notify> notifications2
			) {
		// TODO Auto-generated method stub
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout p = new LinearLayout(this);
		p.setLayoutParams(params);
		p.setOrientation(LinearLayout.VERTICAL);
		p.setBackgroundColor(Color.BLUE);
		LinearLayout lPrincipal;

		for (int i = 0; i < notifications2.size(); i++) {
			lPrincipal = new LinearLayout(this);
			lPrincipal.setOrientation(LinearLayout.HORIZONTAL);
			lPrincipal.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT));
			LinearLayout lSecundario = new LinearLayout(this);

			ImageView image = new ImageView(this);
			
			image.setImageResource(R.drawable.photo);
			TextView nombreU = new TextView(this);
			TextView asuntoU = new TextView(this);
			TextView whenU = new TextView(this);
			TextView numberOfMessagesU = new TextView(this);
			LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
			/**
			 * Aplicamos un tamaño a la imagen
			 */
			LinearLayout lImage = new LinearLayout(this);
			lImage.setLayoutParams(new LinearLayout.LayoutParams(45, 45));

			params.setMargins(4, 0, 0, 0);
			image.setLayoutParams(params2);
			lImage.addView(image);
			

			lImage.setGravity(Gravity.CENTER_VERTICAL);

			/**
			 * modificamos los parametros de tamaño para el resto de componentes
			 */
			params2 = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT,(float)1.0);

			// nombreU.setBackgroundColor(Color.BLUE);
			/**
			 * Añadimos la imagen al linearlayout principal
			 */
			lPrincipal.addView(lImage);

			lSecundario.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT));



			/**
			 * Aplicamos orientacion a los linearlayouts
			 */
			lSecundario.setOrientation(LinearLayout.VERTICAL);
			/**
			 * modiicamos propiedades de los textviews
			 */
			LinearLayout l1 = new LinearLayout(this);
			l1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
			asuntoU.setLayoutParams(params2);
			asuntoU.setText("sin asunto");
			asuntoU.setTextColor(Color.BLACK);
			asuntoU.setPadding(5, 0, 0, 0);
			asuntoU.setGravity(Gravity.LEFT);
			l1.addView(asuntoU);
			//numberOfMessagesU.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
			params2 = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
			numberOfMessagesU.setLayoutParams(params2);
			numberOfMessagesU.setBackgroundResource(R.drawable.square_notification);
			numberOfMessagesU.setPadding(4, 0, 4, 0);
			params2.setMargins(0, 0, 0, 4);
			numberOfMessagesU.setText("3");
			numberOfMessagesU.setTextColor(Color.BLACK);
			numberOfMessagesU.setGravity(Gravity.RIGHT);
			l1.addView(numberOfMessagesU);
			l1.setPadding(0, 0, 7, 0);
			lSecundario.addView(l1);
			LinearLayout l2 = new LinearLayout(this);
			l2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
			params2 = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT,(float)1.0);
			nombreU.setLayoutParams(params2);
			nombreU.setText("Jesus");
			nombreU.setTextColor(Color.BLACK);
			nombreU.setPadding(5, 0, 0, 0);
			nombreU.setGravity(Gravity.LEFT);
			l2.addView(nombreU);
			whenU.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));			
			//whenU.setPadding(4, 0, 7, 0);
			whenU.setText("ayer");
			whenU.setTextColor(Color.GRAY);
			whenU.setGravity(Gravity.RIGHT);
			l2.addView(whenU);
			l2.setPadding(0, 0, 7, 0);
			lSecundario.addView(l2);

			/**
			 * añadimos al linear layout princpal el secundario
			 */
			// lSecundario.setBackgroundColor(Color.BLUE);
			lPrincipal.addView(lSecundario);
			/**
			 * añadimos al linear layout del xml todo lo generado hasta el
			 * momento
			 */
			// lSecundario.setBackgroundColor(Color.BLUE);
			LinearLayout rayaGris = new LinearLayout(this);
			rayaGris.setBackgroundColor(Color.DKGRAY);
			rayaGris.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT, 1));
			// lPrincipal.addView(rayaGris);
			lPrincipal.setBackgroundColor(Color.WHITE);
			lPrincipal.setGravity(Gravity.CENTER);
			lPrincipal.setPadding(3, 7, 3, 7);
			//p.addView(lPrincipal);
			//p.addView(rayaGris);
			((LinearLayout)findViewById(R.id.messages)).addView(lPrincipal);
			((LinearLayout)findViewById(R.id.messages)).addView(rayaGris);
			lPrincipal.setId(i);
			list.add(lPrincipal);
		}
		//prin.addView(p);

		// prin.addView(p);

	}

	private void loadSimulatedNotifys() {
		// TODO Auto-generated method stub
		List<Notify> l1 = new ArrayList<Notify>();

		l1.add(new Notify((java.sql.Date) new Date(Date
				.parse("Thu, 12 May 2010 12:16:00 GMT-0500")), "Jesus_manza",
				"has commented on yout post"));
		l1.add(new Notify((java.sql.Date) new Date(Date
				.parse("Thu, 12 May 2010 12:16:00 GMT-0500")), "David Perez",
				"has commented on yout post"));
		l1.add(new Notify((java.sql.Date) new Date(Date
				.parse("Thu, 12 May 2010 12:16:00 GMT-0500")), "David Perez",
				"has commented on yout post"));
		inbox.add(l1);
		List<Notify> l2 = new ArrayList<Notify>();

		l2.add(new Notify((java.sql.Date) new Date(Date
				.parse("Thu, 12 May 2010 12:16:00 GMT-0500")), "Jesus_manza",
				"has commented on yout post"));
		l2.add(new Notify((java.sql.Date) new Date(Date
				.parse("Thu, 12 May 2010 12:16:00 GMT-0500")), "David Perez",
				"has commented on yout post"));

		inbox.add(l2);

	}

	public void onBackPressed() {
		startActivity(new Intent(this, PantallaBonita.class));
		finish();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
		startActivity(new Intent(this,Conversation.class));
		finish();
	}

}
