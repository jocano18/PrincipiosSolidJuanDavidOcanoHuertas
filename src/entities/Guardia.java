package entities;

/**
 * LSP: Guardia cumple el contrato de Empleado sin alterarlo.
 */
public class Guardia extends Empleado {
    private String nivelHabilitacion;
    private boolean portaArmas;

    public Guardia(String id, String nombre, String email, String nivelHabilitacion) {
        super(id, nombre, email);
        this.nivelHabilitacion = nivelHabilitacion;
        this.portaArmas = nivelHabilitacion.equals("Armado");
    }

    @Override
    public String getRol() {
        return "Guardia - " + nivelHabilitacion;
    }

    @Override
    public boolean validarCertificaciones() {
        return true;
    }

    public boolean isPortaArmas() { return portaArmas; }
}
