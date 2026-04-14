package Estacionamiento;
import java.time.Duration;
import java.time.LocalTime;
import Estacionamiento.TDAS.Colas.ColaTDA;
import Estacionamiento.TDAS.Colas.ColaLD;




public class Estacionamiento{
    private int tiempoDeEntrada;
    DiccionarioVehiculo d = new DiccionarioVehiculo();
    ColaTDA cola = new ColaLD();
    int contD = 0;
    int maximoD = 2;
    int contC = 0;
    double precio;

    public void EmpezarDia(){
        d.InicializarDiccionario();
        cola.InicializarCola();
    }

    public Vehiculo CrearVehiculo(String patente, String tipo, LocalTime hora){
        return new Vehiculo(patente, tipo, hora);
    }

    public void IngresarVehiculo(Vehiculo vehiculo){
        d.Agregar(vehiculo.getPatente(), vehiculo);
        contD ++;
    }

    public double SacarVehiculo(String patente, LocalTime salida){
        Vehiculo vehiculo = d.Recuperar(patente);
        LocalTime entrada = vehiculo.getHoradeEntrada();
        Duration duracion = Duration.between(entrada, salida);
        String tipo = vehiculo.getTipo();
        long minutos = duracion.toMinutes();
        long horas = (minutos + 59) / 60;
        if (tipo.equals("A")){
            double precio = horas * 1000;
        }else{
            double precio = horas * 2000;
        }
        d.Eliminar(patente);
        contD --;
        return precio;
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

    public int CantidadCola(){
        return contC;
    }

    public Vehiculo SacarCola(){
        Vehiculo vehiculo = cola.Primero();
        cola.Desacolar();
        contC --;
        return vehiculo;
    }
}
