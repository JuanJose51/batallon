package Logica;

import java.time.LocalDate;
import java.util.ArrayList;
import Modelos.Vehiculo;
import Modelos.EstadoOperativo;
import Modelos.Mision;
import Modelos.TransporteTropas;
import Modelos.VehiculoBlindado;
import Modelos.VehiculoDeApoyo;
import Modelos.Soldado;
import Modelos.Rango;
import Modelos.FuncionSoldado;

public class Batallon {
	private String nombre;
	private ArrayList<VehiculoBlindado> vehiculosBlindados=new ArrayList<VehiculoBlindado>();
	private ArrayList<VehiculoDeApoyo> vehiculosDeApoyo= new ArrayList<VehiculoDeApoyo>();
	private ArrayList<TransporteTropas> vehiculoDeTropas= new ArrayList<TransporteTropas>();
	private ArrayList<Vehiculo> vehiculos=new ArrayList<Vehiculo>();
	private ArrayList<Mision> misiones=new ArrayList<Mision>();
	private ArrayList<Soldado> soldados= new ArrayList<Soldado>();
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
	public int kilometrajePromedioVehiculoBlindados() {
		int contador=0;
		for(VehiculoBlindado b:this.vehiculosBlindados) {
			contador+=b.getKilometraje();
		}return contador/vehiculoDeTropas.size();
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
	public int kilometrajePromedioVehiculoApoyo() {
		int contador=0;
		for(VehiculoDeApoyo p:this.vehiculosDeApoyo) {
			contador+=p.getKilometraje();
		}return contador/vehiculoDeTropas.size();
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
	public int kilometrajePromedioVehiculoTransporte() {
		int contador=0;
		
		for(TransporteTropas t:this.vehiculoDeTropas) {
			contador+=t.getKilometraje();
		}return contador/vehiculoDeTropas.size();
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
	public boolean agregarMision(LocalDate fecha, String ubicacion,String idVehiculo,int idMision) {
		boolean estado =buscarVehiculo(idVehiculo);
		if(estado != false) {
			Mision m=new Mision(fecha,ubicacion,idVehiculo,idMision);
			misiones.add(m);
			Vehiculo v=buscarVehiculoEnGeneral(idVehiculo);
			v.agregarMisionVehiculo(m);
			return true;
		}return false;
	}
	public Mision buscarMision(int id) {
		for(Mision m:misiones) {
			int idMision=m.getIdMision();
			if(idMision==id) {
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
	public void actualizarMision(int id,LocalDate fecha, String ubicacion,String idVehiculo) {
		Mision m =buscarMision(id);
		m.setFecha(fecha);
		m.setUbicacion(ubicacion);
		m.setIdVehiculo(idVehiculo);
		
	}
	public Mision buscarMisionPorFechaYUbicacion(LocalDate facha,String ubicacion) {
		for(Mision m:this.misiones) {
			if(m.getFecha().equals(facha) &&m.getUbicacion().equalsIgnoreCase(ubicacion)) {
				return m;
			}
		}return null;
	}
	public Vehiculo vehiculoConMasMisiones() {
		int mayorCantidadMisiones=0;
		Vehiculo v=null;
		for(VehiculoBlindado vb :this.vehiculosBlindados) {
			if(vb.getMisiones().size()>mayorCantidadMisiones) {
				v=vb;
				mayorCantidadMisiones =vb.getMisiones().size();
			}
		}
		for(VehiculoDeApoyo vp :this.vehiculosDeApoyo) {
			if(vp.getMisiones().size()>mayorCantidadMisiones) {
				v=vp;
				mayorCantidadMisiones =vp.getMisiones().size();
			}
		}
		for(TransporteTropas vt :this.vehiculoDeTropas) {
			if(vt.getMisiones().size()>mayorCantidadMisiones) {
				v=vt;
				mayorCantidadMisiones =vt.getMisiones().size();
			}
		}
		return v;
	}
//METODOS DE SOLDADOS//
	public boolean existeSoldado(String id) {
		for(Soldado s:this.soldados) {
			if(s.getId().equals(id)) {
				return true;
			}
		}return false;
	}
	public boolean agregarSoldado(String id,String nombreCompleto,Rango rango,FuncionSoldado funcion,int edad) {
		Soldado s=new Soldado(id, nombreCompleto, rango, funcion, edad);
		boolean estado =existeSoldado(id);
		if(estado!=true) {
		   soldados.add(s);
		   s.asignarMison();
		   return true;
		}return false;
	}
	public boolean eliminarSoldado(String id) {
		for(Soldado s:this.soldados) {
			if(s.getId().equals(id)) {
				soldados.remove(s);
				eliminarSoldadoEnMisioneInbolucrado(id);
				return true;
			}
		}return false;
	}
	public Soldado buscarSoldado(String idSoldado) {
		for(Soldado s:this.soldados) {
			if(s.getId().equals(idSoldado)) {
				soldados.remove(s);
				return s;
			}
		}return null;
	}
	public boolean agregarSoldadoAMision(int idMision,String id) {
		Soldado soldado=buscarSoldado(id);
		Mision mision=buscarMision(idMision);
		if(soldado != null&& mision != null) {
			mision.agregarSoldadoAMision(soldado);
			return true;
		}return false;
	}
	public void eliminarSoldadoEnMisioneInbolucrado(String idSoldado) {
		Soldado s =buscarSoldado(idSoldado);
		if(s!=null) {
			for(Mision m:this.misiones) {
				for(Soldado soldado:m.getPersonal()) {
					if(soldado.getId().equals(idSoldado)) {
						m.getPersonal().remove(s);
					}
				}
			}
		}
	}
	  public ArrayList<Soldado> buscarSoldadosPorFuncion(FuncionSoldado funcion) {
	        ArrayList<Soldado> resultado = new ArrayList<Soldado>();
	        for (Soldado s : soldados) { 
	            if (s.getFuncion().equals(funcion)) {
	                resultado.add(s);
	            }
	        }
	        return resultado;
	  }
	  public ArrayList<Soldado> soldadoDisponiblePorRango(Rango rango){
		  ArrayList<Soldado> listaSoldados=new ArrayList<Soldado>();
		  for(Soldado s:soldados) {
			  if(s.getRango().equals(rango)&&s.isDisponible()==true) {
				  listaSoldados.add(s);
			  }
		  }return listaSoldados;
	  }
	  public int calcularEdadPromedioPersonal() {
		  int edad=0;
		  for(Soldado s:soldados) {
			  edad+=s.getEdadSoldado();
		  }if(edad!=0) {
			  return edad/soldados.size();
		  }return -1;
		  
	  }
	  
	
}
