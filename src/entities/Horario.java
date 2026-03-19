package entities;

import java.time.LocalTime;

/**
 * SRP: Solo encapsula el rango de disponibilidad.
 */
public class Horario {
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(String diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public boolean solapaCon(Horario otro) {
        return this.horaInicio.isBefore(otro.horaFin) && otro.horaInicio.isBefore(this.horaFin);
    }

    public String getDiaSemana() { return diaSemana; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public LocalTime getHoraFin() { return horaFin; }
}
