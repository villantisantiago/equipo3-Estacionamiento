package Estacionamiento;

import Estacionamiento.TDAS.Conjuntos.ConjuntoA;
import Estacionamiento.TDAS.Conjuntos.ConjuntosTDA;
import Estacionamiento.TDAS.Diccionarios.DiccionarioSimpleTDA;
import Estacionamiento.TDAS.Diccionarios.Elemento;

public class DiccionarioVehiculo implements estacionamientoDiccionario {
    private class NodoClave {
        String clave;
        Vehiculo valor;
        NodoClave sigClave;
    }

    private NodoClave origen;

    public void InicializarDiccionario() {
        origen = null;
    }

    public void Agregar(String clave, Vehiculo valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null) {
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc; // Nuevo Origen
        }
        nc.valor = valor;
    }

    private NodoClave Clave2NodoClave(String clave) {
        NodoClave aux = origen; // el nodo viajero
        while (aux != null && !aux.clave.equals(clave))
            aux = aux.sigClave;
        return aux;
    }

    public void Eliminar(String clave) {
        if (origen != null) {
            if (origen.clave.equals(clave)) {
                origen = origen.sigClave;
            } else { // es algún otro
                NodoClave aux = origen;
                while (aux.sigClave != null && !aux.sigClave.clave.equals(clave))
                    aux = aux.sigClave;
                if (aux.sigClave != null)
                    aux.sigClave = aux.sigClave.sigClave;
            }
        }
    }

    public Vehiculo Recuperar(String patente) {
        NodoClave nc = Clave2NodoClave(patente);
        return nc.valor;
    }

    public estacionamientoConjunto Claves() {
        estacionamientoConjunto c = new ConjuntoVehiculos();
        c.InicializarConjunto();
        NodoClave aux = origen;
        while (aux != null) {
            c.Agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }
}