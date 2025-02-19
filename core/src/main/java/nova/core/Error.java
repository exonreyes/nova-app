package nova.core;

/**
 * Interfaz para estandarizar la representación de códigos de error y sus mensajes asociados.
 * <p>
 * Esta interfaz define métodos para obtener un código único de error y personalizar los mensajes
 * relacionados con dicho error. Puede ser implementada por enumeraciones o clases que representen
 * diferentes tipos de errores en un sistema.
 * </p>
 *
 * <h2>Objetivos:</h2>
 * <ul>
 *   <li>Facilitar la centralización de códigos y mensajes de error.</li>
 *   <li>Permitir la personalización de mensajes con diferentes niveles de detalle.</li>
 * </ul>
 *
 * <h3>Ejemplo de Implementación:</h3>
 * <pre>
 * public enum ErrorCode implements ErrorInfo {
 *     INVALID_REQUEST("ERR001", "Solicitud inválida"),
 *     ENTITY_NOT_FOUND("ERR002", "Entidad no encontrada");
 *
 *     private final String code;
 *     private final String message;
 *
 *     ErrorCode(String code, String message) {
 *         this.code = code;
 *         this.message = message;
 *     }
 *
 *     public String getCode() {
 *         return code;
 *     }
 *
 *     public String getMessage() {
 *         return message;
 *     }
 *
 *     public String getMessage(String detail) {
 *         return String.format("%s - %s", message, detail);
 *     }
 *
 *     public String getMessage(String... details) {
 *         return message + ": " + String.join(", ", details);
 *     }
 * }
 * </pre>
 */
public interface Error {

    /**
     * Obtiene el código único del error.
     * <p>
     * Este código debe ser único y permite identificar de forma clara
     * el tipo de error ocurrido dentro del sistema.
     * </p>
     *
     * @return el código del error como una cadena de texto.
     *
     * <h3>Ejemplo:</h3>
     * <pre>
     * String code = ErrorCode.ENTITY_NOT_FOUND.getCode();
     * System.out.println(code); // "ERR002"
     * </pre>
     */
    String getCode();

    /**
     * Obtiene el mensaje asociado al error.
     * <p>
     * Este método devuelve una descripción genérica del error.
     * </p>
     *
     * @return el mensaje del error como una cadena de texto.
     *
     * <h3>Ejemplo:</h3>
     * <pre>
     * String message = ErrorCode.INVALID_REQUEST.getMessage();
     * System.out.println(message); // "Solicitud inválida"
     * </pre>
     */
    String getMessage();

    /**
     * Obtiene un mensaje de error personalizado con un detalle adicional.
     * <p>
     * Este método permite agregar información adicional al mensaje del error,
     * como el nombre de un campo o el contexto en el que ocurrió el error.
     * </p>
     *
     * @param detail un detalle adicional que se incluirá en el mensaje.
     * @return el mensaje del error con el detalle incluido.
     *
     * <h3>Ejemplo:</h3>
     * <pre>
     * String message = ErrorCode.ENTITY_NOT_FOUND.getMessage("Usuario no encontrado");
     * System.out.println(message); // "Entidad no encontrada - Usuario no encontrado"
     * </pre>
     */
    String getMessage(String detail);

    /**
     * Obtiene un mensaje de error personalizado con múltiples detalles.
     * <p>
     * Este método permite incluir varios detalles adicionales en el mensaje del error,
     * separados por comas, para proporcionar más contexto sobre el problema.
     * </p>
     *
     * @param details uno o más detalles adicionales para personalizar el mensaje.
     * @return el mensaje del error con los detalles incluidos.
     *
     * <h3>Ejemplo:</h3>
     * <pre>
     * String message = ErrorCode.INVALID_REQUEST.getMessage("campo: nombre", "valor: null");
     * System.out.println(message); // "Solicitud inválida: campo: nombre, valor: null"
     * </pre>
     */
    String getMessage(String... details);
}

