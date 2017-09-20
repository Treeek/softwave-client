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

public class Comentario {
    private String texto;
    private int visibilidade;
    private List<Integer> usuariosProntuario;
    private Blog blog;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(int visibilidade) {
        this.visibilidade = visibilidade;
    }

    public List<Integer> getUsuariosProntuario() {
        return usuariosProntuario;
    }

    public void setUsuariosProntuario(List<Integer> usuariosProntuario) {
        this.usuariosProntuario = usuariosProntuario;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
    
}
