package br.com.microservice_transacao.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.microservice_transacao.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class TransacaoDTO implements Serializable {

	public TransacaoDTO() {

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_lancamento;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_pagamento;

	private String estabelecimento;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData_lancamento() {
		return data_lancamento;
	}

	public void setData_lancamento(LocalDate data_lancamento) {
		this.data_lancamento = data_lancamento;
	}

	public LocalDate getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(LocalDate data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public TransacaoDTO(LocalDate data_lancamento, LocalDate data_pagamento, String estabelecimento, Tipo tipo,
			BigDecimal valor) {
		super();
		this.data_lancamento = data_lancamento;
		this.data_pagamento = data_pagamento;
		this.estabelecimento = estabelecimento;
		this.tipo = tipo;
		this.valor = valor;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private BigDecimal valor;

}
