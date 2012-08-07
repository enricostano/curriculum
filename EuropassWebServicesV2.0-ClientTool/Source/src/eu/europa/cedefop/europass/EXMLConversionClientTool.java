package eu.europa.cedefop.europass;

import eu.europa.cedefop.europass.services.client.EuropassXMLConversionServiceStub;

import java.io.File;
import java.io.FileOutputStream;

import javax.activation.DataHandler;

import org.apache.commons.io.FileUtils;

public class EXMLConversionClientTool implements ConversionClientToolInterface{

 private final String serviceURL = "/EuropassXMLConversionService.EuropassXMLConversionServiceHttpSoap12Endpoint/"; 
    private String endPointURL;
    private String outDir;
    private String xmlStr;
    private String exmlLocale;
    
    public EXMLConversionClientTool() {
    }
    
    public void initTool (String url, String xml, String locale, String outPath) {
        this.endPointURL = url + serviceURL;
        this.xmlStr = Utils.toString(xml);
        this.exmlLocale  = locale;
        this.outDir      = outPath;
    }
    
    public void convertToPDFwithXMLCV() throws Exception {
      EuropassXMLConversionServiceStub client = new EuropassXMLConversionServiceStub(  endPointURL);
      
      EuropassXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new EuropassXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.exmlLocale);
      
      EuropassXMLConversionServiceStub.FileResponse response = client.convertToPDFwithXMLCV(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("CV", Utils.EPDF_EXTENSION) );
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFwithXMLLP() throws Exception {
      EuropassXMLConversionServiceStub client = new EuropassXMLConversionServiceStub(  endPointURL);
      
      EuropassXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new EuropassXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.exmlLocale);
      
      EuropassXMLConversionServiceStub.FileResponse response = client.convertToPDFwithXMLLP(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("LP", Utils.EPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFwithHRXMLCV() throws Exception {
      EuropassXMLConversionServiceStub client = new EuropassXMLConversionServiceStub(endPointURL);
      
      EuropassXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new EuropassXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.exmlLocale);
      
      EuropassXMLConversionServiceStub.FileResponse response = client.convertToPDFwithHRXMLCV(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("CV", Utils.HRPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFwithHRXMLLP() throws Exception {
      EuropassXMLConversionServiceStub client = new EuropassXMLConversionServiceStub(  endPointURL);
      
      EuropassXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new EuropassXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.exmlLocale);
      
      EuropassXMLConversionServiceStub.FileResponse response = client.convertToPDFwithHRXMLLP(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("LP", Utils.HRPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToMSWordCV() throws Exception {
      EuropassXMLConversionServiceStub client = new EuropassXMLConversionServiceStub(  endPointURL);
      
      EuropassXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new EuropassXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.exmlLocale);
      
      EuropassXMLConversionServiceStub.FileResponse response = client.convertToMSWordCV(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("CV", Utils.DOC_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToMSWordLP() throws Exception {
      EuropassXMLConversionServiceStub client = new EuropassXMLConversionServiceStub(  endPointURL);
      
      EuropassXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new EuropassXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.exmlLocale);
      
      EuropassXMLConversionServiceStub.FileResponse response = client.convertToMSWordLP(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("LP", Utils.DOC_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToODTCV () throws Exception {
      EuropassXMLConversionServiceStub client = new EuropassXMLConversionServiceStub(  endPointURL);
      
      EuropassXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new EuropassXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.exmlLocale);
      
      EuropassXMLConversionServiceStub.FileResponse response = client.convertToODTCV(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("CV", Utils.ODT_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToODTLP () throws Exception {
      EuropassXMLConversionServiceStub client = new EuropassXMLConversionServiceStub(  endPointURL);
      
      EuropassXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new EuropassXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.exmlLocale);
      
      EuropassXMLConversionServiceStub.FileResponse response = client.convertToODTLP(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("LP", Utils.ODT_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToHTMLCV () throws Exception {
     EuropassXMLConversionServiceStub client = new EuropassXMLConversionServiceStub(  endPointURL);
     
     EuropassXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new EuropassXMLConversionServiceStub.XMLLocaleRequest();
     xmlLocale.setXml(this.xmlStr);
     xmlLocale.setLocale(this.exmlLocale);
     
     EuropassXMLConversionServiceStub.HTMLResponse response = client.convertToHTMLCV(xmlLocale);
     
      String fn = this.outDir+"/" + Utils.fileName("CV", Utils.HTML_EXTENSION);
      File f = new File (fn);
      FileUtils.writeStringToFile(f, response.getHtml(), "UTF-8");
    }
    
    public void convertToHTMLLP () throws Exception {
     EuropassXMLConversionServiceStub client = new EuropassXMLConversionServiceStub(  endPointURL);
     
     EuropassXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new EuropassXMLConversionServiceStub.XMLLocaleRequest();
     xmlLocale.setXml(this.xmlStr);
     xmlLocale.setLocale(this.exmlLocale);
     
     EuropassXMLConversionServiceStub.HTMLResponse response = client.convertToHTMLLP(xmlLocale);
     
      String fn = this.outDir+"/" + Utils.fileName("LP", Utils.HTML_EXTENSION);
      File f = new File (fn);
      FileUtils.writeStringToFile(f, response.getHtml(), "UTF-8");
    
    }
}
