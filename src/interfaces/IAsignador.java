package interfaces;

import entities.Asignacion;

import java.util.List;

/**
 * DIP (Dependency Inversion Principle): GestorHorario depende de esta abstracción.
 * OCP (Open/Closed Principle): Para nuevo tipo de empresa, solo implementar esta interfaz.
 * Ningún código existente se modifica.
 */
public interface IAsignador {
    Asignacion asignar(ITurno turno, List<IEmpleado> empleados);
    boolean validarRestriccion(ITurno turno, IEmpleado empleado);
}
