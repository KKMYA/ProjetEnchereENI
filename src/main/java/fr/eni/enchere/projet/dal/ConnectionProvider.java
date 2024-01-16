package fr.eni.enchere.projet.dal;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionProvider {
	private static DataSource datasource;
	
	
	/*
	 * Au chargement de la classe, on effectue UNE fois une serie d'instructions pour récupérer le context et le pool de connexion (et ne pas avoir à le faire à chaque demande)
	 */
	static {
		try {
			// 1 - je recupère un lien vers le context de mon pool de connexion (par convention dans le fichier META-INF/context.xml)
			Context context = new InitialContext();
			// 2 - je recupère le pool de connexion nommé "jdbc/pool_cnx"
			datasource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Cette méthode va retourner une connexion à la base de donées à partir du pool de connexion
	 */
	public static Connection getConnection() {
		try {
			// 1 - j'essaye de récupérer une connexion du pool de connexion (c'est là qu'on peut avoir besoin d'attendre qu'une connexion se libère)
			Connection cnx = datasource.getConnection();
			// 2 - si tout se passe bien, je retourne la connexion
			return cnx;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
