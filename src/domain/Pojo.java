package domain;

public class Pojo {

	private Integer corRaca, idade, reservaEtnico, reservaEnsinoPub, reservaRenda, apoioSocial, atividadeExtracurricular, tipoEscola;
	private String situacao, sexo;
	
	public Pojo() {
		
	}

	public int getCorRaca() {
		return corRaca;
	}

	public void setCorRaca(int corRaca) {
		this.corRaca = corRaca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getReservaEtnico() {
		return reservaEtnico;
	}

	public void setReservaEtnico(int reservaEtnico) {
		this.reservaEtnico = reservaEtnico;
	}

	public int getReservaEnsinoPub() {
		return reservaEnsinoPub;
	}

	public void setReservaEnsinoPub(int reservaEnsinoPub) {
		this.reservaEnsinoPub = reservaEnsinoPub;
	}

	public int getReservaRenda() {
		return reservaRenda;
	}

	public void setReservaRenda(int reservaRenda) {
		this.reservaRenda = reservaRenda;
	}

	public int getApoioSocial() {
		return apoioSocial;
	}

	public void setApoioSocial(int apoioSocial) {
		this.apoioSocial = apoioSocial;
	}

	public int getAtividadeExtracurricular() {
		return atividadeExtracurricular;
	}

	public void setAtividadeExtracurricular(int atividadeExtracurricular) {
		this.atividadeExtracurricular = atividadeExtracurricular;
	}

	public int getTipoEscola() {
		return tipoEscola;
	}

	public void setTipoEscola(int tipoEscola) {
		this.tipoEscola = tipoEscola;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Pojo [corRaca=" + corRaca + ", sexo=" + sexo + ", idade=" + idade + ", reservaEtnico=" + reservaEtnico
				+ ", reservaEnsinoPub=" + reservaEnsinoPub + ", reservaRenda=" + reservaRenda + ", apoioSocial="
				+ apoioSocial + ", atividadeExtracurricular=" + atividadeExtracurricular + ", tipoEscola=" + tipoEscola
				+ ", situacao=" + situacao + "]";
	}
	
	
	
}
