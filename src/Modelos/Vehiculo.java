package Modelos;

import java.util.ArrayList;

public abstract class Vehiculo {
	protected String id;
	protected String modelo;
	protected String yearFabricacion;
	protected int kilometraje;
	protected EstadoOperativo estadoOperativo;
	protected ArrayList<Mision> misiones=new ArrayList<Mision>();
	public ArrayList<Mision> getMisiones() {
		return misiones;
	}
	public void setMisiones(ArrayList<Mision> misiones) {
		this.misiones = misiones;
	}
	public Vehiculo(String id, String modelo, String yearFabricacion, int kilometraje, EstadoOperativo estadoOperativo) {
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
	public void agregarMisionVehiculo(Mision m) {
		this.misiones.add(m);
	}
	public EstadoOperativo getEstadoOperativo() {
		return estadoOperativo;
	}
	public void setEstadoOperativo(EstadoOperativo estadoOperativo) {
		this.estadoOperativo = estadoOperativo;
	}
	public void eliminarMisionVehiculo(int id) {
		for(Mision m:this.misiones) {
			if(m.getIdMision() == id) {
				misiones.remove(m);
			}
		}
	}
	

}
