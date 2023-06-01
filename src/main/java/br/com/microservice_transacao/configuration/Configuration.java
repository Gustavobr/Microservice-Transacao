package br.com.microservice_transacao.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@org.springframework.context.annotation.Configuration
@Component
public class Configuration {

	@Bean

	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
