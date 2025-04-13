package Main;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import Logica.Batallon;
import Modelos.EstadoOperativo;
import Modelos.FuncionSoldado;
import Modelos.Mision;
import Modelos.Rango;
import Modelos.Soldado;
import Modelos.TransporteTropas;
import Modelos.VehiculoBlindado;
import Modelos.VehiculoDeApoyo;

public class Main {
	public static Batallon b = new Batallon("los mas machos");

	public static void main(String[] args) {
		int opcion = 0;
		String mensaje = "Ingrese una opción \n" + "1.Gestion de Vehiculos\n" + "2.Gestion de Misiones\n" + "3.gestion De Soldado\n"+"4.salir";
		while (opcion != 4) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			switch (opcion) {
			case 1:
				gestionVehiculo();
				break;
			case 2:
				gestionMision();
				break;
			case 3:
				gestionSoldado();
				break;
			}
		}

	}

	public static void gestionVehiculo() {
		int opcion = 0;
		String mensajeGestionVehiculo = "Ingrese una opción\n" + "1.Agregar Vehiculo\n" + "2.Buscar Vehiculo\n"
				+ "3.Eliminar Vehiculo\n" + "4.Actualizar Vehiculo\n" +"5.kilometraje promedio\n"+"6.vehiculo con más misiones\n"+"7.atras";
		while (opcion != 7) {
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
			case 5:
				kilometrajePromedio();
				break;
			case 6:
				JOptionPane.showMessageDialog(null,"el vehiculo con más misiones es"+b.vehiculoConMasMisiones().toString());
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
				.parseInt(JOptionPane.showInputDialog("ingrese el numero de la opcion del tipo de vehiculo a buscar\n"
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
	public static void gestionMision() {
		int opc=0;
		String gestionMisiones = "Ingrese una Opción\n" + "1.Agregar Mision\n" + "2.buscar mision\n" + "3.Eliminar Mision\n"
				+ "4.actualiza\n" +"5.buscar midion por fecha y ubicación\n"+ "6.atras\n";
		while(opc != 6) {
			opc=Integer.parseInt(JOptionPane.showInputDialog(gestionMisiones));
			switch(opc) {
			case 1:
				agregarMision();
				break;
			case 2:
				buscarMision();
				break;
			case 3:
				eliminarMision();
				break;
			case 4:
				actualizarMision();
				break;
			case 5:
				buscarMisionPorFechaYUbicacion();
				break;
			}
		}
		
	}
	public static void agregarMision() {
		String id=JOptionPane.showInputDialog("ingrese el id del vehiculo al cual se le va a asignar la mision");
		boolean estado=b.buscarVehiculo(id);
		if(estado != false) {
			int mes=Integer.parseInt(JOptionPane.showInputDialog("ingrese el mes de la misión"));
			int dia=Integer.parseInt(JOptionPane.showInputDialog("ingrese el día de la misión"));
			int year=Integer.parseInt(JOptionPane.showInputDialog("ingrese el año de la misión"));
			LocalDate fecha= LocalDate.of(year, mes, dia);
			String ubicacion=JOptionPane.showInputDialog("ingrese la ubicacion de la misión");
			int idMision=b.getMisiones().size()+1;
			boolean m =b.agregarMision(fecha, ubicacion, id,idMision);
			if(m==true) {
				JOptionPane.showMessageDialog(null,"Se agrego con exito :");
			}else {
				JOptionPane.showMessageDialog(null,"no se agrego");
			}
			
			JOptionPane.showMessageDialog(null,"Se agrego con exito :)\n el id de la mision es "+idMision);
		}else {
			JOptionPane.showMessageDialog(null,"Error:no se agrego con exito :(\n verifique que el id del vehiculo sea correcto");
		}
	}
	public static void buscarMision() {
		int id=Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la misión"));
		Mision m=b.buscarMision(id);
		if(m!=null) {
			JOptionPane.showMessageDialog(null,"Informacion misión\n"+m.toString());

		}else {
			JOptionPane.showMessageDialog(null,"Error:no se encontro id relacionado");
		}
	}
	public static void eliminarMision() {
		int id=Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la misión"));
		Mision m=b.buscarMision(id);
		if(m!=null) {
			b.eliminarMision(id);
			JOptionPane.showMessageDialog(null,"se elimino con exito :)");

		}else {
			JOptionPane.showMessageDialog(null,"Error:no se encontro id relacionado a la misión");
		}
	}
	public static void actualizarMision() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la mision"));
		boolean estado = b.existeMision(id);
		if (estado != false) {
			Mision m = b.buscarMision(id);
			String idVehiculo = JOptionPane
					.showInputDialog("ingrese el id del vehiculo al cual se le va a asignar la mision");
			boolean estadoVehiculo = b.buscarVehiculo(idVehiculo);
			if (estadoVehiculo != false) {
				m.setIdVehiculo(idVehiculo);
				int mes = Integer.parseInt(JOptionPane.showInputDialog("ingrese el mes de la misión"));
				int dia = Integer.parseInt(JOptionPane.showInputDialog("ingrese el día de la misión"));
				int year = Integer.parseInt(JOptionPane.showInputDialog("ingrese el año de la misión"));
				LocalDate fecha = LocalDate.of(year, mes, dia);
				m.setFecha(fecha);
				m.setUbicacion(JOptionPane.showInputDialog("ingrese la ubicacion de la misión"));
				JOptionPane.showMessageDialog(null, "se actualizo con exito :)");

			} else {
				JOptionPane.showMessageDialog(null, "Error el id no se encontro");

			}
		}else {
			JOptionPane.showMessageDialog(null, "Error el id de la mision no se encontro");
		}
	}
	public static void buscarMisionPorFechaYUbicacion() {
		int mes=Integer.parseInt(JOptionPane.showInputDialog("ingrese el mes de la misión"));
		int dia=Integer.parseInt(JOptionPane.showInputDialog("ingrese el día de la misión"));
		int year=Integer.parseInt(JOptionPane.showInputDialog("ingrese el año de la misión"));
		LocalDate fecha= LocalDate.of(year, mes, dia);
		String ubicacion=JOptionPane.showInputDialog("ingrese la ubicacion de la misión");
		Mision m=b.buscarMisionPorFechaYUbicacion(fecha, ubicacion);
		if(m != null) {
			JOptionPane.showMessageDialog(null,"Informacion misión\n"+m.toString());

		}else {
			JOptionPane.showMessageDialog(null,"Error:no se encontro un mision relacionado");
		}
	}
	public static void kilometrajePromedio() {
		int tipoVehiculo = Integer
				.parseInt(JOptionPane.showInputDialog("ingrese el numero de la opcion del tipo de vehiculo a buscar\n"
						+ "1.Vehiculo Blindado\n" + "2.Vehiculo de apoyo\n" + "3.Vehiculo de tansporte de tropas"));
		switch (tipoVehiculo) {
		case 1:
			JOptionPane.showMessageDialog(null,"el promedio de los blindados es de"+b.kilometrajePromedioVehiculoBlindados());
			break;
		case 2:
			JOptionPane.showMessageDialog(null,"el promedio de los blindados es de"+b.kilometrajePromedioVehiculoApoyo());
			break;
		case 3:
			JOptionPane.showMessageDialog(null,"el promedio de los blindados es de"+b.kilometrajePromedioVehiculoTransporte());
			break;
		}
	}

	public static void gestionSoldado() {
		int opcion = 0;
		String mensaje = "Ingrese una opción\n" + "1.agregar soldado\n" + "2.eliminar soldado\n" + "3.buscar soldado por id\n"
				+ "4.actualizar soldado\n" + "5.liberar soldados en misiones terminadas\n"
				+ "6.obtener soldados disponibles por rango\n" + "7.edad promedio personal\n"
				+ "8.Buscar soldados por especialidad\n"+"9.atras";
		while(opcion!=9) {
			opcion =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			switch(opcion) {
			case 1:
				agregarSoldado();
				break;
			case 2:
				eliminarSoldado();
				break;
			case 3:
				buscarSoldadoPorId();
				break;
			case 4:
				actualizarSoldado();
				break;
			case 5:
				liberarSoldadosDeMisionesFinalizadas();
				break;
			case 6:
				obtenerSoldadosDisponiblePorRango();
				break;
			case 7:
				edadPromedioPersonal();
				break;
			case 8:
				buscarSoldadoPorEspecialidad();
				break;
			}
		}
	}
	public static void agregarSoldado() {
		boolean estado;
		String idSoldado;
		do {
		idSoldado =JOptionPane.showInputDialog("ingrese el id del soldado");
		estado=b.existeSoldado(idSoldado);
		if(estado != false) {
			JOptionPane.showMessageDialog(null, "este id ya existe ingrese otro :)");
		}
		}while(estado != false);
		String nombre=JOptionPane.showInputDialog("ingrse el nombre del soldado");
		Rango[] opciones = Rango.values();
		Rango rangoSeleccionado = (Rango) JOptionPane.showInputDialog(
	            null,
	            "Selecciona un rango:",
	            "Elegir Rango",
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            opciones,
	            opciones[0] // opción por defecto
	        );
		FuncionSoldado[] funcionOpc =FuncionSoldado.values();
		FuncionSoldado funcion=(FuncionSoldado) JOptionPane.showInputDialog(null,"seleccionar un funcion" , "elegir funcion",JOptionPane.QUESTION_MESSAGE, null, funcionOpc, funcionOpc[0]);
		int edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del sooldado"));
		b.agregarSoldado(idSoldado, nombre, rangoSeleccionado, funcion, edad);
		JOptionPane.showMessageDialog(null, "Se agrego con exio");
	}
	public static void eliminarSoldado() {
		String id =JOptionPane.showInputDialog("ingrese el id del soldado a eliminar");
		boolean estado =b.eliminarSoldado(id);
		if(estado !=false) {
			JOptionPane.showMessageDialog(null, "Se eelimino el soldado con exito");
		}else {
			JOptionPane.showMessageDialog(null,"Error: verifique que el id sea correcto" );
		}
	}
    public static void buscarSoldadoPorId() {
    	String id =JOptionPane.showInputDialog("ingrese el id de un soldado");
    	Soldado s=b.buscarSoldado(id);
    	if(s!=null) {
    		JOptionPane.showMessageDialog(null, s.toString());
    	}else {
    		JOptionPane.showMessageDialog(null, "Error:verifique que el id sea correcto");
    	}
    }
    public static void actualizarSoldado() {
    	String id=JOptionPane.showInputDialog("ingrese el id del soldado");
    	Soldado soldado=b.buscarSoldado(id);
    	if(soldado != null) {
    		soldado.setId(JOptionPane.showInputDialog("ingrese un id"));
    		soldado.setNombreCompleto(JOptionPane.showInputDialog("ingrese el nombre completo  del soldado"));
    		soldado.setEdadSoldado(Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad en enteros")));
    		Rango[] opciones = Rango.values();
    		Rango rangoSeleccionado = (Rango) JOptionPane.showInputDialog(
    	            null,
    	            "Selecciona un rango:",
    	            "Elegir Rango",
    	            JOptionPane.QUESTION_MESSAGE,
    	            null,
    	            opciones,
    	            opciones[0] // opción por defecto
    	        );
    		soldado.setRango(rangoSeleccionado);
    		FuncionSoldado[] funcionOpc =FuncionSoldado.values();
    		FuncionSoldado funcion=(FuncionSoldado) JOptionPane.showInputDialog(null,"seleccionar un funcion" , "elegir funcion",JOptionPane.QUESTION_MESSAGE, null, funcionOpc, funcionOpc[0]);
    		soldado.setFuncion(funcion);
    		JOptionPane.showMessageDialog(null,"Se actualizo con exito");
    		
    	}else {
    		JOptionPane.showMessageDialog(null,"Error: no se encontro el id");
    	}
    	
    }
    public static void obtenerSoldadosDisponiblePorRango() {
    	Rango[] opciones = Rango.values();
		Rango rangoSeleccionado = (Rango) JOptionPane.showInputDialog(
	            null,
	            "Selecciona un rango:",
	            "Elegir Rango",
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            opciones,
	            opciones[0] // opción por defecto
	        );
		ArrayList<Soldado> soldados=b.soldadoDisponiblePorRango(rangoSeleccionado);
    	String mensaje="";
    	int n=1;
    	for(Soldado s:soldados) {
    		mensaje+=n+"."+s.toString()+"\n";
    		n++;
    	}
    	JOptionPane.showMessageDialog(null, mensaje);
    }
    public static void edadPromedioPersonal() {
    	int edadPromedio=b.calcularEdadPromedioPersonal();
    	if(edadPromedio != -1) {
    		JOptionPane.showMessageDialog(null,"la edad promedio de el personal es de "+edadPromedio);
    	}else {
    		JOptionPane.showMessageDialog(null,"No hay personal agregado");
    	}
    }
    public static void buscarSoldadoPorEspecialidad() {
    	FuncionSoldado[] opciones = FuncionSoldado.values();
		FuncionSoldado funcion = (FuncionSoldado) JOptionPane.showInputDialog(
	            null,
	            "Selecciona un rango:",
	            "Elegir Rango",
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            opciones,
	            opciones[0]
	        );
		ArrayList<Soldado> soldados=b.buscarSoldadosPorFuncion(funcion);
    	String mensaje="";
    	int n=1;
    	for(Soldado s:soldados) {
    		mensaje+=n+"."+s.toString()+"\n";
    		n++;
    	}
    	JOptionPane.showMessageDialog(null, mensaje);
    }
    public static void liberarSoldadosDeMisionesFinalizadas() {
    	
    }
}
