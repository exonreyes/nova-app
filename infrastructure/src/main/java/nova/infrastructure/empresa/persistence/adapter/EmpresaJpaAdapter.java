package nova.infrastructure.empresa.persistence.adapter;

import lombok.RequiredArgsConstructor;
import nova.core.empresa.Empresa;
import nova.domain.empresa.port.EmpresaDao;
import nova.infrastructure.empresa.persistence.exception.EmpresaNotFoundException;
import nova.infrastructure.empresa.persistence.query.EmpresaGeneralQuery;
import nova.infrastructure.empresa.persistence.repository.EmpresaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmpresaJpaAdapter implements EmpresaDao {
    private final EmpresaRepository empresaRepository;

    @Override
    public Empresa obtenerEmpresa(Integer empresaId) {
        return empresaRepository.findById(empresaId, EmpresaGeneralQuery.class)
                .map(x -> new Empresa(x.id(), x.nombre())).orElseThrow(() -> new EmpresaNotFoundException("Empresa con ID" + empresaId + " no encontrada"));
    }

    @Override
    public Empresa obtenerDetalles(Integer empresaId) {
        return empresaRepository.findById(empresaId).map(
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
        ).orElseThrow(() -> new EmpresaNotFoundException("Empresa con ID " + empresaId + " no encontrada"));
    }

}
