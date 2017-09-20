/*
 * Feito por John Schmitz Bretas
 * Use e abuse =)
 */

package java.br.net.softwave.client.domain;

import java.util.List;

/** 
 * 
 * @author John Schmitz Bretas 
 */ 

public class Disciplina {
    private String nome;
    private List<Integer> turmasNumero;
    private int atividadesId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Integer> getTurmasNumero() {
        return turmasNumero;
    }

    public void setTurmasNumero(List<Integer> turmasNumero) {
        this.turmasNumero = turmasNumero;
    }

    public int getAtividadesId() {
        return atividadesId;
    }

    public void setAtividadesId(int atividadesId) {
        this.atividadesId = atividadesId;
    }
    
}
