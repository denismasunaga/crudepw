package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Carro;

public class CarroDAO {

	public CarroDAO() {

	}

	public void add(Carro carro) throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexaoBanco cb = new ConexaoBanco();

		String sql = "insert into carros(codigo, modelo, cor, fabricante, ano) values (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = cb.obterConexao().prepareStatement(sql);
		pstmt.setInt(1, carro.getCodigo());
		pstmt.setString(2, carro.getModelo());
		pstmt.setString(3, carro.getCor());
		pstmt.setString(4, carro.getFabricante());
		pstmt.setInt(5, carro.getAno());
		pstmt.execute();
	}

	public void update(Carro carro) throws SQLException {
		ConexaoBanco cb = new ConexaoBanco();

		String sql = "update carros set modelo = ?, cor = ?, fabricante = ?, ano = ?";
		PreparedStatement pstmt = cb.obterConexao().prepareStatement(sql);
		pstmt.setInt(1, carro.getCodigo());
		pstmt.setString(2, carro.getModelo());
		pstmt.setString(3, carro.getCor());
		pstmt.setString(4, carro.getFabricante());
		pstmt.setInt(5, carro.getAno());
		pstmt.execute();
	}

	public void delete(Carro carro) throws SQLException {
		ConexaoBanco cb = new ConexaoBanco();

		String sql = "delete from carros where codigo = ?";
		PreparedStatement pstmt = cb.obterConexao().prepareStatement(sql);
		pstmt.setInt(1, carro.getCodigo());
		pstmt.execute();
	}

	public List<Carro> getAll() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexaoBanco cb = new ConexaoBanco();

		Statement stmt = cb.obterConexao().createStatement();
		String sql = "select codigo, modelo, cor, fabricante, ano from carros order by codigo";
		ResultSet rs = stmt.executeQuery(sql);

		List<Carro> listaDeCarros = new ArrayList<Carro>();
		while (rs.next()) {

			Carro carro = new Carro();
			carro.setCodigo(rs.getInt("codigo"));
			carro.setModelo(rs.getString("modelo"));
			carro.setCor(rs.getString("cor"));
			carro.setFabricante(rs.getString("fabricante"));
			carro.setAno(rs.getInt("ano"));

			listaDeCarros.add(carro);
		}
		return listaDeCarros;
	}
	
	public Carro find(int id) throws SQLException {
		ConexaoBanco cb = new ConexaoBanco();

		String sql = "select * from carros where codigo = ?";
		PreparedStatement pstmt = cb.obterConexao().prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		Carro carro = new Carro();
		
		if (rs.first()) {
			carro.setCodigo(rs.getInt("codigo"));
			carro.setModelo(rs.getString("modelo"));
			carro.setCor(rs.getString("cor"));
			carro.setFabricante(rs.getString("fabricante"));
			carro.setAno(rs.getInt("ano"));
		}
		return carro;
	}
}
