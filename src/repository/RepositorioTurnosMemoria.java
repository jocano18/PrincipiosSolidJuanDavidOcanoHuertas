package repository;

import interfaces.IRepositorioTurnos;
import interfaces.ITurno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DIP: Implementación concreta de IRepositorioTurnos.
 * Patrón Repository para acceso a datos en memoria.
 */
public class RepositorioTurnosMemoria implements IRepositorioTurnos {
    private Map<String, ITurno> turnos;
    private Map<String, List<ITurno>> turnosPorEmpleado;

    public RepositorioTurnosMemoria() {
        this.turnos = new HashMap<>();
        this.turnosPorEmpleado = new HashMap<>();
    }

    @Override
    public void guardar(ITurno turno) {
        turnos.put(turno.getTipo() + "_" + System.currentTimeMillis(), turno);
    }

    @Override
    public List<ITurno> buscarPorFecha(LocalDate fecha) {
        List<ITurno> resultado = new ArrayList<>();
        return resultado;
    }

    @Override
    public List<ITurno> buscarPorEmpleado(String id) {
        return turnosPorEmpleado.getOrDefault(id, new ArrayList<>());
    }
}
