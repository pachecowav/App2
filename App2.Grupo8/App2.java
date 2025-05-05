import Modelos.Cultivo;
import Modelos.Parcela;
import Servicios.GestorCultivos;
import Servicios.GestorParcelas;
import Utiles.GestorCSV;
import java.util.*;

public class App2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java App2 <archivo_csv>");
            return;
        }

        String archivoCSV = args[0];
        Scanner scanner = new Scanner(System.in);

        // Leer cultivos desde el CSV
        List<cultivo> cultivos = gestorcsv.leerDesdeCSV(archivoCSV);
        List<parcela> parcelas = gestor_de_parcelas.extraerParcelasDesdeCultivos(cultivos);

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
                    gestioncultivos.listarCultivos(cultivos);
                    break;
                case "2":
                    gestioncultivos.crearCultivo(cultivos, scanner);
                    break;
                case "3":
                    gestioncultivos.editarCultivo(cultivos, scanner);
                    break;
                case "4":
                    gestioncultivos.eliminarCultivo(cultivos, scanner);
                    break;
                case "5":
                    gestor_de_parcelas.listarParcelas(parcelas);
                    break;
                case "6":
                    gestor_de_parcelas.agregarParcela(parcelas, scanner);
                    break;
                case "7":
                    gestor_de_parcelas.editarParcela(parcelas, scanner);
                    break;
                case "8":
                    gestor_de_parcelas.eliminarParcela(parcelas, cultivos, scanner);
                    break;
                case "9":
                    gestor_de_parcelas.asignarCultivoAParcela(parcelas, cultivos, scanner);
                    break;
                case "10":
                    gestioncultivos.registrarActividad(cultivos, scanner);
                    break;
                case "11":
                    gestioncultivos.listarActividades(cultivos, scanner);
                    break;
                case "12":
                    gestioncultivos.eliminarActividad(cultivos, scanner);
                    break;
                case "13":
                    gestioncultivos.marcarActividadComoCompletada(cultivos, scanner);
                    break;
                case "14":
                    gestioncultivos.buscarCultivos(cultivos, scanner);
                    break;
                case "15":
                    gestioncultivos.reporteCultivos(cultivos);
                    break;
                case "16":
                    gestorcsv.guardarEnCSV(archivoCSV, cultivos);
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

