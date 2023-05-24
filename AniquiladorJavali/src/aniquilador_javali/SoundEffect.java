package aniquilador_javali;

import java.io.InputStream;
import javax.sound.sampled.*;

public class SoundEffect implements Runnable{
	
    //ATRIBUTOS
    private String audioPath;
    private boolean loop;
    
    //CONSTRUTOR	
    public SoundEffect(String audioPath, boolean loop) {
        this.audioPath = audioPath;
        this.loop = loop;
    }
    
    //MÉTODOS ESPECÍFICOS
    public void play() {
        Thread t = new Thread(this);
        t.start();
    }
    
    
    @Override
    public void run() {
        try {
            // Inicia a reprodução em loop infinito
            do{
                // Cria um novo fluxo de entrada de áudio a partir do arquivo original
                InputStream inputStream = SoundEffect.class.getResourceAsStream(audioPath);
                AudioInputStream copiedStream = AudioSystem.getAudioInputStream(inputStream);

                // Obtém o formato de áudio do arquivo .wav
                AudioFormat audioFormat = copiedStream.getFormat();

                // Cria um DataLine.Info para a linha de reprodução
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

                // Obtém a linha de reprodução do sistema
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                
                // Abre novamente a linha de reprodução
                line.open(audioFormat);

                // Inicia a reprodução
                line.start();

                // Cria um buffer para armazenar os dados do áudio
                byte[] buffer = new byte[4096];
                int bytesRead = 0;

                // Lê dados do áudio do InputStream e escreve na linha de reprodução
                while ((bytesRead = copiedStream.read(buffer)) != -1) {
                    line.write(buffer, 0, bytesRead);
                }

                // Encerra a reprodução
                line.drain();
                line.stop();
                line.close();
                copiedStream.close();
            }while (loop);

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    // Métodos de acesso
    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
  