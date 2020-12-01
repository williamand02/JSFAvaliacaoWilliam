package br.edu.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.faculdadedelta.modelo.ProcessoWilliam;
import br.edu.faculdadedelta.util.Conexao;

public class Dao {
	public void incluir(ProcessoWilliam processo) throws SQLException, ClassNotFoundException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "INSERT INTO processos (assunto_proc, interessado_proc, numero_proc, valor_proc, data_autuacao_proc) "
				+ " VALUES (?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, processo.getAssunto_proc());
		ps.setString(2, processo.getInteressado_proc());
		ps.setString(3, processo.getNumero_proc());
		ps.setDouble(4, processo.getValor_proc());
		ps.setDate(5, new java.sql.Date(processo.getData_autuacao_proc().getTime()));
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public void alterar(ProcessoWilliam processo) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "UPDATE processos SET "
				+ " assunto_proc = ?, "
				+ " interessado_proc = ?, "
				+ " numero_proc  = ?, "
				+ " valor_proc  = ? ,"
				+ " data_autuacao_proc  = ? "
				+ " WHERE id_proc = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, processo.getAssunto_proc().trim());
		ps.setString(2, processo.getInteressado_proc().trim());
		ps.setString(3, processo.getNumero_proc());
		ps.setDouble(4, processo.getValor_proc());
		ps.setDate(5, new java.sql.Date(processo.getData_autuacao_proc().getTime()));
		ps.setDouble(6, processo.getId_proc());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public List<ProcessoWilliam> listar() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "SELECT id_proc, assunto_proc, numero_proc, "
				+ " interessado_proc , data_autuacao_proc,valor_proc  FROM processos";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<ProcessoWilliam> listaRetorno = new ArrayList<ProcessoWilliam>();
 		
		while (rs.next()) {
			ProcessoWilliam processo = new ProcessoWilliam();
			processo.setId_proc(rs.getLong("id_proc"));
			processo.setAssunto_proc(rs.getString("assunto_proc").trim());
			processo.setNumero_proc(rs.getString("numero_proc"));
			processo.setInteressado_proc(rs.getString("interessado_proc"));
			processo.setData_autuacao_proc(rs.getDate("data_autuacao_proc"));
			processo.setValor_proc(rs.getDouble("valor_proc"));
			listaRetorno.add(processo);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return listaRetorno;
	}
	
	public void excluir(ProcessoWilliam processo) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "DELETE FROM processos WHERE id_proc = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, processo.getId_proc());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
}
