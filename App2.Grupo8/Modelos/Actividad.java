package Modelos;

import java.time.LocalDate;

public class Actividad {
    private String tipo;
    private LocalDate fecha;
    private boolean completada;

    public Actividad(String tipo, LocalDate fecha) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.completada = false;
    }

    public Actividad(String tipo2, String fecha2) {
        this.tipo = tipo2;
        this.fecha = LocalDate.parse(fecha2);
        this.completada = false;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void completar() {
        this.completada = true;
    }

    @Override
    public String toString() {
        return tipo + ":" + fecha + (completada ? ":COMPLETADA" : "");
    }

    public static Actividad fromString(String s) {
        String[] parts = s.split(":");
        Actividad act = new Actividad(parts[0], LocalDate.parse(parts[1]));
        if (parts.length > 2 && parts[2].equals("COMPLETADA")) {
            act.completar();
        }
        return act;
    }
    public String aCSV() {
        return "actividad_csv_representation";
    }
    public void setCompletada(boolean b) {
        throw new UnsupportedOperationException("Unimplemented method 'setCompletada'");
    }
}
