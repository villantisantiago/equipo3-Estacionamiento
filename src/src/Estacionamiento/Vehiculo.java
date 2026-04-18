package Estacionamiento;

import java.time.LocalTime;

public class Vehiculo {

    // Atributos
    protected String patente;
    protected LocalTime horaDeEntrada;
    protected String tipo;
    protected double precio = 0;

    // Metodo constructor
    public Vehiculo(String patente, String tipo, LocalTime horaDeEntrada){
        // mandar al main el scanner
        this.patente = patente;
        this.tipo = tipo;
        this.horaDeEntrada = horaDeEntrada;
    }

    // Getter - Setter
    String getPatente(){
        return this.patente;
    }

    LocalTime getHoradeEntrada(){
        return this.horaDeEntrada;
    }

    String getTipo(){
        return this.tipo;
    }

    double getPrecio () {
        return precio;
    }

    public void setPrecio (double precio) {
        this.precio += precio;
    }

    public void setHoraEntrada(LocalTime horadeEntrada){
        this.horaDeEntrada = horadeEntrada;
    }
}
