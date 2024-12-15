package org.example.a;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    //--------------------------------------DATOS DEL SISTEMA--------------------------------------


    public static Scanner Keyboard = new Scanner(System.in);

    //{titulo}
    public static String[] ciudades = {
            "Cabo Polonio",
            "La Paloma",
            "Salto",
            "Tacuarembó",
    };

    //{titulo}
    public static String[] tiposAlojamientos = {
            "Hotel",
            "Finca",
            "Apartamento",
            "Dia de Sol",
    };

    //{idAlojamiento, nombreHotel, ciudad, tipoDeAlojamiento, cantidadDeEstrellas, precio}
    public static String[][] alojamientos = {
            {"1", "Hotel Las Dunas", ciudades[0], tiposAlojamientos[0], "4.3", "150"},
            {"2", "Cabanas El Bosque", ciudades[0], tiposAlojamientos[1], "3.1", "80"},
            {"3", "Apartamento Mar del Plata", ciudades[0], tiposAlojamientos[1], "3.5", "70"},
            {"4", "Cabana Los Pinos", ciudades[1], tiposAlojamientos[0], "4.0", "110"},
            {"5", "Cabana El Refugio", ciudades[2], tiposAlojamientos[3], "5.1", "120"},
            {"6", "Posada La Estancia", ciudades[3], tiposAlojamientos[3], "4.0", "90"}
    };

    //{idHabitacion, titulo, descripcion, beneficiosHabitacion, precio}
    public static String[][] habitaciones = {
            {"1", "Habitacion sencilla",
                    "La habitacion sencilla tiene una cama matrimonial, vista al jardin, aire acondicionado, minibar, TV de pantalla plana, y bano privado",
                    "Desayuno incluido", "40"},
            {"2", "Habitacion doble",
                    "La habitacion doble tiene 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio",
                    "No tiene beneficios", "50"},
            {"3", "Habitacion familiar",
                    "La habitacion familiar tiene 2 camas dobles, bano privado, aire acondicionado, TV de pantalla plana, escritorio, y vistas al mar",
                    "Desayuno incluido, acceso a actividades familiares", "90"},
            {"4", "Habitacion superior",
                    "Habitacion con cama queen size, escritorio, bano con ducha y tina, aire acondicionado, TV de pantalla plana, y minibar",
                    "Acceso a la piscina, desayuno incluido", "120"},
            {"5", "Suite Deluxe",
                    "Suite con cama king size, jacuzzi, terraza privada con vista panoramica, TV de pantalla plana, cafetera y minibar",
                    "Acceso al spa, masaje gratuito", "200"}
    };

    // {idHabitacion, idAlojamiento, disponiblidad, maximaCantidadDePersonas}
    public static int[][] relacionHotelHabitacion = {
            {1, 1, 0, 5}, // Habitacion 1 en Hotel Las Dunas
            {2, 2, 1, 10}, // Habitacion 2 en Cabañas El Bosque
            {3, 3, 1, 30}, // Habitacion 3 en Apartamento Mar del Plata
            {4, 4, 0, 7}, // Habitacion 4 en Cabaña Los Pinos
            {5, 5, 1, 4}  // Habitacion 5 en Cabaña El Refugio
    };

    // {idCliente, Nombre, apellido, email, nacionalidad, número de teléfono}
    public static String[][] cliente = {
            {"1", "Mariano", "Villa", "a@a.com", "Colombiana", "23423565"},
    };

    // {idReserva, idCliente, precioTotal, idHabitacionComprada}
    public static String[][] reservacionCliente = {
            {"1", "1", "1000", "1"},  // Reserva del cliente 1 Mariano
    };

    // {idHabitacionComprada, idReserva, idHabitacion}
    public static String[][] habitacionesCompradas = {
            {"1", "1", "1"},  // Reserva 1 (Cliente 1) compra la habitación 1
    };


    //--------------------------------------FUNCION PRINCIPAL-----------------------------------------


    //Metodo inicial
    public static void main(String[] args) {
        limpiarConsola();
        System.out.println("inicio de aplicacion");

        /*
        String nombreCiudad = elegirNombreCiudad();
        String tipoAlojamiento = elegirTipoAlojamiento();
        int cantAdultos = ingresarCantidadPersonas("Adultos");
        int cantNinios = ingresarCantidadPersonas("Ninios");
        System.out.println("Ingrese la fecha de inicio del hospedaje");
        int[] InicioHospedaje = ingresarFecha();
        System.out.println("Ingrese la fecha final del hospedaje");
        int[] FinalHospedaje = ingresarFecha();

        //Primera funcion
        HotelesConLosSigientesParametros(nombreCiudad, tipoAlojamiento, 1, InicioHospedaje, FinalHospedaje, cantAdultos, cantNinios);
        */

        /*
        //precreada
        LinkedList<String[]> HotelesDisponibles = hotelesConLosSigientesParametros(
                "Cabo Polonio",
                "Finca",
                1,
                new int[]{2, 3, 2024},
                new int[]{31, 3, 2024},
                2,
                2
        );
        */

        confirmarHabitaciones(
                "Cabanas El Bosque",
                new int[]{2, 3, 2024},
                new int[]{31, 3, 2024},
                2,
                2,
                1
        );


    }


    //---------------------------------------PRIMER METODO---------------------------------------------


    public static LinkedList<String[]> hotelesConLosSigientesParametros(String ciudad, String tipoAlojamiento, int cantHabitacionesCliente, int[] diaInicioHospedaje, int[] diaFinalHospedaje, int cantAdultos, int cantNinios) {
        LinkedList<String[]> listaHoteles = new LinkedList<>();

        for (String[] hotel : alojamientos) {
            //Comprueba si el hotel es de la ciudad y si tiene el tipo de alojamiento
            if (!(hotel[2].equals(ciudad) && hotel[3].equals(tipoAlojamiento))) continue;

            //Calcula la cantidad de personas que iran a la habitacion
            int cantidadPersonas = cantAdultos + cantNinios;

            //Comprueba si hay habitaciones disponibles en el hotel de esa ciudad
            int[] cantidadYprecioHabitacionesDisponibles = buscarPrecioCantHabitacionesAlojamientoDisponible(hotel, cantidadPersonas);
            int cantidadHabitacionesDisponibles = cantidadYprecioHabitacionesDisponibles[0];
            int minPrecioHabitacionesDisponibles = cantidadYprecioHabitacionesDisponibles[1];

            if (cantidadHabitacionesDisponibles < 1) continue;

            //Comprueba que hay mas habitacinoes disponibles que las requeridas por el cliente
            if (cantidadHabitacionesDisponibles < cantHabitacionesCliente) continue;

            listaHoteles.add(hotel);
            listaHoteles.add(new String[]{"El precio aproximado del hotel |" + hotel[1] + "| es: $ "
                    + minPrecioHabitacionesDisponibles + "\nPrecio aproximado por la fecha elegida: $ "
                    + calcularPrecioHabitacion(minPrecioHabitacionesDisponibles, diaInicioHospedaje, diaFinalHospedaje)
            });
        }


        renderizarDatos(
                listaHoteles,
                new String[]{
                        "id",
                        "Nombre Hotel",
                        "Ciudad",
                        "Tipo de alojamiento",
                        "Estrellas",
                        "Precio"
                }
        );

        return listaHoteles;
    }

    public static int[] buscarPrecioCantHabitacionesAlojamientoDisponible(String[] alojamiento, int cantPersonas) {

        int minPrecioHabitacion = 0;
        int cantidadHabitaciones = 0;

        //Busca en todas las relaciones entre el alojamiento y las habitaciones
        for (int[] unaRelacionHotelHabitacion : relacionHotelHabitacion) {

            //Comprueba que las habitaciones sean del Alojamiento
            if (unaRelacionHotelHabitacion[1] != convertirStringAInt(alojamiento[0])) continue;

            //comprueba que la habitacion esta disponible
            if (unaRelacionHotelHabitacion[2] != 1) continue;

            //comprueba que la habitacion tiene espacio para la cantidad de personas que lo habitaran
            if (unaRelacionHotelHabitacion[3] < cantPersonas) continue;

            String[] habitacion = obtenerHabitacionDeAlojamiento(unaRelacionHotelHabitacion[0]);
            int precioHabitacion = convertirStringAInt(habitacion[4]);

            if (minPrecioHabitacion == 0 || precioHabitacion < minPrecioHabitacion)
                minPrecioHabitacion = precioHabitacion;

            cantidadHabitaciones++;
        }

        return new int[]{cantidadHabitaciones, minPrecioHabitacion};
    }

    public static String[] obtenerHabitacionDeAlojamiento(int idHabitacion) {
        for (String[] unaHabitacion : habitaciones) {
            if (convertirStringAInt(unaHabitacion[0]) == idHabitacion) {
                return unaHabitacion;
            }
        }
        return new String[0];
    }

    public static int calcularPrecioHabitacion(int precio, int[] fechaInicial, int[] fechaFinal) {
        double precioFinal = precio;

        if ((fechaInicial[0] <= 10 && fechaFinal[0] >= 5)) {
            precioFinal = precio - (precio * 0.08);
        }

        if ((fechaInicial[0] <= 15 && fechaFinal[0] >= 10)) {
            precioFinal = precio + (precio * 0.10);
        }

        if ((fechaInicial[0] <= 31 && fechaFinal[0] >= 26)) {
            precioFinal = precio + (precio * 0.15);
        }

        return (int) precioFinal;
    }


    //--------------------------------------SEGUNDO METODO---------------------------------------------


    public static void confirmarHabitaciones(String nombreHotel, int[] diaInicioHospedaje, int[] diaFinalHospedaje, int cantAdultos, int cantNinios, int cantHabitacionesCliente) {
        String[] alojamiento = buscarAlojamientoPorNombre(nombreHotel);
        int cantidadPersonas = cantAdultos + cantNinios;
        LinkedList<String[]> habitacionesDisponibles = buscarHabitacionesDisponible(alojamiento, cantidadPersonas);

        renderizarDatos(
                habitacionesDisponibles,
                new String[]{
                        "id",
                        "Tipo de habitacion",
                        "Descripcion",
                        "Veneficios",
                        "Precio por tipo de habitacion",
                }
        );

        for (String[] unaHabitacion : habitacionesDisponibles) {

            //Comprueba que hay mas habitacinoes disponibles que las requeridas por el cliente
            if (habitacionesDisponibles.size() < cantHabitacionesCliente) continue;

            System.out.println(
                    "El precio total de la habitacion es: $ "
                            + calcularPrecioHabitacion(convertirStringAInt(unaHabitacion[4]), diaInicioHospedaje, diaFinalHospedaje)
            );
            System.out.println("------------------------------------------------");
        }
    }

    public static LinkedList<String[]> buscarHabitacionesDisponible(String[] alojamiento, int cantPersonas) {

        LinkedList<String[]> habitacionesDisponibles = new LinkedList<>();

        //Busca en todas las relaciones entre el alojamiento y las habitaciones
        for (int[] unaRelacionHotelHabitacion : relacionHotelHabitacion) {

            //Comprueba que las habitaciones sean del Alojamiento
            if (unaRelacionHotelHabitacion[1] != convertirStringAInt(alojamiento[0])) continue;

            //comprueba que la habitacion esta disponible
            if (unaRelacionHotelHabitacion[2] != 1) continue;

            //comprueba que la habitacion tiene espacio para la cantidad de personas que lo habitaran
            if (unaRelacionHotelHabitacion[3] < cantPersonas) continue;

            String[] habitacion = obtenerHabitacionDeAlojamiento(unaRelacionHotelHabitacion[0]);

            habitacionesDisponibles.add(habitacion);
        }

        return habitacionesDisponibles;
    }


    //--------------------------------------TERCER METODO----------------------------------------------


    //--------------------------------------RENDERIZAR FORMULARIOS-------------------------------------


    public static String elegirNombreCiudad() {
        boolean salir = false;
        String nombreCiudad = "";
        while (!salir) {
            System.out.println("-----------------------------");
            System.out.println("BIENVENIDO A Booking Hoteles");
            System.out.println("Realize su reserva de habitaciones");
            System.out.println("Elija la ciudad de el hotel al que desea viajar");
            for (int i = 0; i < ciudades.length; i++) {
                System.out.println(i + 1 + ". ciudad:  " + ciudades[i]);
            }
            System.out.println("\n");
            int num = ingresarNumero("Eliga una opción: ");
            limpiarConsola();

            if (num > ciudades.length || num < 0) {
                System.out.println("No es un numero válido");
                continue;
            }
            nombreCiudad = ciudades[num - 1];
            salir = true;
        }

        return nombreCiudad;
    }

    public static String elegirTipoAlojamiento() {
        boolean salir = false;
        String tipoAlojamiento = "";
        while (!salir) {
            System.out.println("-----------------------------");
            System.out.println("BIENVENIDO A Booking Hoteles");
            System.out.println("Elija el tipo de alojamiento que desea");
            for (int i = 0; i < tiposAlojamientos.length; i++) {
                System.out.println(i + 1 + ". tipos de alojamientos:  " + tiposAlojamientos[i]);
            }
            System.out.println("\n");
            int num = ingresarNumero("Eliga una opción: ");

            limpiarConsola();

            if (num > tiposAlojamientos.length || num < 0) {
                System.out.println("No es un numero válido");
                continue;
            }
            tipoAlojamiento = tiposAlojamientos[num - 1];
            salir = true;
        }

        return tipoAlojamiento;
    }

    public static int ingresarCantidadPersonas(String tipoPersona) {
        System.out.println("-----------------------------");

        int cantPersonas = 0;

        boolean salir = false;
        while (!salir) {
            cantPersonas = ingresarNumero("Ingrese la cantidad de " + tipoPersona + ": ");

            if (cantPersonas < 0) {
                System.out.println("No es un numero válido");
                continue;
            }

            salir = true;
        }

        System.out.println("-----------------------------");
        System.out.println("cantPersonas: " + cantPersonas);

        limpiarConsola();

        return cantPersonas;
    }

    public static int[] ingresarFecha() {

        int dia = 0;
        int mes = 0;
        int anio = 0;

        boolean salir = false;
        while (!salir) {
            System.out.println("-----------------------------");
            System.out.println("Ingrese una fecha posterior a la actual");
            System.out.println("-----------------------------");

            dia = ingresarNumero("Ingrese el dia: ");
            if (dia < 1 || dia > 31) {
                limpiarConsola();
                System.out.println("Error ingrese los datos nuevamente");
                continue;
            }

            mes = ingresarNumero("Ingrese el mes: ");
            if (mes < 1 || mes > 12) {
                System.out.println("Error ingrese los datos nuevamente");

                continue;
            }

            anio = ingresarNumero("Ingrese el anio: ");
            if (anio < 2024) {
                limpiarConsola();
                System.out.println("Error ingrese los datos nuevamente");
                continue;
            }

            salir = true;
        }

        System.out.println("-----------------------------");
        System.out.println("Dia: " + dia);
        System.out.println("Mes: " + mes);
        System.out.println("Anio: " + anio);

        limpiarConsola();

        return new int[]{dia, mes, anio};
    }


    //--------------------------------------FUNCIONES DE UTILIDAD--------------------------------------


    public static String[] buscarAlojamientoPorNombre(String nombreAlojamiento) {
        for (String[] unAlojamiento : alojamientos) {
            if (unAlojamiento[1].contains(nombreAlojamiento)) {
                return unAlojamiento;
            }
        }
        return new String[0];
    }

    public static int convertirStringAInt(String str) {
        int numero = 0;
        int longitud = str.length();

        // Iterar sobre cada carácter del String
        for (int i = 0; i < longitud; i++) {
            // Obtener el valor numérico del carácter (por ejemplo, '1' -> 1)
            char c = str.charAt(i);
            int valor = c - '0';  // Resta el valor ASCII de '0' para obtener el número

            // Multiplicar el número actual por 10 (para mover los dígitos a la izquierda)
            // y sumar el valor actual
            numero = numero * 10 + valor;
        }

        return numero;
    }

    public static String ingresarTexto(String msg) {
        System.out.print(msg);
        return Keyboard.nextLine();
    }

    public static int ingresarNumero(String msg) {
        int numero = 0;
        System.out.print(msg);
        while (true) {
            if (Keyboard.hasNextInt()) {
                numero = Keyboard.nextInt();
                break;
            } else {
                System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
                Keyboard.next();
            }
        }
        return numero;
    }

    public static void limpiarConsola() {
        // Imprime 50 líneas en blanco para simular la limpieza
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void renderizarDatos(String[][] mostrarDato) {
        System.out.println("------------------------------------------------");
        for (String[] unDato : mostrarDato) {
            for (String atributo : unDato) {
                System.out.println(atributo);
            }
            System.out.println("------------------------------------------------");
        }
    }

    public static void renderizarDatos(LinkedList<String[]> mostrarDato) {
        System.out.println("------------------------------------------------");
        for (String[] unDato : mostrarDato) {
            for (String atributo : unDato) {
                System.out.println(atributo);
            }
            System.out.println("------------------------------------------------");
        }
    }

    public static void renderizarDatos(LinkedList<String[]> mostrarDato, String[] atributos) {
        System.out.println("------------------------------------------------");
        for (String[] unDato : mostrarDato) {
            for (int i = 0; i < unDato.length; i++) {
                System.out.println(atributos[i] + ": " + unDato[i]);
            }
            System.out.println("------------------------------------------------");
        }
    }


}
