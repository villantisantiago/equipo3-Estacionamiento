import Estacionamiento.Estacionamiento;
import java.util.Scanner;
import Estacionamiento.Vehiculo;

void main() {

    Estacionamiento estacionamiento = new Estacionamiento();
    estacionamiento.EmpezarDia();

    boolean bandera = true;
    while (bandera){
        System.out.println("1) Ingresar vehiculo");
        System.out.println("2) Retirar vehiculo");
        System.out.println("3) Lugares disponibles");
        System.out.println("4) Finalizar dia");
        System.out.println("0) Cerrar programa");
        System.out.print(" ");

        Scanner sc = new Scanner(System.in);
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
                break;
                }

            case 1:
                if (estacionamiento.HayLugar()){
                    System.out.print("Que vehiculo tiene? C/A: ");
                    String tipoVehiculo = sc.nextLine();
                    System.out.print("Ingrese la patente: ");
                    patente = sc.nextLine();
                    patente = patente.toUpperCase();
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Ingrese hora (HH:mm): ");
                    String input = sc.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime hora = LocalTime.parse(input, formatter);
                    estacionamiento.IngresarVehiculo(estacionamiento.CrearVehiculo(patente, tipoVehiculo, hora));
                }
                else{
                    System.out.print("Desea ingresar a la cola? S/N: ");
                    String ing = sc.nextLine();
                    if (ing.equals("S")){
                        System.out.print("Ingrese patente: ");
                        patente = sc.nextLine();
                        System.out.print("Que vehiculo tiene? C/A: ");
                        String TipoVehiculo = sc.nextLine();
                        patente = patente.toUpperCase();
                        Vehiculo vehiculo = new Vehiculo(patente, TipoVehiculo, LocalTime "0");
                        estacionamiento.AgregarACola(vehiculo);
                    }
                }

            case 2:
                System.out.print("Digite la patente a retirar");
                String pasarpatente = sc.nextLine();
                pasarpatente = pasarpatente.toUpperCase();
                int total = estacionamiento.SacarVehiculo(pasarpatente);
                System.out.println("El importe a pagar es de $"+ total);}
                if (estacionamiento.CantidadCola()> 0){
                    Vehiculo entra = estacionamiento.SacarCola();
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Ingrese hora (HH:mm): ");
                    String input = sc.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime hora = LocalTime.parse(input, formatter);
                    entra.setHoraEntrada(hora);
                    estacionamiento.IngresarVehiculo(entra);

            case 3:
                int cant = estacionamiento.CuantoLugar();
                System.out.println("Hay" + cant + "lugares disponibles");

            case 4:



              /*  if (estacionamiento.LugarCola()){
                    estacionamiento.SacarCola();

                }



                HayLugar();
                 CuantoLugar
                 */




    }


}
}
