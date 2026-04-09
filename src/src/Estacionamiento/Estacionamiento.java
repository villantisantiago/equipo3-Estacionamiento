package Estacionamiento;
import java.time.LocalTime;
import java.time.Duration;
import java.time.LocalDate;
import Estacionamiento.TDAS.Diccionarios.*;

public class Estacionamiento {
    private int tiempoDeEntrada;
    DiccionarioSimpleTDA d = new DiccionarioSimple();

    void EmpezarDia(){
        d.InicializarDiccionario();
    }
    void IngresarVehiculo(Vehiculo vehiculo){

        d.Agregar(vehiculo.getPatente(), vehiculo);
    }
}
