package boardgamecafe.pedidos ;

public class Mesa {

    private int idMesa;
    private int numeroPersonas;
    private boolean hayNinos;
    private boolean hayJovenes;

    public Mesa(int idMesa, int numeroPersonas, boolean hayNinos, boolean hayJovenes) {
        this.idMesa = idMesa;
        this.numeroPersonas = numeroPersonas;
        this.hayNinos = hayNinos;
        this.hayJovenes = hayJovenes;
    }


    public int getIdMesa() 
    { 
        return idMesa; 
    }

    public void setIdMesa(int idMesa) 
    { 
        this.idMesa = idMesa; 
    }

    public int getNumeroPersonas() 
    { 
        return numeroPersonas; 
    }

    public void setNumeroPersonas(int numeroPersonas) 
    { 
        this.numeroPersonas = numeroPersonas; 
    }

    public boolean isHayNinos() 
    { 
        return hayNinos; 
    }

    public void setHayNinos(boolean hayNinos) 
    { 
        this.hayNinos = hayNinos; 
    }

    public boolean isHayJovenes() 
    { 
        return hayJovenes; 
    }

    public void setHayJovenes(boolean hayJovenes) 
    { 
        this.hayJovenes = hayJovenes; 
    }
}
