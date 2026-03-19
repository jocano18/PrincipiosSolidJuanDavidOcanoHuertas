package main;

import entities.*;
import interfaces.*;
import notifiers.*;
import repository.RepositorioTurnosMemoria;
import services.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SistemaTurnos sistema = new SistemaTurnos();
        sistema.ejecutarDemo();
    }
}
