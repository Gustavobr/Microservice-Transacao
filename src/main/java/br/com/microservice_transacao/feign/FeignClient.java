package br.com.microservice_transacao.feign;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.microservice_transacao.DTO.PagamentoDTO;

@org.springframework.cloud.openfeign.FeignClient(name = "feignClient", url = "http://localhost:9095")
public interface FeignClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/pagamentos", produces = MediaType.APPLICATION_JSON_VALUE)
	Page<PagamentoDTO> getAll();
	
	

}
