package entities;

import java.time.LocalDateTime;

/**
 * LSP: También sustituye a Turno correctamente.
 */
public class TurnoGuardia extends Turno {
    private String zonaVigilancia;
    private int nivelAlerta;

    public TurnoGuardia(String id, LocalDateTime inicio, LocalDateTime fin, String zona) {
        super(id, inicio, fin, "Guardia");
        this.zonaVigilancia = zona;
        this.nivelAlerta = 1;
    }

    @Override
    public int calcularDuracion() {
        return super.calcularDuracion();
    }

    @Override
    public String getTipo() {
        return "Guardia - " + zonaVigilancia;
    }

    public String getZonaVigilancia() { return zonaVigilancia; }
    public int getNivelAlerta() { return nivelAlerta; }
}
