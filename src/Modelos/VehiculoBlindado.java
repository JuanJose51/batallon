package Modelos;

public class VehiculoBlindado extends Vehiculo {
	protected String nivelBlindaje;

	public VehiculoBlindado(String id, String modelo, String yearFabricacion, int kilometraje, EstadoOperativo estadoOperativo,String nivelBlindaje) {
		super(id, modelo, yearFabricacion, kilometraje, estadoOperativo);
		this.nivelBlindaje =nivelBlindaje;
	}

	public String getNivelBlindaje() {
		return nivelBlindaje;
	}

	public void setNivelBlindaje(String nivelBlindaje) {
		this.nivelBlindaje = nivelBlindaje;
	}

	@Override
	public String toString() {
		return "VehiculoBlindado [nivelBlindaje=" + nivelBlindaje + ", id=" + id + ", modelo=" + modelo
				+ ", yearFabricacion=" + yearFabricacion + ", kilometraje=" + kilometraje + ", estadoOperativo="
				+ estadoOperativo + ", misiones=" + misiones + "]";
	}
	
	
	

}
