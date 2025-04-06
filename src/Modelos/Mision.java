package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mision {
	private  int idMision;
	private LocalDate fecha;
	private String ubicacion;
	private ArrayList<String> personal=new ArrayList<String>();
	private String idVehiculo;
	public Mision(LocalDate fecha, String ubicacion, ArrayList<String> personal,String idVehiculo,int idMision) {
		super();
		this.fecha = fecha;
		this.ubicacion = ubicacion;
		this.personal = personal;
		this.idVehiculo = idVehiculo;
		this.idMision= idMision;
	}
	public int getIdMision() {
		return idMision;
	}
	public void setIdMision(int idMision) {
		this.idMision = idMision;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public ArrayList<String> getPersonal() {
		return personal;
	}
	public void setPersonal(ArrayList<String> personal) {
		this.personal = personal;
	}

	public String getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	@Override
	public String toString() {
		return "Mision [fecha=" + fecha + ", ubicacion=" + ubicacion + ", personal=" + personal + ",id del vehiculo en uso"
				+ idVehiculo + "]";
	}
	
	

}
