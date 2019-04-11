/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Hosam
 */
public class CaptureImages {

    public static void main(String args[]) throws AWTException, IOException, InterruptedException {
        // capture the whole screen        

        /*// Save as JPEG
        int i = 0;
        while (true) {
            File file = new File("D://SC//" + i + ".jpg");
            ImageIO.write(screencapture, "jpg", file);
            Thread.sleep(100);
            i++;
        }//*/
        try {
            File desFile = new File("D://SC");
            if (!desFile.exists()) {
                desFile.mkdir();
            }
            Robot robot = new Robot();
            String format = "jpg";

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            int i = 0;
            while (true) {
                BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
                ImageIO.write(screenFullImage, format, new File(desFile +"//"+ i + ".jpg"));
                Thread.sleep(10000);
                i++;
            }
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
    }
}
