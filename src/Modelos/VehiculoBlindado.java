package Modelos;

public class VehiculoBlindado extends Vehiculo {
	protected String nivelBlindaje;

	public VehiculoBlindado(String id, String modelo, String yearFabricacion, int kilometraje, String estadoOperativo,String nivelBlindaje) {
		super(id, modelo, yearFabricacion, kilometraje, estadoOperativo);
		this.nivelBlindaje =nivelBlindaje;
	}

	public String getNivelBlindaje() {
		return nivelBlindaje;
	}

	public void setNivelBlindaje(String nivelBlindaje) {
		this.nivelBlindaje = nivelBlindaje;
	}
	
	

}
