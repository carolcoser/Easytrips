package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;

import connection.ConnectionMySQL;
import modelo.Cliente;
import modelo.Compra;
import modelo.PacotesViagem;
import dao.PacotesDAO;

public class CompraDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Compra Compra) {
		String sql = "INSERT INTO Compra (valor_itens, qtd_itens, dataCompra, valorCompra, id_pacote, id_cliente) values (?, ?, ?, ?, ?, ?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setDouble(1, Compra.getValor_itens());
			pstm.setDouble(2, Compra.getQtd_itens());
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(3, new Date(formatter.parse(Compra.getDataCompra()).getTime()));
			
			pstm.setDouble(4, Compra.getValorCompra());
			pstm.setInt(5, Compra.getPacotes().getId_pacote());
			pstm.setInt(6, Compra.getCliente().getId_cliente());
		
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

	public List<Compra> getCompra(){
		String sql = "select * from Compra;";

		List<Compra> listaCompras = new ArrayList<>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Compra compra = new Compra();
				Cliente cliente = new Cliente();
				PacotesViagem pacote = new PacotesViagem();
				
				compra.setId_compra(rset.getInt("id_compra"));
				cliente.setId_cliente(rset.getInt("id_cliente"));
				pacote.setId_pacote(rset.getInt("id_pacote"));
				compra.setQtd_itens(rset.getInt("qtd_itens"));
				compra.setValor_itens(rset.getDouble("valor_itens"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				compra.setDataCompra(dateFormat.format(rset.getDate("dataCompra")));
				
				compra.setValorCompra(rset.getDouble("valorCompra"));
				listaCompras.add(compra);
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
		return listaCompras;
	}

	public void update(Compra compra) {
		String sql = "UPDATE Compra SET valor_itens = ?, qtd_itens = ?, dataCompra = ?, valorCompra = ?, id_pacote = ?, id_cliente = ?  WHERE id_compra = ?";

		try {
	conn = ConnectionMySQL.createConnectionMySQL();
	pstm = conn.prepareStatement(sql);

	pstm.setDouble(1, compra.getValor_itens());
	pstm.setDouble(2, compra.getQtd_itens());
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	pstm.setDate(3, new Date(formatter.parse(compra.getDataCompra()).getTime()));
	
	pstm.setDouble(4, compra.getValorCompra());
	pstm.setInt(5, compra.getPacotes().getId_pacote());
	pstm.setInt(6, compra.getCliente().getId_cliente());
	pstm.setInt(7. compra.getId_compra());
	
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
		String sql = "DELETE FROM Compra WHERE id_compra = ?";

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

	public Compra getCompraById(int id) {
		String sql = "select * from Compra WHERE id_compra = ?";

		Compra compra = new Compra();
		Cliente cliente = new Cliente();
		PacotesViagem pacote = new PacotesViagem();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			cliente.setId_cliente(rset.getInt("id_cliente"));
			pacote.setId_pacote(rset.getInt("id_pacote"));
			compra.setQtd_itens(rset.getInt("qtd_itens"));
			compra.setValor_itens(rset.getDouble("valor_itens"));
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			compra.setDataCompra(dateFormat.format(rset.getDate("dataCompra")));
			
			compra.setValorCompra(rset.getDouble("valorCompra"));
			compra.setId_compra(rset.getInt("id_compra"));

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
		return compra;
	}

}

