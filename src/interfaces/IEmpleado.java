package interfaces;

import entities.Horario;

import java.util.List;

/**
 * ISP: Interfaz específica para empleados.
 * Cada cliente depende solo de los métodos que necesita.
 */
public interface IEmpleado {
    String getId();
    String getNombre();
    List<Horario> getDisponibilidad();
    String getRol();
}
