package boardgamecafe.usuarios;

public class Empleado extends Usuario{

	public int id_empleado;
    public boolean en_turno;
    public String codigo_descuento;
    
    public Empleado(int id_empleado, String login, String password) {
        super(login, password);
        this.id_empleado = id_empleado;
        this.en_turno = false;
        this.codigo_descuento = "";
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
    
    public void Consultar_turno_semanal() {}
    
    public void Solicitar_cambio_turno(String cambio_dia, String tipo, int id_empleado_intercambio) {}
    
    public void Sugerir_producto(String nombre, double precio, String tipo, boolean alcoholica, boolean caliente, List<String> alergenos) {}
}

