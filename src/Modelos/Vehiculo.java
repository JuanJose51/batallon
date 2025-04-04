package Modelos;

import java.util.ArrayList;

public abstract class Vehiculo {
	protected String id;
	protected String modelo;
	protected String yearFabricacion;
	protected int kilometraje;
	protected String estadoOperativo;
	protected ArrayList<Mision> misiones=new ArrayList<Mision>();
	public ArrayList<Mision> getMisiones() {
		return misiones;
	}
	public void setMisiones(ArrayList<Mision> misiones) {
		this.misiones = misiones;
	}
	public Vehiculo(String id, String modelo, String yearFabricacion, int kilometraje, String estadoOperativo) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.yearFabricacion = yearFabricacion;
		this.kilometraje = kilometraje;
		this.estadoOperativo = estadoOperativo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getYearFabricacion() {
		return yearFabricacion;
	}
	public void setYearFabricacion(String yearFabricacion) {
		this.yearFabricacion = yearFabricacion;
	}
	public int getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}
	public String getEstadoOperativo() {
		return estadoOperativo;
	}
	public void setEstadoOperativo(String estadoOperativo) {
		this.estadoOperativo = estadoOperativo;
	}
	

}
