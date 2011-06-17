package org.jesus.Diaspora;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.jesus.Diaspora.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
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

public class VistaComentarios extends Activity {
	/** Called when the activity is first created. */
	List<Comentario> lista = new ArrayList<Comentario>();
	boolean oculto = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vista_comment);
		Toast.makeText(getBaseContext(), "example of view of comments", Toast.LENGTH_LONG).show();
		rellenarListaComentarios();
		/**
		 * Rellenar el layout según los comentarios que tenga
		 */
		crearInterfaz();
		/*
		 * ((LinearLayout) findViewById(R.id.LayoutRellenar))
		 * .setBackgroundColor(Color.BLUE);
		 */
		((TextView) findViewById(R.id.Ocultar))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if (oculto == false) {
							oculto = true;
							((LinearLayout) findViewById(R.id.LayoutRellenar2))
									.removeAllViews();
							((TextView) findViewById(R.id.Ocultar))
									.setText("Show");
						} else {
							oculto = false;
							crearInterfaz();
							((TextView) findViewById(R.id.Ocultar))
							.setText("Hide");
						}
					}
				});
		((ImageView)findViewById(R.id.iconobusqueda)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(VistaComentarios.this,
						VistaBusqueda.class));
				finish();
			}});
		((ImageView) findViewById(R.id.iconolista))
		.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(VistaComentarios.this,
						PantallaBonita.class));
				finish();
			}
		});
		((ImageView)findViewById(R.id.letrero)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(VistaComentarios.this,PantallaPrincipal.class));
				finish();
			}});

	}

	private void crearInterfaz() {
		// TODO Auto-generated method stub
		((LinearLayout) findViewById(R.id.LayoutRellenar2))
		.removeAllViews();
		LinearLayout l = new LinearLayout(this);
		LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		for (int i = 0; i < lista.size(); i++) {
			/**
			 * Inicializamos componenetes visuales
			 */
			LinearLayout lSecundario = new LinearLayout(this);
			LinearLayout lPrincipal = new LinearLayout(this);
			ImageView image = new ImageView(this);
			RelativeLayout rTextViews = new RelativeLayout(getBaseContext());
			image.setImageBitmap(lista.get(i).getImagenUsuario());
			TextView nombreU = new TextView(this);
			TextView comentarioU = new TextView(this);
			TextView fecha = new TextView(this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					35, 35);
			/**
			 * Aplicamos un tamaño a la imagen
			 */
			LinearLayout lImage = new LinearLayout(this);
			lImage.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.FILL_PARENT));

			params.setMargins(4, 12, 0, 0);
			image.setLayoutParams(params);
			//image.setPadding(0, 8, 0, 0);
			
			lImage.addView(image);

			lImage.setGravity(Gravity.CENTER_HORIZONTAL);

			/**
			 * modificamos los parametros de tamaño para el resto de componentes
			 */
			params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			/**
			 * Aplicamos márgenes y aplicamos los parámetros de tamaño al layout
			 * principal
			 */

			params.setMargins(4, 4, 6, 25);

			lPrincipal.setLayoutParams(params);
			/**
			 * Aplicamos al textview 1 los parametros
			 */
			nombreU.setLayoutParams(params);
			nombreU.setPadding(0, 7, 0, 0);
			/**
			 * Añadimos la imagen al linearlayout principal
			 */
			lPrincipal.addView(lImage);

			/**
			 * Aplicamos márgenes y aplicamos los parámetros de tamaño al
			 * textview del comentario
			 */
			// params.setMargins(14, 14, 6, 14);
			params.setMargins(10, 0, 0, 10);
			lSecundario.setLayoutParams(params);
			comentarioU.setLayoutParams(params);
			/**
			 * parámetros de tamaño para los textviews de nombreU y fecha
			 */
			/*
			 * params = new LinearLayout.LayoutParams(
			 * LinearLayout.LayoutParams.WRAP_CONTENT,
			 * LinearLayout.LayoutParams.WRAP_CONTENT);
			 */
			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.WRAP_CONTENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);

			/**
			 * Aplicamos al textview del comentario y la fecha los parametros de
			 * tamaño
			 */
			fecha.setPadding(0, 0, 12, 0);
			params2.addRule(RelativeLayout.ALIGN_PARENT_LEFT,
					RelativeLayout.TRUE);
			comentarioU.setLayoutParams(params2);
			params2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
					RelativeLayout.TRUE);
			fecha.setLayoutParams(params2);
			/**
			 * Aplicamos orientacion a los linearlayouts
			 */
			lPrincipal.setOrientation(LinearLayout.HORIZONTAL);
			lSecundario.setOrientation(LinearLayout.VERTICAL);
			/**
			 * modiicamos propiedades de los textviews
			 */
			nombreU.setText(lista.get(i).getNombreUsuario());
			nombreU.setTextColor(R.color.black);
			nombreU.setGravity(Gravity.LEFT);
			nombreU.setTypeface(null, Typeface.BOLD);
			comentarioU.setText(lista.get(i).getComentario()
					+ "sadlkfjasldñfjasldfjsadlñfj\njklsdlafjsañldfkj" + i);
			comentarioU.setGravity(Gravity.LEFT);
			comentarioU.setTextColor(Color.BLACK);
			fecha.setGravity(Gravity.RIGHT);
			fecha.setTextColor(R.color.gray);
			// fecha.setBackgroundColor(Color.CYAN);
			fecha.setText("hoy");
			/**
			 * parámetros para el relative layout
			 */
			params2 = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.WRAP_CONTENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
			params2.setMargins(0, 0, 4, 0);
			rTextViews.setLayoutParams(params2);
			/**
			 * añadimos al relative layout tanto el nombreU como la fecha
			 */
			rTextViews.addView(nombreU);
			rTextViews.addView(fecha);
			/**
			 * añadimos al linear layout secundario el relative layout
			 */
			lSecundario.addView(rTextViews);
			lSecundario.addView(comentarioU);
			/**
			 * añadimos al linear layout princpal el secundario
			 */
			// l2.setBackgroundColor(Color.WHITE);
			lPrincipal.addView(lSecundario);
			/**
			 * añadimos al linear layout del xml todo lo generado hasta el
			 * momento
			 */

			((LinearLayout) findViewById(R.id.LayoutRellenar2))
					.addView(lPrincipal);
			LinearLayout rayaGris = new LinearLayout(this);
			rayaGris.setBackgroundColor(Color.parseColor("#E6E6E6"));
			rayaGris.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT, 1));
			((LinearLayout) findViewById(R.id.LayoutRellenar2))
					.addView(rayaGris);

		}
		l.setLayoutParams(p);

	}

	private void rellenarListaComentarios() {
		// TODO Auto-generated method stub

		lista.add(new Comentario("David Perez Zaba", "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo." +
				" Nullam dictum felis eu pede mollis pretium. Integer tincidunt.",
				BitmapFactory.decodeResource(getResources(), R.drawable.custom_photo),
				new Date(System.currentTimeMillis())));
		lista.add(new Comentario("David Perez Zaba", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +
				"Aenean commodo ligula eget dolor.",
				BitmapFactory.decodeResource(getResources(), R.drawable.photo),
				new Date(System.currentTimeMillis())));
		lista.add(new Comentario("David Perez Zaba", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +
				"Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes," +
				" nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim",
				BitmapFactory.decodeResource(getResources(), R.drawable.custom_photo),
				new Date(System.currentTimeMillis())));
		lista.add(new Comentario("David Perez Zaba", "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo." +
				" Nullam dictum felis eu pede mollis pretium. Integer tincidunt.",
				BitmapFactory.decodeResource(getResources(), R.drawable.photo),
				new Date(System.currentTimeMillis())));
		lista.add(new Comentario("David Perez Zaba", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +
				"Aenean commodo ligula eget dolor.",
				BitmapFactory.decodeResource(getResources(), R.drawable.custom_photo),
				new Date(System.currentTimeMillis())));

	}
}
