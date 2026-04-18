package Estacionamiento;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import Estacionamiento.TDAS.Colas.ColaTDA;
import Estacionamiento.TDAS.Colas.ColaLD;

public class Estacionamiento{
    DiccionarioVehiculo d = new DiccionarioVehiculo();

    ColaTDA cola = new ColaLD();
    ConjuntoVehiculos conjuntopatentes = new ConjuntoVehiculos();
    double precio;
    int contD = 0;
    int maximoD = 2;
    int contC = 0;
    String elemento;

    public void EmpezarPrograma(){ // Habria q cambiarle el nombre a ese metodo
        d.InicializarDiccionario();
        cola.InicializarCola();
        conjuntopatentes.InicializarConjunto();
    }

    public void FinalizarDia(){
        estacionamientoConjunto aux = new ConjuntoVehiculos();
        aux.InicializarConjunto();
        String salida = "24:00";
        String entrada = "00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora = LocalTime.parse(salida, formatter);
        LocalTime hora2 = LocalTime.parse(salida, formatter);

        while(!conjuntopatentes.ConjuntoVacio()){
            elemento = conjuntopatentes.Elegir();
            Vehiculo vehiculo = d.Recuperar(elemento);
            vehiculo.setPrecio(CalcularPrecio(elemento, hora));
            vehiculo.setHoraEntrada(hora2);
            aux.Agregar(elemento);
            conjuntopatentes.Sacar(elemento);
        }
        while(!aux.ConjuntoVacio()){
            elemento = aux.Elegir();
            conjuntopatentes.Agregar(elemento);
            aux.Sacar(elemento);
        }
    }

    public Vehiculo CrearVehiculo(String patente, String tipo, LocalTime hora){
        return new Vehiculo(patente, tipo, hora);
    }

    public void IngresarVehiculo(Vehiculo vehiculo){ // PRE: no tiene que estar la patente en el diccionario
            d.Agregar(vehiculo.getPatente(), vehiculo);
            conjuntopatentes.Agregar(vehiculo.patente);
            contD++;
    }

    public boolean EstaPatente(String patente){
        return conjuntopatentes.Pertenece(patente);
    }

    public double SacarVehiculo(String patente, LocalTime salida){
        CalcularPrecio(patente, salida);
        Vehiculo vehiculo = d.Recuperar(patente);
        precio = vehiculo.getPrecio();
        d.Eliminar(patente);
        conjuntopatentes.Sacar(patente);
        contD --;
        return (precio);
    }

    public double CalcularPrecio(String patente, LocalTime salida){
        Vehiculo vehiculo = d.Recuperar(patente);
        LocalTime entrada = vehiculo.getHoradeEntrada();
        Duration duracion = Duration.between(entrada, salida);
        String tipo = vehiculo.getTipo();
        tipo = tipo.toUpperCase();
        long minutos = duracion.toMinutes();
        long horas = (minutos + 59) / 60;
        if (tipo.equals("A")){
            precio = horas * 1000;
        }else {
            precio = horas * 2000;
        }
        return precio;
    }

    public boolean HayLugar(){
        return contD < maximoD;
    }

    public int CuantoLugar(){
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
        contC--;
        return vehiculo;
    }

    public boolean ColaVacia(){  // pre: Cola inicializada y con almenos 1 Vehiculo dentro
        return cola.ColaVacia();
    }

    public void Patentes() {
        estacionamientoConjunto aux = new ConjuntoVehiculos();
        aux.InicializarConjunto();
        while(!conjuntopatentes.ConjuntoVacio()){
            elemento = conjuntopatentes.Elegir();
            System.out.println(elemento);
            aux.Agregar(elemento);
            conjuntopatentes.Sacar(elemento);
        }

        while(!aux.ConjuntoVacio()){
            elemento = aux.Elegir();
            conjuntopatentes.Agregar(elemento);
            aux.Sacar(elemento);
        }
    }
}
