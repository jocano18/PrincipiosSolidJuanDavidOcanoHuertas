package services;

import entities.Asignacion;
import interfaces.IAsignador;
import interfaces.INotificador;
import interfaces.IRepositorioTurnos;
import interfaces.ITurno;
import interfaces.IEmpleado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * SRP: Solo coordina el flujo de publicación del horario.
 * DIP: Depende de interfaces, no de clases concretas.
 * Inyección de dependencias via constructor.
 */
public class GestorHorario {
    private IAsignador asignador;
    private INotificador notificador;
    private IRepositorioTurnos repositorio;

    public GestorHorario(IAsignador asignador, INotificador notificador, IRepositorioTurnos repositorio) {
        this.asignador = asignador;
        this.notificador = notificador;
        this.repositorio = repositorio;
    }

    public void publicarHorario(List<ITurno> turnos, List<IEmpleado> empleados) {
        System.out.println("=== PUBLICANDO HORARIO ===");
        for (ITurno turno : turnos) {
            Asignacion asignacion = asignador.asignar(turno, empleados);
            if (asignacion != null) {
                asignacion.confirmar();
                repositorio.guardar(turno);
                notificador.notificar(asignacion);
                System.out.println("Turno publicado: " + turno.getTipo());
            }
        }
    }

    public void reprogramarTurno(ITurno turno, String motivo) {
        System.out.println("Reprogramando turno: " + turno.getTipo());
        notificador.notificarCambio(turno, motivo);
    }

    public List<Asignacion> obtenerHorarioSemanal(LocalDate semana) {
        return new ArrayList<>();
    }
}
