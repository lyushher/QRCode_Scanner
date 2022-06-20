import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeGenerate {
 
    public static void main(String[] args) throws Exception {
         
        String content = "https://simplifyingtechcode.wordpress.com/";
        String pathToStore = "C:\\Tools\\QRCodeGenerated.jpg";
         
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 500, 500);
        MatrixToImageWriter.writeToPath(bitMatrix, "jpg", Paths.get(pathToStore));
         
        System.out.println("QR Code Generated Successfully");
 
    }
 
}