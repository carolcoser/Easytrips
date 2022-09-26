package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Cliente;
import model.Login;

public class ClienteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Cliente cliente) {
		String sql = "INSERT INTO cliente (emailCliente, nomeCliente, senhaCliente, cpfCliente, id_login) values (?, ?, ?, ?, ?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getEmailCliente());
			pstm.setString(2, cliente.getNomeCliente());
			pstm.setString(3, cliente.getSenhaCliente());
			pstm.setString(4, cliente.getCpfCliente());
			pstm.setInt(5, cliente.getLogin().getId_login());
			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Cliente> getCliente(){
		String sql = "select * from cliente_login;";

		List<Cliente> listaClientes = new ArrayList<>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();
				Login login = new Login();
				
				cliente.setId_cliente(rset.getInt("id_cliente"));
				login.setId_login(rset.getInt("id_login"));
				login.setTipoLogin(rset.getString("tipoLogin"));
				cliente.setLogin(login);
				cliente.setNomeCliente(rset.getString("nomeCliente"));
				cliente.setEmailCliente(rset.getString("emailCliente"));
				cliente.setSenhaCliente(rset.getString("senhaCliente"));
				cliente.setCpfCliente(rset.getString("cpfCliente"));
				
				listaClientes.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaClientes;
	}

	public void update(Cliente cliente) {
		String sql = "UPDATE cliente SET id_login = ?, emailCliente = ?, nomeCliente = ?, senhaCliente = ?, cpfCliente = ?  WHERE id_cliente = ?";

		try {
	conn = ConnectionMySQL.createConnectionMySQL();
	pstm = conn.prepareStatement(sql);

	pstm.setInt(1, cliente.getLogin().getId_login());
	pstm.setString(2, cliente.getEmailCliente());
	pstm.setString(3, cliente.getNomeCliente());
	pstm.setString(4, cliente.getSenhaCliente());
	pstm.setString(5, cliente.getCpfCliente());
	pstm.setInt(6, cliente.getId_cliente());
	
	pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteById(int id) {
		String sql = "DELETE FROM Cliente WHERE id_cliente = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Cliente getClienteById(int id) {
		String sql = "select * from Cliente WHERE id_cliente = ?";

		Cliente cliente = new Cliente();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			
			cliente.setNomeCliente(rset.getString("nomeCliente"));
			cliente.setEmailCliente(rset.getString("emailCliente"));
			cliente.setSenhaCliente(rset.getString("senhaCliente"));
			cliente.setCpfCliente(rset.getString("cpfCliente"));
			cliente.setId_cliente(rset.getInt("id_cliente"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}

}


