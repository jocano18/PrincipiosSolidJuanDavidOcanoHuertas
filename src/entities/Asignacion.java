package entities;

import interfaces.IEmpleado;
import interfaces.ITurno;

import java.time.LocalDateTime;

/**
 * SRP: Solo representa el resultado de una asignación.
 */
public class Asignacion {
    private ITurno turno;
    private IEmpleado empleado;
    private LocalDateTime fechaAsignacion;
    private String estado;

    public Asignacion(ITurno turno, IEmpleado empleado) {
        this.turno = turno;
        this.empleado = empleado;
        this.fechaAsignacion = LocalDateTime.now();
        this.estado = "Pendiente";
    }

    public void confirmar() {
        this.estado = "Confirmada";
    }

    public void cancelar(String motivo) {
        this.estado = "Cancelada: " + motivo;
    }

    public ITurno getTurno() { return turno; }
    public IEmpleado getEmpleado() { return empleado; }
    public String getEstado() { return estado; }
}
