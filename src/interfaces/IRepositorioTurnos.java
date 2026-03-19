package interfaces;

import java.time.LocalDate;
import java.util.List;

/**
 * DIP: Los servicios dependen de esta abstracción, no de una base de datos concreta.
 * Patrón Repository para persistencia.
 */
public interface IRepositorioTurnos {
    void guardar(ITurno turno);
    List<ITurno> buscarPorFecha(LocalDate fecha);
    List<ITurno> buscarPorEmpleado(String id);
}
