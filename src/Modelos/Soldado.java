package Modelos;

public class Soldado {
	private String idSoldado;
	private String nombreCompleto;
	private Rango rango;
	private FuncionSoldado funcion;
	private int edadSoldado;
	private boolean disponible;
	public Soldado(String idSoldado, String nombreCompleto, Rango rango, FuncionSoldado funcion, int edadSoldado) {
		super();
		this.idSoldado = idSoldado;
		this.nombreCompleto = nombreCompleto;
		this.rango = rango;
		this.funcion = funcion;
		this.edadSoldado = edadSoldado;
		this.disponible = true;
	}
    @Override
    public String toString() {
        return "Soldado{" +
                "idSoldado='" + idSoldado + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", FuncionSoldado=" + funcion +
                ", disponible=" + disponible +
                '}';
    }
    public void asignarMison (){
        if (disponible==true) {
            disponible = false;
            System.out.println("Soldado" + idSoldado + "asignado a la mision");
        }
        else {
            System.out.println("Soldado" + idSoldado + "no disponible");
        }
    }
    public void liberarMion (){
        disponible = true;
        System.out.println("Soldado" + idSoldado + "liberado de la mision");
    }
    public void getInfo(){
        System.out.println("IDSoldado" + idSoldado);
        System.out.println("NombreCompleto" + nombreCompleto);
        System.out.println("FuncionSoldado" + funcion);
        System.out.println("Disponible" + disponible);
        System.out.println("EdadSoldado"+ edadSoldado);
    }
	public String getId() {
		return idSoldado;
	}
	public void setId(String id) {
		this.idSoldado = id;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public Rango getRango() {
		return rango;
	}
	public void setRango(Rango rango) {
		this.rango = rango;
	}
	public FuncionSoldado getFuncion() {
		return funcion;
	}
	public void setFuncion(FuncionSoldado funcion) {
		this.funcion = funcion;
	}
	public int getEdadSoldado() {
		return edadSoldado;
	}
	public void setEdadSoldado(int edadSoldado) {
		this.edadSoldado = edadSoldado;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
    

	
	

}
