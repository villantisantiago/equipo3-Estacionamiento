package Estacionamiento;

public class ConjuntoVehiculos implements estacionamientoConjunto{
    private String[] a;
    private int cant;

    public void InicializarConjunto() {
        a = new String[100];
        cant = 0;
    }

    public void Agregar(String x) {
        String patenteMayus = x.toUpperCase();
        if (!this.Pertenece(patenteMayus)) {
            a[cant] = patenteMayus;
            cant++;
        }
    }

    public void Sacar(String x) {
        String patenteMayus = x.toUpperCase();
        for (int i = 0; i < cant; i++) {
            if (a[i].equals(patenteMayus)) {
                a[i] = a[cant - 1];
                cant--;
                return;
            }
        }
    }

    public boolean Pertenece(String x) {
        String patenteMayus = x.toUpperCase();
        int i = 0;
        while (i < cant && !a[i].equals(patenteMayus)) {
            i++;
        }
        return (i < cant);
    }

    public boolean ConjuntoVacio() {
        return (cant == 0);
    }
}
