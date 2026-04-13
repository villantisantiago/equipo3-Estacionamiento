package Estacionamiento;
import Estacionamiento.TDAS.Diccionarios.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Estacionamiento{
    private int tiempoDeEntrada;
    DiccionarioVehiculo d = new DiccionarioVehiculo();

    void EmpezarDia(){
        d.InicializarDiccionario();
    }

    public Boolean IngresarVehiculo(Vehiculo vehiculo){
        if(!d.EstaLleno()){
            d.Ingresar(vehiculo.getPatente(), vehiculo);
            return true;
        }else{
            return false;
        }
    }

    int SacarVehiculo(String patente){
        Vehiculo vehiculo = d.Recuperar(patente);

        // Pide el tiempo de salida
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese hora (HH:mm): ");
        String input = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora = LocalTime.parse(input, formatter);

        d.Eliminar(patente);
        return 2;
    }

    boolean HayLugar(){
        return true;
    }

    int CuantoLugar(){
        return 0;
    }
}
