package main;

import entities.*;
import interfaces.*;
import notifiers.*;
import repository.RepositorioTurnosMemoria;
import services.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaTurnos {

    public void ejecutarDemo() {
        mostrarHeader();
        
        List<IEmpleado> empleadosHospital = crearEmpleadosHospital();
        List<IEmpleado> empleadosSeguridad = crearEmpleadosSeguridad();
        List<IEmpleado> empleadosPlanta = crearEmpleadosPlanta();
        List<ITurno> turnos = crearTurnos();

        System.out.println("===============================================================");
        System.out.println("               HOSPITAL (AsignadorHospital)");
        System.out.println("===============================================================");
        ejecutarEjemplo(new AsignadorHospital(), new NotificadorEmail(), empleadosHospital, turnos);

        System.out.println("\n===============================================================");
        System.out.println("               SEGURIDAD (AsignadorSeguridad)");
        System.out.println("===============================================================");
        ejecutarEjemplo(new AsignadorSeguridad(), new NotificadorSMS(), empleadosSeguridad, turnos);

        System.out.println("\n===============================================================");
        System.out.println("               PLANTA (AsignadorPlanta)");
        System.out.println("===============================================================");
        ejecutarEjemplo(new AsignadorPlanta(), new NotificadorPush(), empleadosPlanta, turnos);

        mostrarPrincipiosSolid();
    }

    private void ejecutarEjemplo(IAsignador asignador, INotificador notificador, 
                                  List<IEmpleado> empleados, List<ITurno> turnos) {
        GestorHorario gestor = new GestorHorario(asignador, notificador, new RepositorioTurnosMemoria());
        gestor.publicarHorario(turnos, empleados);
    }

    private List<IEmpleado> crearEmpleadosHospital() {
        List<IEmpleado> empleados = new ArrayList<>();
        Empleado e1 = new Enfermero("E001", "Maria Garcia", "maria@hospital.com", "UCI");
        e1.agregarDisponibilidad(new Horario("Lunes", LocalTime.of(8, 0), LocalTime.of(16, 0)));
        empleados.add(e1);

        Empleado e2 = new Enfermero("E002", "Carlos Lopez", "carlos@hospital.com", "Pediatria");
        e2.agregarDisponibilidad(new Horario("Martes", LocalTime.of(8, 0), LocalTime.of(16, 0)));
        empleados.add(e2);

        return empleados;
    }

    private List<IEmpleado> crearEmpleadosSeguridad() {
        List<IEmpleado> empleados = new ArrayList<>();
        empleados.add(new Guardia("G001", "Pedro Sanchez", "pedro@seguridad.com", "Armado"));
        empleados.add(new Guardia("G002", "Ana Martinez", "ana@seguridad.com", "Desarmado"));
        return empleados;
    }

    private List<IEmpleado> crearEmpleadosPlanta() {
        List<IEmpleado> empleados = new ArrayList<>();
        Operario op1 = new Operario("O001", "Juan Perez", "juan@planta.com", 8);
        op1.agregarMaquina("CNC-01");
        empleados.add(op1);

        Operario op2 = new Operario("O002", "Elena Ruiz", "elena@planta.com", 12);
        op2.agregarMaquina("CNC-02");
        empleados.add(op2);

        return empleados;
    }

    private List<ITurno> crearTurnos() {
        List<ITurno> turnos = new ArrayList<>();
        turnos.add(new Turno("T001", LocalDateTime.now(), LocalDateTime.now().plusHours(8), "Manana"));
        turnos.add(new TurnoRotativo("T002", LocalDateTime.now(), LocalDateTime.now().plusHours(12), "Ciclo A"));
        turnos.add(new TurnoGuardia("T003", LocalDateTime.now(), LocalDateTime.now().plusHours(8), "Zona A"));
        return turnos;
    }

    private void mostrarHeader() {
        System.out.println("+============================================================+");
        System.out.println("|        PRINCIPIOS SOLID - SISTEMA DE GESTION DE TURNOS     |");
        System.out.println("+============================================================+\n");
    }

    private void mostrarPrincipiosSolid() {
        System.out.println("\n===============================================================");
        System.out.println("               PRINCIPIOS SOLID DEMOSTRADOS");
        System.out.println("===============================================================");
        System.out.println(
            "SRP: Turno, Empleado, GestorHorario, Asignacion tienen una unica razon para cambiar.\n" +
            "OCP: Herencia (Empleado -> Enfermero/Guardia/Operario, Notificador -> Email/SMS/Push)\n" +
            "     Composición (GestorHorario + IAsignador)\n" +
            "LSP: Todas las subclases sustituyen correctamente a sus clases base.\n" +
            "ISP: ITurno, IEmpleado, IAsignador, INotificador, IRepositorioTurnos\n" +
            "DIP: GestorHorario depende de interfaces, no de implementaciones."
        );
    }
}
