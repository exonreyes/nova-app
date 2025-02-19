package nova.infrastructure.empresa.persistence.adapter;

import lombok.RequiredArgsConstructor;
import nova.core.empresa.Departamento;
import nova.domain.empresa.port.DepartamentoDao;
import nova.infrastructure.empresa.persistence.repository.DepartamentoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartamentoJpaAdapter implements DepartamentoDao {
    private final DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> obtenerPorEmpresa(Integer empresaID) {

        return departamentoRepository.findByEmpresa_Id(empresaID).stream().map(x ->
                new Departamento(x.getId(), x.getNombre())).toList();
    }
}
