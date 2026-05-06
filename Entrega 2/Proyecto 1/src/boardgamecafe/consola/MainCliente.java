package boardgamecafe.consola;

import java.util.Scanner;
import boardgamecafe.BoardCafe;

public class MainCliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoardCafe cafe = new BoardCafe();

        System.out.println("Board Cafe - cliente");
        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (!cafe.login(login, password)) {
            System.out.println("Tus credenciales son incorrectas o tu usuario no existe.");
            System.out.println("Quieres registrarse? (s,n): ");
            String resp = sc.nextLine();

            if (resp.equalsIgnoreCase("s")) 
            {
                System.out.print("Nombre completo: ");
                String nombre = sc.nextLine();

                try {
                    cafe.registrarUsuario(nombre, login, password, "cliente");
                    System.out.println("Registro exitoso, Iniciando sesion");
                    cafe.login(login, password);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error en registro: " + e.getMessage());
                    return;
                }
            } 
            else
            {
                System.out.println("No se inicio sesion.");
                return;
            }
        }

        


        if (!cafe.getUsuarioActivo().getClass().getSimpleName().equalsIgnoreCase("Cliente")) 
        {
            System.out.println("Esta interfaz es solo para clientes.");
            cafe.logout();
            return;
        }


        boolean salir = false;
        while (!salir) {
            System.out.println("\n Menu Cliente:");
            System.out.println("1. Ver catalogo de juegos");
            System.out.println("2. Tomar mesa");
            System.out.println("3. Solicitar prestamo");
            System.out.println("4. Devolver juego");
            System.out.println("5. Comprar juego");
            System.out.println("6. Comprar producto cafeteria");
            System.out.println("7. Usar puntos de fidelidad");
            System.out.println("8. Ver historial de compras");
            System.out.println("9. Ver favoritos / agregar / eliminar favorito");
            System.out.println("10. Ver torneos disponibles");
            System.out.println("11. Inscribirse a torneo");
            System.out.println("12. Desinscribirse de torneo");
            System.out.println("13. Cerrar sesion y salir");
            System.out.print("Seleccione: ");

            int opcion = leerEnteroValido(sc);

            try {
                if (opcion == 1) 
                {
                    System.out.println(cafe.consultarCatalogo());
                } 
                else if (opcion == 2) 
                {
                    System.out.print("Personas en la mesa: ");
                    int cant = leerEnteroValido(sc);

                    System.out.print("Hay ninos? (true,false): ");
                    boolean ninos = Boolean.parseBoolean(sc.nextLine());
                    System.out.print("Hay jovenes? (true,false): ");

                    boolean jovenes = Boolean.parseBoolean(sc.nextLine());
                    cafe.tomarMesa(cant, ninos, jovenes);
                    System.out.println("Mesa tomada exitosamente.");
                } 
                else if (opcion == 3) 
                {
                    System.out.print("ID del juego 1 (0 si no): ");
                    int idJ1 = leerEnteroValido(sc);

                    System.out.print("ID del juego 2 (0 si no): ");
                    int idJ2 = leerEnteroValido(sc);
                    System.out.print("ID de la mesa: ");
                    int idMesa = leerEnteroValido(sc);

                    cafe.solicitarPrestamo(idJ1, idJ2, idMesa);
                    System.out.println("Prestamo registrado.");
                } 
                else if (opcion == 4) 
                {
                    System.out.print("ID del prestamo a devolver: ");
                    int idDev = leerEnteroValido(sc);
                    cafe.devolverJuego(idDev);
                    System.out.println("Juego devuelto.");

                } 
                else if (opcion == 5) 
                {
                    System.out.print("ID del juego a comprar: ");
                    int idComp = leerEnteroValido(sc);
                    System.out.print("Cantidad: ");
                    int cantComp = leerEnteroValido(sc);

                    cafe.comprarJuego(idComp, cantComp);
                    System.out.println("Juego comprado exitosamente.");
                } 
                else if (opcion == 6) 
                {
                    System.out.print("ID del producto: ");
                    int idProd = leerEnteroValido(sc);
                    System.out.print("Cantidad: ");
                    int cantProd = leerEnteroValido(sc);
                    System.out.print("Propina: ");
                    
                    double propina = Double.parseDouble(sc.nextLine());
                    cafe.crearPedido(idProd, cantProd, propina);
                    System.out.println("Pedido registrado.");
                
                } 
                else if (opcion == 7) 
                {
                    System.out.print("ID de la Compra o Pedido: ");
                    int idCP = leerEnteroValido(sc);
                    System.out.print("Cantidad de puntos a usar: ");

                    int pts = leerEnteroValido(sc);
                    cafe.usarPuntosFidelidad(pts, idCP);
                    System.out.println("Puntos de fidelidad aplicados.");
                
                } 
                else if (opcion == 8) 
                {
                    System.out.println("Compras: " + cafe.consultarHistorialCompras().size());
                    System.out.println("Pedidos: " + cafe.consultarHistorialPedidos().size());
                } 
                else if (opcion == 9) 
                {
                    System.out.print("(1. Ver) (2. Agregar)  (3. Eliminar)");
                    int sub = leerEnteroValido(sc);
                    if (sub == 1) {
                        System.out.println("Favoritos: " + cafe.consultarFavoritos());
                    } else if (sub == 2) {
                        System.out.print("ID juego: ");
                        cafe.agregarFavorito(leerEnteroValido(sc));
                        System.out.println("Agregado.");
                    } else if (sub == 3) {
                        System.out.print("ID juego: ");
                        cafe.eliminarFavorito(leerEnteroValido(sc));
                        System.out.println("Eliminado");
                    }
                } 
                else if (opcion == 10) 
                {
                    for (boardgamecafe.Torneos.Torneo t : cafe.consultarTorneos()) {
                        System.out.println(t.getIdTorneo() + " - " + t.getNombre() + " (" + t.getTipo() + ")");
                    }
                } 
                else if (opcion == 11) 
                {
                    System.out.print("ID Torneo: ");
                    int idT = leerEnteroValido(sc);
                    System.out.print("Cantidad participantes: ");
                    int cantT = leerEnteroValido(sc);

                    cafe.inscribirseATorneo(idT, cantT);
                    System.out.println("Inscrito exitosamente.");
                } 
                else if (opcion == 12) 
                {
                    System.out.print("Ingresa el ID Torneo a desinscribirse: ");

                    cafe.desinscribirseATorneo(leerEnteroValido(sc));
                    System.out.println("Desinscripcion exitosa.");
                } 
                else if (opcion == 13) 
                {
                    salir = true;
                } 
                else 
                {
                    System.out.println("Opcion no valida intente de nuevo.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        cafe.guardarTodo();
        System.out.println("Sesion cerrada. Datos guardados.");
        sc.close();
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


