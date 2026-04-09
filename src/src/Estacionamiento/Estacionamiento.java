package Estacionamiento;
import java.time.LocalTime;
import java.time.Duration;
import java.time.LocalDate;
import Estacionamiento.TDAS.Diccionarios.*;

public class Estacionamiento{
    private int tiempoDeEntrada;
    estacionamientoDiccionario d = new DiccionarioVehiculo();

    void EmpezarDia(){
        d.InicializarDiccionario();
    }

    public Boolean IngresarVehiculo(Vehiculo vehiculo){
        ConjuntoVehiculos claves = d.Claves();
        if(claves.ConjuntoVacio()){
            d.Ingresar(vehiculo.getPatente(), vehiculo);
            return true;
        }else{
            return false;
        }
    }

    void SacarVehiculo(String patente){
        d.Eliminar(patente);

    }
}
