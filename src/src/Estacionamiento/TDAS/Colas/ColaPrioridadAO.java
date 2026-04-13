package Estacionamiento.TDAS.Colas;

import Estacionamiento.Vehiculo;

public class ColaPrioridadAO implements ColaPrioridadTDA {

    class Nodo {
        Vehiculo valor;
        int prioridad;
        Nodo sig;
    }

    Nodo primero;

    public void InicializarCola() {
        primero = null;
    }

    public void AcolarPrioridad(Vehiculo x, int prioridad) {
        Nodo nuevo = new Nodo();
        nuevo.valor = x;
        nuevo.prioridad = prioridad;
        nuevo.sig = null;

        if (primero == null || prioridad > primero.prioridad) {
            nuevo.sig = primero;
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.sig != null && actual.sig.prioridad >= prioridad) {
                actual = actual.sig;
            }
            nuevo.sig = actual.sig;
            actual.sig = nuevo;
        }
    }

    public void Desacolar() {
        primero = primero.sig;
    }

    public boolean ColaVacia() {
        return primero == null;
    }

    public Vehiculo Primero() {
        return primero.valor;
    }

    public int Prioridad() {
        return primero.prioridad;
    }
}