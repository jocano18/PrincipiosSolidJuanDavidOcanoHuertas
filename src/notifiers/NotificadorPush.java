package notifiers;

import entities.Asignacion;
import interfaces.ITurno;

/**
 * OCP: Nueva extensión para notificaciones push.
 */
public class NotificadorPush extends Notificador {

    @Override
    public void notificar(Asignacion asignacion) {
        System.out.println("[PUSH] Notificando a: " + asignacion.getEmpleado().getNombre());
        System.out.println("[PUSH] " + formatearMensaje(asignacion));
    }

    @Override
    public void notificarCambio(ITurno turno, String motivo) {
        System.out.println("[PUSH] Actualización: " + motivo);
    }
}
