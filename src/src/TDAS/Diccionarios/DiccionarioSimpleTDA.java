package TDAS.Diccionarios;
import TDAS.Conjuntos.ConjuntosTDA;

public interface DiccionarioSimpleTDA {
    void InicializarDiccionario();
    void Agregar(int clave, int valor);
    void Eliminar(int clave);
    int Recuperar(int clave);
    ConjuntosTDA claves();
}
