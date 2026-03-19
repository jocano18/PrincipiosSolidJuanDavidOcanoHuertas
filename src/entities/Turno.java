package entities;

import interfaces.ITurno;

import java.time.LocalDateTime;
import java.time.Duration;

/**
 * SRP (Single Responsibility Principle): Solo modela la estructura de un turno.
 * No notifica, no asigna, no persiste. Una única razón para cambiar.
 */
public class Turno implements ITurno {
    private String id;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private String tipo;

    public Turno(String id, LocalDateTime inicio, LocalDateTime fin, String tipo) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.tipo = tipo;
    }

    @Override
    public int calcularDuracion() {
        return (int) Duration.between(inicio, fin).toHours();
    }

    @Override
    public boolean esValido() {
        return fin.isAfter(inicio) && inicio.isAfter(LocalDateTime.now().minusDays(1));
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    public String getId() { return id; }
    public LocalDateTime getInicio() { return inicio; }
    public LocalDateTime getFin() { return fin; }
}
