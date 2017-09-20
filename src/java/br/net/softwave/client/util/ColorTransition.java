package br.net.softwave.client.util;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ColorTransition extends Transition {
    
    private String corHexadecimal;
    private Region regiao;

    public ColorTransition(String corHexadecimal, Region regiao, Duration duracao) {
        setCycleDuration(duracao);
        setInterpolator(Interpolator.LINEAR);
        
        this.corHexadecimal = corHexadecimal;
        this.regiao = regiao;
    }

    @Override
    protected void interpolate(double frac) {
        regiao.setBackground(new Background(new BackgroundFill(Color.web(corHexadecimal, frac), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public String getCorHexadecimal() {
        return corHexadecimal;
    }

    public void setCorHexadecimal(String corHexadecimal) {
        this.corHexadecimal = corHexadecimal;
    }

    public Region getRegiao() {
        return regiao;
    }

    public void setRegiao(Region regiao) {
        this.regiao = regiao;
    }
    
}
