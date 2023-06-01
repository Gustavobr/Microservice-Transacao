package br.com.microservice_transacao.service;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.microservice_transacao.DTO.TransacaoDTO;
import br.com.microservice_transacao.entity.Transacao;
import br.com.microservice_transacao.enums.Tipo;
import br.com.microservice_transacao.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired

	private TransacaoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public org.springframework.data.domain.Page<TransacaoDTO> obterTodos(
			org.springframework.data.domain.Pageable paginacao) throws Exception {

		return repository.findAll(paginacao).map(t -> modelMapper.map(t, TransacaoDTO.class));

	}

	public TransacaoDTO obterporId(@PathVariable(required = true) Integer id) throws Exception {
		Optional<Transacao> transacao = repository.findById(id);
		if (transacao.isPresent()) {
			return modelMapper.map(transacao, TransacaoDTO.class);
		} else {
			return null;
		}
	}

	public TransacaoDTO criarTransacao(@Valid @RequestBody TransacaoDTO transacaoDTO) throws Exception {

		Transacao transacao = modelMapper.map(transacaoDTO, Transacao.class);
		transacao.setTipo(Tipo.TRANSFERENCIA);

		repository.save(transacao);

		return modelMapper.map(transacao, TransacaoDTO.class);

	}

	public TransacaoDTO atualizaTransacao(Integer id, @Valid @RequestBody TransacaoDTO transacaoDTO) throws Exception {
		Transacao transacao = modelMapper.map(transacaoDTO, Transacao.class);
		transacao.setId(id);
		transacao = repository.save(transacao);

		return modelMapper.map(transacao, TransacaoDTO.class);
	}

	public void removeTransacao(Integer id) throws Exception {
		repository.deleteById(id);
	}

}
