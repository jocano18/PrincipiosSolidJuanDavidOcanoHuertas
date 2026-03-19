package notifiers;

import entities.Asignacion;
import interfaces.ITurno;

/**
 * OCP: Nueva extensión para SMS.
 */
public class NotificadorSMS extends Notificador {

    @Override
    public void notificar(Asignacion asignacion) {
        System.out.println("[SMS] Enviando a: " + asignacion.getEmpleado().getNombre());
        System.out.println("[SMS] Asignado turno: " + asignacion.getTurno().getTipo());
    }

    @Override
    public void notificarCambio(ITurno turno, String motivo) {
        System.out.println("[SMS] Turno modificado: " + motivo);
    }
}
