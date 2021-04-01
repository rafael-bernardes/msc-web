package br.com.bom_destino.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.primefaces.PrimeFaces;

import br.com.bom_destino.entities.EspelhoIptu;
import br.com.bom_destino.enums.TipoPessoa;
import br.com.bom_destino.utils.PropertiesUtil;
import br.com.bom_destino.utils.TextoUtils;


@ManagedBean(name = "espelho")
public class EspelhoIPTUBean implements Serializable {

	private static final String FALHA_AO_CONSULTAR_ESPELHO = "Falha ao consultar espelho de IPTU";

	private static final long serialVersionUID = 1L;

	private Integer tipoPessoa;
	private String documento;
	private boolean adicionarIdentificacao;

	private EspelhoIptu espelho;
	
	public void gerarEspelho() {
		if(tipoPessoa == null || tipoPessoa == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o tipo de pessoa.", ""));
			return;
		}else if(documento == null || documento.length() == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o documento.", ""));
			return;
		}
		
		ResteasyClient client = new ResteasyClientBuilder().build();
		
		try {
			WebTarget target = client.target(PropertiesUtil.obterURI("gateway-api")).path("espelhos");
		
			target = target.queryParam("tipo-pessoa", tipoPessoa);
			target = target.queryParam("documento", documento);
			
			if(adicionarIdentificacao) {
				target = target.queryParam("nome-cliente", "img-web");
			}
			
			Response response = target.request().get();
			
			if(!Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, FALHA_AO_CONSULTAR_ESPELHO, ""));
			}else {
				espelho = response.readEntity(EspelhoIptu.class);
				
				PrimeFaces.current().executeScript("PF('dialogEspelho').show()");
			}
		} catch (IllegalArgumentException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, FALHA_AO_CONSULTAR_ESPELHO, e.getMessage()));
		} catch (NullPointerException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, FALHA_AO_CONSULTAR_ESPELHO, e.getMessage()));
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, FALHA_AO_CONSULTAR_ESPELHO, e.getMessage()));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, FALHA_AO_CONSULTAR_ESPELHO, e.getMessage()));
		}
	}

	public String formatarCPF(String cpf) {
		String retorno = "";
		
		try {
			retorno = TextoUtils.formatarCPF(cpf);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao formatar CPF", e.getMessage()));
		}
		
		return retorno;
	}
	
	public String obterTipoPessoa(Integer tipoPessoa) {
		return TipoPessoa.fromCodigo(tipoPessoa).getDescricao();
	}
	
	public String obterDataProcessamento(Date data) {
		return TextoUtils.formatarData(data);
	}
	
	public Integer getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(Integer fisica) {
		this.tipoPessoa = fisica;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public EspelhoIptu getEspelho() {
		return espelho;
	}

	public void setEspelho(EspelhoIptu espelho) {
		this.espelho = espelho;
	}

	public boolean isAdicionarIdentificacao() {
		return adicionarIdentificacao;
	}

	public void setAdicionarIdentificacao(boolean adicionarIdentificacao) {
		this.adicionarIdentificacao = adicionarIdentificacao;
	}
}