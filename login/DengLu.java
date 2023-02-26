package login;

import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.DengLuJieMian;

public class DengLu {
public static void main(String args[]) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	/*adl = new GuanLiYuanDengluJieMian();*/
	DengLuJieMian dljm = new DengLuJieMian();
}
}
