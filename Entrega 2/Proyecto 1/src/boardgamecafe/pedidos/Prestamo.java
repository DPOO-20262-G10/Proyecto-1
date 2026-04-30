package boardgamecafe.pedidos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import boardgamecafe.Juegos.CopiaJuego;
import boardgamecafe.usuarios.Usuario;


public class Prestamo {

    private int idPrestamo;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean activo;
    private boolean advertenciaDificil;
    private Usuario solicitante;
    private List<CopiaJuego> copias;

    public Prestamo(int idPrestamo, boolean advertenciaDificil, Usuario solicitante) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = new Date();
        this.fechaFin = null;
        this.activo = true;
        this.advertenciaDificil = advertenciaDificil;
        this.solicitante = solicitante;
        this.copias = new ArrayList<CopiaJuego>();
    }

    public void agregarCopia(CopiaJuego copia) {
        copias.add(copia);
    }

    public void finalizarPrestamo() {
        this.activo = false;
        this.fechaFin = new Date();
    }

    public int getIdPrestamo() 
	{ 
		return idPrestamo; 
	}

    public void setIdPrestamo(int idPrestamo) 
	{ 
		this.idPrestamo = idPrestamo; 
	}

    public Date getFechaInicio() 
	{ 
		return fechaInicio; 
	}

    public void setFechaInicio(Date fechaInicio) 
	{ 
		this.fechaInicio = fechaInicio; 
	}

    public Date getFechaFin() 
	{ 
		return fechaFin; 
	}

    public void setFechaFin(Date fechaFin) 
	{ 
		this.fechaFin = fechaFin; 
	}

    public boolean isActivo() 
	{ 
		return activo; 
	}

    public void setActivo(boolean activo) 
	{ 
		this.activo = activo; 
	}

    public boolean isAdvertenciaDificil() 
	{ 
		return advertenciaDificil; 
	}

    public void setAdvertenciaDificil(boolean advertenciaDificil) 
	{ 
		this.advertenciaDificil = advertenciaDificil; 
	}

    public Usuario getSolicitante() 
	{ 
		return solicitante; 
	}

    public void setSolicitante(Usuario solicitante) 
	{ 
		this.solicitante = solicitante; 
	}

    public List<CopiaJuego> getCopias() 
	{ 
		return copias; 
	}

    public void setCopias(List<CopiaJuego> copias) 
	{ 
		this.copias = copias; 
	}
}
