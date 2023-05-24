/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogocarro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Cainã
 */
public class Carro {
    
    private int vida = 100;
    private int altura = 80;
    private int largura = 50;
    private Color cor;
    private int x = 0;
    private int y = 0;
    protected Rectangle rect = new Rectangle(0,0,altura,largura);
    private ImageIcon img;

    public Carro(String url){
       img     = new ImageIcon(this.getClass().getResource("/"+url));
       largura = img.getIconWidth();
       altura  = img.getIconHeight();
       rect.height = altura;
       rect.width = largura;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
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
    
    
    
    public void desenhar (Graphics g, int x, int y)
    {
        this.x = x;
        this.y = y;
        if(img != null)
        {
            g.drawImage(img.getImage(), x, y, null);
        }
    }
    
    public void mover (int movX, int movY)
    {
        this.x+=movX;
        this.y+=movY;
    }
    
    public void trataColisao (Carro player, Carro c)
    {
        
        // Colisao traseira
        if(player.getY() == c.getY()+ c.getAltura())
        {
            if((c.getX() > player.getX()&& c.getX()< player.getX()+player.getLargura()) 
               || (c.getX()+ c.getLargura() > player.getX()&& c.getX()+ c.getLargura() < player.getX()+player.getLargura()))
            {
                player.setVida(0);
            }
        }
        
        // Colisao pela direita
        else if (player.getX() + player.getLargura() >= c.getX() && player.getX() + player.getLargura() <= c.getX()+c.getLargura())
        {
            if(c.getY()+ c.getAltura() > player.getY() && c.getY()< player.getY()+player.getAltura())
            {
                player.setVida(0);
            }
        }
        else if (player.getX() <= c.getX() + c.getLargura() && player.getX() + player.getLargura() >= c.getX() )
        {
            if(c.getY()+ c.getAltura() > player.getY() && c.getY()< player.getY()+player.getAltura())
            {
                player.setVida(0);
            }
        }
    }
    
    
    public void trataColisao2 (Tiro t, Carro c)
    {
        
        // Colisao traseira
        if(t.getY()<= c.getY()+ c.getAltura())
        {
            if((c.getX() >= t.getX()&& c.getX()< t.getX()+t.getLargura()) 
               || (c.getX()+ c.getLargura() > t.getX()&& c.getX()+ c.getLargura() < t.getX()+t.getLargura()))
            {
                c.danoVida(30);
            }
        }
    }
    
    public void danoVida(int dano)
    {
        this.vida-=dano;
    }
    
}
