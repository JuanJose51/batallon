package Modelos;

public class VheiculoDeApoyo extends Vehiculo {
	protected String tipoVehiculo;

	public VheiculoDeApoyo(String id, String modelo, String yearFabricacion, int kilometraje, String estadoOperativo,String tipoVehiculo) {
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
