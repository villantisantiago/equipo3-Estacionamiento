package Estacionamiento;
import java.time.LocalTime;

import Estacionamiento.TDAS.Colas.ColaPrioridadAO;
import Estacionamiento.TDAS.Diccionarios.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Estacionamiento{
    private int tiempoDeEntrada;
    DiccionarioVehiculo d = new DiccionarioVehiculo();
    ColaPrioridadAO cola = new ColaPrioridadAO();
    int contD = 0;
    int maximoD = 10;
    int contC = 0;

    public void EmpezarDia(){
        d.InicializarDiccionario();
        cola.InicializarCola();
    }

    public Boolean IngresarVehiculo(Vehiculo vehiculo){
        if(contD<maximoD){
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese hora (HH:mm): ");
            String input = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime hora = LocalTime.parse(input, formatter);

            vehiculo.setHoraEntrada(hora);
            d.Agregar(vehiculo.getPatente(), vehiculo);
            contD ++;
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
        contD --;
        return 2;
    }

    boolean HayLugar(){
        return contD < maximoD;
    }

    int CuantoLugar() {
        return maximoD - contD;
    }

    void AgregarACola(Vehiculo vehiculo){
        cola.Acolar(vehiculo);
        contC ++;
    }

    int CantidadCola(){
        return contC;
    }

    void SacarCola(Vehiculo vehiculo){
        cola.Desacolar();
        contC --;
    }
}
