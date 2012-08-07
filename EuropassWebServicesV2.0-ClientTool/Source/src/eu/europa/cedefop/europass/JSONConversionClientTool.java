package eu.europa.cedefop.europass;

import java.io.File;
import eu.europa.cedefop.europass.services.client.JSONConversionServiceStub;

import java.io.FileOutputStream;

import javax.activation.DataHandler;

import org.apache.commons.io.FileUtils;

public class JSONConversionClientTool implements ConversionClientToolInterface {

    private final String serviceURL = "/JSONConversionService.JSONConversionServiceHttpSoap12Endpoint/";
    private String endPointURL;
    private String outDir;
    private String jsonLocale;
    private String xmlStr;
    
    public JSONConversionClientTool() {
    }
    
    public void initTool (String url, String xml, String locale, String outPath) {
        this.endPointURL = url + serviceURL;
        this.jsonLocale  = locale;
        this.xmlStr = Utils.toString(xml);
        this.outDir      = outPath;
    }
    
    public  void convertToXMLCV() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONRequest json = new JSONConversionServiceStub.JSONRequest();
      json.setJson(this.xmlStr);
      
      JSONConversionServiceStub.XMLResponse response = stub.convertToXMLCV(json);
      
//      LOG.debug("Convert to XML: \n" + response.getXml());
      
