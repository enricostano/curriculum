package eu.europa.cedefop.europass;

import eu.europa.cedefop.europass.services.client.PDFWithEuropassXMLConversionServiceStub;

import java.io.File;

import java.io.FileOutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.commons.io.FileUtils;

public class PDFWithEuropassXMLConversionClientTool  implements ConversionClientToolInterface {
    
    private final String serviceURL = "/PDFWithEuropassXMLConversionService.PDFWithEuropassXMLConversionServiceHttpSoap12Endpoint/";
    private String endPointURL;
    private String outDir;
    private File pdfFile;
    private String pdfLocale;
    
    private DataHandler pdfWithXml;
    
    public PDFWithEuropassXMLConversionClientTool() {
    }
    
    public void initTool (String url, String xml, String locale, String outPath) {
        this.endPointURL = url + serviceURL;
        this.pdfLocale   = locale;
        this.pdfFile = Utils.toFile(xml);
        this.outDir      = outPath;
        
        this.pdfWithXml = getPDFWithXMLDH();
    }
    
    protected DataHandler getPDFWithXMLDH(){
      DataHandler fileDH = new DataHandler(new FileDataSource(this.pdfFile));
      return fileDH;
    }
    
    public void convertToPDFwithHRXMLCV() throws Exception {
      PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(endPointURL);
      
      PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithEuropassXMLConversionServiceStub.FileResponse response = client.convertToPDFwithHRXMLCV(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("CV", Utils.HRPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFwithHRXMLLP() throws Exception {
      PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(endPointURL);
      
      PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithEuropassXMLConversionServiceStub.FileResponse response = client.convertToPDFwithHRXMLLP(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("LP", Utils.HRPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToHTMLCV () throws Exception {
     PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(endPointURL);
     
      PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithXml);
      fileLocale.setLocale(this.pdfLocale);
     
     PDFWithEuropassXMLConversionServiceStub.HTMLResponse response = client.convertToHTMLCV(fileLocale);
     
     String fn = this.outDir+ "/" + Utils.fileName("CV", Utils.HTML_EXTENSION);
     File f = new File (fn);
     FileUtils.writeStringToFile(f, response.getHtml(), "UTF-8");
    }
    
    public void convertToHTMLLP () throws Exception {
     PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(endPointURL);
     
      PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithXml);
      fileLocale.setLocale(this.pdfLocale);
     
     PDFWithEuropassXMLConversionServiceStub.HTMLResponse response = client.convertToHTMLLP(fileLocale);
     
     String fn = this.outDir+ "/" + Utils.fileName("LP", Utils.HTML_EXTENSION);
     File f = new File (fn);
     FileUtils.writeStringToFile(f, response.getHtml(), "UTF-8");
    }
    
    public void convertToMSWordCV() throws Exception {
      PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(endPointURL);
      
      PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithEuropassXMLConversionServiceStub.FileResponse response = client.convertToMSWordCV(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("CV", Utils.DOC_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToMSWordLP() throws Exception {
      PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(endPointURL);
      
      PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithEuropassXMLConversionServiceStub.FileResponse response = client.convertToMSWordLP(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("LP", Utils.DOC_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToODTCV () throws Exception {
      PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(endPointURL);
      
      PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithEuropassXMLConversionServiceStub.FileResponse response = client.convertToODTCV(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("CV", Utils.ODT_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToODTLP () throws Exception {
      PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(endPointURL);
      
      PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithEuropassXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithEuropassXMLConversionServiceStub.FileResponse response = client.convertToODTLP(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+ "/" + Utils.fileName("LP", Utils.ODT_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToXMLCV() throws Exception {
      PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(this.endPointURL);
      PDFWithEuropassXMLConversionServiceStub.FileRequest request = new PDFWithEuropassXMLConversionServiceStub.FileRequest();
      request.setFile(this.pdfWithXml);

      PDFWithEuropassXMLConversionServiceStub.XMLResponse response = client.convertToXMLCV(request);

      String fn = this.outDir+ "/" + Utils.fileName("CV", Utils.EXML_EXTENSION);
      File f = new File(fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
    public void convertToXMLLP() throws Exception {
      PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(this.endPointURL);
      PDFWithEuropassXMLConversionServiceStub.FileRequest request = new PDFWithEuropassXMLConversionServiceStub.FileRequest();
      request.setFile(this.pdfWithXml);

      PDFWithEuropassXMLConversionServiceStub.XMLResponse response = client.convertToXMLLP(request);

      String fn = this.outDir+ "/" + Utils.fileName("LP", Utils.EXML_EXTENSION);
      File f = new File(fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
    public void extractXML() throws Exception {
      PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(this.endPointURL);
      PDFWithEuropassXMLConversionServiceStub.FileRequest request = new PDFWithEuropassXMLConversionServiceStub.FileRequest();
      request.setFile(this.pdfWithXml);

      PDFWithEuropassXMLConversionServiceStub.XMLResponse response = client.extractXML(request);

      String fn = this.outDir+ "/" + Utils.fileName("", Utils.EXML_EXTENSION);
      File f = new File(fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
    public void convertToHRXML() throws Exception {
      PDFWithEuropassXMLConversionServiceStub client = new PDFWithEuropassXMLConversionServiceStub(endPointURL);
      PDFWithEuropassXMLConversionServiceStub.FileRequest request = new PDFWithEuropassXMLConversionServiceStub.FileRequest();
      request.setFile(this.pdfWithXml);
      
      PDFWithEuropassXMLConversionServiceStub.XMLResponse response = client.convertToHRXML(request);
      
      String fn = this.outDir+ "/" + Utils.fileName("", Utils.HRXML_EXTENSION);
      File f = new File (fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
}
