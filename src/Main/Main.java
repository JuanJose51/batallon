package Main;

import javax.swing.JOptionPane;

import Logica.Batallon;
import Modelos.EstadoOperativo;
import Modelos.VehiculoBlindado;

public class Main {
	public  static Batallon b=new Batallon("los mas machos");

	public static void main(String[] args) {
		int opcion=0;
		String mensaje="Ingrese una opción \n"+"1.Gestion de Vehiculos\n"+"2.Gestion de Misiones\n"+"3.salir";
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
		int tipoVehiculo =Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de la opcion\n"+"1.Vehiculo Blindado\n"+"2.Vehiculo de apoyo\n"+"3.Vehiculo de tansporte de tropas"));
		switch(tipoVehiculo) {
		case 1:
			EstadoOperativo estadoSeleccionado =(EstadoOperativo)JOptionPane.showInputDialog(null,"Seleccione el estado operativo del vehículo:",
		            "Estado Operativo",
		            JOptionPane.QUESTION_MESSAGE,
		            null,
		            EstadoOperativo.values(),    
		            EstadoOperativo.DISPONIBLE 
		        );
			boolean estado;
			String id;
			do {
				id=JOptionPane.showInputDialog("ingrese un id para el vehiculo");
				estado =b.existeVehiculoBlindado(id);
			}while(estado !=false);
			String modelo =JOptionPane.showInputDialog("Ingrese el modelo del Vehiculo");
			String yearDeFabricacion=JOptionPane.showInputDialog("ingrese el año de fabricación");
			int kilometrage=Integer.parseInt(JOptionPane.showInputDialog("ingrese el kilometrage del vehiculo en numeros enteros"));
			String nivel =JOptionPane.showInputDialog("ingrese el nivel de blindaje\n"+"bajo\n"+"medio\n"+"alto\n");
			VehiculoBlindado v=new VehiculoBlindado(id, modelo, yearDeFabricacion, kilometrage, estadoSeleccionado, nivel);
			boolean estado1 =b.agregarVehiculoBlindado(v);
			if(estado1 !=false) {
				JOptionPane.showMessageDialog(null, "Se agrego con exito :)");
			}else {
				JOptionPane.showMessageDialog(null, "Error:no se agrego con exito :(");
			}
			break;
		}
	}
	

}
