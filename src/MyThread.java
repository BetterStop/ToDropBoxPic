import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyThread extends Thread{

    DbxClientV2 client;
    BufferedImage screenShot;

    MyThread(DbxClientV2 cl, BufferedImage scShot){
        client = cl;
        screenShot = scShot;
    }

    @Override
    public void run() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_hhmss");
        Calendar now = Calendar.getInstance();
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(screenShot, "jpeg", os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());
            FileMetadata metadata = client.files().uploadBuilder("/"+formatter.format(now.getTime())+".jpg")
                        .uploadAndFinish(is);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

