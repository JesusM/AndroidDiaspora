package org.jesus.Diaspora;

import java.util.LinkedList;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaPrincipal extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.principal);
		Toast.makeText(getBaseContext(), "example of main view",
				Toast.LENGTH_LONG).show();
		//ListView a = (ListView) findViewById(R.id.comentarios);
		// cargarTop25();
		SharedPreferences settings = getSharedPreferences("entrada de datos",
				MODE_PRIVATE);
		settings.getString("aspecto", "all aspects");
		((TextView) findViewById(R.id.aspect)).setText(settings.getString(
				"aspecto", "all aspects"));
		//ComentariosAdapter ta = new ComentariosAdapter(this);
		//a.setAdapter(ta);
		cargarComentarios();
		((ImageView) findViewById(R.id.iconolista))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(PantallaPrincipal.this,
								ViewAspects.class));
						finish();
					}
				});
		((ImageView) findViewById(R.id.iconobusqueda))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(PantallaPrincipal.this,
								VistaBusqueda.class));
						finish();
					}
				});
		((TextView) findViewById(R.id.write))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(PantallaPrincipal.this,
								VistaEscribir.class));
						finish();
					}
				});

	}

	private void cargarComentarios() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
			
			LayoutInflater inflater = this.getLayoutInflater();
			View item = null;
			item = inflater.inflate(R.layout.comentario, null);

			ImageView a = (ImageView) item.findViewById(R.id.PhotoProfile);
			
			//Example load image (or not) depending if arg0%2==0
			if (i%2==0) {
				ImageView b = (ImageView) item.findViewById(R.id.UploadPhoto);
				b.setImageResource(R.drawable.photo_large);
				a.setImageResource(R.drawable.custom_photo);
			}else{
				a.setImageResource(R.drawable.photo);
			}

			((TextView) item.findViewById(R.id.NameProfile)).setText("Jesus");
			((TextView) item.findViewById(R.id.comentario))
					.setText("Finalizado el V Concurso Universitario de Software Libre, "
							+ "tras la fase final en Granada, conociendo a muy buena gente y exponiendo nuestros proyectos, "
							+ "me vuelvo a casa con el orgullo de haber recibido el Premio Especial del Concurso (que se corresponde con el primer premio).");
			((TextView) item.findViewById(R.id.comentarioResponses))
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							startActivity(new Intent(PantallaPrincipal.this,
									VistaComentarios.class));
						}
					});
			((TextView) item.findViewById(R.id.comentarioSince))
					.setText("hace 2 días");
			((TextView) item.findViewById(R.id.comentarioResponses))
					.setText("not comment yet");
			LinearLayout rGris = new LinearLayout(this);
			rGris.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,1));
			rGris.setBackgroundColor(R.color.lightgray);
			
			((LinearLayout)findViewById(R.id.comentarios)).addView(item);
			((LinearLayout)findViewById(R.id.comentarios)).addView(rGris);
		}
	}

	public class ComentariosAdapter extends BaseAdapter {

		private Activity c;

		public ComentariosAdapter(Activity context) {
			this.c = context;

		}

		public int getCount() {
			return 5;
		}

		public Object getItem(int arg0) {
			return arg0;
		}

		public long getItemId(int arg0) {
			return arg0;
		}

		public View getView(int arg0, View arg1, ViewGroup arg2) {
			LayoutInflater inflater = c.getLayoutInflater();
			View item = null;
			item = inflater.inflate(R.layout.comentario, null);

			ImageView a = (ImageView) item.findViewById(R.id.PhotoProfile);
			
			//Example load image (or not) depending if arg0%2==0
			if (arg0%2==0) {
				ImageView b = (ImageView) item.findViewById(R.id.UploadPhoto);
				b.setImageResource(R.drawable.photo_large);
				a.setImageResource(R.drawable.custom_photo);
			}else{
				a.setImageResource(R.drawable.photo);
			}

			((TextView) item.findViewById(R.id.NameProfile)).setText("Jesus");
			((TextView) item.findViewById(R.id.comentario))
					.setText("Finalizado el V Concurso Universitario de Software Libre, "
							+ "tras la fase final en Granada, conociendo a muy buena gente y exponiendo nuestros proyectos, "
							+ "me vuelvo a casa con el orgullo de haber recibido el Premio Especial del Concurso (que se corresponde con el primer premio).");
			((TextView) item.findViewById(R.id.comentarioResponses))
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							startActivity(new Intent(PantallaPrincipal.this,
									VistaComentarios.class));
						}
					});
			((TextView) item.findViewById(R.id.comentarioSince))
					.setText("hace 2 días");
			((TextView) item.findViewById(R.id.comentarioResponses))
					.setText("not comment yet "+getApplicationContext().getString(R.string.arrowright));
			// item.setBackgroundResource(R.drawable.my_drawable_top25_element);
			return item;
		}
	}

}
