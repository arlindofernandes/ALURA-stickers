import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerMaker {

    public void cria(InputStream inputStream , String filename) throws Exception {
        // abrir imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // crialnova imagem
        int width = imagemOriginal.getWidth();
        int height = imagemOriginal.getHeight();
        int newHeight = height + 200;
        BufferedImage novaImagem = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        //copiar a imagem na nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0,0, null);

        //fonte
        var fonte = new Font("Impact", Font.BOLD, 80);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        // escrever na imagem
        String str = "TOPZERA";
        FontMetrics fMetrics = graphics.getFontMetrics();
        Rectangle2D retangulo = fMetrics.getStringBounds(str, graphics);
        int Stringwidth = (int) retangulo.getWidth();
        int posex = (width - Stringwidth)/2;
        int posey = newHeight - 100;
        graphics.drawString(str, posex,posey );

        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        var textLayout = new TextLayout(str,fonte,fontRenderContext);
        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posex, posey);
        graphics.setTransform(transform);

        var outlineStroke = new BasicStroke(Stringwidth *0.004f);
        graphics.setStroke(outlineStroke);
        
        graphics.setColor(Color.black);
        graphics.draw(outline);
        graphics.setClip(outline);




        //salvar em um aquivo
        ImageIO.write(novaImagem, "png", new File(filename));

    }

}
