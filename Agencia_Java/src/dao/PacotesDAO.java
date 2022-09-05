package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Destinos;
import modelo.Hoteis;
import modelo.PacotesViagem;


//SAVE-CREATE
public class PacotesDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(PacotesViagem pacote) {
		String sql = "INSERT INTO pacotesviagem (valor_pacote, promo, id_hotel, id_destino) values (?, ?, ?, ?);";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setDouble(1, pacote.getValor_pacote());
			pstm.setString(2, pacote.getPromo());
			pstm.setInt(3, pacote.getHotel().getId_hotel());
			pstm.setInt(4, pacote.getDestino().getId_destino());

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


	//READ
	public List<PacotesViagem> getPacotes(){
		String sql = "select * from pacotesviagem;";

		List<PacotesViagem> listaPacotes = new ArrayList<>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				PacotesViagem pacote = new PacotesViagem();
				Hoteis hotel = new Hoteis();
				Destinos destino = new Destinos();

				pacote.setId_pacote(rset.getInt("id_pacote"));
				pacote.setPromo(rset.getString("promo"));
				pacote.setValor_pacote(rset.getDouble("valor_pacote"));
				hotel.setNome_hotel(rset.getString("nome_hotel"));
				hotel.setValor_diaria(rset.getDouble("valor_diaria"));
				destino.setPais(rset.getString("pais"));
				destino.setNomeDestino(rset.getString("nomeDestino"));
				destino.setCidade_origem(rset.getString("cidade_origem"));
				pacote.setHotel(hotel);
				pacote.setDestino(destino);
				listaPacotes.add(pacote);
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
		return listaPacotes;
	}

	//UPDATE
	public void update(PacotesViagem pacote) {
		String sql = "UPDATE pacotesviagem SET valor_pacote, promo, id_hotel, id_destino WHERE id_pacote = ?;";

		try {
	conn = ConnectionMySQL.createConnectionMySQL();
	pstm = conn.prepareStatement(sql);

	pstm.setDouble(1, pacote.getValor_pacote());
	pstm.setString(2, pacote.getPromo());
	pstm.setInt(3, pacote.getHotel().getId_hotel());
	pstm.setInt(4, pacote.getDestino().getId_destino());
	pstm.setInt(5, pacote.getId_pacote());

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

	//DELETE
	public void deleteById(int id) {
		String sql = "DELETE FROM pacotesviagem WHERE id_pacote = ?;";

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


	//BUSCAR POR ID
	public PacotesViagem getPacoteById(int id) {
		String sql = "select * from pacotesviagem WHERE id_pacote = ?;";

		PacotesViagem pacote = new PacotesViagem();
		Destinos destino = new Destinos();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			pacote.setPromo(rset.getString("promo"));
			pacote.setValor_pacote(rset.getDouble("valor_pacote"));
			destino.setNomeDestino(rset.getString("nomeDestino"));
			pacote.setDestino(destino);
			pacote.setId_pacote(rset.getInt("id_pacote"));


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
		return pacote;
	}

}
