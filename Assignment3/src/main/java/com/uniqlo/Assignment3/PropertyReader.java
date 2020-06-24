package com.uniqlo.Assignment3;

import java.io.FileInputStream;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
 String propFileName=null;
	public PropertyReader()  {
        propFileName = "V:\\uniqlo\\Assignment3\\src\\test\\resources\\AUT.properties";
    }
	public  String getProperty(String Key) {

        String result = "";

        try {

            Properties prop = new Properties();

            InputStream inputStream = new FileInputStream(propFileName);

            prop.load(inputStream);

            result = prop.getProperty(Key);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
