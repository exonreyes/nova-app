package nova.cuenta.port;

import nova.cuenta.Credencial;
import nova.cuenta.command.FiltroCuentaCmd;

import java.util.List;
import java.util.Optional;

public interface CredencialPersistencePort {
    List<Credencial> obtenerCredenciales(FiltroCuentaCmd filtro);

    Optional<Credencial> obtenerDetalles(Integer idCredencial);

    void actualizar(Credencial credencial);

    void eliminar(Integer idCredencial);

    void guardar(Credencial credencial);

    boolean existePorID(Integer idCredencial);

    boolean existeUsuario(Integer idProveedor, String usuario);
}
