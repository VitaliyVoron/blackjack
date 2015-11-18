package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import model.Player;

public class DAOService {
	
	Player player;
	
	public void updatePlayerAccount(Player player) {
		this.player = player;
        Connection c = null;
        Statement st = null;
        try {
                c = DriverManager.getConnection(
                                "jdbc:postgresql://localhost:5432/blackjack",
                                "postgres", "123");
                c.getAutoCommit();
                st = c.createStatement();
                String s = "UPDATE money SET money =" + player.getMoney()
                                + " WHERE  ='" + player.getAccountNumber() + "';";
                st.executeUpdate(s);
                st.close();
                c.close();
        } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.out.println("Problems with updatePlayerAccount DB");
        }
	}
	
	public void getPlayerAccount(Player player) {
		this.player = player;
        Connection c = null;
        Statement st = null;
        try {
                c = DriverManager.getConnection(
                                "jdbc:postgresql://localhost:5432/blackjack",
                                "postgres", "123");
                c.getAutoCommit();
                st = c.createStatement();
                String s = "SELECT money FROM porse =" + player.getMoney()
                                + " WHERE  ='" + player.getAccountNumber() + "';";
                //st.executeUpdate(s);
                st.close();
                c.close();
        } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.out.println("Problems with getPlayerAccount DB");
        }
	}
	
	

}
