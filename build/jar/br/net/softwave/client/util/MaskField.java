package br.net.softwave.client.util;

import javafx.scene.control.TextField;

public class MaskField {
    
    private final TextField campo;
    private final char[] mascara;

    public MaskField(TextField campo, String mascara) {
        this.campo = campo;
        this.mascara = mascara.toCharArray();
        
        campo.setOnKeyPressed((event) -> {
            char[] caracteres = campo.getText().toCharArray();
            
            for (int i = 0; i < caracteres.length; i++) {
                
            }
        });
    }

    public TextField getCampo() {
        return campo;
    }

    public char[] getMascara() {
        return mascara;
    }

}
