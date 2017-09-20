/*
 * Feito por John Schmitz Bretas
 * Use e abuse =)
 */

package java.br.net.softwave.client.domain;
/** 
 * 
 * @author John Schmitz Bretas 
 */ 

public class Blog {
    private String autor;
    private String titulo;
    private int visible;
    private AreaConhecimento areaConhecimentoId;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public AreaConhecimento getAreaConhecimentoId() {
        return areaConhecimentoId;
    }

    public void setAreaConhecimentoId(AreaConhecimento areaConhecimentoId) {
        this.areaConhecimentoId = areaConhecimentoId;
    }
    
}
