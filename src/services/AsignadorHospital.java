package services;

import entities.Asignacion;
import entities.Enfermero;
import entities.Horario;
import entities.Turno;
import interfaces.IAsignador;
import interfaces.IEmpleado;
import interfaces.ITurno;

import java.time.LocalTime;
import java.util.List;

/**
 * OCP (por composición): GestorHorario no cambia al agregar nuevo tipo de empresa.
 * Para hospital, seguridad o planta = se inyecta un IAsignador diferente.
 */
public class AsignadorHospital implements IAsignador {
    private int ratioMinimo = 3;

    @Override
    public Asignacion asignar(ITurno turno, List<IEmpleado> empleados) {
        for (IEmpleado emp : empleados) {
            if (validarRestriccion(turno, emp) && emp instanceof Enfermero) {
                return new Asignacion(turno, emp);
            }
        }
        return null;
    }

    @Override
    public boolean validarRestriccion(ITurno turno, IEmpleado empleado) {
        if (!(empleado instanceof Enfermero enfermero)) {
            return false;
        }
        if (!enfermero.validarCertificaciones()) {
            return false;
        }
        return verificarEspecialidad(turno, enfermero) && verificarDescanso(empleado);
    }

    private boolean verificarEspecialidad(ITurno turno, Enfermero emp) {
        return true;
    }

    private boolean verificarDescanso(IEmpleado emp) {
        for (Horario h : emp.getDisponibilidad()) {
            if (h.getHoraFin().isAfter(LocalTime.of(22, 0))) {
                return false;
            }
        }
        return true;
    }
}
