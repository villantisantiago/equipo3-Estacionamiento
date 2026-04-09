package Estacionamiento;

import Estacionamiento.TDAS.Conjuntos.ConjuntosTDA;

public interface estacionamientoDiccionario {
    void InicializarDiccionario();
    void Ingresar(String patente, Vehiculo vehiculo);
    void Eliminar(String patente);
    Vehiculo Recuperar(String patente);
    ConjuntoVehiculos Claves();
}
