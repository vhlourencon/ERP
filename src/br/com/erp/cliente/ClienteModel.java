package br.com.erp.cliente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.erp.enums.EstadoCivilEnum;
import br.com.erp.enums.TipoLogradouro;

@Table
@Entity(name = "cliente")
public class ClienteModel {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nomeRazao;
	private String email;
	private String tipo = "J";

	private String pfApelido;
	private String pfCPF;
	@Temporal(TemporalType.TIMESTAMP)
	private Date pfDataNascimento;
	@Enumerated(EnumType.STRING)
	private EstadoCivilEnum pfEstadoCivil;
	private String pfRG;
	private String pgORgaoEmissor;
	private String pfOrgaoEmissoUF;
	private String pfCNH;
	private String pfSeguranca;
	private String pfCEI;
	private String pfTelefone;
	private String pfCelular;

	private String pjNomeFantasia;
	@Column(columnDefinition = "boolean default false")
	private boolean pjAtivo=false;
	private String pjCNPJ;
	@Column(columnDefinition = "boolean default false")
	private boolean pjContribuinte=false;
	private String pjIE;
	private String pjIM;
	private String pjResponsavelNome;
	private String pjREsponsavelCPF;
	@Temporal(TemporalType.TIMESTAMP)
	private Date pjREsponsvavelDN;
	private String pjREsponsavelTelefone;
	private String pjResponsavelCelular;
	private String pjREsponsavelEmail;

	private String endCEP;
	private String endCidade;
	private String endUF;
	private String endTipoLogradouro;
	private String endLogradouro;
	private String endNumero;
	private String endComplemento;
	private String endBairro;
	private String observacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndCEP() {
		return endCEP;
	}

	public void setEndCEP(String endCEP) {
		this.endCEP = endCEP;
	}

	public String getEndCidade() {
		return endCidade;
	}

	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}

	public String getEndUF() {
		return endUF;
	}

	public void setEndUF(String endUF) {
		this.endUF = endUF;
	}

	public String getEndTipoLogradouro() {
		return endTipoLogradouro;
	}

	public void setEndTipoLogradouro(String endTipoLogradouro) {
		this.endTipoLogradouro = endTipoLogradouro;
	}

	public String getEndLogradouro() {
		return endLogradouro;
	}

	public void setEndLogradouro(String endLogradouro) {
		this.endLogradouro = endLogradouro;
	}

	public String getEndNumero() {
		return endNumero;
	}

	public void setEndNumero(String endNumero) {
		this.endNumero = endNumero;
	}

	public String getEndComplemento() {
		return endComplemento;
	}

	public void setEndComplemento(String endComplemento) {
		this.endComplemento = endComplemento;
	}

	public String getEndBairro() {
		return endBairro;
	}

	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNomeRazao() {
		return nomeRazao;
	}

	public void setNomeRazao(String nomeRazao) {
		this.nomeRazao = nomeRazao;
	}

	public String getPfApelido() {
		return pfApelido;
	}

	public void setPfApelido(String pfApelido) {
		this.pfApelido = pfApelido;
	}

	public String getPfCPF() {
		return pfCPF;
	}

	public void setPfCPF(String pfCPF) {
		this.pfCPF = pfCPF;
	}

	public Date getPfDataNascimento() {
		return pfDataNascimento;
	}

	public void setPfDataNascimento(Date pfDataNascimento) {
		this.pfDataNascimento = pfDataNascimento;
	}

	public EstadoCivilEnum getPfEstadoCivil() {
		return pfEstadoCivil;
	}

	public void setPfEstadoCivil(EstadoCivilEnum pfEstadoCivil) {
		this.pfEstadoCivil = pfEstadoCivil;
	}

	public String getPfRG() {
		return pfRG;
	}

	public void setPfRG(String pfRG) {
		this.pfRG = pfRG;
	}

	public String getPgORgaoEmissor() {
		return pgORgaoEmissor;
	}

	public void setPgORgaoEmissor(String pgORgaoEmissor) {
		this.pgORgaoEmissor = pgORgaoEmissor;
	}

	public String getPfOrgaoEmissoUF() {
		return pfOrgaoEmissoUF;
	}

	public void setPfOrgaoEmissoUF(String pfOrgaoEmissoUF) {
		this.pfOrgaoEmissoUF = pfOrgaoEmissoUF;
	}

	public String getPfCNH() {
		return pfCNH;
	}

	public void setPfCNH(String pfCNH) {
		this.pfCNH = pfCNH;
	}

	public String getPfSeguranca() {
		return pfSeguranca;
	}

	public void setPfSeguranca(String pfSeguranca) {
		this.pfSeguranca = pfSeguranca;
	}

	public String getPfCEI() {
		return pfCEI;
	}

	public void setPfCEI(String pfCEI) {
		this.pfCEI = pfCEI;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPfTelefone() {
		return pfTelefone;
	}

	public void setPfTelefone(String pfTelefone) {
		this.pfTelefone = pfTelefone;
	}

	public String getPfCelular() {
		return pfCelular;
	}

	public void setPfCelular(String pfCelular) {
		this.pfCelular = pfCelular;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPjNomeFantasia() {
		return pjNomeFantasia;
	}

	public void setPjNomeFantasia(String pjNomeFantasia) {
		this.pjNomeFantasia = pjNomeFantasia;
	}

	public boolean isPjAtivo() {
		return pjAtivo;
	}

	public void setPjAtivo(boolean pjAtivo) {
		this.pjAtivo = pjAtivo;
	}

	public String getPjCNPJ() {
		return pjCNPJ;
	}

	public void setPjCNPJ(String pjCNPJ) {
		this.pjCNPJ = pjCNPJ;
	}

	public boolean isPjContribuinte() {
		return pjContribuinte;
	}

	public void setPjContribuinte(boolean pjContribuinte) {
		this.pjContribuinte = pjContribuinte;
	}

	public String getPjIE() {
		return pjIE;
	}

	public void setPjIE(String pjIE) {
		this.pjIE = pjIE;
	}

	public String getPjIM() {
		return pjIM;
	}

	public void setPjIM(String pjIM) {
		this.pjIM = pjIM;
	}

	public String getPjResponsavelNome() {
		return pjResponsavelNome;
	}

	public void setPjResponsavelNome(String pjResponsavelNome) {
		this.pjResponsavelNome = pjResponsavelNome;
	}

	public String getPjREsponsavelCPF() {
		return pjREsponsavelCPF;
	}

	public void setPjREsponsavelCPF(String pjREsponsavelCPF) {
		this.pjREsponsavelCPF = pjREsponsavelCPF;
	}

	public Date getPjREsponsvavelDN() {
		return pjREsponsvavelDN;
	}

	public void setPjREsponsvavelDN(Date pjREsponsvavelDN) {
		this.pjREsponsvavelDN = pjREsponsvavelDN;
	}

	public String getPjREsponsavelTelefone() {
		return pjREsponsavelTelefone;
	}

	public void setPjREsponsavelTelefone(String pjREsponsavelTelefone) {
		this.pjREsponsavelTelefone = pjREsponsavelTelefone;
	}

	public String getPjResponsavelCelular() {
		return pjResponsavelCelular;
	}

	public void setPjResponsavelCelular(String pjResponsavelCelular) {
		this.pjResponsavelCelular = pjResponsavelCelular;
	}

	public String getPjREsponsavelEmail() {
		return pjREsponsavelEmail;
	}

	public void setPjREsponsavelEmail(String pjREsponsavelEmail) {
		this.pjREsponsavelEmail = pjREsponsavelEmail;
	}

}
