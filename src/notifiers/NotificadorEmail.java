package notifiers;

import entities.Asignacion;
import interfaces.ITurno;

/**
 * OCP: Nueva extensión sin modificar la clase base.
 */
public class NotificadorEmail extends Notificador {

    @Override
    public void notificar(Asignacion asignacion) {
        System.out.println("[EMAIL] Enviando a: " + asignacion.getEmpleado().getNombre());
        System.out.println("[EMAIL] Mensaje: " + formatearMensaje(asignacion));
    }

    @Override
    public void notificarCambio(ITurno turno, String motivo) {
        System.out.println("[EMAIL] Cambio de turno: " + turno.getTipo() + " - Motivo: " + motivo);
    }
}
