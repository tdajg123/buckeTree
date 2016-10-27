package kr.ac.BucketTree.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;


public abstract class AbstractIText5PdfView extends AbstractView {

   public AbstractIText5PdfView() {
      setContentType("application/pdf");
   }

   @Override
   protected boolean generatesDownloadContent() {
      return true;
   }

   @Override
   protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
         HttpServletResponse response) throws Exception {
      ByteArrayOutputStream baos = createTemporaryOutputStream();
      Document document = newDocument();
      PdfWriter writer = newWriter(document, baos);
      prepareWriter(model, writer, request);
      buildPdfMetadata(model, document, request);

      document.open();
      buildPdfDocument(model, document, writer, request, response);
      document.close();
      writeToResponse(response, baos);
   }

   @Override
   protected void writeToResponse(HttpServletResponse response, ByteArrayOutputStream baos) throws IOException {
      response.setContentType(getContentType());
      ServletOutputStream out = response.getOutputStream();
      baos.writeTo(out);
      out.flush();
   }

   protected Document newDocument() {
      Document document = new Document();
      Rectangle one = new Rectangle(600, 600);
      document.setPageSize(one);
      document.setMargins(50, 50, 50, 50);

      return document;
   }

   protected PdfWriter newWriter(Document document, OutputStream os) throws DocumentException {
      return PdfWriter.getInstance(document, os);
   }

   protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request)
         throws DocumentException {
      writer.setViewerPreferences(getViewerPreferences());
   }

   protected int getViewerPreferences() {
      return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
   }

   // Document가 open되기 전, pdf의 meta 정보를 넣을 때 사용
   protected abstract void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request)
         throws Exception;

   // pdf의 내용을 추가하는데 이용
   protected abstract void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
         HttpServletRequest request, HttpServletResponse response) throws Exception;

}