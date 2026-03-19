package services;

import entities.Asignacion;
import entities.Operario;
import entities.Turno;
import interfaces.IAsignador;
import interfaces.IEmpleado;
import interfaces.ITurno;

import java.util.List;

/**
 * OCP: Nueva implementación para planta de producción.
 */
public class AsignadorPlanta implements IAsignador {
    private int maxHorasSemanales = 40;

    @Override
    public Asignacion asignar(ITurno turno, List<IEmpleado> empleados) {
        for (IEmpleado emp : empleados) {
            if (validarRestriccion(turno, emp) && emp instanceof Operario) {
                return new Asignacion(turno, emp);
            }
        }
        return null;
    }

    @Override
    public boolean validarRestriccion(ITurno turno, IEmpleado empleado) {
        if (!(empleado instanceof Operario)) {
            return false;
        }
        Operario op = (Operario) empleado;
        if (turno.calcularDuracion() > op.getTurnoMaxHoras()) {
            return false;
        }
        return verificarMaquinas(turno, op);
    }

    private boolean verificarMaquinas(ITurno turno, Operario op) {
        return true;
    }
}
