package interfaces;

import entities.Asignacion;

/**
 * ISP: Notificador separado de IAsignador.
 * Un servicio puede notificar sin conocer la lógica de asignación.
 */
public interface INotificador {
    void notificar(Asignacion asignacion);
    void notificarCambio(ITurno turno, String motivo);
}
