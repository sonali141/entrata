package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    public static String readPropertyFile(String key)  {

   //     System.out.println(System.getProperty("user.dir"));
        File file =new File(System.getProperty("user.dir")+"\\configPropertyRepo\\GlobalRepo.properties");
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
      /* String myurl= prop.getProperty("URL");
        System.out.println(myurl);
        System.out.println(key);*/
        return prop.getProperty(key);
    }

public static String getURL()
{
    String myurl= ReadPropertiesFile.readPropertyFile("URL");
//    System.out.println(myurl);
    return myurl;

}
}
