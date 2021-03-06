package Page;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class basePage {

    public static  String getValuefromProprtyFile(String propertyName)  {

        File file= new File("/Users/preranabhatt/Desktop/testfolder/mobiletest/config.properties");
        FileInputStream fileInputStream=null;
        try  {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Properties properties= new Properties();
        try {
            properties.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(propertyName);
    }



    public static  String getURL(String property)
    {
        String GivenUrl= getValuefromProprtyFile("BASEURL")+ getValuefromProprtyFile( property);
        return GivenUrl;
    }
}
