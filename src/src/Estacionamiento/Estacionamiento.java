package Estacionamiento;
import java.time.LocalTime;
import Estacionamiento.TDAS.Diccionarios.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Estacionamiento{
    private int tiempoDeEntrada;
    DiccionarioVehiculo d = new DiccionarioVehiculo();
    int cont = 0;
    int maximo = 10;

    public void EmpezarDia(){
        d.InicializarDiccionario();
    }

    public Boolean IngresarVehiculo(Vehiculo vehiculo){
        if(cont<maximo){
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese hora (HH:mm): ");
            String input = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime hora = LocalTime.parse(input, formatter);

            vehiculo.setHoraEntrada(hora);
            d.Agregar(vehiculo.getPatente(), vehiculo);
            cont ++;
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
        return cont < maximo;
    }

    int CuantoLugar() {
        return 0;
    }

    void AgregarACola(String patente){
        Vehiculo vehiculo = d.Recuperar(patente);
    }

    Boolean LugarCola(){
        return true;
    }

    void SacarCola(){

    }


}
