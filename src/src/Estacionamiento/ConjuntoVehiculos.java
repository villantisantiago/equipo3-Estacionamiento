package Estacionamiento;

public class ConjuntoVehiculos implements estacionamientoConjunto{
    private String[] a;
    private int cant;

    public void InicializarConjunto() {
        a = new String[100];
        cant = 0;
    }

    public void Agregar(String x) {
        if (!this.Pertenece(x)){
            a[cant] = x;
            cant++;
        }
    }

    public void Sacar(String x) {
        int i = 0;
        while (i < cant && !a[i].equals(x)) {
            i++;
        }
        if (i < cant) {
            a[i] = a[cant -1];
            cant--;
        }
    }

    public String Elegir() {
        return a[cant - 1];
    }

    public boolean Pertenece(String v) {
        int i = 0;
        while (i < cant && !a[i].equals(v)) {
            i++;
        }
        return (i < cant);
    }

    public boolean ConjuntoVacio() {
        return (cant == 0);
    }
}
