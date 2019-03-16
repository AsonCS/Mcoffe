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
public class Compra {
    private short idcom;
    private short idpro;
    private short idfor;
    private float prcom;
    private short qucom;
    private int dacom;

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
     * @return the idfor
     */
    public short getIdfor() {
        return idfor;
    }

    /**
     * @param idfor the idfor to set
     */
    public void setIdfor(short idfor) {
        this.idfor = idfor;
    }

    /**
     * @return the prcom
     */
    public float getPrcom() {
        return prcom;
    }

    /**
     * @param prcom the prcom to set
     */
    public void setPrcom(float prcom) {
        this.prcom = prcom;
    }

    /**
     * @return the qucom
     */
    public short getQucom() {
        return qucom;
    }

    /**
     * @param qucom the qucom to set
     */
    public void setQucom(short qucom) {
        this.qucom = qucom;
    }

    /**
     * @return the dacom
     */
    public int getDacom() {
        return dacom;
    }

    /**
     * @param dacom the dacom to set
     */
    public void setDacom(int dacom) {
        this.dacom = dacom;
    }
}
