package Logica;

import java.util.ArrayList;
import Modelos.Vehiculo;
import Modelos.EstadoOperativo;
import Modelos.Mision;
import Modelos.TransporteTropas;
import Modelos.VehiculoBlindado;
import Modelos.VheiculoDeApoyo;

public class Batallon {
	private String nombre;
	private ArrayList<Vehiculo> vehiculos=new ArrayList<Vehiculo>();
	private ArrayList<Mision> misiones=new ArrayList<Mision>();
	public Batallon(String nombre, ArrayList<Vehiculo> vehiculos, ArrayList<Mision> misiones) {
		super();
		this.nombre = nombre;
		this.vehiculos = vehiculos;
		this.misiones = misiones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public ArrayList<Mision> getMisiones() {
		return misiones;
	}
	public void setMisiones(ArrayList<Mision> misiones) {
		this.misiones = misiones;
	}
//METODOS DE VEHICULOS//
	public boolean existeVehiculo(String id) {
		for(Vehiculo v:this.vehiculos) {
			if(v.getId().equals(id)) {
				return true;
			}
		}return false;
	}
	public boolean agregarVehiculo(Vehiculo v) {
		boolean estado =existeVehiculo(v.getId());
		if(estado != true) {
			this.vehiculos.add(v);
			return true;
		}return false;
	}
}
