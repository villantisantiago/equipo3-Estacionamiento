package Estacionamiento;
import Estacionamiento.TDAS.Diccionarios.*;
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

    void SacarVehiculo(String patente){
        Vehiculo vehiculo = d.Recuperar(patente);
        vehiculo.
        d.Eliminar(patente);
        // Devuelve el tiempo de salida
        Scanner entrada = new Scanner(System.in);
        String tiempoSalida = entrada.nextLine();

    }
}
