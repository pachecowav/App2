package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Cultivo extends ElementoAgricola {
    private String variedad;
    private double superficie;
    private String codigoParcela;
    private List<Actividad> actividades;
    private String parcela;
    private String nombre;
    private String tipo;             // ← Este probablemente falta
    private String fechaSiembra;
    private int duracionDias;
    private String ubicacion;
    


    public Cultivo(String nombre, String variedad, double superficie, String codigoParcela, String fecha, String estado) {
        super(nombre, fecha, estado);
        this.variedad = variedad;
        this.superficie = superficie;
        this.codigoParcela = codigoParcela;
        this.actividades = new ArrayList<>();
    }

    public Cultivo(String nombre, String variedad2, double superficie2, String codigoParcela2, LocalDate fecha, String estado) {
        super(nombre, fecha.toString(), estado); // Llama al constructor de la clase padre
        this.superficie = superficie2;
        this.codigoParcela = codigoParcela2;
        this.actividades = new ArrayList<>();
    }

    public String getVariedad() {
        return variedad;
    }

    public double getSuperficie() {
        return superficie;
    }

    public String getCodigoParcela() {
        return codigoParcela;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setCodigoParcela(String codigoParcela) {
        this.codigoParcela = codigoParcela;
    }

    public void agregarActividad(Actividad a) {
        actividades.add(a);
    }

    @Override
    public String toCSV() {
        String actStr = actividades.stream()
            .map(Actividad::toString)
            .collect(Collectors.joining("\",\"", "[\"", "\"]"));
        return String.format("Cultivo,\"%s\",\"%s\",%.2f,\"%s\",\"%s\",\"%s\",%s",
                nombre, variedad, superficie, codigoParcela, fecha.toString(), estado, actStr);
    }

    @Override
    public String toString() {
        return nombre + " (" + variedad + ") - " + estado + " en " + codigoParcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public String getParcela() {
        return parcela;
    }

    
    public static Cultivo desdeCSV(String linea) {
        String[] partes = linea.split(",");
        String nombre = partes[0];
        String variedad = partes[1];
        double superficie = Double.parseDouble(partes[2]);
        String codigoParcela = partes[3];
        LocalDate fecha = LocalDate.parse(partes[4]);
        String estado = partes[5];
        return new Cultivo(nombre, variedad, superficie, codigoParcela, fecha, estado);
    }

    public void setFecha(String nextLine) {
    
        throw new UnsupportedOperationException("Unimplemented method 'setFecha'");
    }

    public String aCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(",");
        sb.append(tipo).append(","); // Removed as 'tipo' is not defined
        sb.append(fechaSiembra).append(",");
        sb.append(duracionDias).append(",");
        sb.append(ubicacion).append(",");
    
        // Agregar las actividades en formato resumido
        for (Actividad act : actividades) {
            sb.append(act.aCSV()).append(";");
        }
    
        return sb.toString();
    }
    
}