      String fn = Utils.fileName("CV", Utils.EXML_EXTENSION);
      File f = new File ( this.outDir +"/" + fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
    public void convertToXMLLP() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(this.endPointURL);

      JSONConversionServiceStub.JSONRequest json = new JSONConversionServiceStub.JSONRequest();
      json.setJson(this.xmlStr);

      JSONConversionServiceStub.XMLResponse response = stub.convertToXMLLP(json);

//      LOG.debug("Convert to XML: \n" + response.getXml());

      String fn = Utils.fileName("LP", Utils.EXML_EXTENSION);
      File f = new File(this.outDir +"/"  + fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
    public  void convertToHRXML() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONRequest json = new JSONConversionServiceStub.JSONRequest();
      json.setJson(this.xmlStr);
      
      JSONConversionServiceStub.XMLResponse response = stub.convertToHRXML(json);
      
//      LOG.debug("Convert to HRXML: \n" + response.getXml());
      
      String fn = Utils.fileName("", Utils.HRXML_EXTENSION);
      File f = new File ( this.outDir +"/"  + fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
    public void convertToPDFwithXMLCV() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONLocaleRequest request = new JSONConversionServiceStub.JSONLocaleRequest();
      request.setJson(this.xmlStr);
      request.setLocale(this.jsonLocale);
      
      JSONConversionServiceStub.FileResponse response = stub.convertToPDFwithXMLCV(request);
      
      FileOutputStream out = new FileOutputStream(this.outDir +"/" + Utils.fileName("CV", Utils.EPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFwithXMLLP() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONLocaleRequest request = new JSONConversionServiceStub.JSONLocaleRequest();
      request.setJson(this.xmlStr);
      request.setLocale(this.jsonLocale);
      
      JSONConversionServiceStub.FileResponse response = stub.convertToPDFwithXMLLP(request);
      
      FileOutputStream out = new FileOutputStream(this.outDir +"/" + Utils.fileName("LP", Utils.EPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFWithHRXMLCV() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONLocaleRequest request = new JSONConversionServiceStub.JSONLocaleRequest();
      request.setJson(this.xmlStr);
      request.setLocale(this.jsonLocale);
      
      JSONConversionServiceStub.FileResponse response = stub.convertToPDFwithHRXMLCV(request);
      
      FileOutputStream out = new FileOutputStream(this.outDir +"/" + Utils.fileName("CV", Utils.HRPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFWithHRXMLLP() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONLocaleRequest request = new JSONConversionServiceStub.JSONLocaleRequest();
      request.setJson(this.xmlStr);
      request.setLocale(this.jsonLocale);
      
      JSONConversionServiceStub.FileResponse response = stub.convertToPDFwithHRXMLLP(request);
      
      FileOutputStream out = new FileOutputStream(this.outDir +"/" + Utils.fileName("LP", Utils.HRPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToHTMLCV() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONLocaleRequest request = new JSONConversionServiceStub.JSONLocaleRequest();
      request.setJson(this.xmlStr);
      request.setLocale(this.jsonLocale);
      
      JSONConversionServiceStub.HTMLResponse response = stub.convertToHTMLCV(request);
      
//      LOG.debug("Convert to HTML: \n" + response.getHtml());
      
       String fn = Utils.fileName("CV", Utils.HTML_EXTENSION);
       File f = new File ( this.outDir +"/"  + fn);
       FileUtils.writeStringToFile(f, response.getHtml(), "UTF-8");
    }
    
    public void convertToHTMLLP() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONLocaleRequest request = new JSONConversionServiceStub.JSONLocaleRequest();
      request.setJson(this.xmlStr);
      request.setLocale(this.jsonLocale);
      
      JSONConversionServiceStub.HTMLResponse response = stub.convertToHTMLLP(request);
      
//      LOG.debug("Convert to HTML: \n" + response.getHtml());
      
       String fn = Utils.fileName("LP", Utils.HTML_EXTENSION);
       File f = new File ( this.outDir +"/"  + fn);
       FileUtils.writeStringToFile(f, response.getHtml(), "UTF-8");
    }
    
    public void convertToMSWordCV() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONLocaleRequest request = new JSONConversionServiceStub.JSONLocaleRequest();
      request.setJson(this.xmlStr);
      request.setLocale(this.jsonLocale);
      
      JSONConversionServiceStub.FileResponse response = stub.convertToMSWordCV(request);
      
      FileOutputStream out = new FileOutputStream(outDir +"/" + Utils.fileName("CV", Utils.DOC_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToMSWordLP() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONLocaleRequest request = new JSONConversionServiceStub.JSONLocaleRequest();
      request.setJson(this.xmlStr);
      request.setLocale(this.jsonLocale);
      
      JSONConversionServiceStub.FileResponse response = stub.convertToMSWordLP(request);
      
      FileOutputStream out = new FileOutputStream(this.outDir +"/" + Utils.fileName("LP", Utils.DOC_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToODTCV() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONLocaleRequest request = new JSONConversionServiceStub.JSONLocaleRequest();
      request.setJson(this.xmlStr);
      request.setLocale(this.jsonLocale);
      
      JSONConversionServiceStub.FileResponse response = stub.convertToODTCV(request);
      
      FileOutputStream out = new FileOutputStream(this.outDir +"/" + Utils.fileName("CV", Utils.ODT_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToODTLP() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.JSONLocaleRequest request = new JSONConversionServiceStub.JSONLocaleRequest();
      request.setJson(this.xmlStr);
      request.setLocale(this.jsonLocale);
      
      JSONConversionServiceStub.FileResponse response = stub.convertToODTLP(request);
      
      FileOutputStream out = new FileOutputStream(this.outDir +"/" + Utils.fileName("LP", Utils.ODT_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public  void convertFromHRXML() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.XMLRequest xml = new JSONConversionServiceStub.XMLRequest();
      xml.setXml(this.xmlStr);
      
      JSONConversionServiceStub.JSONResponse response = stub.convertFromHRXML(xml);

       String fn = Utils.fileName("json", Utils.JSON_EXTENSION);
       File f = new File ( this.outDir +"/"  + fn);
       FileUtils.writeStringToFile(f, response.getJson(), "UTF-8");
    }
    
    public  void convertFromXMLCV() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(endPointURL);
      
      JSONConversionServiceStub.XMLRequest xml = new JSONConversionServiceStub.XMLRequest();
      xml.setXml(this.xmlStr);
      
      JSONConversionServiceStub.JSONResponse response = stub.convertFromXMLCV(xml);
      
      String fn = Utils.fileName("CV", Utils.JSON_EXTENSION);
      File f = new File ( this.outDir +"/"  + fn);
      FileUtils.writeStringToFile(f, response.getJson(), "UTF-8");
    }
    
    public void convertFromXMLLP() throws Exception {
      JSONConversionServiceStub stub = new JSONConversionServiceStub(this.endPointURL);

      JSONConversionServiceStub.XMLRequest xml = new JSONConversionServiceStub.XMLRequest();
      xml.setXml(this.xmlStr);

      JSONConversionServiceStub.JSONResponse response = stub.convertFromXMLLP(xml);

      String fn = Utils.fileName("LP", Utils.JSON_EXTENSION);
      File f = new File(this.outDir +"/"  + fn);
      FileUtils.writeStringToFile(f, response.getJson(), "UTF-8");
    }
    
}
