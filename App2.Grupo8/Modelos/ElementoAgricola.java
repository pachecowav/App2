package models;

import java.time.LocalDate;

public abstract class ElementoAgricola {
    protected String nombre;
    protected LocalDate fecha;
    protected String estado;

    public ElementoAgricola(String nombre, LocalDate fecha, String estado) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public abstract String toCSV();
}
