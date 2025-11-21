// Lukas Paolo Toshisuke Cortes Alfaro 22.108.123-4 ICCI
// Cristian Harold Wilson Andreu 21.887.896-2 ICCI
package logica;

import java.util.Scanner;
import java.time.LocalDate;
import dominio.*;
import estrategias.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Sistema sistema = Sistema.getInstance();

    public static void main(String[] args) {
        // 1. Cargar los archivos 
        sistema.cargarDatos();
        
        System.out.println("=== SISTEMA GESTIÓN PROYECTOS 2035 ===");
        
        // 2. Login
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();

        Usuario logueado = sistema.login(usuario, contraseña);

        if (logueado != null) {
            System.out.println("\nBienvenido " + logueado.getUsername() + " [" + logueado.getRol() + "]");
            
            // 3. Derivar al menú correcto según rol
            if (logueado.getRol().equalsIgnoreCase("Administrador")) {
                menuAdmin();
            } else {
                menuColaborador(logueado.getUsername());
            }
        } else {
            System.out.println("Error: Credenciales incorrectas.");
        }
    }

    // --- MENÚ ADMINISTRADOR ---
    private static void menuAdmin() {
        while (true) {
            System.out.println("\n--- MENÚ ADMIN ---");
            System.out.println("1. Ver Proyectos y Tareas");
            System.out.println("2. Ordenar Tareas (Strategy)");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            
            
            try {
                int op = Integer.parseInt(sc.nextLine());
                
                switch (op) {
                    case 1: 
                        for (Proyecto p : sistema.getProyectos()) {
                            System.out.println("PROYECTO: " + p.getNombre() + " (" + p.getId() + ")");
                            for (Tarea t : p.getTareas()) {
                                System.out.println("   -> " + t);
                            }
                        }
                        break;
                        
                    case 2: // Strategy
                        System.out.println("Criterio: 1.Fecha | 2.Impacto | 3.Complejidad");
                        int crit = Integer.parseInt(sc.nextLine());
                        IEstrategiaOrdenamiento estrategia = null;
                        
                        if (crit == 1) estrategia = new OrdenPorFecha();
                        else if (crit == 2) estrategia = new OrdenPorImpacto();
                        else if (crit == 3) estrategia = new OrdenPorComplejidad();
                        
                        if (estrategia != null) {
                            for (Proyecto p : sistema.getProyectos()) {
                                System.out.println("\nOrdenando Proyecto " + p.getNombre() + ":");
                                p.ordenarTareas(estrategia);
                                for (Tarea t : p.getTareas()) System.out.println("   -> " + t);
                            }
                        }
                        break;
                        
                    case 3: return; // Salir
                    default: System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número.");
            }
        }
    }
    
 // --- MENÚ COLABORADOR ---
    private static void menuColaborador(String miUser) {
        IVisitor visitor = new AnalisisVisitor();
       
        while (true) {
            System.out.println("\n--- MENÚ COLABORADOR ---");
            System.out.println("1. Ver Mis Tareas");
            System.out.println("2. Analizar Mis Tareas (Visitor)");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            try {
                int op = Integer.parseInt(sc.nextLine());
                switch (op) {
                    case 1: // Ver mis tareas
                        boolean tieneTareas = false;
                        for (Proyecto p : sistema.getProyectos()) {
                            for (Tarea t : p.getTareas()) {
                                if (t.getResponsable().equals(miUser)) {
                                    System.out.println(p.getId() + " | " + t);
                                    tieneTareas = true;
                                }
                            }
                        }
                        if (!tieneTareas) System.out.println("No tienes tareas asignadas.");
                        break;
                       
                    case 2: // Aplicar Visitor
                        for (Proyecto p : sistema.getProyectos()) {
                            for (Tarea t : p.getTareas()) {
                                if (t.getResponsable().equals(miUser)) {
                                    System.out.print("Analizando tarea " + t.getId() + ": ");
                                    t.accept(visitor); 
                                }
                            }
                        }
                        break;
                       
                    case 3: return;
                    default: System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número.");
            }
        }
    }
}