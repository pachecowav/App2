ppackage Modelos;

import java.time.LocalDate;

public abstract class ElementoAgricola {
    protected String nombre;
    protected String fecha;
    protected String estado;

    public ElementoAgricola(String nombre, String fecha2, String estado) {
        this.nombre = nombre;
        this.fecha = fecha2;
        this.estado = estado;
    }

    public ElementoAgricola(String nombre2, LocalDate fechaSiembra, String estado2) {
        this.nombre = nombre2;
        this.fecha = fechaSiembra.toString();
        this.estado = estado2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public abstract String toCSV();
}
