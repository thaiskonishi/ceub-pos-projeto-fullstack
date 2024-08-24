package br.edu.uniceub.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.edu.uniceub.dto.AtivoDto;
import br.edu.uniceub.models.Ativo;
import br.edu.uniceub.repository.AtivoRepository;
import br.edu.uniceub.repository.SetorRepository;
import br.edu.uniceub.repository.TipoAtivoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;

@Path("/ativo")
public class AtivoService {

    @Inject
    AtivoRepository repository;

    @Inject
    SetorRepository setorRepository;

    @Inject
    TipoAtivoRepository tipoAtivoRepository;

    public List<AtivoDto> getAtivosList() {
        return repository.listAll().stream().map(this::ativoParaDto).collect(Collectors.toList());
    }

    public AtivoDto getAtivo(Long id) {
        Optional<Ativo> ativo = repository.findByIdOptional(id);
        if (ativo.isPresent()) {
            return ativoParaDto(ativo.get());
        }
        return null;
    }

    @Transactional
    public AtivoDto insereAtivo(Ativo novoAtivo) {
        repository.persist(novoAtivo);
        return ativoParaDto(novoAtivo);
    }

    @Transactional
    public AtivoDto alteraAtivo(Long id, Ativo ativo) {
        Ativo entity = repository.findById(id);
        if (entity != null) {
            entity.setNome(ativo.getNome());
            entity.setTicker(ativo.getTicker());
            entity.setDataFundacao(ativo.getDataFundacao());
            entity.setIdSetor(ativo.getIdSetor());
            entity.setIdTipoAtivo(ativo.getIdTipoAtivo());
            ativo.setId(entity.getId());
            return ativoParaDto(ativo);
        }
        return null;
    }

    @Transactional
    public AtivoDto deleteAtivo(Long id) {
        Optional<Ativo> optionalAtivo = repository.findByIdOptional(id);
        if (optionalAtivo.isPresent()) {
            repository.deleteById(id);
            return ativoParaDto(optionalAtivo.get());
        }
        return null;
    }

    public AtivoDto ativoParaDto(Ativo ativo) {
        AtivoDto ativoDto = new AtivoDto();

        ativoDto.setId(ativo.getId());
        ativoDto.setIdSetor(ativo.getIdSetor());
        ativoDto.setIdTipoAtivo(ativo.getIdTipoAtivo());
        ativoDto.setNome(ativo.getNome());
        ativoDto.setTicker(ativo.getTicker());
        ativoDto.setDataFundacao(ativo.getDataFundacao());
        ativoDto.setSetor(setorRepository.findById(ativo.getIdSetor().longValue()).getNomeSetor());
        ativoDto.setTipoAtivo(tipoAtivoRepository.findById(ativo.getIdTipoAtivo().longValue()).getNomeTipoAtivo());

        return ativoDto;
    }

}
