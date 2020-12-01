package br.edu.faculdadedelta.modelo;

import java.util.Date;

public class ProcessoWilliam {


	private Long id_proc;
	private String assunto_proc;
	private String interessado_proc;
	private String numero_proc;
	private double valor_proc;
	private Date data_autuacao_proc;
	
	public ProcessoWilliam(Long id_proc, String assunto_proc, String interessado_proc, String numero_proc,
			double valor_proc, Date data_autuacao_proc) {
		this.id_proc = id_proc;
		this.assunto_proc = assunto_proc;
		this.interessado_proc = interessado_proc;
		this.numero_proc = numero_proc;
		this.valor_proc = valor_proc;
		this.data_autuacao_proc = data_autuacao_proc;
	}
	

	public ProcessoWilliam() {
	}


	public Long getId_proc() {
		return id_proc;
	}


	public void setId_proc(Long id_proc) {
		this.id_proc = id_proc;
	}


	public String getAssunto_proc() {
		return assunto_proc;
	}


	public void setAssunto_proc(String assunto_proc) {
		this.assunto_proc = assunto_proc;
	}


	public String getInteressado_proc() {
		return interessado_proc;
	}


	public void setInteressado_proc(String interessado_proc) {
		this.interessado_proc = interessado_proc;
	}


	public String getNumero_proc() {
		return numero_proc;
	}


	public void setNumero_proc(String numero_proc) {
		this.numero_proc = numero_proc;
	}


	public double getValor_proc() {
		return valor_proc;
	}


	public void setValor_proc(double valor_proc) {
		this.valor_proc = valor_proc;
	}


	public Date getData_autuacao_proc() {
		return data_autuacao_proc;
	}


	public void setData_autuacao_proc(Date data_autuacao_proc) {
		this.data_autuacao_proc = data_autuacao_proc;
	}

	
}
