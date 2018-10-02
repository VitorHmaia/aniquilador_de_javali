
package jogocarro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class GameCarro extends javax.swing.JFrame implements Runnable {

    private boolean left;
    private boolean right;
    private boolean space;
    private boolean letraR;
    
    public GameCarro() {
        initComponents();
        createBufferStrategy(2);
        Thread t = new Thread(this);
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        else if (evt.getKeyCode() == KeyEvent.VK_SPACE) 
        {
            space = true;
        }
        else if (evt.getKeyCode() == KeyEvent.VK_R) 
        {
            letraR = true;
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }else if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            space = false;
        }
         else if (evt.getKeyCode() == KeyEvent.VK_R) {
            letraR = false;
        }
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameCarro().setVisible(true);
            }
        });
    }

    @Override
    public void run() {
        
        Graphics g;
        int ctrlCar = 0;
        int ctrlTiro = 0;
        int velPlayer = 0;
        int velCar = 1;
        int s = 0;
        int setPlayer=0;
        int setPlayer2=0;

        ArrayList <Carro> carros1 = new ArrayList();
        ArrayList <Carro> carros2 = new ArrayList();
        ArrayList <Carro> lixoCar1 = new ArrayList();
        ArrayList <Carro> lixoCar2 = new ArrayList();
        ArrayList <Faixa> lixoFaixa1 = new ArrayList();
        ArrayList <Faixa> lixoFaixa2 = new ArrayList();
        ArrayList <Faixa> faixas1 = new ArrayList();
        ArrayList <Faixa> faixas2 = new ArrayList();
        ArrayList <Integer> posCar1 = new ArrayList();
        ArrayList <Integer> posCar2 = new ArrayList();
        ArrayList <Tiro> tiros = new ArrayList();
        ArrayList <Tiro> lixoTiros = new ArrayList();
        ArrayList <Explosao> explosoes = new ArrayList();
        ArrayList <Explosao> lixoExplosoes = new ArrayList();
        
        int score=0;
        int record=0;
        int level=1;
        
        Carro player = new Carro("carro2.png");
        player.setX(getWidth()/4);
       
        Arma canhao = new Arma ("Canhao3.png");
        Arma gameOver = new Arma ("GameOver.png");
        
        Random r = new Random();
        
        
        
        while(true)
        {
            g = getBufferStrategy().getDrawGraphics();
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.GREEN);
            
            ctrlCar++;
            if(setPlayer<2&&getWidth()>=1000)
                setPlayer++;
            
            if(setPlayer2<2&&getWidth()<1000)
                setPlayer2++;
           
            if(setPlayer==1|| setPlayer2==1)
                player.setX(getWidth()/2);
            
            if(getWidth()<=1000)
            {
                setPlayer=0;
                g.fillRect(0, 0, getWidth()/4, getHeight());
                g.fillRect(getWidth()-getWidth()/4, 0, getWidth()/4, getHeight());    
            }
            else
            {
                g.fillRect(0, 0, getWidth()/8*3, getHeight());
                g.fillRect(getWidth()-getWidth()/8*3, 0, getWidth()/8*3, getHeight());
            }
            g.setColor(Color.WHITE);
            if(getWidth()<=1000)
            {
                g.fillRect(getWidth()/4, 0, 10, getHeight());
                g.fillRect(getWidth()-getWidth()/4-10, 0, 10, getHeight());
            }
            else
            {
                g.fillRect(getWidth()/8*3, 0, 10, getHeight());
                g.fillRect(getWidth()-getWidth()/8*3-10, 0, 10, getHeight());
            }
            
            if (getWidth()<1000 && posCar1.size()<2)
            {
                velPlayer=2;
                posCar2.clear();
                posCar1.add(getWidth()/8*3-34);
                posCar1.add(getWidth()/8*5-34);
            }
            
            if (getWidth()>1000 && posCar2.size()<4)
            {
                velPlayer=2;
                posCar1.clear();
                posCar2.add(getWidth()/20*8-34);
                posCar2.add(getWidth()/20*9-34);
                posCar2.add(getWidth()/20*10-34);
                posCar2.add(getWidth()/20*11-34);
                posCar2.add(getWidth()/20*12-34);
            }
            
            
            if(getWidth()>1000)
            {
                ctrlCar+=3;
                setPlayer2=0;
                if(faixas2.isEmpty())
                {
                    faixas1.clear();
                    for (int i=1;i<5;i++)
                    {
                        Faixa f = new Faixa();
                        f.setX(getWidth()/8*3 + getWidth()/20*i - f.getLargura());
                        f.desenhar(g);
                        faixas2.add(f);
                    }
                }
            }
            else
            {
                if(faixas1.isEmpty())
                {
                    faixas2.clear();
                    Faixa f = new Faixa();
                    f.setX(getWidth()/2- f.getLargura());
                    f.desenhar(g);
                    faixas1.add(f);
                }
            }
            if(!faixas1.isEmpty())
            {
                Faixa ultima = faixas1.get(faixas1.size()-1);
            
                if(ultima.getY()>90)
                {
                   Faixa f = new Faixa();
                   f.setX(getWidth()/2- f.getLargura());
                   f.desenhar(g);
                   faixas1.add(f); 
                }
            }
            for (Faixa f : faixas1) 
            {
                f.desenhar(g);
                f.mover(velCar*2);
                if(f.getY()> getHeight())
                    lixoFaixa1.add(f);

            }
            
            if(!faixas2.isEmpty())
            {
                Faixa ultima = faixas2.get(faixas2.size()-1);
            
                if(ultima.getY()>90)
                {
                   for (int i=1;i<5;i++)
                    {
                        Faixa f = new Faixa();
                        f.setX(getWidth()/8*3 + getWidth()/20*i - f.getLargura());
                        f.desenhar(g);
                        faixas2.add(f);
                    } 
                }
            }
            for (Faixa f : faixas2) 
            {
                f.desenhar(g);
                f.mover(velCar*2);
                if(f.getY()> getHeight())
                    lixoFaixa2.add(f);
            }
            
            player.desenhar(g ,player.getX() ,getHeight() - player.getAltura());
            
             if(player.getVida()>0 && ctrlCar>=350)
                score++;
            
            if(ctrlCar > 350)
            {
                ctrlCar = 0;
                
                Carro c = new Carro("carro3.png");
                
                if(getWidth()<=1000)
                {
                    carros2.clear();
                    c.setY(0-c.getAltura());
                    c.setX(posCar1.get(r.nextInt(2)));
                    carros1.add(c);  
                }
                else
                {
                    int t = r.nextInt(5);
                    while(s == t)
                        t = r.nextInt(5);
                    
                    s = t;
                    
                    carros1.clear();
                    c.setY(0-c.getAltura());
                    c.setX(posCar2.get(s));
                    carros2.add(c);  
                } 
            }
            for (Tiro t: tiros)
            {
                t.desenhar(g, t.getX(), t.getY());
                t.mover(3);
                
                if(t.getY()<0)
                    lixoTiros.add(t);
                
                if(getWidth()<=1000)
                {
                    for(Carro c : carros1)
                    {
                        c.trataColisao2(t, c);
                        if(t.trataColisao(c, t))
                            lixoTiros.add(t);
                    }
                }
                else
                {
                    for(Carro c : carros2)
                    {
                        c.trataColisao2(t, c);
                        if(t.trataColisao(c, t))
                            lixoTiros.add(t);
                    }
                }
            }
            
            if(score<1000)
            {
                level=1;
                velCar=1;
            }
            else if(score>=1000&&score<2000)
            {
                level=2;
                velCar=2;
                ctrlCar++;
            }
            else if(score>=2000&&score<4000)
            {
                level=3;
                velCar=4;
                ctrlCar+=4;
            }
            else if(score>=4000&&score<8000)
            {
                level=4;
                velCar=5;
                ctrlCar+=8;
            }
            else if(score>=8000&&score<12000)
            {
                level=5;
                velCar=7;
                ctrlCar+=10;
            }
            else if(score>=12000)
            {
                level=6;
                velCar=9;
                ctrlCar+=14;
            }
            
            for (Carro c : carros1) 
            {
                c.desenhar(g,c.getX(),c.getY());
                c.mover(0,velCar);
                c.trataColisao(player, c);
                
                if(c.getVida()<=0)
                {
                    Explosao exp = new  Explosao("Explosao.png");
                    exp.setX((c.getX()+c.getLargura()/2)-(exp.getLargura()/2));
                    exp.setY((c.getY()+c.getAltura()/2)-(exp.getAltura()/2));
                    explosoes.add(exp);
                    lixoCar1.add(c);
                    score+=100;
                }
                if(c.getY()> getHeight())
                    lixoCar1.add(c);
            }
            
            for (Carro c : carros2) 
            {
                c.desenhar(g,c.getX(),c.getY());
                c.mover(0,velCar);
                c.trataColisao(player, c);
                if(c.getVida()<=0)
                {
                    Explosao exp = new  Explosao("Explosao.png");
                    exp.setX((c.getX()+c.getLargura()/2)-(exp.getLargura()/2));
                    exp.setY((c.getY()+c.getAltura()/2)-(exp.getAltura()/2));
                    explosoes.add(exp);
              
                    lixoCar2.add(c);
                    score+=100;
                }
                
                if(c.getY()> getHeight())
                    lixoCar2.add(c);
            }
            
            for(Explosao e : explosoes)
            {
                e.desenhar(g, e.getX(),e.getY());
                g.setColor(Color.BLACK);
                 g.setFont(new Font("Arial",Font.PLAIN,30));
                g.drawString("+100", e.getX(), e.getY());
                if(e.temporizar()>30)
                    lixoExplosoes.add(e);
            }
            
            canhao.desenhar(g,(player.getX()+player.getLargura()/2)-canhao.getLargura()/2, player.getY()-10);
            
            if(player.getVida()<=0)
            {
                if(record<score)
                    record=score;
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                gameOver.desenhar(g,getWidth()/2-gameOver.getLargura()/2, getHeight()/2-gameOver.getAltura()/2);
                g.setColor(Color.RED);
                g.drawString("Pressione R para reiniciar", getWidth() / 2 - 70, gameOver.getY()+gameOver.getAltura()+20);
                g.setFont(new Font("Arial",Font.PLAIN,18));
                if(score==record)
                    g.drawString("NEW RECORD !", getWidth() / 2 - 65, gameOver.getY()-20);
                    
                if(letraR)
                {
                    player.setVida(100);
                    carros1.clear();
                    carros2.clear();
                    tiros.clear();
                    score = 0;
                }
            } 
            if (getWidth()>1000)
            {
                if (left && player.getX() > posCar2.get(0)) {
                    player.mover(velPlayer*-1, 0); 
                } else {
                    if (right && player.getX() < getWidth() - player.getLargura() - getWidth()/8*3) 
                    {
                       player.mover(velPlayer, 0);
                    } 
                    else 
                    {
                        player.mover(0,0);
                    }
                }
            }
            else
            {
                if (left && player.getX() > getWidth()/4) {
                    player.mover(velPlayer*-1, 0);
                } else {
                    if (right && player.getX() < getWidth() - player.getLargura() - getWidth()/4) 
                    {
                       player.mover(velPlayer, 0);
                    } 
                    else 
                    {
                        player.mover(0,0);
                    }
                }
            }
            if (space)
            {
                if(!tiros.isEmpty())
                {
                    Tiro ultimoTiro = tiros.get(tiros.size()-1);
                    if(ultimoTiro.getY()<player.getY()-ultimoTiro.getAltura())
                    {
                        Tiro t = new Tiro("Tiro.png");
                        t.setX(canhao.getX()+canhao.getLargura()/2-t.getLargura()/2);
                        t.setY(canhao.getY());
                        tiros.add(t);
                    }
                }
                else
                {
                    Tiro t = new Tiro("Tiro.png");
                    t.setX(canhao.getX()+canhao.getLargura()/2-t.getLargura()/2);
                    t.setY(canhao.getY());
                    tiros.add(t);
                }
            }
            
            g.setColor(Color.BLUE);
            g.setFont(new Font("Arial",Font.PLAIN,14));
            g.drawString("Score: "+ score, 10, getHeight()-50);
            g.drawString("Record: "+ record, 10, getHeight()-30);
            g.setFont(new Font("Arial",Font.PLAIN,20));
            g.drawString("LEVEL: "+ level, getWidth()/2-40, 60);
            
            
            g.dispose();
            getBufferStrategy().show();
            try 
            {
                if(getWidth()>500)
                    Thread.sleep(2);
                else
                    Thread.sleep(5);
            } 
            catch (InterruptedException ex) {}
            
            faixas1.removeAll(lixoFaixa1);
            lixoFaixa1.clear();
            faixas2.removeAll(lixoFaixa2);
            lixoFaixa2.clear();
            carros1.removeAll(lixoCar1);
            lixoCar1.clear();
            carros2.removeAll(lixoCar2);
            lixoCar2.clear();
            tiros.removeAll(lixoTiros);
            lixoTiros.clear();
            explosoes.removeAll(lixoExplosoes);
            lixoExplosoes.clear();
            
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
