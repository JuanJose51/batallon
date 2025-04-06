package Main;

import javax.swing.JOptionPane;

import Logica.Batallon;
import Modelos.EstadoOperativo;

public class Main {
	public  static Batallon b=new Batallon("los mas machos");

	public static void main(String[] args) {
		int opcion=0;
		String mensaje="Ingrese una opción \n"+"1.Gestion de Vehiculos\n"+"2.Gestion de Misiones"+"3.salir";
		String gestionMisiones="Ingrese una Opción\n"+"1.Agregar Mision"+"2.buscar mision"+"3.Eliminar Mision"+"4.actualizar"+"5.salir";
		while(opcion!= 3) {
			opcion=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			switch(opcion) {
			case 1:
				gestionVehiculo();
				break;
			case 2:
				break;
			}
		}

	}
	public static void gestionVehiculo() {
		int opcion=0;
		String mensajeGestionVehiculo="Ingrese una opción\n"+"1.Agregar Vehiculo\n"+"2.Buscar Vehiculo\n"+"3.Eliminar Vehiculo\n"+"4.Actualizar Vehiculo\n"+"5.salir";
		while(opcion !=5) {
			opcion=Integer.parseInt(JOptionPane.showInputDialog(mensajeGestionVehiculo));
			switch(opcion) {
			case 1:
				agregarVehiculo();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
				
			}
		}
	}
	public static void agregarVehiculo() {
		String mensaje ="Ingrese una opcion de tipo de Vehiculo"+"1.blindado\n"+"2.de Apoyo\n"+"3.transporte de tropas";
		int tipoVehiculo =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		switch(tipoVehiculo) {
		case 1:
			String id=JOptionPane.showInputDialog("Ingrese el id del vehiculo");
			boolean estado =b.existeVehiculoBlindado(id);
			if(estado != true) {
				String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo");
				String yearDeFabricacion =JOptionPane.showInputDialog("Ingrese el año de fabricacion del vehiculo");
				int kilometraje =Integer.parseInt(JOptionPane.showInputDialog("ingrese el en numeros enteros el kilometraje del vehiculo"));
				EstadoOperativo estadoSeleccionado =(EstadoOperativo)JOptionPane.showInputDialog(null,"Seleccione el estado operativo del vehículo:",
			            "Estado Operativo",
			            JOptionPane.QUESTION_MESSAGE,
			            null,
			            EstadoOperativo.values(),    
			            EstadoOperativo.DISPONIBLE 
			        );
			}
			break;
		case 2:
			
			break;
		case 3:
			break;
		}
		
	}
	

}
