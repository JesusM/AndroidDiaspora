/**
 * 
 */
package org.jesus.Diaspora;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.util.*;

import org.jesus.Diaspora.R.color;

/**
 * @author jesus
 * 
 */
public class ViewNotifications extends Activity {
	// Example of notifications
	List<List<Notify>> notifications = new ArrayList<List<Notify>>();
	private int number_of_not = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.view_notifications);
		Toast.makeText(getBaseContext(), "example of notifications", Toast.LENGTH_LONG).show();
		// load the simulated notifications
		loadSimulatedNotifys();

		for (int i = 0; i < notifications.size(); i++) {
			number_of_not += notifications.get(i).size();
		}
		((TextView) findViewById(R.id.number_of_notifications))
				.setText(number_of_not + "");
		// load the interface depedient of the simulated notifications
		loadInterface();

//		((Button) findViewById(R.id.Mark_as_read))
//				.setOnClickListener(new OnClickListener() {
//
//					@Override
//					public void onClick(View arg0) {
//						// TODO Auto-generated method stub
//						number_of_not = 0;
//						((TextView) findViewById(R.id.number_of_notifications))
//								.setText(number_of_not + "");
//						((LinearLayout) findViewById(R.id.layout_notif_a_rellenar)).removeAllViews();
//					}
//				});
//		((ImageView)findViewById(R.id.letrero)).setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				startActivity(new Intent(ViewNotifications.this,PantallaPrincipal.class));
//				finish();
//			}});
	}

	private void loadInterface() {
		// TODO Auto-generated method stub

		for (int i = 0; i < notifications.size(); i++) {
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			LinearLayout lprincipal = new LinearLayout(this);
			lprincipal.setOrientation(LinearLayout.VERTICAL);
			//params.setMargins(0, 0, 0, 20);
			//lprincipal.setPadding(0, 0, 0, 10);
			lprincipal.setLayoutParams(params);
			LinearLayout ldate = new LinearLayout(this);						
			params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.WRAP_CONTENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			ldate.setLayoutParams(new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT));
						
			//lprin.addView(ldate);
			//TextView day = new TextView(this);
			TextView month = new TextView(this);
			params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.WRAP_CONTENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			//day.setLayoutParams(params);
			month.setLayoutParams(params);

			month.setText("12 May");
			month.setTextSize((float)15.0);
			month.setPadding(7, 2, 7, 3);
			month.setTextColor(Color.BLACK);

			month.setGravity(Gravity.CENTER);						
			
			//month.setBackgroundResource(R.drawable.square_notification);
			month.setTypeface(null, Typeface.BOLD);
			ldate.addView(month);			
			ldate.setPadding(0, 0, 0, 7);
			lprincipal.addView(ldate);								
			
			rellenarNotificacion(notifications.get(i), lprincipal);
			
			((LinearLayout) findViewById(R.id.layout_notif_a_rellenar))
					.addView(lprincipal);
		}
		
		 

	}

	private void rellenarNotificacion(List<Notify> notifications2,
			LinearLayout prin) {
		// TODO Auto-generated method stub
		if (notifications2.size() <= 1) {
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.FILL_PARENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			LinearLayout p = new LinearLayout(this);
			p.setOrientation(LinearLayout.VERTICAL);
			p.setPadding(7, 4, 7, 4);
			p.setLayoutParams(params);
			TextView comment = new TextView(this);
			comment.setLayoutParams(params);
			TextView date = new TextView(this);
			date.setLayoutParams(params);
			comment.setTextSize((float) 13.0);
			comment.setTextColor(Color.BLACK);
			comment.setGravity(Gravity.LEFT);
			comment.setTypeface(null, Typeface.BOLD);
			comment.setText(notifications2.get(0).getUser_notify() + " "
					+ notifications2.get(0).getType_notify());
			date.setTextColor(Color.GRAY);
			date.setGravity(Gravity.LEFT);
			date.setText(notifications2.get(0).getDate().toGMTString());
			date.setTextColor(Color.GRAY);
			date.setGravity(Gravity.LEFT);
			p.addView(comment);
			p.addView(date);
			prin.addView(p);
		} else {
			prin.setPadding(0, 0, 0, 7);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			LinearLayout p = new LinearLayout(this);			
			p.setLayoutParams(params);
			p.setOrientation(LinearLayout.VERTICAL);
			p.setBackgroundColor(Color.BLUE);
			LinearLayout lPrincipal ;
			
			for (int i = 0; i < notifications2.size(); i++) {
				lPrincipal = new LinearLayout(this);
				lPrincipal.setOrientation(LinearLayout.HORIZONTAL);
				lPrincipal.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.FILL_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT));		
				LinearLayout lSecundario = new LinearLayout(this);
				
				
				//lPrincipal.setPadding(7, 4, 7, 4);
				ImageView image = new ImageView(this);
				
				RelativeLayout rTextViews = new RelativeLayout(getBaseContext());
				//image.setImageBitmap(lista.get(i).getImagenUsuario());
				image.setImageResource(R.drawable.photo);
				TextView nombreU = new TextView(this);
				TextView comentarioU = new TextView(this);				
				LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
						45, 45);
				/**
				 * Aplicamos un tamaño a la imagen
				 */
				LinearLayout lImage = new LinearLayout(this);
				lImage.setLayoutParams(new LinearLayout.LayoutParams(
						45,
						45));

				params.setMargins(4, 0, 0, 0);
				image.setLayoutParams(params2);
				lImage.addView(image);

				lImage.setGravity(Gravity.CENTER_VERTICAL);

				/**
				 * modificamos los parametros de tamaño para el resto de componentes
				 */
				params2 = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.FILL_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT);
				/**
				 * Aplicamos márgenes y aplicamos los parámetros de tamaño al layout
				 * principal
				 */

				//params2.setMargins(4, 4, 6, 25);
				
						
				/**
				 * Aplicamos al textview 1 los parametros
				 */
				nombreU.setLayoutParams(params2);
				
				nombreU.setPadding(7, 0, 0, 0);
				//nombreU.setBackgroundColor(Color.BLUE);
				/**
				 * Añadimos la imagen al linearlayout principal
				 */
				lPrincipal.addView(lImage);

				/**
				 * Aplicamos márgenes y aplicamos los parámetros de tamaño al
				 * textview del comentario
				 */
				// params.setMargins(14, 14, 6, 14);
				params2.setMargins(10, 0, 0, 10);
				lSecundario.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.FILL_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT));
				comentarioU.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.FILL_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT));
				comentarioU.setPadding(7, 0, 0, 0);
				/**
				 * parámetros de tamaño para los textviews de nombreU y fecha
				 */
				/*
				 * params = new LinearLayout.LayoutParams(
				 * LinearLayout.LayoutParams.WRAP_CONTENT,
				 * LinearLayout.LayoutParams.WRAP_CONTENT);
				 */
				RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT);

				/**
				 * Aplicamos al textview del comentario y la fecha los parametros de
				 * tamaño
				 */
				
				/*params3.addRule(RelativeLayout.ALIGN_PARENT_LEFT,
						RelativeLayout.TRUE);				
				params3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
						RelativeLayout.TRUE);*/
				
				/**
				 * Aplicamos orientacion a los linearlayouts
				 */
				//lPrincipal.setOrientation(LinearLayout.HORIZONTAL);
				lSecundario.setOrientation(LinearLayout.VERTICAL);
				/**
				 * modiicamos propiedades de los textviews
				 */
				nombreU.setText(notifications2.get(i).getDate().toGMTString());
				nombreU.setTextColor(R.color.black);
				nombreU.setGravity(Gravity.LEFT);
				nombreU.setTypeface(null, Typeface.BOLD);																			
				// fecha.setBackgroundColor(Color.CYAN);				
				/**
				 * parámetros para el relative layout
				 */
				params3 = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT);
				params3.setMargins(0, 0, 4, 0);
				rTextViews.setLayoutParams(params3);
				rTextViews.setGravity(Gravity.CENTER);
				comentarioU.setText("hoy");
				/**
				 * añadimos al relative layout tanto el nombreU como la fecha
				 */
				rTextViews.addView(nombreU);				
				/**
				 * añadimos al linear layout secundario el relative layout
				 */
				lSecundario.addView(rTextViews);
				lSecundario.addView(comentarioU);
				lSecundario.setGravity(Gravity.CENTER);
				
				/**
				 * añadimos al linear layout princpal el secundario
				 */
				//lSecundario.setBackgroundColor(Color.BLUE);
				lPrincipal.addView(lSecundario);
				/**
				 * añadimos al linear layout del xml todo lo generado hasta el
				 * momento
				 */
				//lSecundario.setBackgroundColor(Color.BLUE);				
				LinearLayout rayaGris = new LinearLayout(this);
				rayaGris.setBackgroundColor(Color.DKGRAY);
				rayaGris.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.FILL_PARENT, 1));
				//lPrincipal.addView(rayaGris);
				lPrincipal.setBackgroundColor(Color.WHITE);
				lPrincipal.setGravity(Gravity.CENTER);
				lPrincipal.setPadding(3, 7, 3, 7);
				p.addView(lPrincipal);
				p.addView(rayaGris);
			}
			prin.addView(p);
			
			//prin.addView(p);
			
		}

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
		notifications.add(l1);
		List<Notify> l2 = new ArrayList<Notify>();

		l2.add(new Notify((java.sql.Date) new Date(Date
				.parse("Thu, 12 May 2010 12:16:00 GMT-0500")), "Jesus_manza",
				"has commented on yout post"));
		l2.add(new Notify((java.sql.Date) new Date(Date
				.parse("Thu, 12 May 2010 12:16:00 GMT-0500")), "David Perez",
				"has commented on yout post"));

		notifications.add(l2);

	}


}
