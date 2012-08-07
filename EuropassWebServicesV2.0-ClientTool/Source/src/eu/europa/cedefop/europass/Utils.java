package eu.europa.cedefop.europass;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStreamReader;

import java.io.StringWriter;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.commons.io.IOUtils;

public class Utils {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
    
    public static final String CV = "CV";
    
    public static final String HRXML_EXTENSION = "-hrxml.xml";
    public static final String EXML_EXTENSION  = ".xml";
    public static final String HRPDF_EXTENSION = "-hrxml.pdf";
    public static final String EPDF_EXTENSION  = ".pdf";
    public static final String ODT_EXTENSION   = ".odt";
    public static final String DOC_EXTENSION   = ".doc";
    public static final String HTML_EXTENSION  = ".html";
    public static final String JSON_EXTENSION  = ".json";
    
    
    public Utils() {
    }
    
    public static String toString (String path) {
      String str = null; 
      
      try {
        StringWriter writer = new StringWriter();
        IOUtils.copy(new FileInputStream(path), writer, "UTF-8");
        str = writer.toString();
        
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
    }
    
    public static File toFile (String path) {
        File file = new File(path);
        if (file.exists()) {
            return file;
        } else {
            System.out.println("Error while reading the file: The file does not exist");
            return null;
        }
    }
    
    public static String fileName(String type, String extension) {
        Date now = new Date();
        String date = format.format(now);
        if (type.length() > 0 && type!=null){
            type = "-" + type;
        }
        String fileName = "Europass"+type+"-"+date+extension;;
        
        return fileName;
    }
}
