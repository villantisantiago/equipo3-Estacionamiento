package Estacionamiento.TDAS.Colas;

import Estacionamiento.Vehiculo;

public interface ColaTDA {
    void InicializarCola();
    void Acolar(Vehiculo x);
    void Desacolar();
  //  boolean ColaVacia();
    Vehiculo Primero();
}