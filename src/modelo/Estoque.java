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
public class Estoque {
    private short idpro;
    private String nopro;
    private float pcpro;
    private float prpro;
    private short qupro;
    private byte qmpro;

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
     * @return the nopro
     */
    public String getNopro() {
        return nopro;
    }

    /**
     * @param nopro the nopro to set
     */
    public void setNopro(String nopro) {
        this.nopro = nopro;
    }

    /**
     * @return the pcpro
     */
    public float getPcpro() {
        return pcpro;
    }

    /**
     * @param pcpro the pcpro to set
     */
    public void setPcpro(float pcpro) {
        this.pcpro = pcpro;
    }

    /**
     * @return the prpro
     */
    public float getPrpro() {
        return prpro;
    }

    /**
     * @param prpro the prpro to set
     */
    public void setPrpro(float prpro) {
        this.prpro = prpro;
    }

    /**
     * @return the qupro
     */
    public short getQupro() {
        return qupro;
    }

    /**
     * @param qupro the qupro to set
     */
    public void setQupro(short qupro) {
        this.qupro = qupro;
    }

    /**
     * @return the qmpro
     */
    public byte getQmpro() {
        return qmpro;
    }

    /**
     * @param qmpro the qmpro to set
     */
    public void setQmpro(byte qmpro) {
        this.qmpro = qmpro;
    }
}
