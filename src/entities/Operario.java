package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * LSP: Operario también sustituye a Empleado sin sorpresas.
 */
public class Operario extends Empleado {
    private List<String> maquinasHabilitadas;
    private int turnoMaxHoras;

    public Operario(String id, String nombre, String email, int turnoMaxHoras) {
        super(id, nombre, email);
        this.maquinasHabilitadas = new ArrayList<>();
        this.turnoMaxHoras = turnoMaxHoras;
    }

    @Override
    public String getRol() {
        return "Operario";
    }

    @Override
    public boolean validarCertificaciones() {
        return true;
    }

    public void agregarMaquina(String maquina) {
        maquinasHabilitadas.add(maquina);
    }

    public int getTurnoMaxHoras() { return turnoMaxHoras; }
}
