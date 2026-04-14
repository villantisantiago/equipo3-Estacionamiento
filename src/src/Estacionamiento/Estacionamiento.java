package Estacionamiento;
import java.time.LocalTime;

import Estacionamiento.TDAS.Colas.ColaTDA;
import Estacionamiento.TDAS.Colas.ColaLD;
import Estacionamiento.TDAS.Diccionarios.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;


public class Estacionamiento{
    private int tiempoDeEntrada;
    DiccionarioVehiculo d = new DiccionarioVehiculo();
    ColaTDA cola = new ColaLD();
    int contD = 0;
    int maximoD = 10;
    int contC = 0;

    public void EmpezarDia(){
        d.InicializarDiccionario();
        cola.InicializarCola();
    }

    public Vehiculo CrearVehiculo(String patente, String tipo, LocalTime hora){
        Vehiculo v = new Vehiculo(patente, tipo, hora);
        return v;
    }

    public void IngresarVehiculo(Vehiculo vehiculo){
        d.Agregar(vehiculo.getPatente(), vehiculo);
        contD ++;
    }

    public void SacarVehiculo(String patente, LocalTime salida){
        Vehiculo vehiculo = d.Recuperar(patente);
        LocalTime entrada = vehiculo.getHoradeEntrada();
        Duration duracion = Duration.between(entrada, salida);
        d.Eliminar(patente);
        contD --;
    }

    public boolean HayLugar(){
        return contD < maximoD;
    }

    public int CuantoLugar() {
        return maximoD - contD;
    }

    public void AgregarACola(Vehiculo vehiculo){
        cola.Acolar(vehiculo);
        contC ++;
    }

    int CantidadCola(){
        return contC;
    }

    public Vehiculo SacarCola(){
        Vehiculo vehiculo = cola.Primero();
        cola.Desacolar();
        contC --;
        return vehiculo;
    }
}


