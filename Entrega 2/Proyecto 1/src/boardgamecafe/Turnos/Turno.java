package boardgamecafe.Turnos;

import java.sql.Time;


public class Turno {

    private int idTurno;
    private String diaSemana;
    private Time horaInicio;
    private Time horaFinal;

    public Turno(int idTurno, String diaSemana, Time horaInicio, Time horaFinal) {
        this.idTurno = idTurno;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public int getIdTurno() 
	{ 
		return idTurno; 
	}

    public void setIdTurno(int idTurno) 
	{ 
		this.idTurno = idTurno; 
	}

    public String getDiaSemana() 
	{ 
		return diaSemana; 
	}

    public void setDiaSemana(String diaSemana) 
	{ 
		this.diaSemana = diaSemana; 
	}

    public Time getHoraInicio() 
	{ 
		return horaInicio; 
	}

    public void setHoraInicio(Time horaInicio) 
	{ 
		this.horaInicio = horaInicio; 
	}

    public Time getHoraFinal() 
	{ 
		return horaFinal; 
	}

    public void setHoraFinal(Time horaFinal) 
	{ 
		this.horaFinal = horaFinal; 
	}
}
