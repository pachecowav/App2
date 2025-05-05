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
     
