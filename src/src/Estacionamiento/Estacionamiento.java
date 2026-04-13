package Estacionamiento;
import java.time.LocalTime;
import java.time.Duration;
import java.time.LocalDate;
import Estacionamiento.TDAS.Diccionarios.*;

public class Estacionamiento{
    private int tiempoDeEntrada;
    DiccionarioVehiculo d = new DiccionarioVehiculo();

    void EmpezarDia(){
        d.InicializarDiccionario();
    }

    public Boolean IngresarVehiculo(Vehiculo vehiculo){
        if(!d.Estalleno()){
            d.Ingresar(vehiculo.getPatente(), vehiculo);
            return true;
        }else{
            return false;
        }
    }

    void SacarVehiculo(String patente){
        d.Eliminar(patente);
        // Devuelve el tiempo de salida
    }
}
