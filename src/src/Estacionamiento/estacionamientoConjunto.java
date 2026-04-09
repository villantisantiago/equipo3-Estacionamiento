package Estacionamiento;

public interface estacionamientoConjunto {
    void InicializarConjunto();
    void Agregar(String x);
    boolean ConjuntoVacio();
    void Sacar(String x);
    boolean Pertenece(String x);
}
