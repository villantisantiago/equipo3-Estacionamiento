package Estacionamiento;

import Estacionamiento.TDAS.Conjuntos.ConjuntosTDA;

public interface estacionamientoDiccionario {
    void InicializarDiccionario();
    void Agregar(String patente, Vehiculo vehiculo);
    void Eliminar(String patente);
    Vehiculo Recuperar(String patente);
    estacionamientoConjunto Claves();
}
