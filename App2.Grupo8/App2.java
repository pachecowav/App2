import Modelos.Cultivo;
import Modelos.Parcela;
import Servicios.GestorCultivos;
import Servicios.GestorParcelas;
import Utiles.GestorCSV;
import java.util.*;
import java.io.IOException;

public class App2 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Uso: java App2 <archivo_csv>");
            return;
        }

        String archivoCSV = args[0];
        Scanner scanner = new Scanner(System.in);

        // Leer cultivos desde el CSV
        List<Cultivo> cultivos = GestorCSV.leerDesdeCSV(archivoCSV);
        List<Parcela> parcelas = GestorParcelas.extraerParcelasDesdeCultivos(cultivos);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Sistema de Gestión Agrícola ===");
            System.out.println("1. Listar cultivos");
            System.out.println("2. Crear cultivo");
            System.out.println("3. Editar cultivo");
            System.out.println("4. Eliminar cultivo");
            System.out.println("5. Listar parcelas");
            System.out.println("6. Crear parcela");
            System.out.println("7. Editar parcela");
            System.out.println("8. Eliminar parcela");
            System.out.println("9. Asignar cultivo a parcela");
            System.out.println("10. Registrar actividad");
            System.out.println("11. Listar actividades por cultivo");
            System.out.println("12. Eliminar actividad");
            System.out.println("13. Marcar actividad como completada");
            System.out.println("14. Buscar cultivos");
            System.out.println("15. Reporte");
            System.out.println("16. Salir y guardar");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    GestorCultivos.listarCultivos(cultivos);
                    break;
                case "2":
                    GestorCultivos.crearCultivo(cultivos, scanner);
                    break;
                case "3":
                    GestorCultivos.editarCultivo(cultivos, scanner);
                    break;
                case "4":
                    GestorCultivos.eliminarCultivo(cultivos, scanner);
                    break;
                case "5":
                    GestorParcelas.listarParcelas(parcelas);
                    break;
                case "6":
                    GestorParcelas.agregarParcela(parcelas, scanner);
                    break;
                case "7":
                    GestorParcelas.editarParcela(parcelas, scanner);
                    break;
                case "8":
                    GestorParcelas.eliminarParcela(parcelas, cultivos, scanner);
                    break;
                case "9":
                    GestorParcelas.asignarCultivoAParcela(parcelas, cultivos, scanner);
                    break;
                case "10":
                    GestorCultivos.registrarActividad(cultivos, scanner);
                    break;
                case "11":
                    GestorCultivos.listarActividades(cultivos, scanner);
                    break;
                case "12":
                    GestorCultivos.eliminarActividad(cultivos, scanner);
                    break;
                case "13":
                    GestorCultivos.marcarActividadComoCompletada(cultivos, scanner);
                    break;
                case "14":
                    GestorCultivos.buscarCultivos(cultivos, scanner);
                    break;
                case "15":
                    GestorCultivos.reporteCultivos(cultivos);
                    break;
                case "16":
                    GestorCSV.guardarEnCSV(archivoCSV, cultivos);
                    System.out.println("Cambios guardados en " + archivoCSV + ". Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }
}


        scanner.close();
    }
}

