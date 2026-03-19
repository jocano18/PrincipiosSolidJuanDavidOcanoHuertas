package entities;

import interfaces.IEmpleado;
import interfaces.ITurno;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * SRP: Solo modela datos del empleado. Una única razón para cambiar.
 * OCP (por herencia): Subclases especializan comportamiento sin modificar esta clase base.
 */
public abstract class Empleado implements IEmpleado {
    protected String id;
    protected String nombre;
    protected String email;
    protected List<Horario> disponibilidad;

    public Empleado(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.disponibilidad = new ArrayList<>();
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public List<Horario> getDisponibilidad() { return disponibilidad; }

    @Override
    public abstract String getRol();

    public abstract boolean validarCertificaciones();

    public void agregarDisponibilidad(Horario horario) {
        disponibilidad.add(horario);
    }
}
