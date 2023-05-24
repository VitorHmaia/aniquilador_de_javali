/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogocarro;

import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Graphics;

/**
 *
 * @author Cainã
 */
public class Faixa {
    private int altura = 80;
    private int largura = 10;
    private Color cor = WHITE;
    private int x = 0;
    private int y = 0 - altura;

    public void desenhar(Graphics g) {
        g.setColor(cor);
        g.fillRect(x, y, largura, altura);
    }
    
    public void mover (int veloc)
    {
        this.y += veloc;
                
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
