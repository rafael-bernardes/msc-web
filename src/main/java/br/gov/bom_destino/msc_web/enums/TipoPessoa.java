package br.gov.bom_destino.msc_web.enums;

public enum TipoPessoa {
	FISICA(1, "Física"),
	JURIDICA(2, "Jurídica"),
	DEFAULT(0, "");
	
	private TipoPessoa(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	private Integer codigo;
	private String descricao;
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static TipoPessoa fromCodigo(Integer codigo) {
		for (TipoPessoa tipoPessoa : TipoPessoa.values()) {
			if(tipoPessoa.codigo.equals(codigo)) {
				return tipoPessoa;
			}
		}
		
		return TipoPessoa.DEFAULT;
	}
}