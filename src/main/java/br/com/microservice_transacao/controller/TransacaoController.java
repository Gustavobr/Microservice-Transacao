package br.com.microservice_transacao.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.microservice_transacao.DTO.TransacaoDTO;
import br.com.microservice_transacao.service.TransacaoService;

@RestController
@RequestMapping("/ms/transacao")
public class TransacaoController {

	@Autowired

	private TransacaoService service;

	@GetMapping
	public Page<TransacaoDTO> obterTodos(@PageableDefault(size = 10) Pageable paginacao) throws Exception {
		return service.obterTodos(paginacao);

	}

	@GetMapping("/{id}")
	public ResponseEntity<TransacaoDTO> detalhar(@PathVariable(required = true) Integer id) throws Exception {

		TransacaoDTO transacaoDTO = service.obterporId(id);
		if (transacaoDTO != null) {
			return ResponseEntity.ok(transacaoDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<TransacaoDTO> excluirTransacao(@PathVariable(required = true) Integer id) throws Exception {
		service.removeTransacao(id);

		return ResponseEntity.noContent().build();

	}

	@PostMapping
	public ResponseEntity<TransacaoDTO> criarTransacao(@Valid @RequestBody TransacaoDTO transacaoDTO,
			UriComponentsBuilder uriBuilder) throws Exception {
		TransacaoDTO dto = service.criarTransacao(transacaoDTO);
		URI endereco = uriBuilder.path("/ms/transacao/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(endereco).body(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TransacaoDTO> atualizar(@Valid @RequestBody TransacaoDTO pagamentoDTO,
			@PathVariable(required = true) Integer id) throws Exception {
		TransacaoDTO DTO = service.atualizaTransacao(id, pagamentoDTO);
		return ResponseEntity.ok(DTO);
	}

}
