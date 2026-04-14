package boardgamecafe.usuarios;

public class Cliente extends Usuario {
    
    public int id_cliente;
    
    public Cliente(int id_cliente, String login, String password) {
        super(login, password);
        this.id_cliente = id_cliente;
    }

    



    
    @Override
    public void Iniciar_sesion(String login, String password) {}
    
    @Override
    public void Cerrar_sesion() {}
    
    @Override
    public void Agregar_favorito(int id_juego) {}
    
    @Override
    public void Eliminar_favorito(int id_juego) {}
    
    @Override
    public void Consultar_favoritos() {}
    
    public void Tomar_mesa(int numero_personas, boolean hay_ninos, boolean hay_jovenes) {}
    
    public void Solicitar_prestamo(int id_juego1, int id_juego2, int id_mesa) {}
    
    public void Devolver_juego(int id_prestamo) {}
    
    public void Comprar_juego(int id_juego, int cantidad) {}
    
    public void Usar_puntos(int puntos) {}
    
    public void Comprar_producto(int id_producto, int cantidad, double propina) {}
    
    public void Ver_alergenos(int id_producto) {}
    
    public void Consultar_historial_compras() {}
}
