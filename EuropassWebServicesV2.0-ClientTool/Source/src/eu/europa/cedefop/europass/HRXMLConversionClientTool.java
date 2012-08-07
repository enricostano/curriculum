package eu.europa.cedefop.europass;

import eu.europa.cedefop.europass.services.client.HRXMLConversionServiceStub;

import java.io.File;
import java.io.FileOutputStream;

import javax.activation.DataHandler;

import org.apache.commons.io.FileUtils;

public class HRXMLConversionClientTool  implements ConversionClientToolInterface {

    private final String serviceURL = "/HRXMLConversionService.HRXMLConversionServiceHttpSoap12Endpoint/";
    private String endPointURL;
    private String outDir;
    private String hrLocale;
    private String xmlStr;
    
    public HRXMLConversionClientTool() {
    }
    
    public void initTool (String url, String xml, String locale, String outPath) {
        this.endPointURL = url + serviceURL;
        this.hrLocale    = locale;
        this.xmlStr = Utils.toString(xml);
        this.outDir      = outPath;
    }
    
    public void convertToPDFwithXMLCV() throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      
      HRXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new HRXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.hrLocale);
      
      HRXMLConversionServiceStub.FileResponse response = client.convertToPDFwithXMLCV(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("CV", Utils.EPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFwithXMLLP() throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      
      HRXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new HRXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.hrLocale);
      
      HRXMLConversionServiceStub.FileResponse response = client.convertToPDFwithXMLLP(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("LP", Utils.EPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFwithHRXMLCV() throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      
      HRXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new HRXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.hrLocale);
      
      HRXMLConversionServiceStub.FileResponse response = client.convertToPDFwithHRXMLCV(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("CV", Utils.HRPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFwithHRXMLLP() throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      
      HRXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new HRXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.hrLocale);
      
      HRXMLConversionServiceStub.FileResponse response = client.convertToPDFwithHRXMLLP(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("LP", Utils.HRPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToHTMLCV () throws Exception {
     HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
     
     HRXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new HRXMLConversionServiceStub.XMLLocaleRequest();
     xmlLocale.setXml(this.xmlStr);
     xmlLocale.setLocale(this.hrLocale);
     
     HRXMLConversionServiceStub.HTMLResponse response = client.convertToHTMLCV(xmlLocale);
     
     String fn = this.outDir+ "/" + Utils.fileName("CV", Utils.HTML_EXTENSION);
     File f = new File (fn);
     FileUtils.writeStringToFile(f, response.getHtml(), "UTF-8");
    }
    
    public void convertToHTMLLP () throws Exception {
     HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
     
     HRXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new HRXMLConversionServiceStub.XMLLocaleRequest();
     xmlLocale.setXml(this.xmlStr);
     xmlLocale.setLocale(this.hrLocale);
     
     HRXMLConversionServiceStub.HTMLResponse response = client.convertToHTMLLP(xmlLocale);
     
     String fn = this.outDir+ "/" + Utils.fileName("LP", Utils.HTML_EXTENSION);
     File f = new File (fn);
     FileUtils.writeStringToFile(f, response.getHtml(), "UTF-8");
    }
    
    public void convertToMSWordCV() throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      
      HRXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new HRXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.hrLocale);
      
      HRXMLConversionServiceStub.FileResponse response = client.convertToMSWordCV(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("CV", Utils.DOC_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToMSWordLP() throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      
      HRXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new HRXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.hrLocale);
      
      HRXMLConversionServiceStub.FileResponse response = client.convertToMSWordLP(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("LP", Utils.DOC_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToODTCV () throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      
      HRXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new HRXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.hrLocale);
      
      HRXMLConversionServiceStub.FileResponse response = client.convertToODTCV(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("CV", Utils.ODT_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToODTLP () throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      
      HRXMLConversionServiceStub.XMLLocaleRequest xmlLocale = new HRXMLConversionServiceStub.XMLLocaleRequest();
      xmlLocale.setXml(this.xmlStr);
      xmlLocale.setLocale(this.hrLocale);
      
      HRXMLConversionServiceStub.FileResponse response = client.convertToODTLP(xmlLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("LP", Utils.ODT_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToXMLCV() throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      HRXMLConversionServiceStub.XMLRequest request = new HRXMLConversionServiceStub.XMLRequest();
      request.setXml(this.xmlStr);
      
      HRXMLConversionServiceStub.XMLResponse response = client.convertToXMLCV(request);
      
      String fn = this.outDir+ "/" + Utils.fileName("CV", Utils.EXML_EXTENSION);
      File f = new File (fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
    public void convertToXMLLP() throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      HRXMLConversionServiceStub.XMLRequest request = new HRXMLConversionServiceStub.XMLRequest();
      request.setXml(this.xmlStr);
      
      HRXMLConversionServiceStub.XMLResponse response = client.convertToXMLLP(request);
      
      String fn = this.outDir+ "/" + Utils.fileName("LP", Utils.EXML_EXTENSION);
      File f = new File (fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
    public void convertFromXML() throws Exception {
      HRXMLConversionServiceStub client = new HRXMLConversionServiceStub(endPointURL);
      HRXMLConversionServiceStub.XMLRequest request = new HRXMLConversionServiceStub.XMLRequest();
      request.setXml(this.xmlStr);
      
      HRXMLConversionServiceStub.XMLResponse response = client.convertToHRXML(request);
      
      String fn = this.outDir+ "/" + Utils.fileName("", Utils.HRXML_EXTENSION);
      File f = new File (fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
}
