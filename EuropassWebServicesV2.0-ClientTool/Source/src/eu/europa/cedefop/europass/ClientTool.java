package eu.europa.cedefop.europass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.HashMap;

import java.util.Iterator;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class ClientTool {
    private static final   String USAGE  = "[-h] [-c <type>] [-L <language>] [-O <output-directory>][-F <input-file>] [-T <conversion-type>] [-M <conversion-method>] ";
    private static final   String HEADER = "Europass Web Services Client - A tool for converting files between Europass supported formats.";
    private static final   String FOOTER = "For more information, please contact Europass europass-support@cedefop.europa.eu.";
    
    private static HashMap classesMap  = new HashMap();
    private static HashMap methodsMap  = new HashMap();
    private static HashMap jsonMap     = new HashMap();
    private static HashMap exmlMap     = new HashMap();
    private static HashMap pdfexmlMap  = new HashMap();
    private static HashMap hrxmlMap    = new HashMap();
    private static HashMap pdfhrxmlMap = new HashMap();

    public ClientTool() {
        /*
         * Create the maps that contain the mapping for the classes and the methods used for their respective conversion type/method
         */
        //ClassesMap: Key = Conversion Type, Value = Class
        classesMap.put("json","eu.europa.cedefop.europass.JSONConversionClientTool");
        classesMap.put("exml","eu.europa.cedefop.europass.EXMLConversionClientTool");
        classesMap.put("pdf-exml","eu.europa.cedefop.europass.PDFWithEuropassXMLConversionClientTool");
        classesMap.put("hrxml","eu.europa.cedefop.europass.HRXMLConversionClientTool");
        classesMap.put("pdf-hrxml","eu.europa.cedefop.europass.PdfWithHRXMLConversionClientTool");
        
        //jsonMap: Key = Conversion Method, Value = Method() 
        jsonMap.put("to-exml-cv","convertToXMLCV");
        jsonMap.put("to-exml-lp","convertToXMLLP");
        jsonMap.put("to-hrxml","convertToHRXML");
        jsonMap.put("to-pdf-exml-cv","convertToPDFwithXMLCV");
        jsonMap.put("to-pdf-exml-lp","convertToPDFwithXMLLP");
        jsonMap.put("to-pdf-hrxml-cv","convertToPDFWithHRXMLCV");
        jsonMap.put("to-pdf-hrxml-lp","convertToPDFWithHRXMLLP");
        jsonMap.put("to-html-cv","convertToHTMLCV");
        jsonMap.put("to-html-lp","convertToHTMLLP");
        jsonMap.put("to-doc-cv","convertToMSWordCV");
        jsonMap.put("to-doc-lp","convertToMSWordLP");
        jsonMap.put("to-odt-cv","convertToODTCV");
        jsonMap.put("to-odt-lp","convertToODTLP");
        jsonMap.put("from-hrxml","convertFromHRXML");
        jsonMap.put("from-exml-cv","convertFromXMLCV");
        jsonMap.put("from-exml-lp","convertFromXMLLP");
        
        //exmlMap: Key = Conversion Method, Value = Method()   
        exmlMap.put("to-pdf-exml-cv","convertToPDFwithXMLCV");
        exmlMap.put("to-pdf-exml-lp","convertToPDFwithXMLLP");
        exmlMap.put("to-pdf-hrxml-cv","convertToPDFwithHRXMLCV");
        exmlMap.put("to-pdf-hrxml-lp","convertToPDFwithHRXMLLP");
        exmlMap.put("to-html-cv","convertToHTMLCV");
        exmlMap.put("to-html-lp","convertToHTMLLP");
        exmlMap.put("to-doc-cv","convertToMSWordCV");
        exmlMap.put("to-doc-lp","convertToMSWordLP");
        exmlMap.put("to-odt-cv","convertToODTCV");
        exmlMap.put("to-odt-lp","convertToODTLP");
        
        //pdfexmlMap: Key = Conversion Method, Value = Method()   
        pdfexmlMap.put("to-pdf-hrxml-cv","convertToPDFwithHRXMLCV");
        pdfexmlMap.put("to-pdf-hrxml-lp","convertToPDFwithHRXMLLP");    
        pdfexmlMap.put("to-html-cv","convertToHTMLCV");
        pdfexmlMap.put("to-html-lp","convertToHTMLLP");
        pdfexmlMap.put("to-doc-cv","convertToMSWordCV");
        pdfexmlMap.put("to-doc-lp","convertToMSWordLP");
        pdfexmlMap.put("to-odt-cv","convertToODTCV");
        pdfexmlMap.put("to-odt-lp","convertToODTLP");
        pdfexmlMap.put("to-exml-cv","convertToXMLCV");
        pdfexmlMap.put("to-exml-lp","convertToXMLLP");
        pdfexmlMap.put("to-exml","extractXML");
        pdfexmlMap.put("to-hrxml","convertToHRXML");
        
        
        //hrxmlMap: Key = Conversion Method, Value = Method()    
        hrxmlMap.put("to-pdf-exml-cv","convertToPDFwithXMLCV");
        hrxmlMap.put("to-pdf-exml-lp","convertToPDFwithXMLLP");
        hrxmlMap.put("to-pdf-hrxml-cv","convertToPDFwithHRXMLCV");
        hrxmlMap.put("to-pdf-hrxml-lp","convertToPDFwithHRXMLLP"); 
        hrxmlMap.put("to-html-cv","convertToHTMLCV");
        hrxmlMap.put("to-html-lp","convertToHTMLLP");
        hrxmlMap.put("to-doc-cv","convertToMSWordCV");
        hrxmlMap.put("to-doc-lp","convertToMSWordLP");
        hrxmlMap.put("to-odt-cv","convertToODTCV");
        hrxmlMap.put("to-odt-lp","convertToODTLP");
        hrxmlMap.put("to-exml-cv","convertToXMLCV");
        hrxmlMap.put("to-exml-lp","convertToXMLLP");
        hrxmlMap.put("from-exml","convertFromXML");
        
        //pdfhrxmlMap: Key = Conversion Method, Value = Method()     
        pdfhrxmlMap.put("to-pdf-exml-cv","convertToPDFwithXMLCV");
        pdfhrxmlMap.put("to-pdf-exml-lp","convertToPDFwithXMLLP");
        pdfhrxmlMap.put("to-html-cv","convertToHTMLCV");
        pdfhrxmlMap.put("to-html-lp","convertToHTMLLP");
        pdfhrxmlMap.put("to-doc-cv","convertToMSWordCV");
        pdfhrxmlMap.put("to-doc-lp","convertToMSWordLP");
        pdfhrxmlMap.put("to-odt-cv","convertToODTCV");
        pdfhrxmlMap.put("to-odt-lp","convertToODTLP");
        pdfhrxmlMap.put("to-exml-cv","convertToXMLCV");
        pdfhrxmlMap.put("to-exml-lp","convertToXMLLP");
        pdfhrxmlMap.put("to-hrxml","convertToHRXML");
        
        //methodsMap: Key = Conversion Type, Value = Method Map
        methodsMap.put("json",jsonMap);
        methodsMap.put("exml",exmlMap);
        methodsMap.put("pdf-exml",pdfexmlMap);
        methodsMap.put("hrxml",hrxmlMap);
        methodsMap.put("pdf-hrxml",pdfhrxmlMap);
    }  
  public static void main(String[] args) {
    ClientTool clientTool         = new ClientTool();
    CommandLineParser   parser    = new BasicParser( );
    Options             options   = new Options( );
    Options             eOptions  = new Options( );
    
    options.addOption("h", "help"             , false, "Show help");
    
    options.addOption("L", "language"         , true, "*Required* The language in which to reveive the converted document. E.g. en_GB for English, fr_FR for French");
    options.addOption("F", "input-file"       , true, "*Required* The input file to be converted (in one of the following formats: Europass XML, Europass PDF with E-XML attachment,"
                                                      + " Europass JSON, HR-XML, PDF with HR-XML attachment)");
    options.addOption("T", "conversion-type"  , true, "*Required* Type one of the following to denote the conversion service to use, (\"json\", \"exml\", \"pdf-exml\", \"hrxml\", \"pdf-hrxml\")");
    options.addOption("M", "conversion-method", true, "*Required* Denote the conversion method to use, (\"to-exml-cv\", \"to-json\", \"to-pdf+exml-lp\"). Type -c and the conversion type, to see all the available options");
    options.addOption("O", "output-directory" , true, "*Optional* The directory you want to save the converted file");
    options.addOption("U", "url"              , true, "*Optional* Provide the Europass web services url, e.g. \"http://europass.cedefop.europa.eu/soapsws/services\"");
    options.addOption("c", "conv"             , true, "*Info* Available Conversion Methods based on the conversion service, (\"json\", \"exml\", \"pdf-exml\", \"hrxml\", \"pdf-hrxml\")");
    
    
    if (args.length == 0) {
        clientTool.helpFile(options);
        System.exit(0);
    }
    
    
    String locale = "";
    String filename = "";
    String cType = "";
    String cMethod= "";
    String cHelp="";
    String url ="";
    String outDir = "";
    
    try {
        CommandLine cl = parser.parse( options, args );
    
        if (cl.hasOption("h")) {
              clientTool.helpFile(options);
              System.exit(0);
        }
        if (cl.hasOption("c")) {
            cHelp = cl.getOptionValue("c");
            if (cHelp != null && cHelp.length()>0) {
                clientTool.methodHelp(cHelp);
            }
            System.out.println();
            clientTool.helpFile(eOptions);
            System.exit(0);
        }
        if (cl.hasOption("O")) {
              outDir = cl.getOptionValue("O");
        } else {
              outDir = ".";
        }
        if (cl.hasOption("L")) {
              locale = cl.getOptionValue("L");
        } else {
              locale = "en_GB";
        }
        if (cl.hasOption("F")) {
              filename = cl.getOptionValue("F");
        } else {
            clientTool.helpFile(options);
            System.exit(0);
        }
        if (cl.hasOption("T")) {
              cType = cl.getOptionValue("T");
        } else {
            clientTool.helpFile(options);
            System.exit(0);
        }
        if (cl.hasOption("M")) {
              cMethod = cl.getOptionValue("M");
        } else {
            clientTool.helpFile(options);
            System.exit(0);
        }
        if (cl.hasOption("U")) {
              url = cl.getOptionValue("U");
        } else {
            url="http://europass.cedefop.europa.eu/soapws/services";
        }
    } catch (ParseException e) {
        System.out.println("Error parsing the command-line parameter " + e);
        System.exit(1);
    }
    
    try {
        clientTool.callMethod(filename, url, locale, outDir, cType, cMethod);
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
  
  
    protected void callMethod(String fileName, String url, String locale, String outDir, String cClass, String cMethod) {
        String className = "";
        HashMap methodMap = new HashMap();
        String methodName = "";
        
        Iterator classIt = classesMap.keySet().iterator();
        Iterator methIt  = methodsMap.keySet().iterator();
        
        //Iterate to get the class Name
        while (classIt.hasNext()) {
           String key = (String)classIt.next();
            
            if (key.equals(cClass) )
               className = (String)classesMap.get(key);
        }
        //Iterate to get the Method Hash Map
        while (methIt.hasNext()) {
            String mKey = (String)methIt.next();
            
            if (mKey.equals(cClass)) {
               methodMap = (HashMap)methodsMap.get(mKey);
            }
        }
        //Iterate to get the method Name
        Iterator mNameIt = methodMap.keySet().iterator();
        while (mNameIt.hasNext()) {
            String mNKey = (String)mNameIt.next();
            
            if (mNKey.equals(cMethod)) {
                methodName = (String)methodMap.get(mNKey);
            }
        }
        
        System.out.println("Converting file: " + fileName + ". Please wait....");
        
        Class implClass;
        
        try {
            implClass = Class.forName(className);
            ConversionClientToolInterface convert = (ConversionClientToolInterface)implClass.newInstance();
            convert.initTool(url, fileName, locale, outDir);
            
            Method method = convert.getClass().getMethod(methodName, null);
            method.invoke(convert, null);
            System.out.println("The conversion is complete.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Couldn't find the class.");
            ex.printStackTrace();
        } catch (InstantiationException ine){
            System.out.println("Couldn't instantiate the class.");
            ine.printStackTrace();
        } catch (NoSuchMethodException mex) {
            System.out.println("Couldn't find the method.");
            mex.printStackTrace();
        } catch (InvocationTargetException iex) {
            System.out.println("Couldn't invoke the method.");
            iex.printStackTrace();
        } catch (IllegalAccessException iae) {
            System.out.println("Couldn't access the method.");
            iae.printStackTrace();
        }
    }
  
  protected void helpFile(Options options) {
    HelpFormatter hf = new HelpFormatter( );
    hf.setWidth( 80 );
    hf.printHelp( USAGE, HEADER, options, FOOTER );
  }
  
  protected void methodHelp(String method) {
    
    if (method != null && method.length()>0) {
        System.out.println();
        if (method.equals("json")) {
            System.out.println("The available conversion methods for the \"json\" conversion type are:");
            System.out.println("to-exml-cv, to-exml-lp, to-html-cv, to-html-lp,");
            System.out.println("to-pdf-exml-cv,to-pdf-exml-lp, to-pdf-hrxml-cv, to-pdf-hrxml-lp,");
            System.out.println("to-doc-cv,to-doc-lp, to-odt-cv, to-odt-lp,");
            System.out.println("from-exml-cv, from-exml-lp, from-hrxml");
        } else if (method.equals("exml")) {
            System.out.println("The available conversion methods for the \"exml\" conversion type are:");
            System.out.println("to-pdf-exml-cv, to-pdf-exml-lp, to-pdf-hrxml-cv, to-pdf-hrxml-lp,");
            System.out.println("to-doc-cv,to-doc-lp, to-odt-cv, to-odt-lp,");
            System.out.println("to-html-cv, to-html-lp");
        } else if(method.equals("pdf-exml")) {
            System.out.println("The available conversion methods for the \"pdf-exml\" conversion type are:");
            System.out.println("to-pdf-hrxml-cv, to-pdf-hrxml-lp, to-html-cv, to-html-lp,");
            System.out.println("to-doc-cv, to-doc-lp, to-odt-cv, to-odt-lp,");
            System.out.println("to-exml-cv, to-exml-lp, to-exml, to-hrxml");
        } else if(method.equals("hrxml")) {
            System.out.println("The available conversion methods for the \"hrxml\" conversion type are:");
            System.out.println("to-pdf-exml-cv, to-pdf-exml-lp, to-pdf-hrxml-cv, to-pdf-hrxml-lp,");
            System.out.println("to-html-cv, to-html-lp, to-doc-cv, to-doc-lp,");
            System.out.println("to-odt-cv, to-odt-lp, to-exml-cv, to-exml-lp, from-exml");
       } else if(method.equals("pdf-hrxml")) {
            System.out.println("The available conversion methods for the \"pdf-hrxml\" conversion type are:");
            System.out.println("to-pdf-exml-cv, to-pdf-exml-lp, to-html-cv, to-html-lp,");
            System.out.println("to-doc-cv, to-doc-lp, to-odt-cv, to-odt-lp,");
            System.out.println("to-exml-cv, to-exml-lp, to-hrxml");
      } else {
            System.out.println("Please select a valid conversion type: one of \"json\", \"exml\", \"pdf-exml\", \"hrxml\", \"pdf-hrxml\".");
      }
    } else {
        System.out.println("Please select a valid conversion type: one of \"json\", \"exml\", \"pdf-exml\", \"hrxml\", \"pdf-hrxml\".");
    }
  }
}
