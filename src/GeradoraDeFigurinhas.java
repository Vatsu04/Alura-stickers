import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.File;

import java.io.InputStream;


import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
        // leitura da imagem
        // InputStream inputStream =  new FileInputStream(new File("entrada/filme-maior.jpg"));
        /* InputStream inputStream
         = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies_3.jpg").openStream(); */
        
        
         BufferedImage imagemOriginal = ImageIO.read(inputStream);
        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        // copiar a imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //O que escrever?
        
        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 0, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        
        ImageIO.write(novaImagem, "png",  new File(nomeArquivo));

        
    }

    /* public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    } */
}
