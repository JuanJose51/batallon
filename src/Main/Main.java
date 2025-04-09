package Main;

import javax.swing.JOptionPane;

import Logica.Batallon;
import Modelos.EstadoOperativo;
import Modelos.TransporteTropas;
import Modelos.VehiculoBlindado;
import Modelos.VehiculoDeApoyo;

public class Main {
	public static Batallon b = new Batallon("los mas machos");

	public static void main(String[] args) {
		int opcion = 0;
		String mensaje = "Ingrese una opción \n" + "1.Gestion de Vehiculos\n" + "2.Gestion de Misiones\n" + "3.salir";
		String gestionMisiones = "Ingrese una Opción\n" + "1.Agregar Mision" + "2.buscar mision" + "3.Eliminar Mision"
				+ "4.actualizar" + "5.atras";
		while (opcion != 3) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			switch (opcion) {
			case 1:
				gestionVehiculo();
				break;
			case 2:
				break;
			}
		}

	}

	public static void gestionVehiculo() {
		int opcion = 0;
		String mensajeGestionVehiculo = "Ingrese una opción\n" + "1.Agregar Vehiculo\n" + "2.Buscar Vehiculo\n"
				+ "3.Eliminar Vehiculo\n" + "4.Actualizar Vehiculo\n" + "5.atras";
		while (opcion != 5) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(mensajeGestionVehiculo));
			switch (opcion) {
			case 1:
				agregarVehiculo();
				break;
			case 2:
				buscarVehiculo();
				break;
			case 3:
				eliminarVehiculo();
				break;
			case 4:
				actualizarVehiculo();
				break;

			}
		}
	}

	public static void agregarVehiculo() {
		int tipoVehiculo = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de la opcion\n"
				+ "1.Vehiculo Blindado\n" + "2.Vehiculo de apoyo\n" + "3.Vehiculo de tansporte de tropas"));
		switch (tipoVehiculo) {
		case 1:
			EstadoOperativo estadoSeleccionado = (EstadoOperativo) JOptionPane.showInputDialog(null,
					"Seleccione el estado operativo del vehículo:", "Estado Operativo", JOptionPane.QUESTION_MESSAGE,
					null, EstadoOperativo.values(), EstadoOperativo.DISPONIBLE);
			boolean estado;
			String id;
			do {
				id = JOptionPane.showInputDialog("ingrese un id para el vehiculo");
				estado = b.existeVehiculoBlindado(id);
			} while (estado != false);
			String modelo = JOptionPane.showInputDialog("Ingrese el modelo del Vehiculo");
			String yearDeFabricacion = JOptionPane.showInputDialog("ingrese el año de fabricación");
			int kilometrage = Integer
					.parseInt(JOptionPane.showInputDialog("ingrese el kilometrage del vehiculo en numeros enteros"));
			String nivel = JOptionPane
					.showInputDialog("ingrese el nivel de blindaje\n" + "bajo\n" + "medio\n" + "alto\n");
			VehiculoBlindado v = new VehiculoBlindado(id, modelo, yearDeFabricacion, kilometrage, estadoSeleccionado,
					nivel);
			boolean estado1 = b.agregarVehiculoBlindado(v);
			if (estado1 != false) {
				JOptionPane.showMessageDialog(null, "Se agrego con exito :)");
			} else {
				JOptionPane.showMessageDialog(null, "Error:no se agrego con exito :(");
			}
			break;
		case 2:
			EstadoOperativo estadoSeleccionado2 = (EstadoOperativo) JOptionPane.showInputDialog(null,
					"Seleccione el estado operativo del vehículo:", "Estado Operativo", JOptionPane.QUESTION_MESSAGE,
					null, EstadoOperativo.values(), EstadoOperativo.DISPONIBLE);
			boolean estado2;
			String id2;
			do {
				id2 = JOptionPane.showInputDialog("ingrese un id para el vehiculo");
				estado2 = b.existeVehiculoBlindado(id2);
			} while (estado2 != false);
			String modelo2 = JOptionPane.showInputDialog("Ingrese el modelo del Vehiculo");
			String yearDeFabricacion2 = JOptionPane.showInputDialog("ingrese el año de fabricación");
			int kilometrage2 = Integer
					.parseInt(JOptionPane.showInputDialog("ingrese el kilometrage del vehiculo en numeros enteros"));
			String tipoDeVehiculoDeApoyo = JOptionPane.showInputDialog("medico" + "Logistica" + "Comunicaciones");
			VehiculoDeApoyo vehiculo = new VehiculoDeApoyo(id2, modelo2, yearDeFabricacion2, kilometrage2,
					estadoSeleccionado2, tipoDeVehiculoDeApoyo);
			boolean estad = b.agregarVehiculoDeApoyo(vehiculo);
			if (estad != false) {
				JOptionPane.showMessageDialog(null, "Se agrego con exito :)");
			} else {
				JOptionPane.showMessageDialog(null, "Error: no se pudo agregar con exito");
			}
			break;
		case 3:
			EstadoOperativo estadoSeleccionado3 = (EstadoOperativo) JOptionPane.showInputDialog(null,
					"Seleccione el estado operativo del vehículo:", "Estado Operativo", JOptionPane.QUESTION_MESSAGE,
					null, EstadoOperativo.values(), EstadoOperativo.DISPONIBLE);
			boolean estado3;
			String id3;
			do {
				id3 = JOptionPane.showInputDialog("ingrese un id para el vehiculo");
				estado3 = b.existeVehiculoBlindado(id3);
			} while (estado3 != false);
			String modelo3 = JOptionPane.showInputDialog("Ingrese el modelo del Vehiculo");
			String yearDeFabricacion3 = JOptionPane.showInputDialog("ingrese el año de fabricación");
			int kilometrage3 = Integer
					.parseInt(JOptionPane.showInputDialog("ingrese el kilometrage del vehiculo en numeros enteros"));
			int cantidadSpoldados = Integer.parseInt(
					JOptionPane.showInputDialog("Ingrese el numero de soldados que puede transportar el vehiculo"));
			boolean estd = b.agregarVehiculodeTransporte(id3, modelo3, yearDeFabricacion3, kilometrage3,
					estadoSeleccionado3, cantidadSpoldados);
			if (estd != false) {
				JOptionPane.showMessageDialog(null, "Se agrego con exito :)");
			} else {
				JOptionPane.showMessageDialog(null, "Error: no se pudo agregar con exito");
			}
		}
	}

	public static void eliminarVehiculo() {
		int tipoVehiculo = Integer
				.parseInt(JOptionPane.showInputDialog("ingrese el numero de la opcion del tipo de vehiculo a elinar\n"
						+ "1.Vehiculo Blindado\n" + "2.Vehiculo de apoyo\n" + "3.Vehiculo de tansporte de tropas"));
		switch (tipoVehiculo) {
		case 1:
			String id1=JOptionPane.showInputDialog("ingrese el id del vehiculo blindado");
			boolean estado=b.eliminarVehiculoBlindado(id1);
			if(estado !=false) {
				JOptionPane.showMessageDialog(null, "se elimino con exito;)");
			}else {
				JOptionPane.showMessageDialog(null,"no se pudo eliminar :(, verifique que los datos ingresados son correctos");
			}
			break;
		case 2:
			String id2=JOptionPane.showInputDialog("ingrese el id del vehiculo de apoyo");
			boolean estado2=b.eliminarVehiculoDeApoyo(id2);
			if(estado2 !=false) {
				JOptionPane.showMessageDialog(null, "se elimino con exito;)");
			}else {
				JOptionPane.showMessageDialog(null,"no se pudo eliminar :(, verifique que los datos ingresados son correctos");
			}
			break;
		case 3:
			String id3=JOptionPane.showInputDialog("ingrese el id del vehiculo de transporte de tropas");
			boolean estado3=b.eliminarVehiculoDeTransporteDeTropas(id3);
			if(estado3 !=false) {
				JOptionPane.showMessageDialog(null, "se elimino con exito;)");
			}else {
				JOptionPane.showMessageDialog(null,"no se pudo eliminar :(, verifique que los datos ingresados son correctos");
			}
			break;
		}

	}
	public static void buscarVehiculo() {
		int tipoVehiculo = Integer
				.parseInt(JOptionPane.showInputDialog("ingrese el numero de la opcion del tipo de vehiculo a elinar\n"
						+ "1.Vehiculo Blindado\n" + "2.Vehiculo de apoyo\n" + "3.Vehiculo de tansporte de tropas"));
		switch (tipoVehiculo) {
		case 1:
			String id1=JOptionPane.showInputDialog("ingrese el id del vehiculo blindado");
			VehiculoBlindado vb=b.buscarVehiculoBlindado(id1);
			if(vb !=null) {
				JOptionPane.showMessageDialog(null, vb.toString());
			}else {
				JOptionPane.showMessageDialog(null, "no se encontro el id ");
			}
			break;
		case 2:
			String id2=JOptionPane.showInputDialog("ingrese el id del vehiculo de apoyo");
			VehiculoDeApoyo vp=b.buscarVehiculoDeApoyo(id2);
			if(vp !=null) {
				JOptionPane.showMessageDialog(null, vp.toString());
			}else {
				JOptionPane.showMessageDialog(null, "no se encontro el id ");
			}
			break;
		case 3:
			String id3=JOptionPane.showInputDialog("ingrese el id del vehiculo de transporte de tropas");
			TransporteTropas vt=b.buscarVehiculoTransporteTropas(id3);
			if(vt !=null) {
				JOptionPane.showMessageDialog(null, vt.toString());
			}else {
				JOptionPane.showMessageDialog(null, "no se encontro el id ");
			}
			break;
		}
	}
	public static void actualizarVehiculo() {
		int tipoVehiculo = Integer
				.parseInt(JOptionPane.showInputDialog("ingrese el numero de la opcion del tipo de vehiculo a elinar\n"
						+ "1.Vehiculo Blindado\n" + "2.Vehiculo de apoyo\n" + "3.Vehiculo de tansporte de tropas"));
		switch (tipoVehiculo) {
		case 1:
			String id1=JOptionPane.showInputDialog("ingrese el id del vehiculo blindado");
			VehiculoBlindado vb=b.buscarVehiculoBlindado(id1);
			if(vb !=null) {
				vb.setEstadoOperativo( (EstadoOperativo) JOptionPane.showInputDialog(null,
						"Seleccione el estado operativo del vehículo:", "Estado Operativo", JOptionPane.QUESTION_MESSAGE,
						null, EstadoOperativo.values(), EstadoOperativo.DISPONIBLE));
				boolean estado;
				String id;
				do {
					id = JOptionPane.showInputDialog("ingrese un id para el vehiculo");
					estado = b.existeVehiculoBlindado(id);
				} while (estado != false);
				vb.setId(id);
				vb.setModelo( JOptionPane.showInputDialog("Ingrese el modelo del Vehiculo"));
				vb.setYearFabricacion(JOptionPane.showInputDialog("ingrese el año de fabricación"));
				vb.setKilometraje(Integer
						.parseInt(JOptionPane.showInputDialog("ingrese el kilometrage del vehiculo en numeros enteros")));
				vb.setNivelBlindaje(JOptionPane
						.showInputDialog("ingrese el nivel de blindaje\n" + "bajo\n" + "medio\n" + "alto\n")); 
				JOptionPane.showMessageDialog(null,"se actualizo con exito :)");
				
			}else {
				JOptionPane.showMessageDialog(null, "no se encontro el id ");
			}
			break;
		case 2:
			String id2=JOptionPane.showInputDialog("ingrese el id del vehiculo blindado");
			VehiculoDeApoyo vp=b.buscarVehiculoDeApoyo(id2);
			if(vp !=null) {
				vp.setEstadoOperativo( (EstadoOperativo) JOptionPane.showInputDialog(null,
						"Seleccione el estado operativo del vehículo:", "Estado Operativo", JOptionPane.QUESTION_MESSAGE,
						null, EstadoOperativo.values(), EstadoOperativo.DISPONIBLE));
				boolean estado;
				String id;
				do {
					id = JOptionPane.showInputDialog("ingrese un id para el vehiculo");
					estado = b.existeVehiculoDeApoyo(id);
				} while (estado != false);
				vp.setId(id);
				vp.setModelo( JOptionPane.showInputDialog("Ingrese el modelo del Vehiculo"));
				vp.setYearFabricacion(JOptionPane.showInputDialog("ingrese el año de fabricación"));
				vp.setKilometraje(Integer
						.parseInt(JOptionPane.showInputDialog("ingrese el kilometrage del vehiculo en numeros enteros")));
				vp.setTipoVehiculo(JOptionPane.showInputDialog("medico\n" + "Logistica\n" + "Comunicaciones\n"));
				JOptionPane.showMessageDialog(null, "se actualizo con exito :)");
			}else {
				JOptionPane.showMessageDialog(null, "Error: no se encontro el id relacionado al vehiculo");
			}
			
			break;
		case 3:
			String id3=JOptionPane.showInputDialog("ingrese el id del vehiculo blindado");
			TransporteTropas vt=b.buscarVehiculoTransporteTropas(id3);
			if(vt !=null) {
				vt.setEstadoOperativo( (EstadoOperativo) JOptionPane.showInputDialog(null,
						"Seleccione el estado operativo del vehículo:", "Estado Operativo", JOptionPane.QUESTION_MESSAGE,
						null, EstadoOperativo.values(), EstadoOperativo.DISPONIBLE));
				boolean estado;
				String id;
				do {
					id = JOptionPane.showInputDialog("ingrese un id para el vehiculo");
					estado = b.existeVehiculoDeTransporte(id);
				} while (estado != false);
				vt.setId(id);
				vt.setModelo( JOptionPane.showInputDialog("Ingrese el modelo del Vehiculo"));
				vt.setYearFabricacion(JOptionPane.showInputDialog("ingrese el año de fabricación"));
				vt.setKilometraje(Integer
						.parseInt(JOptionPane.showInputDialog("ingrese el kilometrage del vehiculo en numeros enteros")));
				vt.setCapacidadTrasporteSoldados(Integer.parseInt(
					JOptionPane.showInputDialog("Ingrese el numero de soldados que puede transportar el vehiculo")));
				JOptionPane.showMessageDialog(null, "se actualizo con exito :)");
			}else {
				JOptionPane.showMessageDialog(null, "Error: no se encontro el id relacionado al vehiculo");
			}
			break; 
		}
	}

}
