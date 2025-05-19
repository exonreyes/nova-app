package nova.empresa.adapter;

import lombok.RequiredArgsConstructor;
import nova.empresa.Departamento;
import nova.empresa.port.DepartamentoPersistencePort;
import nova.empresa.repository.DepartamentoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartamentoJpaAdapter implements DepartamentoPersistencePort {
    private final DepartamentoJpaRepository departamentoJpaRepository;

    @Override
    public List<Departamento> obtenerDepartamentos() {
        return departamentoJpaRepository.findAll().stream().map(x ->
                new Departamento(x.getId(), x.getNombre())).toList();
    }
}
