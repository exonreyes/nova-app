package nova.empleado;

public enum EstatusEmpleado {
    ACTIVO("A"),
    BAJA("B"),
    REINGRESO("R");

    private final String codigo;

    EstatusEmpleado(String codigo) {
        this.codigo = codigo;
    }

    public static EstatusEmpleado fromCodigo(String codigo) {
        for (EstatusEmpleado estatus : values()) {
            if (estatus.codigo.equalsIgnoreCase(codigo)) {
                return estatus;
            }
        }
        throw new IllegalArgumentException("Código de estatus inválido: " + codigo);
    }

    public String getCodigo() {
        return codigo;
    }
}