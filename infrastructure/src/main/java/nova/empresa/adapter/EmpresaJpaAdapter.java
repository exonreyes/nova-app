package nova.empresa.adapter;

import lombok.RequiredArgsConstructor;
import nova.empresa.Empresa;
import nova.empresa.model.query.EmpresaGeneralQuery;
import nova.empresa.port.EmpresaPersistencePort;
import nova.empresa.repository.EmpresaJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmpresaJpaAdapter implements EmpresaPersistencePort {
    private final EmpresaJpaRepository empresaJpaRepository;

    @Override
    public Optional<Empresa> obtenerEmpresa(Integer id) {
        return empresaJpaRepository.findById(id, EmpresaGeneralQuery.class)
                .map(x -> new Empresa(x.id(), x.nombre()));
    }

    @Override
    public Optional<Empresa> obtenerDetalles(Integer empresaId) {
        return empresaJpaRepository.findById(empresaId).map(
                data ->
                {
                    Empresa empresa = new Empresa(data.getId(), data.getNombre());
                    empresa.setTelefono(data.getTelefono());
                    empresa.setRazonSocial(data.getRazonSocial());
                    empresa.setRfc(data.getRfc());
                    empresa.setRegimenCapital(data.getRegimenCapital());
                    empresa.setRegimen(data.getRegimen());
                    empresa.setCalle(data.getCalle());
                    empresa.setColonia(data.getColonia());
                    empresa.setMunicipio(data.getMunicipio());
                    empresa.setCodigoPostal(data.getCodigoPostal());
                    empresa.setTipoVialidad(data.getTipoVialidad());
                    empresa.setNombreVialidad(data.getNombreVialidad());
                    empresa.setNumeroExterior(data.getNumeroExterior());
                    empresa.setNumeroInterior(data.getNumeroInterior());
                    empresa.setEntidadFederativa(data.getEntidadFederativa());
                    empresa.setInicioOperaciones(data.getInicioOperaciones());
                    empresa.setLocalidad(data.getLocalidad());
                    empresa.setMunicipio(data.getMunicipio());
                    empresa.setColonia(data.getColonia());
                    empresa.setCalle(data.getCalle());
                    empresa.setEstatusPadron(data.getEstatusPadron());
                    empresa.setUltimoCambioEstado(data.getUltimoCambioEstado());
                    return empresa;
                }
        );
    }

}
