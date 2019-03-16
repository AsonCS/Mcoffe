/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import modelo.Cliente;
import modelo.Comanda;
import static controle.Conexao.*;
import java.util.ArrayList;
import modelo.Estoque;
import modelo.Tabela;
import modelo.Vendas;

/**
 *
 * @author acsgs
 */
public class ControleCaixa {
    public ArrayList dados;
    public Tabela tabela;
    public Float total;
    private String s;
    public void pesquisarcli(Cliente cliente) {
        conexao();
        try{
            PreparedStatement pst = con.prepareStatement("select * from cliente where nocli like ? ;");
            pst.setString(1,"%"+cliente.getNocli()+"%");
            rs = pst.executeQuery();
            rs.first();
            cliente.setNocli(rs.getString("nocli"));
            cliente.setCpcli(rs.getString("cpcli"));
            cliente.setIdcli(rs.getShort("idcli"));
        }catch(Exception e){
            System.out.println("pesquisarcli: "+e);
        }
        disconexao();
    }
    public void pesquisarcom(Comanda comanda) {
        conexao();
        try{
            PreparedStatement pst = con.prepareStatement("select * from comanda where nucom like ? ;");
            pst.setString(1,"%"+comanda.getNucom()+"%");
            rs = pst.executeQuery();
            rs.first();
            comanda.setNucom(rs.getString("nucom"));
            comanda.setIdcom(rs.getShort("idcom"));
        }catch(Exception e){
            System.out.println("pesquisarcom: "+e);
        }
        disconexao();
    }
    public void preencherTabelaCaixaCli(int SQL) {        
        dados = new ArrayList();
        String columnName[] = new String[]{"Descrição da Compra","Data da Compra","Preço da Compra"};
        Float tot=Float.parseFloat("0");
        String coluna = "prven",colun = "D ";
        try{
            conexao();
            rs = st.executeQuery("select * from vendas inner join estoque on vendas.idpro = estoque.idpro where vendas.idcli like '"+SQL+"' order by vendas.idven;");
            rs.first(); 
            do{
                coluna = "prven";
                colun = "D ";
                if(rs.getString(String.valueOf(coluna))==null || "".equals(rs.getString(String.valueOf(coluna)))){
                coluna = "pgven";
                colun = "C ";
                }
                dados.add(new Object[]{" "+rs.getString("nopro")," "+rs.getString("daven"),colun+rs.getFloat(coluna)+" R$"});
                tot+= rs.getFloat("prven");
            }while(rs.next());
            disconexao();
        }catch(Exception e) {System.out.println("preencherTabelaCaixaCli: "+e);        
        }        
        total=tot;
        tabela = new Tabela(dados, columnName);
    }
    public void preencherTabelaCaixaCom(Comanda comanda) {        
        dados = new ArrayList();
        String columnName[] = new String[]{"Descrição da Compra","Data da Compra","Preço da Compra"};
        Float tot=Float.parseFloat("0");
        try{
            conexao();
            s = "c"+comanda.getNucom();
            rs = st.executeQuery("select * from "+s+" inner join vendas on "+s+".idven = vendas.idven inner join estoque on vendas.idpro = estoque.idpro order by "+s+".idcon;");
            rs.first(); 
            do{
                dados.add(new Object[]{" "+rs.getString("nopro")," "+rs.getString("daven"),rs.getFloat("prpro")+" R$"});
                tot+= rs.getFloat("prpro");
            }while(rs.next());
            rs = st.executeQuery("select * from "+s+" inner join vendas on "+s+".idven = vendas.idven order by "+s+".idcon;");
            rs.first(); 
            do{
                dados.add(new Object[]{" "+"Outro"," "+rs.getString("daven"),rs.getFloat("prven")+" R$"});
                tot+= rs.getFloat("prven");
            }while(rs.next());
            disconexao();
        }catch(Exception e) {System.out.println("preencherTabelaCaixaCom: "+e);        
        }        
        total=tot;
        tabela = new Tabela(dados, columnName);
    }
    public void pesquisarPro(Estoque estoque){
        conexao();
        try {
            PreparedStatement pst = con.prepareStatement("select * from estoque where nopro like ? ;");
            pst.setString(1,"%"+estoque.getNopro()+"%");
            rs=pst.executeQuery();
            rs.first();
            estoque.setIdpro(rs.getShort("idpro"));
            estoque.setNopro(rs.getString("nopro"));
            estoque.setPrpro(rs.getFloat("prpro"));            
        }catch (Exception e){System.out.println("pesquisar pro"+e);            
        }
        disconexao();
    }
    public void confirmarCompraCli(Vendas vendas,Estoque estoque,Cliente cliente,int conf){
        conexao();
        if(conf==1){
            try {
                PreparedStatement pst = con.prepareStatement("insert into vendas (idcli,daven,prven) values (?,?,?);");
                pst.setShort(1,cliente.getIdcli());
                pst.setString(2,Data.ndata);
                pst.setFloat(3,vendas.getPrven());
                pst.executeUpdate();
            }catch (Exception e){
                System.out.println("confirmarCompraCli :"+e);
            }
        }else{
            try {
                PreparedStatement pst = con.prepareStatement("insert into vendas (idpro,idcli,daven,prven) values (?,?,?,?);");
                pst.setShort(1,estoque.getIdpro());
                pst.setShort(2,cliente.getIdcli());
                pst.setString(3,Data.ndata);
                pst.setFloat(4,estoque.getPrpro());
                pst.executeUpdate();
            }catch (Exception e){
                System.out.println("else confirmarCompraCli :"+e);
            }
        }
        disconexao();
    }
    public void confirmarCompraCom(Vendas vendas,Estoque estoque,Comanda comanda,int conf){
        conexao();
        if(conf==1){
            try {
                PreparedStatement pst = con.prepareStatement("insert into vendas (idcom,daven,prven) values (?,?,?);");
                pst.setShort(1,comanda.getIdcom());
                pst.setString(2,Data.ndata);
                pst.setFloat(3,vendas.getPrven());
                pst.executeUpdate();
                rs = st.executeQuery("select * from vendas");
                rs.last();                
                PreparedStatement pst1 = con.prepareStatement("insert into "+s+" (idven) values (?);");
                pst1.setShort(1,rs.getShort("idven"));
                pst1.executeUpdate();
            }catch (Exception e){
                System.out.println("confirmarCompraCom :"+e);
            }
        }else{
            try {
                PreparedStatement pst = con.prepareStatement("insert into vendas (idpro,idcom,daven,prven) values (?,?,?,?);");
                pst.setShort(1,estoque.getIdpro());
                pst.setShort(2,comanda.getIdcom());
                pst.setString(3,Data.ndata);
                pst.setFloat(4,estoque.getPrpro());
                pst.executeUpdate();
                rs = st.executeQuery("select * from vendas");
                rs.last();                
                PreparedStatement pst1 = con.prepareStatement("insert into "+s+" (idven) values (?);");
                pst1.setShort(1,rs.getShort("idven"));
                pst1.executeUpdate();
            }catch (Exception e){
                System.out.println("else confirmarCompraCom :"+e);
            }
        }
        disconexao();
    }
    public Float confirmarPagamento(Float valorpag){
        Float troco = Float.parseFloat("0");
        return troco;
    }
}
