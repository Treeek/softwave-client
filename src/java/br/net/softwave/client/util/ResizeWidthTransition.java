package br.net.softwave.client.util;

import javafx.animation.Transition;
import javafx.scene.layout.Region;
import javafx.util.Duration;

public class ResizeWidthTransition extends Transition {
    
    private Region regiao;
    private double inicioLargura;
    private double novaLargura;
    private double diferencaLargura;

    public ResizeWidthTransition(Duration duracao, Region regiao, double novaLargura) {
        setCycleDuration(duracao);
        
        this.regiao = regiao;
        this.novaLargura = novaLargura;
        this.inicioLargura = regiao.getWidth();
        this.diferencaLargura = 2 * (novaLargura - inicioLargura);
    }
    
    @Override
    protected void interpolate(double frac) {
        regiao.setMinWidth(inicioLargura + (diferencaLargura * frac));
    }

    public Region getRegiao() {
        return regiao;
    }

    public void setRegiao(Region regiao) {
        this.regiao = regiao;
    }

    public double getInicioLargura() {
        return inicioLargura;
    }

    public void setInicioLargura(double inicioLargura) {
        this.inicioLargura = inicioLargura;
    }

    public double getNovaLargura() {
        return novaLargura;
    }

    public void setNovaLargura(double novaLargura) {
        this.novaLargura = novaLargura;
    }

    public double getDiferencaLargura() {
        return diferencaLargura;
    }

    public void setDiferencaLargura(double diferencaLargura) {
        this.diferencaLargura = diferencaLargura;
    }
    
}
