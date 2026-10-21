package tiendacafeteria;

import java.util.Date;

public class TransaccionCafeteria extends Transaccion {

    private static double impuestoConsumo = 0.08;

    public TransaccionCafeteria() {
    }

    public TransaccionCafeteria(Date fecha) {
        super(fecha);
    }

    public static double getImpuestoConsumo() {
        return impuestoConsumo;
    }

    public static void setImpuestoConsumo(double impuestoConsumo) {
        TransaccionCafeteria.impuestoConsumo = impuestoConsumo;
    }

}
