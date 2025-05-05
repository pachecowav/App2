package Servicios;

import Modelos.Cultivo;
import Modelos.Parcela;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GestorParcelas {
    private List<Modelos.Parcela> parcelas;

    public static void listarParcelas(List<Parcela> parcelas) {
        for (Parcela p : parcelas) {
            System.out.println(p);
        }
    }

    public static void agregarParcela(List<Parcela> parcelas, Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Tamaño (hectáreas): ");
        double tam = Double.parseDouble(scanner.nextLine());
        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();
        parcelas.add(new Parcela(codigo, tam, ubicacion));
        System.out.println("Parcela agregada.");
    }

    public static void editarParcela(List<Parcela> parcelas, Scanner scanner) {
        listarParcelas(parcelas);
        System.out.print("Índice de la Parcela: ");
        int i = Integer.parseInt(scanner.nextLine());
        Parcela p = parcelas.get(i);
        System.out.print("Nuevo tamaño: ");
        p.setTamano(Double.parseDouble(scanner.nextLine()));
        System.out.print("Nueva ubicación: ");
        p.setUbicacion(scanner.nextLine());
        System.out.println("Parcela actualizada.");
    }

    public static void eliminarParcela(List<Parcela> parcelas, List<Cultivo> cultivos, Scanner scanner) {
        listarParcelas(parcelas);
        System.out.print("Índice a eliminar: ");
        int i = Integer.parseInt(scanner.nextLine());
        String codigo = parcelas.get(i).getCodigo();
        boolean tieneCultivos = cultivos.stream().anyMatch(c -> c.getParcela().equals(codigo));
        if (!tieneCultivos) {
            parcelas.remove(i);
            System.out.println("Parcela eliminada.");
        } else {
            System.out.println("No se puede eliminar, tiene cultivos activos.");
        }
    }

    public static void asignarCultivoAParcela(List<Parcela> parcelas, List<Cultivo> cultivos, Scanner scanner) {
        System.out.print("Índice del Cultivo: ");
        int cIndex = Integer.parseInt(scanner.nextLine());
        System.out.print("Índice de la Parcela: ");
        int pIndex = Integer.parseInt(scanner.nextLine());
        Cultivo c = cultivos.get(cIndex);
        Parcela p = parcelas.get(pIndex);
        c.setParcela(p.getCodigo());
        System.out.println("Cultivo asignado a Parcela.");
    }


    public GestorParcelas() {
        this.parcelas = new ArrayList<>();
    }

    public void agregarParcela(Parcela p) {
        parcelas.add(p);
    }

    public void eliminarParcela(Parcela p) {
        parcelas.remove(p);
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public Parcela buscarPorCodigo(String codigo) {
        for (Parcela p : parcelas) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public static List<Parcela> extraerParcelasDesdeCultivos(List<Cultivo> cultivos) {
    Map<String, Parcela> mapa = new HashMap<>();
    for (Cultivo c : cultivos) {
        String codigo = c.getParcela();
        if (!mapa.containsKey(codigo)) {
            Parcela p = new Parcela(codigo, 0.0, "");
            mapa.put(codigo, p);
        }
    }
    return new ArrayList<>(mapa.values());
}

}
