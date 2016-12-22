package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Basicas.Boleto;
import Conexao.ConnectionFactory;



public class Boletodao {

    private Connection connection;

    public Boletodao() {

	try {
	    this.connection = new ConnectionFactory().getConnection();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public void salvar(Boleto boleto) {

	String sql = "INSERT INTO BOLETO (COD_BOLETO,DATA_PAGAMENTO,VALOR_PAGO) VALUES (?,?,?)";
	PreparedStatement stmt;
	try {
	    stmt = connection.prepareStatement(sql);
	
	    stmt.setInt(1, boleto.getCodigoBoleto());
	    stmt.setDate(2, new java.sql.Date(boleto.getDataPagamento().getTime()));
	    stmt.setDouble(3, boleto.getValorPago());
	        
	    stmt.execute();
	    connection.close();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

	
	public void alterar(Boleto boleto) {

	try {

		String sql = "UPDATE FATURA SET COD_BOLETO,DATA_PAGAMENTO,VALOR_PAGO=? WHERE COD_BOLETO=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, boleto.getCodigoBoleto());
	    stmt.setDate(2, new java.sql.Date(boleto.getDataPagamento().getTime()));
	    stmt.setDouble(3, boleto.getValorPago());

		stmt.execute();
		connection.close();

	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}

	public Boleto remover(int codigoBoleto) {

	try {
		String sql = "DELETE FROM BOLETO WHERE COD_BOLETO = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, codigoBoleto);
		stmt.execute();
		connection.close();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	return null;
}

   public List<Boleto> listar() {

	try {
	    List<Boleto> listaBoleto = new ArrayList<Boleto>();
	    PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Boleto ORDER BY COD_BOLETO");

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		listaBoleto.add(montarObjeto(rs));
	    }

	    rs.close();
	    stmt.close();
	    connection.close();

	    return listaBoleto;
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }
   
   public Boleto buscarPorcodigoBoleto(int codigoBoleto) {

		try {
			Boleto boleto = null;

			String sql = "SELECT * FROM BOLETO WHERE COD_BOLETO= ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, codigoBoleto);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				boleto = new Boleto();
				boleto.setCodigoBoleto(rs.getInt("codigoBoleto"));
				boleto.setValorPago(rs.getDouble("valorPago"));
				boleto.setDataPagamento(rs.getDate("dataPagamento"));
			}

			rs.close();
			stmt.close();
			connection.close();

			return boleto;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


    private Boleto montarObjeto(ResultSet rs) throws SQLException {

    Boleto boleto = new Boleto();
	boleto.setCodigoBoleto(rs.getInt("codigoBoleto"));
	boleto.setValorPago(rs.getDouble("valorPago"));
	boleto.setDataPagamento(rs.getDate("dataPagamento"));
	return boleto;
    }

}
