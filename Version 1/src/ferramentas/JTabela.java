package ferramentas;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class JTabela extends AbstractTableModel{
    private ArrayList linhas = null;
    private String colunas[] = null;
    
    public JTabela(ArrayList lin,String col[]){
        setLinhas(lin);
        setColunas(col);
    }
    public ArrayList getLinhas(){
        return linhas;
    }
    public void setLinhas(ArrayList dados){
        linhas = dados;
    }
    public String getColunas()[]{
        return colunas;
    }
    public void setColunas(String[] nomes){
        colunas = nomes;
    }
    public int getColumnCount(){
        return colunas.length;
    }
    public int getRowCount(){
        return linhas.size();
    }
    public String getColumnName(int numColumn){
        return colunas[numColumn];
    }
    public Object getValueAt(int numLin, int numCol){
        Object linha[] = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
}
