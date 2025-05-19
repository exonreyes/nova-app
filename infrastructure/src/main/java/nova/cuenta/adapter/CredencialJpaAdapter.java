package nova.cuenta.adapter;

import lombok.RequiredArgsConstructor;
import nova.cuenta.Credencial;
import nova.cuenta.Proveedor;
import nova.cuenta.command.FiltroCuentaCmd;
import nova.cuenta.model.CredencialModel;
import nova.cuenta.model.ProveedorCuentaModel;
import nova.cuenta.model.query.cuenta.CredencialDetallesQuery;
import nova.cuenta.port.CredencialPersistencePort;
import nova.cuenta.repository.CredencialJpaRepository;
import nova.empresa.Departamento;
import nova.empresa.Unidad;
import nova.empresa.model.DepartamentoModel;
import nova.empresa.model.UnidadModel;
import nova.empresa.specifications.CredencialSpecifications;
import nova.exception.IDNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CredencialJpaAdapter implements CredencialPersistencePort {
    private final CredencialJpaRepository credencialJpaRepository;

    @Override
    public List<Credencial> obtenerCredenciales(FiltroCuentaCmd filtro) {
        return credencialJpaRepository.findAll(CredencialSpecifications.conFiltro(filtro)).stream().map(x -> new Credencial(x.getId(), x.getUsuario(), x.getClave(), x.getActualizado(), x.getComentario())).toList();
    }

    @Override
    public Optional<Credencial> obtenerDetalles(Integer idCredencial) {
        return credencialJpaRepository.findById(idCredencial, CredencialDetallesQuery.class)
                .map(x ->
                        new Credencial(x.id(),
                                new Proveedor(x.cuentaId(), x.cuentaNombre()),
                                new Unidad(x.unidadId(), x.unidadClave(), x.unidadNombre()),
                                new Departamento(x.departamentoId(), x.departamentoNombre()),
                                x.clave(), x.usuario(), x.comentario(), x.actualizado()));
    }

    @Override
    public void actualizar(Credencial credencial) {
        CredencialModel modeloActual = credencialJpaRepository.findById(credencial.getId())
                .orElseThrow(() -> new IDNotFoundException("No se encontró el registro con el ID " + credencial.getId()));
        boolean huboCambios = false;
        if (credencial.getDepartamento() != null &&
                !Objects.equals(credencial.getDepartamento().getId(), modeloActual.getDepartamento().getId())) {
            modeloActual.setDepartamento(new DepartamentoModel(credencial.getDepartamento().getId()));
            huboCambios = true;
        }

        if (credencial.getUnidad() != null &&
                !Objects.equals(credencial.getUnidad().getId(), modeloActual.getUnidad().getId())) {
            modeloActual.setUnidad(new UnidadModel(credencial.getUnidad().getId()));
            huboCambios = true;
        }

        if (credencial.getProveedor() != null &&
                !Objects.equals(credencial.getProveedor().getId(), modeloActual.getCuenta().getId())) {
            modeloActual.setCuenta(new ProveedorCuentaModel(credencial.getProveedor().getId()));
            huboCambios = true;
        }

        if (credencial.getUsuario() != null &&
                !Objects.equals(credencial.getUsuario(), modeloActual.getUsuario())) {
            modeloActual.setUsuario(credencial.getUsuario());
            huboCambios = true;
        }

        if (credencial.getClave() != null &&
                !Objects.equals(credencial.getClave(), modeloActual.getClave())) {
            modeloActual.setClave(credencial.getClave());
            huboCambios = true;
        }

        if (credencial.getComentario() != null &&
                !Objects.equals(credencial.getComentario(), modeloActual.getComentario())) {
            modeloActual.setComentario(credencial.getComentario());
            huboCambios = true;
        }

        if (huboCambios) {
            credencialJpaRepository.save(modeloActual);
        }
    }

    @Override
    public void eliminar(Integer idCredencial) {
        credencialJpaRepository.deleteById(idCredencial);
    }

    @Override
    public void guardar(Credencial credencial) {
        CredencialModel model = new CredencialModel();
        model.setUsuario(credencial.getUsuario());
        model.setClave(credencial.getClave());
        model.setCuenta(new ProveedorCuentaModel(credencial.getProveedor().getId()));
        model.setUnidad(new UnidadModel(credencial.getUnidad().getId()));
        model.setDepartamento(new DepartamentoModel(credencial.getDepartamento().getId()));
        model.setComentario(credencial.getComentario());
        try {
            credencialJpaRepository.save(model);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede guardar la credencial, verifica existencia de la información en la base de datos");
        }
    }

    @Override
    public boolean existePorID(Integer idCredencial) {
        return credencialJpaRepository.existsById(idCredencial);
    }

    @Override
    public boolean existeUsuario(Integer idProveedor, String usuario) {
        return credencialJpaRepository.existsByCuenta_IdAndUsuario(idProveedor, usuario);
    }
}
