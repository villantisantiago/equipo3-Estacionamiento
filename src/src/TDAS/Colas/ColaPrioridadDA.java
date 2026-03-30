package TDAS.Colas;

public class ColaPrioridadDA implements ColaPrioridadTDA{
    int[] elementos;
    int[] prioriades;
    int indice;

    public void InicializarCola() {
        elementos = new int[100];
        prioriades = new int[100];

    }

    public void AcolarPrioridad(int x, int prioridad) {
        int j = indice;
        while (j > 0 && prioriades[j-1] > prioridad){
            elementos[j] = elementos[j - 1];
            prioriades[j] = prioriades[j -1];
            j--;
        }
        elementos[j] = x;
        prioriades[j] = prioridad;
        indice ++;
    }
}
