package partido;

public class Eraqueta extends EstadisticaJugador {

    private int sets;
    private int games_ganados;
    private int aces;
    private int errores_nf;

    public Eraqueta() {
    }

    public Eraqueta(int sets, int games_ganados, int aces, int errores_nf) {
        this.sets = sets;
        this.games_ganados = games_ganados;
        this.aces = aces;
        this.errores_nf = errores_nf;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getGames_ganados() {
        return games_ganados;
    }

    public void setGames_ganados(int games_ganados) {
        this.games_ganados = games_ganados;
    }

    public int getAces() {
        return aces;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    public int getErrores_nf() {
        return errores_nf;
    }

    public void setErrores_nf(int errores_nf) {
        this.errores_nf = errores_nf;
    }

}
