package nova.empresa.command;

public record EmpleadoFiltroCommand(Integer idPuesto, Integer idUnidad, String estatus, Integer page, Integer size) {
}
