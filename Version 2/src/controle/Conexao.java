/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;

/**
 *
 * @author acsgs
 */
public class Conexao {
    public static String erro="";
    public static ResultSet rs;
    public static Statement st;
    public static Connection con;
    public static void conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/software_1_1_1","root","1234");
            st = con.createStatement();
        } catch (Exception ex) {erro=""+ex;}}
    public static void disconexao(){
        try {
            con.close();
        } catch (SQLException e) {erro=""+e;}}}