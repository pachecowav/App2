package services;

import models.Cultivo;

import java.util.ArrayList;
import java.util.List;
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
}
