package Estacionamiento.TDAS.Colas;

import Estacionamiento.Vehiculo;

public interface ColaPrioridadTDA {
    void InicializarCola();
    void AcolarPrioridad(Vehiculo x, int prioridad);
    void Desacolar();
    boolean ColaVacia();
    Vehiculo Primero();
    int Prioridad();
}