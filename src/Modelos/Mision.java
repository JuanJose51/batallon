package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mision {
	private  int idMision;
	private LocalDate fecha;
	private String ubicacion;
	private ArrayList<Soldado> personal=new ArrayList<Soldado>();
	private String idVehiculo;
	public Mision(LocalDate fecha, String ubicacion,String idVehiculo,int idMision) {
		super();
		this.fecha = fecha;
		this.ubicacion = ubicacion;
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
	public ArrayList<Soldado> getPersonal() {
		return personal;
	}
	public void setPersonal(ArrayList<Soldado> personal) {
		this.personal = personal;
	}

	public String getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public void agregarSoldadoAMision(Soldado s) {
		personal.add(s);
	}
	@Override
	public String toString() {
		return "Mision [idMision=" + idMision + ", fecha=" + fecha + ", ubicacion=" + ubicacion + ", personal="
				+ personal + ", idVehiculo=" + idVehiculo + "]";
	}
	
	
	

}
