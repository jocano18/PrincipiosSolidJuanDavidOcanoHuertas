package entities;

/**
 * LSP: Reemplaza a Empleado donde IEmpleado es requerido.
 * OCP herencia: Empleado cerrado, Enfermero lo extiende.
 */
public class Enfermero extends Empleado {
    private String especialidad;
    private boolean licenciaActiva;

    public Enfermero(String id, String nombre, String email, String especialidad) {
        super(id, nombre, email);
        this.especialidad = especialidad;
        this.licenciaActiva = true;
    }

    @Override
    public String getRol() {
        return "Enfermero - " + especialidad;
    }

    @Override
    public boolean validarCertificaciones() {
        return licenciaActiva;
    }

    public String getEspecialidad() { return especialidad; }
}
