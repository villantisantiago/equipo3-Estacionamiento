package Estacionamiento;

import java.util.Scanner;

public class Vehiculo {

    // Atributos
    private String patente;
    protected int valorHora;

    // Metodo constructor
    public Vehiculo(){
        // mandar al main el scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la patente:");
        this.patente = sc.nextLine();
    }

    // Getter - Setter
    public void setPatente(String patente){
        this.patente = patente;
    }

    String getPatente(){
        return this.patente;
    }
}

class Auto extends Vehiculo {
    // Vehiculo obj = new Vehiculo();
    public Auto (){
        super();
        this.valorHora = 2500 ;
    }

}

class Camioneta extends Vehiculo{
    //
    public Camioneta (){
        super();
        this.valorHora = 3500 ;
    }

}
