package Logica;

import java.time.LocalDate;
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
	private ArrayList<Vehiculo> vehiculos=new ArrayList<Vehiculo>();
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
			this.vehiculos.add(v);
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
			this.vehiculos.remove(v);
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
	public boolean agregarVehiculoDeApoyo(VehiculoDeApoyo v) {
		boolean estado =existeVehiculoBlindado(v.getId());
		if(estado != true) {
			this.vehiculosDeApoyo.add(v);
			this.vehiculos.add(v);
			return true;
		}return false;
	}
	public VehiculoDeApoyo buscarVehiculoDeApoyo(String id) {
		for(VehiculoDeApoyo v:this.vehiculosDeApoyo) {
			if(v.getId().equals(id)) {
				return v;
			}
		}return null;
	}
	public boolean eliminarVehiculoDeApoyo(String id) {
		boolean estado =existeVehiculoDeApoyo(id);
		if(estado != false) {
			VehiculoDeApoyo v= buscarVehiculoDeApoyo(id);
			this.vehiculosDeApoyo.remove(v);
			this.vehiculos.remove(v);
			return true;
		}return false;
	}
//VEHICULO DE TRANSPORTE DE TROPAS//
	public boolean existeVehiculoDeTransporte(String id) {
		for(TransporteTropas t:this.vehiculoDeTropas) {
			if(t.getId().equals(id)) {
				return true;
			}
		}return false;
	}
	public boolean agregarVehiculodeTransporte(String id, String modelo, String yearFabricacion, int kilometraje, EstadoOperativo estadoOperativo,int capacidadTrasporteSoldados) {
		boolean estado =existeVehiculoDeTransporte(id);
		if(estado != true) {
			TransporteTropas t=new TransporteTropas(id, modelo, yearFabricacion, kilometraje, estadoOperativo, capacidadTrasporteSoldados);
			this.vehiculoDeTropas.add(t);
			this.vehiculos.add(t);
			return true;
		}return false;
	}
	public TransporteTropas buscarVehiculoTransporteTropas(String id) {
		for(TransporteTropas t:this.vehiculoDeTropas) {
			if(t.getId().equals(id)) {
			   return t;
			}
		}return null;
	}
	public boolean eliminarVehiculoDeTransporteDeTropas(String id) {
		boolean estado =existeVehiculoDeTransporte(id);
		if(estado != false) {
			TransporteTropas t=buscarVehiculoTransporteTropas(id);
			this.vehiculoDeTropas.remove(t);
			this.vehiculos.remove(t);
			return true;
		}return false;
	}
//METODOS DE  MISION//
	public boolean existeMision(int id) {
		for(Mision m:this.misiones) {
			if(m.getIdMision() == id) {
				return true;
			}
		}return false;
	}
	public boolean buscarVehiculo(String id) {
		boolean estado1=existeVehiculoBlindado(id);
		if(estado1 != false) {
			return true;
		}boolean estado2=existeVehiculoDeApoyo(id);
		if(estado2 != false) {
			return true;
		}boolean estado3=existeVehiculoDeTransporte(id);
		if(estado3 != false) {
			return true;
		}else {
			return false;
		}
	}
	public Vehiculo buscarVehiculoEnGeneral(String id) {
		for(Vehiculo m:this.vehiculos) {
			if(m.getId().equals(id)) {
				return m;
			}
		}return null;
	}
	public boolean agregarMision(LocalDate fecha, String ubicacion, ArrayList<String> personal,String idVehiculo) {
		boolean estado =buscarVehiculo(idVehiculo);
		if(estado != true) {
			int idMision= this.misiones.size()+1;
			Mision m=new Mision(fecha,ubicacion,personal,idVehiculo,idMision);
			this.misiones.add(m);
			Vehiculo v=buscarVehiculoEnGeneral(idVehiculo);
			v.agregarMisionVehiculo(m);
			return true;
		}return false;
	}
	public Mision buscarMision(int id) {
		for(Mision m:this.misiones) {
			if(m.getIdMision()==id) {
				return m;
			}
		}return null;
	}
	public boolean eliminarMision(int id) {
		for(Mision m:this.misiones) {
			if(m.getIdMision() ==id) {
				this.misiones.remove(id);
				Vehiculo v =buscarVehiculoEnGeneral(m.getIdVehiculo());
				v.eliminarMisionVehiculo(id);
				return true;
			}
		}return false;
	}
	public void actualizarMision(int id,LocalDate fecha, String ubicacion, ArrayList<String> personal,String idVehiculo) {
		Mision m =buscarMision(id);
		m.setFecha(fecha);
		m.setUbicacion(ubicacion);
		m.setPersonal(personal);
		m.setIdVehiculo(idVehiculo);
		
	}
	
	
}
