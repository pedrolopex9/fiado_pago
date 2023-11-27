package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Usuarios;

public class ProdutosDAO {

	private Connection connection;

	public ProdutosDAO(Connection connection) {
		this.connection = connection;
	}

	public void conectar(Connection connection) throws SQLException {
		this.connection = connection;
	}

	public void inserirUsuario(Usuarios user) throws SQLException {

		String sql = "INSERT INTO Usuarios (usuario_id, email, senha, emailrecup, telefone) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user.getUsuario_id());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getSenha());
		preparedStatement.setString(4, user.getEmailRecup());
		preparedStatement.setString(5, user.getSenha());
		preparedStatement.executeUpdate();
	}

	public void atualizarUsuario(Usuarios user) throws SQLException {
		String sql = "UPDATE Usuarios SET senha = ?, emailrecup = ?, telefone = ? WHERE usuario_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getSenha());
		preparedStatement.setString(2, user.getEmailRecup());
		preparedStatement.setString(3, user.getTelefone());
		preparedStatement.setInt(4, user.getUsuario_id());
		preparedStatement.executeUpdate();
	}

	public void excluirUsuario(Usuarios user) throws SQLException {
		String sql = "DELETE FROM Usuarios WHERE usuario_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user.getUsuario_id());
		preparedStatement.executeUpdate();
	}

	public ResultSet listarUsuarios() throws SQLException {
		String sql = "SELECT * FROM Usuarios";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement.executeQuery();
	}

}
