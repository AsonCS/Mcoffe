package ferramentas;

import java.sql.*;

public class Conexao {
    
    static public Statement cs;
    static public Connection cc;// private
    static public ResultSet cr;// apagar
    
    public static void conexao() {
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            cc = DriverManager.getConnection("jdbc:mysql://localhost:3306/mcoffe","root","");
            cs = cc.createStatement();
            System.out.println("on");
        }catch (Exception e){
            System.out.println(e + "\nCriar banco");
            try{
                //Class.forName("com.mysql.jdbc.Driver");
                cc = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
                cs = cc.createStatement();
                cs.execute("create database if not exists mcoffe default character set utf8 default collate utf8_general_ci;");
                cc = DriverManager.getConnection("jdbc:mysql://localhost:3306/mcoffe","root","");
                cs = cc.createStatement();
                cs.execute("create table if not exists estoque (cod smallint not null primary key auto_increment,pro varchar (30) not null,pmp decimal(6,2),pre decimal(6,2) not null,qua smallint not null,qum tinyint) default charset = utf8;");
                cs.execute("create table if not exists cliente (id smallint not null primary key auto_increment,nome varchar(30)not null,cpf decimal(11,0)not null,cep decimal(8,0)not null,cpre decimal(6,2)) default charset = utf8;");
                cs.execute("create table if not exists comanda (id smallint not null primary key auto_increment,num varchar (3) not null,lpre decimal(6,2)) default charset = utf8;");
                cs.execute("create table if not exists venda (idCli smallint, idCom smallint, codPro smallint, pre decimal, dat date) default charset = utf8;");
                cs.execute("create view venCli as select estoque.pro, venda.dat, venda.pre, venda.idCli from venda JOIN cliente on cliente.id = venda.idCli left join estoque on estoque.cod = venda.codPro;");
                cs.execute("create view venCom as select estoque.pro, venda.dat, venda.pre, venda.idCom from venda JOIN comanda on comanda.id = venda.idCom left join estoque on estoque.cod = venda.codPro;");
                System.out.println("on");
            }catch (Exception en){
                System.err.println("Erro na Criação.");
            }
        }
    }        
    public static void disconexao(){
        try {
            if(!(cs.isClosed())){ cs.close();}
            if(!(cc.isClosed())){ cc.close();}
            System.out.println("off");
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão.");
        }}}
