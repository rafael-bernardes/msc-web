package br.com.bom_destino.enums;

public enum TipoPessoa {
	FISICA(1, "Física"),
	JURIDICA(2, "Jurídica"),
	RURAL(3, "Rural"),
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