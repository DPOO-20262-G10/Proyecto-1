package boardgamecafe.consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import boardgamecafe.BoardCafe;
import boardgamecafe.usuarios.Empleado;
import boardgamecafe.usuarios.Mesero;

public class MainEmpleado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoardCafe cafe = new BoardCafe();

        System.out.println("Board Cafe - Empleado / Mesero");
        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (!cafe.login(login, password)) {
            System.out.println("Credenciales incorrectas o usuario no existe.");
            System.out.println("Deseas registrarte? (s/n): ");
            String resp = sc.nextLine();

            if (resp.equalsIgnoreCase("s")) {
                System.out.print("Nombre completo: ");
                String nombre = sc.nextLine();

                System.out.print("Rol (empleado / mesero): ");
                String rol = sc.nextLine();

                try {
                    cafe.registrarUsuario(nombre, login, password, rol);
                    System.out.println("Registro exitoso. Iniciando sesion...");
                    cafe.login(login, password);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error en registro: " + e.getMessage());
                    return;
                }
            } else {
                System.out.println("No se inicio sesion.");
                return;
            }
        }

        String tipoUsuario = cafe.getUsuarioActivo().getClass().getSimpleName().toLowerCase();

        if (!tipoUsuario.equals("empleado") && !tipoUsuario.equals("mesero")) {
            System.out.println("Esta interfaz es solo para empleados y meseros.");
            cafe.logout();
            return;
        }

        if (tipoUsuario.equals("empleado")) {
            menuEmpleado(sc, cafe);
        } else {
            menuMesero(sc, cafe);
        }

        cafe.guardarTodo();
        System.out.println("Sesion cerrada. Datos guardados.");
        sc.close();
    }



    private static void menuEmpleado(Scanner sc, BoardCafe cafe) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n Menu Empleado:");
            System.out.println("1. Sugerir producto cafeteria");
            System.out.println("2. Solicitar cambio de turno");
            System.out.println("3. Cerrar sesion y salir");
            System.out.print("Seleccione: ");

            int opcion = leerEnteroValido(sc);

            try {
                if (opcion == 1) {
                    sugerirProducto(sc, cafe);

                } else if (opcion == 2) {
                    solicitarCambioTurno(sc, cafe);

                } else if (opcion == 3) {
                    salir = true;

                } else {
                    System.out.println("Opcion no valida, intente de nuevo.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }



    private static void menuMesero(Scanner sc, BoardCafe cafe) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n Menu Mesero:");
            System.out.println("1. Registrar juegos dificiles");
            System.out.println("2. Cerrar sesion y salir");
            System.out.print("Seleccione: ");

            int opcion = leerEnteroValido(sc);

            try {
                if (opcion == 1) {
                    registrarJuegosDificiles(sc, cafe);

                } else if (opcion == 2) {
                    salir = true;

                } else {
                    System.out.println("Opcion no valida, intente de nuevo.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


    // ─────────────────────────────────────────────────────────────
    //  FLUJO: sugerir producto
    // ─────────────────────────────────────────────────────────────
    private static void sugerirProducto(Scanner sc, BoardCafe cafe) {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        double precio = leerDoubleValido(sc);

        System.out.print("Tipo (Bebida / Pasteleria): ");
        String tipo = sc.nextLine();

        System.out.print("Es alcoholica? (true/false): ");
        boolean alcoholica = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Es caliente? (true/false): ");
        boolean caliente = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Alergenos (separados por coma, o Enter para ninguno): ");
        String alergenosRaw = sc.nextLine();

        List<String> alergenos = new ArrayList<>();
        if (!alergenosRaw.trim().isEmpty()) {
            for (String a : alergenosRaw.split(",")) {
                alergenos.add(a.trim());
            }
        }

        cafe.sugerirProducto(nombre, precio, tipo, alcoholica, caliente, alergenos);
        System.out.println("Producto sugerido exitosamente (pendiente de aprobacion).");
    }

    
    private static void solicitarCambioTurno(Scanner sc, BoardCafe cafe) {
        System.out.print("Dia del cambio (ej: lunes): ");
        String dia = sc.nextLine();

        System.out.print("Tipo (cambio / intercambio): ");
        String tipo = sc.nextLine();

        System.out.print("ID del empleado para intercambio: ");
        int idEmpleadoIntercambio = leerEnteroValido(sc);

        cafe.solicitarCambioTurno(dia, tipo, idEmpleadoIntercambio);
        System.out.println("Solicitud de cambio de turno registrada.");
    }


    private static void registrarJuegosDificiles(Scanner sc, BoardCafe cafe) {
        System.out.print("IDs de juegos dificiles (separados por coma, ej: 3,7,12): ");
        String raw = sc.nextLine();

        List<Integer> ids = new ArrayList<>();
        for (String parte : raw.split(",")) {
            try {
                ids.add(Integer.parseInt(parte.trim()));
            } catch (NumberFormatException e) {
                System.out.println("ID invalido ignorado: " + parte.trim());
            }
        }

        if (ids.isEmpty()) {
            System.out.println("No se ingreso ningun ID valido.");
            return;
        }

        cafe.registrarJuegosDificiles(ids);
        System.out.println("Juegos dificiles registrados: " + ids);
    }


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

    private static double leerDoubleValido(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("No es un numero valido.");
            System.out.print("Intenta de nuevo: ");
            sc.next();
        }
        double numero = sc.nextDouble();
        sc.nextLine();
        return numero;
    }
}