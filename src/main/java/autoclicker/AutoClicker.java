package autoclicker;

import org.sikuli.script.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class AutoClicker {

    public static boolean shouldRun = false;

    public void clickImage() {
        shouldRun = true;
        while (shouldRun) {
            try {

                // Create a screen region object that corresponds to the default monitor in full screen
                Screen s = new Screen();


                InputStream resource = this.getClass().getResourceAsStream("/Download.png");
                if (resource == null) {
                    throw new IllegalArgumentException("file not found!");
                }
                    // Specify an image as the target to find on the screen
                BufferedImage bufferedImage = ImageIO.read(resource);
                Image imageTarget = new Image(bufferedImage);

                // Wait for the target to become visible on the screen for at most 5 seconds
                // Once the target is visible, it returns a screen region object corresponding
                // to the region occupied by this target

                Region r = s.wait(imageTarget, 5000);

                // Click the center of the found target
                Mouse.init();
                Mouse.click(r.getCenter(), "L");

            }
            catch (Exception e) {
                e.printStackTrace();
                shouldRun = false;
            }
        }
    }
}