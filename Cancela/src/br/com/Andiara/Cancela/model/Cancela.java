package br.com.Andiara.Cancela.model;

public class Cancela {

	private boolean situacao;
	private int codigo;

	public Cancela() {
	
	}

	public Cancela(boolean situacao,int codigo ) {
		setSituacao(situacao);
		setCodigo(codigo);
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


}
