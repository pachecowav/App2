package utils;

import models.Actividad;
import models.Cultivo;
import services.GestorCultivos;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class GestorCSV {
    public static void cargarDesdeCSV(String ruta, GestorCultivos gestor) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (!linea.startsWith("Cultivo")) continue;
            String[] partes = linea.split("\",\"");
            String nombre = partes[1].replace("\"", "");
            String variedad = partes[2];
            double superficie = Double.parseDouble(partes[3]);
            String codigoParcela = partes[4];
            LocalDate fecha = LocalDate.parse(partes[5].replace("\"", ""));
            String estado = partes[6].replace("\"", "");
            String actividadesRaw = partes[7];
            actividadesRaw = actividadesRaw.replace("[", "").replace("]", "").replace("\"", "");
            String[] actividadesStr = actividadesRaw.split(",");
            Cultivo c = new Cultivo(nombre, variedad, superficie, codigoParcela, fecha, estado);
            for (String act : actividadesStr) {
                if (!act.trim().isEmpty()) {
                    c.agregarActividad(Actividad.fromString(act.trim()));
                }
            }
            gestor.agregarCultivo(c);
        }
        br.close();
    }

    public static void guardarEnCSV(String ruta, List<Cultivo> cultivos) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Cultivo c : cultivos) {
            bw.write(c.toCSV());
            bw.newLine();
        }
        bw.close();
    }
}
