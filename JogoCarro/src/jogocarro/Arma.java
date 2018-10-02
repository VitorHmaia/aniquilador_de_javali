/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogocarro;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Cainã
 */
public class Arma {
    private int x = 0;
    private int y = 0;
    private int largura;
    private int altura;
    protected Rectangle rect = new Rectangle(0,0,altura,largura);
    private ImageIcon img;
    
    public Arma(String url){
       img     = new ImageIcon(this.getClass().getResource("/"+url));
       largura = img.getIconWidth();
       altura  = img.getIconHeight();
       rect.height = altura;
       rect.width = largura;
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

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }
    
    
}
