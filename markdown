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

