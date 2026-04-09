package Estacionamiento;
import java.time.Duration;
import java.time.LocalDateTime;

public class Estadia {
    //atributos
    private LocalDateTime entrada;
    private LocalDateTime salida;

    private Duration duracionEstadia = Duration.between(entrada, salida);
    private long horas = duracionEstadia.toHours(); // Se calcula la diferencia de tiempos con la salida y entrada para
    //saber el tiempo total en el estacionamiento

    // Metodo constructor
    Estadia(){

    }

    // Getters - Setters
    long getDuracionEstadia(){
        return horas;
    }

    void setEntrada(LocalDateTime entrada){
        this.entrada = entrada;
    }

    void setSalida(LocalDateTime salida){
        this.salida = salida;
    }
}
