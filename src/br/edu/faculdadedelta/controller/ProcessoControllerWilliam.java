package br.edu.faculdadedelta.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.faculdadedelta.dao.Dao;
import br.edu.faculdadedelta.modelo.ProcessoWilliam;

@ManagedBean
@SessionScoped
public class ProcessoControllerWilliam {
	
	private Dao dao = new Dao();
	private ProcessoWilliam processo = new ProcessoWilliam();
	
	public ProcessoWilliam getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoWilliam processo) {
		this.processo = processo;
	}

	public void limparCampos() {
		processo = new ProcessoWilliam();
	}
	
	private void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String salvar() {
		try {	
			Calendar c = Calendar.getInstance();
			c.set(2000, Calendar.JANUARY, 1);
			Date dataLimite = c.getTime();
			
			if (processo.getData_autuacao_proc().after(dataLimite) && processo.getData_autuacao_proc().before(new Date())) {

				if (processo.getId_proc() == null) {
					// incluir
					dao.incluir(processo);
					FacesMessage mensagem = new FacesMessage("Inclusão realizada com sucesso!");
					FacesContext.getCurrentInstance().addMessage(null, mensagem);
					limparCampos();
				} else {
					// alterar
					dao.alterar(processo);
					FacesMessage mensagem = new FacesMessage("Alteração realizada com sucesso!");
					FacesContext.getCurrentInstance().addMessage(null, mensagem);
					limparCampos();
				}
			} else  {
				DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);

				exibirMensagem("A data de atuação deve ser maior que "+f.format(dataLimite)+" e menor que "+f.format(new Date())+"!");
			}
			

		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return "cadastro.xhtml";
	}
	
	
	public List<ProcessoWilliam> getLista() {
		List<ProcessoWilliam> listaRetorno = new ArrayList<ProcessoWilliam>();
		try {
			listaRetorno = dao.listar();
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public String editar() {
		return "cadastro.xhtml";
	}
	
	public String excluir() {
		try {
			dao.excluir(processo);
			FacesMessage mensagem = new FacesMessage("Exclusão realizada com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			limparCampos();
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return "lista.xhtml";
	}

}
