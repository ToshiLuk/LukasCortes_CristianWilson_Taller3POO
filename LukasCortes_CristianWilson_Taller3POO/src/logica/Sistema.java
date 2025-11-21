package logica;

import dominio.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Sistema {
    private static Sistema instancia;
    private List<Usuario> usuarios;
    private List<Proyecto> proyectos;

    private Sistema() {
        usuarios = new ArrayList<>();
        proyectos = new ArrayList<>();
    }

    public static Sistema getInstance() {
        if (instancia == null) instancia = new Sistema();
        return instancia;
    }

    public void cargarDatos() {
        cargarUsuarios();
        cargarProyectos();
        cargarTareas();
    }

    private void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split("\\|");
                if (d.length >= 2) {
                    String rol = (d.length > 2) ? d[2] : "Colaborador"; // Default
                    if (rol.equalsIgnoreCase("Administrador")) 
                        usuarios.add(new Administrador(d[0], d[1]));
                    else 
                        usuarios.add(new Colaborador(d[0], d[1]));
                }
            }
        } catch (IOException e) { System.out.println("Error usuarios: " + e.getMessage()); }
    }

    private void cargarProyectos() {
        try (BufferedReader br = new BufferedReader(new FileReader("proyectos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split("\\|");
                if (d.length >= 3) proyectos.add(new Proyecto(d[0], d[1], d[2]));
            }
        } catch (IOException e) { System.out.println("Error proyectos"); }
    }

    private void cargarTareas() {
        try (BufferedReader br = new BufferedReader(new FileReader("tareas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split("\\|");
                if (d.length >= 8) {
                    
                    Tarea t = TareaFactory.crearTarea(d[2], d[0], d[1], d[3], d[4], d[5], d[6], LocalDate.parse(d[7]));

                    for (Proyecto p : proyectos) {
                        if (p.getId().equals(d[0])) {
                            p.agregarTarea(t);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) { System.out.println("Error tareas: " + e.getMessage()); }
    }

    public Usuario login(String usuario, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(usuario) && u.getPassword().equals(contraseña)) return u;
        }
        return null;
    }
    
    public List<Proyecto> getProyectos() { return proyectos; }
}