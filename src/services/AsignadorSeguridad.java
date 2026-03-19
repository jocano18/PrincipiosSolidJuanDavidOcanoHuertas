package services;

import entities.Asignacion;
import entities.Guardia;
import interfaces.IAsignador;
import interfaces.IEmpleado;
import interfaces.ITurno;

import java.util.List;

/**
 * OCP: Nueva implementación de IAsignador. GestorHorario no se modifica.
 */
public class AsignadorSeguridad implements IAsignador {

    @Override
    public Asignacion asignar(ITurno turno, List<IEmpleado> empleados) {
        for (IEmpleado emp : empleados) {
            if (validarRestriccion(turno, emp) && emp instanceof Guardia) {
                return new Asignacion(turno, emp);
            }
        }
        return null;
    }

    @Override
    public boolean validarRestriccion(ITurno turno, IEmpleado empleado) {
        if (!(empleado instanceof Guardia)) {
            return false;
        }
        return verificarHabilitacion(empleado);
    }

    private boolean verificarHabilitacion(IEmpleado empleado) {
        return ((Guardia) empleado).validarCertificaciones();
    }
}
