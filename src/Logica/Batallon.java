package Logica;

import java.util.ArrayList;
import Modelos.Vehiculo;
import Modelos.EstadoOperativo;
import Modelos.Mision;
import Modelos.TransporteTropas;
import Modelos.VehiculoBlindado;
import Modelos.VehiculoDeApoyo;

public class Batallon {
	private String nombre;
	private ArrayList<VehiculoBlindado> vehiculosBlindados=new ArrayList<VehiculoBlindado>();
	private ArrayList<VehiculoDeApoyo> vehiculosDeApoyo= new ArrayList<VehiculoDeApoyo>();
	private ArrayList<TransporteTropas> vehiculoDeTropas= new ArrayList<TransporteTropas>();
	private ArrayList<Mision> misiones=new ArrayList<Mision>();
	public Batallon(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Mision> getMisiones() {
		return misiones;
	}
	public void setMisiones(ArrayList<Mision> misiones) {
		this.misiones = misiones;
	}
//METODOS DE VEHICULOS//
	public boolean existeVehiculoBlindado(String id) {
		for(VehiculoBlindado v:this.vehiculosBlindados) {
			if(v.getId().equals(id)) {
				return true;
			}
		}return false;
	}
	public boolean agregarVehiculoBlindado(VehiculoBlindado v) {
		boolean estado =existeVehiculoBlindado(v.getId());
		if(estado != true) {
			this.vehiculosBlindados.add(v);
			return true;
		}return false;
	}
	public VehiculoBlindado buscarVehiculoBlindado(String id) {
		for(VehiculoBlindado v:vehiculosBlindados) {
			if(v.getId().equals(id)) {
				return v;
			}
		}return null;
	}
	public boolean eliminarVehiculoBlindado(String id) {
		 VehiculoBlindado v =buscarVehiculoBlindado(id);
		if(v != null) {
			this.vehiculosBlindados.remove(v);
			return true;
		}return false;
	}
//METODOS DE VEHICULO DE APOYO//
	public boolean existeVehiculoDeApoyo(String id) {
		for(VehiculoDeApoyo v:this.vehiculosDeApoyo) {
			if(v.getId().equals(id)) {
				return true;
			}
		}return false;
	}
	public boolean agregarVehiculoDeApoyo(Vehiculo v) {
		boolean estado =existeVehiculoBlindado(v.getId());
		if(estado != true) {
			this.vehiculosBlindados.add(v);
			return true;
		}return false;
	}
	
}
