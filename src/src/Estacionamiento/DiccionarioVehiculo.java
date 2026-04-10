package Estacionamiento;

import Estacionamiento.TDAS.Conjuntos.ConjuntoA;
import Estacionamiento.TDAS.Conjuntos.ConjuntosTDA;
import Estacionamiento.TDAS.Diccionarios.DiccionarioSimpleTDA;
import Estacionamiento.TDAS.Diccionarios.Elemento;

public class DiccionarioVehiculo implements estacionamientoDiccionario {
    private Elemento[] elementos;
    private int cant;

    public void InicializarDiccionario() {
        elementos = new Elemento[100];
        cant = 0;
    }

    private int Clave2Ind(String patente) {
        int i = cant - 1;
        while (i >= 0 && elementos[i].clave.equals(patente))
            i--;
        return i;
    }

    public void Ingresar(String patente, Vehiculo obj){
        int pos = Clave2Ind(patente);
        if (pos == -1){ // La patente no se encuentra y no existe
            pos = cant; // Nueva Entrada
            elementos[pos] = new Elemento();
            elementos[pos].clave = patente;
            cant ++;
        }
        elementos[pos].valor = obj;
    }

    public void Eliminar(String Patente){
        int pos = Clave2Ind(Patente);
        if (pos != -1){
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    public Vehiculo Recuperar(String patente){
        int pos = Clave2Ind(patente);
        return elementos[pos].valor;
    }

    public ConjuntoVehiculos Claves(){
        ConjuntoVehiculos c = new ConjuntoVehiculos();
        c.InicializarConjunto();
        for (int i = 0; i < cant; i++)
            c.Agregar(elementos[i].clave);
        return c;
    }

    public boolean Estalleno() {
        if (cant == elementos.length) {
            return true;
        } else {
            return false;
        }
    }
}
