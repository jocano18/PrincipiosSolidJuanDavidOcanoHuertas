package entities;

import java.time.LocalDateTime;

/**
 * LSP (Liskov Substitution Principle): Es sustituible por Turno sin romper el sistema.
 * SRP: Extiende Turno con comportamiento específico de rotación.
 */
public class TurnoRotativo extends Turno {
    private String cicloRotacion;
    private int semanaActual;

    public TurnoRotativo(String id, LocalDateTime inicio, LocalDateTime fin, String cicloRotacion) {
        super(id, inicio, fin, "Rotativo");
        this.cicloRotacion = cicloRotacion;
        this.semanaActual = 1;
    }

    @Override
    public int calcularDuracion() {
        return super.calcularDuracion();
    }

    public void avanzarCiclo() {
        semanaActual++;
    }

    public String getCicloRotacion() { return cicloRotacion; }
    public int getSemanaActual() { return semanaActual; }
}
