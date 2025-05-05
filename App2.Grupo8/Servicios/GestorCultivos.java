package Servicios;

import Modelos.Actividad;
import Modelos.Cultivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GestorCultivos {
    private List<Cultivo> cultivos;

    public GestorCultivos() {
        this.cultivos = new ArrayList<>();
    }

    public void agregarCultivo(Cultivo c) {
        cultivos.add(c);
    }

    public void eliminarCultivo(Cultivo c) {
        cultivos.remove(c);
    }

    public List<Cultivo> getCultivos() {
        return cultivos;
    }

    public List<Cultivo> buscarPorNombre(String nombre) {
        return cultivos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }

    public List<Cultivo> buscarPorVariedad(String variedad) {
        return cultivos.stream()
                .filter(c -> c.getVariedad().equalsIgnoreCase(variedad))
                .collect(Collectors.toList());
    }

    public List<Cultivo> filtrarPorEstado(String estado) {
        return cultivos.stream()
                .filter(c -> c.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public void limpiar() {
        cultivos.clear();
    }

    public static void listarCultivos(List<Cultivo> cultivos) {
        for (Cultivo c : cultivos) {
            System.out.println(c);
        }
    }

    public static void crearCultivo(List<Cultivo> cultivos, Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Variedad: ");
        String variedad = scanner.nextLine();
        System.out.print("Superficie: ");
        double superficie = Double.parseDouble(scanner.nextLine());
        System.out.print("Parcela: ");
        String parcela = scanner.nextLine();
        System.out.print("Fecha de siembra (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        Cultivo nuevo = new Cultivo(nombre, variedad, superficie, parcela, fecha, estado);
        cultivos.add(nuevo);
        System.out.println("Cultivo agregado.");
    }

    public static void editarCultivo(List<Cultivo> cultivos, Scanner scanner) {
        listarCultivos(cultivos);
        System.out.print("Seleccione el índice del Cultivo a editar: ");
        int i = Integer.parseInt(scanner.nextLine());
        Cultivo c = cultivos.get(i);
        System.out.print("Nuevo nombre: ");
        c.setNombre(scanner.nextLine());
        System.out.print("Nueva variedad: ");
        c.setVariedad(scanner.nextLine());
        System.out.print("Nueva superficie: ");
        c.setSuperficie(Double.parseDouble(scanner.nextLine()));
        System.out.print("Nueva parcela: ");
        c.setCodigoParcela(scanner.nextLine());
        System.out.print("Nueva fecha de siembra: ");
        c.setFecha(scanner.nextLine());
        System.out.print("Nuevo estado: ");
        c.setEstado(scanner.nextLine());
        System.out.println("Cultivo actualizado.");
    }

    public static void eliminarCultivo(List<Cultivo> cultivos, Scanner scanner) {
        listarCultivos(cultivos);
        System.out.print("Índice del Cultivo a eliminar: ");
        int i = Integer.parseInt(scanner.nextLine());
        Cultivo c = cultivos.get(i);
        if (c.getActividades().isEmpty()) {
            cultivos.remove(i);
            System.out.println("Cultivo eliminado.");
        } else {
            System.out.println("No se puede eliminar, tiene actividades pendientes.");
        }
    }

    public static void registrarActividad(List<Cultivo> cultivos, Scanner scanner) {
        listarCultivos(cultivos);
        System.out.print("Índice del Cultivo: ");
        int i = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo de Actividad: ");
        String tipo = scanner.nextLine();
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        cultivos.get(i).agregarActividad(new Actividad(tipo, fecha));
    }

    public static void listarActividades(List<Cultivo> cultivos, Scanner scanner) {
        listarCultivos(cultivos);
        System.out.print("Índice del Cultivo: ");
        int i = Integer.parseInt(scanner.nextLine());
        Cultivo c = cultivos.get(i);
        for (Actividad a : c.getActividades()) {
            System.out.println(a);
        }
    }

    public static void eliminarActividad(List<Cultivo> cultivos, Scanner scanner) {
        listarCultivos(cultivos);
        System.out.print("Índice del Cultivo: ");
        int i = Integer.parseInt(scanner.nextLine());
        Cultivo c = cultivos.get(i);
        for (int j = 0; j < c.getActividades().size(); j++) {
            System.out.println(j + ": " + c.getActividades().get(j));
        }
        System.out.print("Índice de Actividad a eliminar: ");
        int actIndex = Integer.parseInt(scanner.nextLine());
        c.getActividades().remove(actIndex);
        System.out.println("Actividad eliminada.");
    }

    public static void marcarActividadComoCompletada(List<Cultivo> cultivos, Scanner scanner) {
        listarCultivos(cultivos);
        System.out.print("Índice del Cultivo: ");
        int i = Integer.parseInt(scanner.nextLine());
        Cultivo c = cultivos.get(i);
        for (int j = 0; j < c.getActividades().size(); j++) {
            System.out.println(j + ": " + c.getActividades().get(j));
        }
        System.out.print("Índice de Actividad completada: ");
        int j = Integer.parseInt(scanner.nextLine());
        c.getActividades().get(j).setCompletada(true);
        System.out.println("Actividad marcada como completada.");
    }

    public static void buscarCultivos(List<Cultivo> cultivos, Scanner scanner) {
        System.out.print("Nombre o variedad: ");
        String query = scanner.nextLine().toLowerCase();
        for (Cultivo c : cultivos) {
            if (c.getNombre().toLowerCase().contains(query) || c.getVariedad().toLowerCase().contains(query)) {
                System.out.println(c);
            }
        }
    }

    public static void reporteCultivos(List<Cultivo> cultivos) {
        for (Cultivo c : cultivos) {
            System.out.println(c.getNombre() + " - Estado: " + c.getEstado());
        }
    }
}

    }
}
