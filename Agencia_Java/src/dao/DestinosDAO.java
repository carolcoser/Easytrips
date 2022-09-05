package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.sql.Date;

import connection.ConnectionMySQL;
import modelo.Destinos;

public class DestinosDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Destinos destino) {
		String sql = "INSERT INTO destinos (pais, cidade_origem, data_ida, data_volta, nomeDestino) values (?, ?, ?, ?, ?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getPais());
			pstm.setString(2, destino.getCidade_origem());

			SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy");
			pstm.setDate(3, new Date(formatter.parse(destino.getData_ida()).getTime()));
			pstm.setDate(4, new Date(formatter.parse(destino.getData_volta()).getTime()));
	
			pstm.setString(5, destino.getNomeDestino());

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

	public List<Destinos> getDestinos() {
		String sql = "select * from destinos";

		List<Destinos> listaDestinos = new ArrayList<>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();
			while (rset.next()) {
				Destinos destino = new Destinos();

				destino.setId_destino(rset.getInt("id_destino"));
				destino.setCidade_origem(rset.getString("cidade_origem"));
				destino.setPais(rset.getString("pais"));
				destino.setNomeDestino(rset.getString("nomeDestino"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
				destino.setData_ida(dateFormat.format(rset.getDate("data_ida")));
				destino.setData_volta(dateFormat.format(rset.getDate("data_volta")));
				
				listaDestinos.add(destino);
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
		return listaDestinos;
	}

	public void update(Destinos destino) {
		String sql = "UPDATE destinos SET data_volta = ?, pais = ?, cidade_origem = ?, data_ida = ?, nomeDestino = ? WHERE id_destino = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getData_volta());
			pstm.setString(2, destino.getPais());
			pstm.setString(3, destino.getCidade_origem());
			pstm.setString(4, destino.getData_ida());
			pstm.setString(5, destino.getNomeDestino());
			pstm.setInt(6, destino.getId_destino());

			pstm.executeUpdate();

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
		String sql = "DELETE FROM destinos WHERE id_destino = ?;";

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

	public Destinos getDestinoById(int id) {
		String sql = "select * from destinos WHERE id_destino = ?;";

		Destinos destino = new Destinos();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			destino.setCidade_origem(rset.getString("cidade_origem"));
			destino.setPais(rset.getString("pais"));
			destino.setNomeDestino(rset.getString("nomeDestino"));
			destino.setData_ida(rset.getString("data_ida"));
			destino.setData_volta(rset.getString("data_volta"));
			destino.setId_destino(rset.getInt("id_destino"));

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
		return destino;
	}

}
