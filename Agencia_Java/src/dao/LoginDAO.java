package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Login;

public class LoginDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Login Login) {
		String sql = "INSERT INTO login (tipoLogin) values (?);";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, Login.getTipoLogin());

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

	public List<Login> getLogin(){
		String sql = "select * from login;";

		List<Login> listaLogin = new ArrayList<>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Login login = new Login();

				login.setTipoLogin(rset.getString("tipoLogin"));
				listaLogin.add(login);
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
		return listaLogin;
	}

	public void update(Login login) {
		String sql = "UPDATE login SET tipoLogin = ? WHERE id_login = ?;";

		try {
	conn = ConnectionMySQL.createConnectionMySQL();
	pstm = conn.prepareStatement(sql);

	pstm.setString(1, login.getTipoLogin());
	pstm.setInt(2, login.getId_login());
	
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
		String sql = "DELETE FROM login WHERE id_login = ?;";

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

	public Login getLoginById(int id) {
		String sql = "select * from login WHERE id_login = ?;";

		Login login = new Login();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			login.setTipoLogin(rset.getString("tipoLogin"));
			login.setId_login(rset.getInt("id_login"));
		

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
		return login;
	}

}
