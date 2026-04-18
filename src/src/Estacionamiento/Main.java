import Estacionamiento.Estacionamiento;
import java.util.Scanner;
import Estacionamiento.Vehiculo;

void main() {

    Estacionamiento estacionamiento = new Estacionamiento();
    estacionamiento.EmpezarPrograma();
    double recaudacion = 0;
    String tipoVehiculo;
    boolean bandera = true;
    Scanner sc = new Scanner(System.in);
    while (bandera) {
        System.out.println(" ");
        System.out.println("Estacionamiento viñescos de viñas");
        System.out.println("=============================");
        System.out.println("1) Ingresar vehiculo");
        System.out.println("2) Retirar vehiculo");
        System.out.println("3) Lugares disponibles");
        System.out.println("4) Finalizar dia");
        System.out.println("5) Ver patentes actuales");
        System.out.println("0) Cerrar programa");
        System.out.println("=============================");
        System.out.print("Ingrese una opcion: ");

        int opcion = sc.nextInt();
        sc.nextLine();
        String patente;

        switch (opcion) {
            case 0:
                System.out.print("Esta seguro que desea cerrar el sistema? S/N: ");
                String opcionf = sc.nextLine();
                opcionf = opcionf.toUpperCase();
                if (opcionf.equals("S")) {
                    bandera = false;

                }
                break;
            case 1:
                if (estacionamiento.HayLugar()) {
                    do {
                        System.out.print("Que vehiculo tiene? C/A: ");
                        tipoVehiculo = sc.nextLine();
                        tipoVehiculo = tipoVehiculo.toUpperCase();
                        if (!tipoVehiculo.equals("A") && !tipoVehiculo.equals("C")) {
                            System.out.println("Error: Solo puedo ingresar A (Auto) o C (Camioneta).");
                        }
                    } while (!tipoVehiculo.equals("A") && !tipoVehiculo.equals("C"));

                    do {
                        System.out.print("Ingrese la patente: ");
                        patente = sc.nextLine();
                        patente = patente.toUpperCase();
                    } while (estacionamiento.EstaPatente(patente));

                    System.out.print("Ingrese hora (HH:mm): ");
                    String input = sc.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime hora = LocalTime.parse(input, formatter);
                    estacionamiento.IngresarVehiculo(estacionamiento.CrearVehiculo(patente, tipoVehiculo, hora));
                } else {
                    System.out.print("Desea ingresar a la cola? S/N: ");
                    String ing = sc.nextLine();
                    ing = ing.toUpperCase();
                    if (ing.equals("S")) {
                        do {
                            System.out.print("Ingrese la patente: ");
                            patente = sc.nextLine();
                            patente = patente.toUpperCase();
                            if (estacionamiento.EstaPatente(patente)){
                                System.out.println("La patente que quiere ingresar ya se encuentra en el estacionamiento, por favor ingrese nuevamente. ");
                            }
                        } while (estacionamiento.EstaPatente(patente));
                        System.out.print("Que vehiculo tiene? C/A: ");
                        String TipoVehiculo = sc.nextLine();
                        patente = patente.toUpperCase();
                        Vehiculo vehiculo = new Vehiculo(patente, TipoVehiculo, LocalTime.of(00,00));
                        estacionamiento.AgregarACola(vehiculo);
                    }

                }
                break;

            case 2:
                System.out.print("Digite la patente a retirar: ");
                String pasarpatente = sc.nextLine();
                pasarpatente = pasarpatente.toUpperCase();
                System.out.print("Ingrese hora de salida (HH:mm): ");
                String input = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime hora = LocalTime.parse(input, formatter);
                double total = estacionamiento.SacarVehiculo(pasarpatente, hora);
                System.out.println("El importe a pagar es de $" + total);
                recaudacion = recaudacion + total;
                if (estacionamiento.CantidadCola() > 0) {
                    Vehiculo entra = estacionamiento.SacarCola();
                    System.out.println("Ingresará un vehiculo de la cola");
                    System.out.print("Ingrese hora de ingreso (HH:mm): ");
                    input = sc.nextLine();
                    formatter = DateTimeFormatter.ofPattern("HH:mm");
                    hora = LocalTime.parse(input, formatter);
                    entra.setHoraEntrada(hora);
                    estacionamiento.IngresarVehiculo(entra);
                }
                break;
            case 3:
                int cant = estacionamiento.CuantoLugar();
                System.out.println("Hay " + cant + " lugares disponibles");
                break;
            case 4:
                System.out.println("la recaudacion total del dia fue de $"+ recaudacion);
                estacionamiento.FinalizarDia();
                break;
            case 5:
                estacionamiento.Patentes();
                break;
        }
    }
}

