package br.edu.uniceub.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.edu.uniceub.dto.CotacaoDto;
import br.edu.uniceub.models.Cotacao;
import br.edu.uniceub.repository.AtivoRepository;
import br.edu.uniceub.repository.CotacaoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;

@Path("/cotacao")
public class CotacaoService {

    @Inject
    CotacaoRepository repository;

    @Inject
    AtivoRepository ativoRepository;

    @Inject
    HistoricoCotacaoService historicoCotacaoService;

    public List<CotacaoDto> getCotacoesList() {
        return repository.listAll().stream().map(this::cotacaoParaDto).collect(Collectors.toList());
    }

    public CotacaoDto getCotacao(Long id) {
        Optional<Cotacao> cotacao = repository.findByIdOptional(id);
        if (cotacao.isPresent()) {
            return cotacaoParaDto(cotacao.get());
        }
        return null;
    }

    @Transactional
    public CotacaoDto insereCotacao(Cotacao novaCotacao) {
        repository.persist(novaCotacao);
        historicoCotacaoService.insereHistoricoCotacao(novaCotacao);
        return cotacaoParaDto(novaCotacao);
    }

    @Transactional
    public CotacaoDto alteraCotacao(Long id, Cotacao cotacao) {
        Cotacao entity = repository.findById(id);
        if (entity != null) {
            entity.setIdAtivo(cotacao.getIdAtivo());
            entity.setData(cotacao.getData());
            entity.setCotacao(cotacao.getCotacao());
            cotacao.setId(entity.getId());
            historicoCotacaoService.insereHistoricoCotacao(cotacao);
            return cotacaoParaDto(cotacao);
        }
        return null;
    }

    @Transactional
    public CotacaoDto deleteCotacao(Long id) {
        Optional<Cotacao> optionalCotacao = repository.findByIdOptional(id);
        if (optionalCotacao.isPresent()) {
            repository.deleteById(id);
            return cotacaoParaDto(optionalCotacao.get());
        }
        return null;
    }

    public CotacaoDto cotacaoParaDto(Cotacao cotacao) {
        CotacaoDto cotacaoDto = new CotacaoDto();

        cotacaoDto.setId(cotacao.getId());
        cotacaoDto.setIdAtivo(cotacao.getIdAtivo());
        cotacaoDto.setTicker(ativoRepository.findById(cotacao.getIdAtivo().longValue()).getTicker());
        cotacaoDto.setData(cotacao.getData());
        cotacaoDto.setCotacao(cotacao.getCotacao());

        return cotacaoDto;
    }

}
