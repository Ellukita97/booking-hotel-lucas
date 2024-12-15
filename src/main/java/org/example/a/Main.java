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

        System.out.println("inicio de aplicacion");

    }


    //---------------------------------------PRIMER METODO---------------------------------------------

    //Por Crear


}
