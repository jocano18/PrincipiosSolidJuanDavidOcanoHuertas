package interfaces;

import java.time.LocalDate;

/**
 * ISP (Interface Segregation Principle): Interfaz pequeña y cohesiva.
 * Solo métodos necesarios para trabajar con turnos.
 */
public interface ITurno {
    int calcularDuracion();
    boolean esValido();
    String getTipo();
}
