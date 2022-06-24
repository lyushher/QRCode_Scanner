import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;


public class GenerateQRWithLogo {
 
    public static void main(String[] args) throws Exception {
         
        String content = "https://simplifyingtechcode.wordpress.com/";
        String pathToStore = "C:\\Tools\\QRCodeGenerate.jpg";
         
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 400, 400);
         MatrixToImageConfig imageConfig = new MatrixToImageConfig(MatrixToImageConfig.BLACK, MatrixToImageConfig.WHITE);
          
           BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, imageConfig);
            
            BufferedImage logoImage = ImageIO.read( new File("C:\\Tools\\githublogo.png"));
            int finalImageHeight = qrImage.getHeight() - logoImage.getHeight();
            int finalImageWidth = qrImage.getWidth() - logoImage.getWidth();
           
            BufferedImage finalImage = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = (Graphics2D) finalImage.getGraphics();
            graphics.drawImage(qrImage, 0, 0, null);
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            graphics.drawImage(logoImage, (int) Math.round(finalImageWidth / 2), (int) Math.round(finalImageHeight / 2), null);
             
            ImageIO.write(finalImage, "png", new File(pathToStore));
         
        System.out.println("QR Code with Logo Generated Successfully");
    }
}
