package Modelos;

public class VehiculoDeApoyo extends Vehiculo {
	protected String tipoVehiculo;

	public VehiculoDeApoyo(String id, String modelo, String yearFabricacion, int kilometraje, EstadoOperativo estadoOperativo,String tipoVehiculo) {
		super(id, modelo, yearFabricacion, kilometraje, estadoOperativo);
		this.tipoVehiculo=tipoVehiculo;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	

}
