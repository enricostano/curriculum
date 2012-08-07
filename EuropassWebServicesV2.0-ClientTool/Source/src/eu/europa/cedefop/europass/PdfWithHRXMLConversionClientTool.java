package eu.europa.cedefop.europass;

import eu.europa.cedefop.europass.services.client.PDFWithHRXMLConversionServiceStub;

import java.io.File;

import java.io.FileOutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.commons.io.FileUtils;

public class PdfWithHRXMLConversionClientTool  implements ConversionClientToolInterface  {
    
    private final String serviceURL = "/PDFWithHRXMLConversionService.PDFWithHRXMLConversionServiceHttpSoap12Endpoint/";
    private String endPointURL;
    private String outDir;
    private String pdfLocale;
    
    private DataHandler pdfWithHRXml;
    private File pdfFile;
    
    public PdfWithHRXMLConversionClientTool() {
    }
    
    public void initTool (String url, String xml, String locale, String outPath) {
        this.endPointURL = url + serviceURL;
        this.pdfLocale   = locale;
        this.pdfFile = Utils.toFile(xml);
        this.outDir      = outPath;
        
        this.pdfWithHRXml   = getPDFWithHRXMLDH();
    }
    
    protected DataHandler getPDFWithHRXMLDH(){
      DataHandler fileDH = new DataHandler(new FileDataSource(pdfFile));
      return fileDH;
    }
    
    public void convertToPDFwithXMLCV() throws Exception {
      PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
      
      PDFWithHRXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithHRXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithHRXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithHRXMLConversionServiceStub.FileResponse response = client.convertToPDFwithXMLCV(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("CV", Utils.EPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToPDFwithXMLLP() throws Exception {
      PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
      
      PDFWithHRXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithHRXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithHRXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithHRXMLConversionServiceStub.FileResponse response = client.convertToPDFwithXMLLP(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("LP", Utils.EPDF_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToHTMLCV () throws Exception {
     PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
     
      PDFWithHRXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithHRXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithHRXml);
      fileLocale.setLocale(this.pdfLocale);
     
     PDFWithHRXMLConversionServiceStub.HTMLResponse response = client.convertToHTMLCV(fileLocale);
     
     String fn = this.outDir+"/" + Utils.fileName("CV", Utils.HTML_EXTENSION);
     File f = new File (fn);
     FileUtils.writeStringToFile(f, response.getHtml(), "UTF-8");
    }
    
    public void convertToHTMLLP () throws Exception {
     PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
     
      PDFWithHRXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithHRXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithHRXml);
      fileLocale.setLocale(this.pdfLocale);
     
     PDFWithHRXMLConversionServiceStub.HTMLResponse response = client.convertToHTMLLP(fileLocale);
     
     String fn = this.outDir+"/" + Utils.fileName("LP", Utils.HTML_EXTENSION);
     File f = new File (fn);
     FileUtils.writeStringToFile(f, response.getHtml(), "UTF-8");
    }
    
    public void convertToMSWordCV() throws Exception {
      PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
      
      PDFWithHRXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithHRXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithHRXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithHRXMLConversionServiceStub.FileResponse response = client.convertToMSWordCV(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("CV", Utils.DOC_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToMSWordLP() throws Exception {
      PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
      
      PDFWithHRXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithHRXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithHRXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithHRXMLConversionServiceStub.FileResponse response = client.convertToMSWordLP(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("LP", Utils.DOC_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToODTCV () throws Exception {
      PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
      
      PDFWithHRXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithHRXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithHRXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithHRXMLConversionServiceStub.FileResponse response = client.convertToODTCV(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("CV", Utils.ODT_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToODTLP () throws Exception {
      PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
      
      PDFWithHRXMLConversionServiceStub.FileLocaleRequest fileLocale = new PDFWithHRXMLConversionServiceStub.FileLocaleRequest();
      fileLocale.setFile(this.pdfWithHRXml);
      fileLocale.setLocale(this.pdfLocale);
      
      PDFWithHRXMLConversionServiceStub.FileResponse response = client.convertToODTLP(fileLocale);
      
      FileOutputStream out = new FileOutputStream(this.outDir+"/" + Utils.fileName("LP", Utils.ODT_EXTENSION));
      DataHandler ret = response.getFile();
      
      ret.writeTo(out);
      out.flush();
    }
    
    public void convertToXMLCV() throws Exception {
      PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
      PDFWithHRXMLConversionServiceStub.FileRequest request = new PDFWithHRXMLConversionServiceStub.FileRequest();
      request.setFile(this.pdfWithHRXml);
      
      PDFWithHRXMLConversionServiceStub.XMLResponse response = client.convertToXMLCV(request);
      
      String fn = this.outDir+"/" + Utils.fileName("CV", Utils.EXML_EXTENSION);
      File f = new File (fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
    public void convertToXMLLP() throws Exception {
      PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
      PDFWithHRXMLConversionServiceStub.FileRequest request = new PDFWithHRXMLConversionServiceStub.FileRequest();
      request.setFile(this.pdfWithHRXml);
      
      PDFWithHRXMLConversionServiceStub.XMLResponse response = client.convertToXMLLP(request);
      
      String fn = this.outDir+"/" + Utils.fileName("LP", Utils.EXML_EXTENSION);
      File f = new File (fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
    
    public void convertToHRXML() throws Exception {
      PDFWithHRXMLConversionServiceStub client = new PDFWithHRXMLConversionServiceStub(this.endPointURL);
      PDFWithHRXMLConversionServiceStub.FileRequest request = new PDFWithHRXMLConversionServiceStub.FileRequest();
      request.setFile(this.pdfWithHRXml);
      
      PDFWithHRXMLConversionServiceStub.XMLResponse response = client.convertToHRXML(request);
      
      String fn = this.outDir+"/" + Utils.fileName("", Utils.HRXML_EXTENSION);
      File f = new File (fn);
      FileUtils.writeStringToFile(f, response.getXml(), "UTF-8");
    }
}
