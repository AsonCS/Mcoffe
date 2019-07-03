/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author acsgs
 */
public class Vendas {
    private short idven;
    private short idpro;
    private short idcli;
    private short idcom;
    private String daven;
    private float prven;
    private float pgven;

    /**
     * @return the idven
     */
    public short getIdven() {
        return idven;
    }

    /**
     * @param idven the idven to set
     */
    public void setIdven(short idven) {
        this.idven = idven;
    }

    /**
     * @return the idpro
     */
    public short getIdpro() {
        return idpro;
    }

    /**
     * @param idpro the idpro to set
     */
    public void setIdpro(short idpro) {
        this.idpro = idpro;
    }
    
    /**
     * @return the idcli
     */
    public short getIdcli() {
        return idcli;
    }

    /**
     * @param idcli the idcli to set
     */
    public void setIdcli(short idcli) {
        this.idcli = idcli;
    }

    /**
     * @return the idcom
     */
    public short getIdcom() {
        return idcom;
    }

    /**
     * @param idcom the idcom to set
     */
    public void setIdcom(short idcom) {
        this.idcom = idcom;
    }

    /**
     * @return the daven
     */
    public String getDaven() {
        return daven;
    }

    /**
     * @param daven the daven to set
     */
    public void setDaven(String daven) {
        this.daven = daven;
    }

    /**
     * @return the prven
     */
    public float getPrven() {
        return prven;
    }

    /**
     * @param prven the prven to set
     */
    public void setPrven(float prven) {
        this.prven = prven;
    }

    /**
     * @return the pgven
     */
    public float getPgven() {
        return pgven;
    }

    /**
     * @param pgven the pgven to set
     */
    public void setPgven(float pgven) {
        this.pgven = pgven;
    }
}
