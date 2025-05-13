1. Arquitectura del Sistema

Paquetes principales:
1. `modelos`: Contiene las entidades del sistema
   - `ElementoAgricola` (clase abstracta)
   - `Cultivo` (hereda de ElementoAgricola)
   - `Parcela`
   - `Actividad` (implementa interfaz `EstadoActividad`)
2. `servicios`: Lógica de negocio y gestión de datos
   - `GestorCultivos`
   - `GestorParcelas`
   - `GestorActividades`
3. `utilidad`: Utilidades generales
   - `CSVManager` (lectura/escritura de archivos)
   - `ValidadorDatos`
     
src/
└── App2/
    └── Grupo8/
        ├── Modelos/
        │   ├── Actividad.java
        │   ├── Cultivo.java
        │   ├── ElementoAgricola.java
        │   └── Parcela.java
        ├── Servicios/
        │   ├── GestorCultivos.java
        │   └── GestorParcelas.java
        ├── Utiles/
        │   └── GestorCSV.java
        └── App2.java 



      2. Manejo de modificadores:
      -Los campos de las clases (nombre, fecha, estado, etc.) se declaran como private mientras que los Getters y Setters publicos dan acceso controlado a los atributos.
      Ej. Private:
      public class Cultivo extends ElementoAgricola {
    private String variedad; // Acceso restringido
   
}
      Ej. Public: 
      public String getVariedad() { return variedad; }
public void setVariedad(String variedad) { this.variedad = variedad; }



