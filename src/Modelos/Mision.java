package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mision {
	private static int idMision=1;
	private LocalDate fecha;
	private String ubicacion;
	private ArrayList<String> personal=new ArrayList<String>();
	private ArrayList<Vehiculo> vehiculosEnUso= new ArrayList<Vehiculo>();
	public Mision(LocalDate fecha, String ubicacion, ArrayList<String> personal, ArrayList<Vehiculo> vehiculosEnUso) {
		super();
		this.fecha = fecha;
		this.ubicacion = ubicacion;
		this.personal = personal;
		this.vehiculosEnUso = vehiculosEnUso;
		this.idMision++;
	}
	public static int getIdMision() {
		return idMision;
	}
	public static void setIdMision(int idMision) {
		Mision.idMision = idMision;
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
	public ArrayList<Vehiculo> getVehiculosEnUso() {
		return vehiculosEnUso;
	}
	public void setVehiculosEnUso(ArrayList<Vehiculo> vehiculosEnUso) {
		this.vehiculosEnUso = vehiculosEnUso;
	}
	@Override
	public String toString() {
		return "Mision [fecha=" + fecha + ", ubicacion=" + ubicacion + ", personal=" + personal + ", vehiculosEnUso="
				+ vehiculosEnUso + "]";
	}
	
	

}
