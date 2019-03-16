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
public class Recebimento {
    private short idrec;
    private short idpro;
    private short idfor;
    private short idcom;
    private String vadrec;
    private String darec;

    /**
     * @return the idrec
     */
    public short getIdrec() {
        return idrec;
    }

    /**
     * @param idrec the idrec to set
     */
    public void setIdrec(short idrec) {
        this.idrec = idrec;
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
     * @return the idcom
     */
    public short getQurec() {
        return idcom;
    }

    /**
     * @param qurec the idcom to set
     */
    public void setQurec(short qurec) {
        this.idcom = qurec;
    }

    /**
     * @return the vadrec
     */
    public String getVadrec() {
        return vadrec;
    }

    /**
     * @param vadrec the vadrec to set
     */
    public void setVadrec(String vadrec) {
        this.vadrec = vadrec;
    }

    /**
     * @return the darec
     */
    public String getDarec() {
        return darec;
    }

    /**
     * @param darec the darec to set
     */
    public void setDarec(String darec) {
        this.darec = darec;
    }
}
