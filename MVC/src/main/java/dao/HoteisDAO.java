package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Hoteis;

public class HoteisDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Hoteis hoteis) {
		String sql = "INSERT INTO hoteis (cafeDaManha, valor_diaria, nome_hotel) values (?, ?, ?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hoteis.getCafeDaManha());
			pstm.setDouble(2, hoteis.getValor_diaria());
			pstm.setString(3, hoteis.getNome_hotel());

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

	public List<Hoteis> getHoteis(){
		String sql = "select * from hoteis";

		List<Hoteis> listaHoteis = new ArrayList<>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Hoteis hotel = new Hoteis();

				hotel.setId_hotel(rset.getInt("id_hotel"));
				hotel.setNome_hotel(rset.getString("nome_hotel"));
				hotel.setCafeDaManha(rset.getString("cafeDaManha"));
				hotel.setValor_diaria(rset.getDouble("valor_diaria"));
				listaHoteis.add(hotel);
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
		return listaHoteis;
	}

	public void update(Hoteis hotel) {
		String sql = "UPDATE hoteis SET nome_hotel = ?, valor_diaria = ?, cafeDaManha = ? WHERE id_hotel = ?";

		try {
	conn = ConnectionMySQL.createConnectionMySQL();
	pstm = conn.prepareStatement(sql);

	pstm.setString(1, hotel.getNome_hotel());
	pstm.setDouble(2, hotel.getValor_diaria());
	pstm.setString(3, hotel.getCafeDaManha());
	pstm.setInt(4, hotel.getId_hotel());


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
		String sql = "DELETE FROM hoteis WHERE id_hotel = ?";

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

	public Hoteis getHotelById(int id) {
		String sql = "select * from hoteis WHERE id_hotel = ?";

		Hoteis hotel = new Hoteis();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			hotel.setNome_hotel(rset.getString("nome_hotel"));
			hotel.setCafeDaManha(rset.getString("cafeDaManha"));
			hotel.setValor_diaria(rset.getDouble("valor_diaria"));
			hotel.setId_hotel(rset.getInt("id_hotel"));

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
		return hotel;
	}

}
