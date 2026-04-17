package Estacionamiento;

public interface estacionamientoConjunto {
    void InicializarConjunto();
    void Agregar(String x);
    boolean ConjuntoVacio();
    void Sacar(String x);
    String Elegir();
    boolean Pertenece(String x);
}
