package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Parcela {
    private String codigo;
    private String ubicacion;
    private double tamaño;
    private List<Cultivo> cultivos;

    public Parcela(String codigo, String ubicacion, double tamaño) {
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.tamaño = tamaño;
        this.cultivos = new ArrayList<>();
    }

    public void setTamano(double tamano) {
        this.tamaño = tamano;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Parcela(String codigo2, double tam, String ubicacion2) {
        this.codigo = codigo2;
        this.tamaño = tam;
        this.ubicacion = ubicacion2;
        this.cultivos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getTamaño() {
        return tamaño;
    }

    public List<Cultivo> getCultivos() {
        return cultivos;
    }

    public void agregarCultivo(Cultivo cultivo) {
        cultivos.add(cultivo);
    }

    public void eliminarCultivo(Cultivo cultivo) {
        cultivos.remove(cultivo);
    }

    @Override
    public String toString() {
        return codigo + " - " + ubicacion + " (" + tamaño + " ha)";
    }
}
