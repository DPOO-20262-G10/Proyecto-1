package boardgamecafe.consola;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import boardgamecafe.logica.BoardCafe;
import boardgamecafe.usuarios.Administrador;

public class MainAdministrador {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BoardCafe cafe = new BoardCafe();

        System.out.println("Board Cafe - Administrador");
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if (!cafe.login(login, password)) {
            System.out.println("Credenciales incorrectas.");
            return;
        }

        if (!(cafe.getUsuarioActivo() instanceof Administrador)) {
            System.out.println("Esta interfaz es solo para administradores.");
            cafe.logout();
            return;
        }

        boolean salir = false;

        while (!salir){

            System.out.println("\n MENU ADMINISTRADOR");
            System.out.println("1. Agregar juego");
            System.out.println("2. Agregar inventario");
            System.out.println("3. Ver inventario");
            System.out.println("4. Marcar copia desaparecida");
            System.out.println("5. Crear turno");
            System.out.println("6. Modificar turno");
            System.out.println("7. Consultar turno");
            System.out.println("8. Aprobar cambio turno");
            System.out.println("9. Rechazar cambio turno");
            System.out.println("10. Aprobar sugerencia producto");
            System.out.println("11. Rechazar sugerencia producto");
            System.out.println("12. Generar reporte ventas");
            System.out.println("13. Salir");
            System.out.print("Seleccione: ");

            int opcion = leerEnteroValido(sc);

            try {

                if (opcion == 1) {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Min jugadores: ");
                    int min = leerEnteroValido(sc);
                    System.out.print("Max jugadores: ");
                    int max = leerEnteroValido(sc);
                    System.out.print("Edad minima: ");
                    int edad = leerEnteroValido(sc);
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();
                    System.out.print("Es dificil (true/false): ");
                    boolean dificil = Boolean.parseBoolean(sc.nextLine());

                    cafe.agregarJuego(nombre, new Date(), min, max, edad, categoria, dificil);
                    System.out.println("Juego agregado.");

                } else if (opcion == 2) {
                    System.out.print("Id juego: ");
                    int id = leerEnteroValido(sc);
                    System.out.print("Cantidad: ");
                    int cantidad = leerEnteroValido(sc);
                    System.out.print("Tipo(venta/prestamo): ");
                    String tipo = sc.nextLine();
                    System.out.print("Estado inicial: ");
                    String estado = sc.nextLine();

                    cafe.agregarJuegosInventario(id, cantidad, tipo, estado);
                    System.out.println("Inventario actualizado. ");

                } else if (opcion == 3) {
                    System.out.println(cafe.verInventarioCompleto());

                } else if (opcion == 4) {
                    System.out.print("Id copia: ");
                    int id = leerEnteroValido(sc);

                    cafe.marcarCopiaDesaparecida(id);
                    System.out.println("Copia marcada como desaparecida.");

                } else if (opcion == 5) {
                    System.out.print("Id empleado: ");
                    int id = leerEnteroValido(sc);
                    System.out.print("Dia: ");
                    String dia = sc.nextLine();
                    System.out.print("Hora inicio (hh:mm:ss): ");
                    Time ini = Time.valueOf(sc.nextLine());
                    System.out.print("Hora fin (hh:mm:ss): ");
                    Time fin = Time.valueOf(sc.nextLine());

                    cafe.crearTurno(id, dia, ini, fin);
                    System.out.println("Turno creado.");

                } else if (opcion == 6) {
                    System.out.print("Id empleado: ");
                    int id = leerEnteroValido(sc);
                    System.out.print("Dia: ");
                    String dia = sc.nextLine();
                    System.out.print("Hora inicio (hh:mm:ss): ");
                    Time ini = Time.valueOf(sc.nextLine());
                    System.out.print("Hora fin (hh:mm:ss): ");
                    Time fin = Time.valueOf(sc.nextLine());

                    cafe.modificarTurno(id, dia, ini, fin);
                    System.out.println("Turno modificado.");

                } else if (opcion == 7) {
                    System.out.print("Id empleado: ");
                    int id = leerEnteroValido(sc);

                    System.out.println(cafe.consultarTurno(id));

                } else if (opcion == 8) {
                    System.out.print("Id solicitud: ");
                    int id = leerEnteroValido(sc);

                    cafe.aprobarCambioTurno(id);
                    System.out.println("Solicitud aprobada.");

                } else if (opcion == 9) {
                    System.out.print("Id solicitud: ");
                    int id = leerEnteroValido(sc);

                    cafe.rechazarCambioTurno(id);
                    System.out.println("Solicitud rechazada.");

                } else if (opcion == 10) {
                    System.out.print("Id Producto: ");
                    int id = leerEnteroValido(sc);

                    cafe.aprobarSugerencia(id);
                    System.out.println("Producto aprobado.");

                } else if (opcion == 11) {
                    System.out.print("Id Producto: ");
                    int id = leerEnteroValido(sc);

                    cafe.rechazarSugerencia(id);
                    System.out.println("Producto rechazado.");

                } else if (opcion == 12) {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                    System.out.print("Fecha inicio (dd/MM/yyyy): ");
                    String Inicio = sc.nextLine();
                    Date fechaInicio = formato.parse(Inicio);

                    System.out.print("Fecha Final (dd/MM/yyyy): ");
                    String Final = sc.nextLine();
                    Date fechaFinal = formato.parse(Final);

                    System.out.print("Agrupacion (dia/mes): ");
                    String agrupacion = sc.nextLine();

                    System.out.print("Tipo (juegos/productos/todos): ");
                    String tipo = sc.nextLine();

                    System.out.println(cafe.generarReporteVentas(fechaInicio, fechaFinal, agrupacion, tipo));

                } else if (opcion == 13) {
                    salir = true;

                } else {
                    System.out.println("Opción invaida.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        cafe.guardarTodo();
        sc.close();
        System.out.println("Sesión cerrada.");
    }

    //Funcion auxiliar para validar la entrada de enteros y no tener q repetirlo
    private static int leerEnteroValido(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("No es un numero valido.");
            System.out.print("Intenta de nuevo: ");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }
}
