package TDAS.Colas;

public class ColaPrioridadAO implements ColaPrioridadTDA{
    Elemento[] elementos;
    int indice;

    public void InicializarCola() {
        elementos = new Elemento[100];
        indice = 0;

    }

    public void AcolarPrioridad(int x, int prioridad) {
        int j = indice;
        while (j > 0 && elementos[j-1] > prioridad){
            elementos[j] = elementos[j - 1];
            prioriades[j] = prioriades[j -1];
            j--;
        }
        elementos[j] = x;
        prioriades[j] = prioridad;
        indice ++;
    }
}

