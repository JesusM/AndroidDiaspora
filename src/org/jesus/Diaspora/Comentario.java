package org.jesus.Diaspora;

import java.util.Date;

import android.graphics.Bitmap;

public class Comentario {
	private String nombreUsuario;
	private String comentario;
	private Bitmap imagenUsuario;
	private Date time;
	public Comentario(String nombreU,String coment,Bitmap image,Date time){
		this.setNombreUsuario(nombreU);
		this.setTime(time);
		this.setComentario(coment);
		this.setImagenUsuario(image);
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @param imagenUsuario the imagenUsuario to set
	 */
	public void setImagenUsuario(Bitmap imagenUsuario) {
		this.imagenUsuario = imagenUsuario;
	}
	/**
	 * @return the imagenUsuario
	 */
	public Bitmap getImagenUsuario() {
		return imagenUsuario;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	
}
