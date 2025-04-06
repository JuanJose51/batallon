package Modelos;

public class TransporteTropas extends Vehiculo{
	protected int capacidadTrasporteSoldados;

	public TransporteTropas(String id, String modelo, String yearFabricacion, int kilometraje, EstadoOperativo estadoOperativo,int capacidadTrasporteSoldados) {
		super(id, modelo, yearFabricacion, kilometraje, estadoOperativo);
		this.capacidadTrasporteSoldados=capacidadTrasporteSoldados;
	}

	public int getCapacidadTrasporteSoldados() {
		return capacidadTrasporteSoldados;
	}

	public void setCapacidadTrasporteSoldados(int capacidadTrasporteSoldados) {
		this.capacidadTrasporteSoldados = capacidadTrasporteSoldados;
	}
	
	
	

}
