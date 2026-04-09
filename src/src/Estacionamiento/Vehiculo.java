package Estacionamiento;

public class Vehiculo {

    // Atributos
    String tipo;
    private String patente;

    // Metodo constructor
    Vehiculo(){
        this.tipo = tipo;
        this.patente = patente;
    }

    // Getter - Setter
    void setPatente(String patente){
        this.patente = patente;
    }
}

class Auto extends Vehiculo {
    // Vehiculo obj = new Vehiculo();
}

class Camioneta extends Vehiculo{
    //
}
