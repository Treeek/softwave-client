/*
 * Feito por John Schmitz Bretas
 * Use e abuse =)
 */

package java.br.net.softwave.client.domain;

import java.time.LocalDate;

/** 
 * 
 * @author John Schmitz Bretas 
 */ 

public class Mesagem {
    private String texto;
    private LocalDate dataEnvio;
    private int trasmissor;
    private int receptor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public int getTrasmissor() {
        return trasmissor;
    }

    public void setTrasmissor(int trasmissor) {
        this.trasmissor = trasmissor;
    }

    public int getReceptor() {
        return receptor;
    }

    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

}
