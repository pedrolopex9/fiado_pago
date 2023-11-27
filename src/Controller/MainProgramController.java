package Controller;

import javax.swing.JOptionPane;
import DAO.ClientesDAO;
import DAO.UsuariosDAO;

import java.sql.*;
import java.util.Locale;


import Util.ModuloConexao;
import View.TelaCarregamento;


public class MainProgramController {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaCarregamento().setVisible(true);
			}
		});
		
	}
}
