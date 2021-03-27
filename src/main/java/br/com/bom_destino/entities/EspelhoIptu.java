package br.com.bom_destino.entities;

import java.util.Date;

public class EspelhoIptu {
	private Contribuinte contribuinte;
	private String matricula;
	private Date dataProcessamento;
	private Double areaTerreno;
	private Double areaEdificada;
	private String utilizacaoImovel;
	private Double valorTributavel;
	private Double impostoAnual;
	private Double taxaColetaLixo;
	private Double desconto;
	private Double totalAnual;
	private String mensagemContribuinte;
	private String observacoes;
	
	public Contribuinte getContribuinte() {
		return contribuinte;
	}
	public void setContribuinte(Contribuinte contribuinte) {
		this.contribuinte = contribuinte;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Date getDataProcessamento() {
		return dataProcessamento;
	}
	public void setDataProcessamento(Date dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}
	public Double getAreaTerreno() {
		return areaTerreno;
	}
	public void setAreaTerreno(Double areaTerreno) {
		this.areaTerreno = areaTerreno;
	}
	public Double getAreaEdificada() {
		return areaEdificada;
	}
	public void setAreaEdificada(Double areaEdificada) {
		this.areaEdificada = areaEdificada;
	}
	public String getUtilizacaoImovel() {
		return utilizacaoImovel;
	}
	public void setUtilizacaoImovel(String utilizacaoImovel) {
		this.utilizacaoImovel = utilizacaoImovel;
	}
	public Double getValorTributavel() {
		return valorTributavel;
	}
	public void setValorTributavel(Double valorTributavel) {
		this.valorTributavel = valorTributavel;
	}
	public Double getImpostoAnual() {
		return impostoAnual;
	}
	public void setImpostoAnual(Double impostoAnual) {
		this.impostoAnual = impostoAnual;
	}
	public Double getTaxaColetaLixo() {
		return taxaColetaLixo;
	}
	public void setTaxaColetaLixo(Double taxaColetaLixo) {
		this.taxaColetaLixo = taxaColetaLixo;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getTotalAnual() {
		return totalAnual;
	}
	public void setTotalAnual(Double totalAnual) {
		this.totalAnual = totalAnual;
	}
	public String getMensagemContribuinte() {
		return mensagemContribuinte;
	}
	public void setMensagemContribuinte(String mensagemContribuinte) {
		this.mensagemContribuinte = mensagemContribuinte;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}