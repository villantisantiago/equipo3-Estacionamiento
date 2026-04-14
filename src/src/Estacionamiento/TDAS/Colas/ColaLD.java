package Estacionamiento.TDAS.Colas;

import Estacionamiento.Vehiculo;

public class ColaLD implements ColaTDA {

    class Nodo {
        Vehiculo info;
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    public void Acolar(Vehiculo x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = null;
        if (ultimo != null) // cola no vacía
            ultimo.sig = nuevo;
        ultimo = nuevo;
        if (primero == null) // la cola estaba vacía
            primero = ultimo;
    }

    public void Desacolar() {
        primero = primero.sig;
        if (primero == null) // la cola quedó vacía
            ultimo = null;
    }

  //  public boolean ColaVacia() {
  //      return ultimo == null;
  //  }

    public Vehiculo Primero() {
        return primero.info;
    }
}