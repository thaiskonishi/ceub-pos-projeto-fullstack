package br.edu.uniceub.service;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.uniceub.dto.HistoricoCotacaoDto;
import br.edu.uniceub.models.Cotacao;
import br.edu.uniceub.models.HistoricoCotacao;
import br.edu.uniceub.repository.AtivoRepository;
import br.edu.uniceub.repository.HistoricoCotacaoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;

@Path("/historico-cotacao")
public class HistoricoCotacaoService {

    @Inject
    HistoricoCotacaoRepository repository;

    @Inject
    AtivoRepository ativoRepository;

    public List<HistoricoCotacaoDto> getHistoricoCotacoesList(Long id) {
        return repository.findHistoricoByTipoAtivo(id).stream().map(this::historicoCotacaoParaDto).collect(Collectors.toList());
    }

    @Transactional
    public void insereHistoricoCotacao(Cotacao cotacao) {
        HistoricoCotacao novoHistoricoCotacao = cotacaoParaHistorico(cotacao);
        repository.persist(novoHistoricoCotacao);
    }

    public HistoricoCotacaoDto historicoCotacaoParaDto(HistoricoCotacao historicoCotacao) {
        HistoricoCotacaoDto historicoCotacaoDto = new HistoricoCotacaoDto();

        historicoCotacaoDto.setId(historicoCotacao.getId());
        historicoCotacaoDto.setTicker(ativoRepository.findById(historicoCotacao.getIdAtivo().longValue()).getTicker());
        historicoCotacaoDto.setData(historicoCotacao.getData());
        historicoCotacaoDto.setCotacao(historicoCotacao.getCotacao());

        return historicoCotacaoDto;
    }

    private HistoricoCotacao cotacaoParaHistorico(Cotacao cotacao) {
        HistoricoCotacao historicoCotacao = new HistoricoCotacao();

        historicoCotacao.setIdAtivo(cotacao.getIdAtivo());
        historicoCotacao.setData(cotacao.getData());
        historicoCotacao.setCotacao(cotacao.getCotacao());

        return historicoCotacao;
    }

}
