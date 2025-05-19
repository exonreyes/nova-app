package nova.cuenta.adapter;

import lombok.RequiredArgsConstructor;
import nova.cuenta.Proveedor;
import nova.cuenta.port.ProveedorPersistencePort;
import nova.cuenta.repository.ProveedorJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProveedorJpaAdapter implements ProveedorPersistencePort {
    private final ProveedorJpaRepository proveedorJpaRepository;

    @Override
    public List<Proveedor> getProveedores() {
        return proveedorJpaRepository.findAll().stream().map(t -> new Proveedor(t.getId(), t.getNombre(), t.getIcon())).toList();
    }

    @Override
    public Optional<Proveedor> getProveedorById(Integer id) {
        return proveedorJpaRepository.findById(id).map(x -> new Proveedor(x.getId(), x.getNombre(), x.getIcon()));
    }
}
