package notifiers;

import entities.Asignacion;
import interfaces.INotificador;
import interfaces.ITurno;

/**
 * OCP (por herencia): Cerrado a modificación, abierto a extensión.
 * Nuevos canales = nueva subclase, sin tocar esta clase base.
 */
public abstract class Notificador implements INotificador {
    
    @Override
    public abstract void notificar(Asignacion asignacion);

    @Override
    public abstract void notificarCambio(ITurno turno, String motivo);

    protected String formatearMensaje(Asignacion asignacion) {
        return "Asignación: " + asignacion.getEmpleado().getNombre() + 
               " - Turno: " + asignacion.getTurno().getTipo();
    }
}
