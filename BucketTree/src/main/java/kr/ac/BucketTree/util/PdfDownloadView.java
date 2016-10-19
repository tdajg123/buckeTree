package kr.ac.BucketTree.util;

import java.io.FileInputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import kr.ac.BucketTree.vo.BucketJournalVO;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.Journal_ImageVO;

public class PdfDownloadView extends AbstractIText5PdfView {

	// 파일 이름
	private void setFileNameToResponse(HttpServletRequest request, HttpServletResponse response, String fileName)
			throws UnsupportedEncodingException {
		String userAgent = request.getHeader("User-Agent");

		if (userAgent.indexOf("MSIE") > -1) {
			fileName = URLEncoder.encode(fileName, "utf-8");
			response.setContentType("doesn/matter");
			response.setHeader("Content-Disposition", "filename=\"" + fileName + "\"");
		} else {
			fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		}
	}

	// 파일 이름 생성
	private String createFileName() {
		SimpleDateFormat fileFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return new StringBuilder("여행일기").append("-").append(fileFormat.format(new Date())).append(".pdf").toString();
	}

	@Override
	protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request)
			throws Exception {
		// Meta data 처리는 하지 않습니다.
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			// 파일이름 생성
			String fileName = createFileName();
			setFileNameToResponse(request, response, fileName);
			// 기본 폰트 설정
			BaseFont cfont = BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font font = new Font(cfont, 12, Font.NORMAL, BaseColor.DARK_GRAY);
			// 타이틀 폰트 설정
			Font titlefont = new Font(cfont, 25, Font.BOLD, BaseColor.DARK_GRAY);
			// 해당 idx에 bucketlist, bucketjournal
			BucketListVO bc = (BucketListVO) model.get("bucket");
			List<BucketJournalVO> bjl = (List<BucketJournalVO>) model.get("journals");
			List<Journal_ImageVO> jil = (List<Journal_ImageVO>) model.get("j_images");
			int b_image = (int) model.get("b_image");

			XMLWorkerHelper helper = XMLWorkerHelper.getInstance();

			// CSS 설정
			CSSResolver cssResolver = new StyleAttrCSSResolver();
			CssFile cssFile = helper.getCSS(new FileInputStream(
					"C:/Users/JY/Documents/workspace-sts-3.8.0.RELEASE/BucketTree/src/main/webapp/WEB-INF/views/resources/css/pdf.css"));
			cssResolver.addCss(cssFile);

			// HTML, 폰트 설정
			XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
			// fontProvider.register("C:Windows/Fonts/HANDotum.ttf",
			// "HANDotum");

			CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);

			HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
			htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

			// Pipelines
			PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
			HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
			CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

			XMLWorker worker = new XMLWorker(css, true);
			XMLParser xmlParser = new XMLParser(worker, Charset.forName("UTF-8"));

			// pdf 작성

			// -- 첫페이지 커버 설정
			PdfContentByte canvas = writer.getDirectContentUnder();
			String cover_Image = "http://localhost:8060/BucketTree/bucket/" + b_image + "/image";
			Image c_image = Image.getInstance(cover_Image);
			c_image.scaleAbsolute(400, 400);
			c_image.setAbsolutePosition(100, 100);
			canvas.addImage(c_image);

			// -- 커버 제목 설정
			// the direct content
			PdfContentByte cb = writer.getDirectContent();
			// the rectangle and the text we want to fit in the rectangle
			Rectangle rect = new Rectangle(200, 20, 400, 100);
			String title = bc.getTitle();
			// try to get max font size that fit in rectangle
			BaseFont bf = BaseFont.createFont();
			int textHeightInGlyphSpace = bf.getAscent(title) - bf.getDescent(title);
			float fontSize = 1000f * rect.getHeight() / textHeightInGlyphSpace;
			Phrase phrase = new Phrase(title, titlefont);
			ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, phrase,
					// center horizontally
					(rect.getLeft() + rect.getRight()) / 2,
					// shift baseline based on descent
					rect.getBottom() - bf.getDescentPoint(title, fontSize), 0);

			// draw the rect
			cb.saveState();
			cb.setColorStroke(BaseColor.WHITE);
			cb.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
			cb.stroke();
			cb.restoreState();

			// 두번째 페이지 설정
			document.newPage();

			Journal_ImageVO ji = jil.get(1);
			int ji_1 = ji.getImage_idx();
			String Image1 = "http://localhost:8060/BucketTree/bucket/" + ji_1 + "/image";
			Image img1 = Image.getInstance(Image1);
			img1.scaleAbsolute(300, 300);
			img1.setAbsolutePosition(0, 300);
			document.add(img1);

			PdfContentByte line = writer.getDirectContent();
			CMYKColor blue = new CMYKColor(0.65f, 0.f, 0.03f, 0.19f);
			line.setColorStroke(blue);
			line.moveTo(336, 564);
			line.lineTo(564, 564);
			line.closePathStroke();
			
			
			BucketJournalVO bjv=bjl.get(0);
			String contents=bjv.getTitle();
			
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(340, 540);
	        cb.setFontAndSize(cfont, 12);
	        cb.showText(contents);
	        cb.endText();
	        cb.restoreState();

			ji = jil.get(1);
			int ji_2 = ji.getImage_idx();
			String Image2 = "http://localhost:8060/BucketTree/bucket/" + ji_2 + "/image";
			Image img2 = Image.getInstance(Image2);
			img2.scaleAbsolute(300, 300);
			img2.setAbsolutePosition(300, 0);
			document.add(img2);

			PdfContentByte under_line = writer.getDirectContent();
			under_line.setColorStroke(blue);
			under_line.moveTo(36, 36);
			under_line.lineTo(264, 36);
			under_line.closePathStroke();
			
			bjv=bjl.get(6);
			contents=bjv.getTitle();
			
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(120, 50);
	        cb.setFontAndSize(cfont, 12);
	        cb.showText(contents);
	        cb.endText();
	        cb.restoreState();

			// 세번째 페이지 설정
			document.newPage();

			ji = jil.get(2);
			int ji_3 = ji.getImage_idx();
			String Image3 = "http://localhost:8060/BucketTree/bucket/" + ji_3 + "/image";
			Image img3 = Image.getInstance(Image3);
			img3.scaleAbsolute(300, 300);
			img3.setAbsolutePosition(300, 300);
			document.add(img3);

			line.setColorStroke(blue);
			line.moveTo(36, 564);
			line.lineTo(264, 564);
			line.closePathStroke();
			
			bjv=bjl.get(5);
			contents=bjv.getTitle();
			
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(120, 540);
	        cb.setFontAndSize(cfont, 12);
	        cb.showText(contents);
	        cb.endText();
	        cb.restoreState();

			ji = jil.get(3);
			int ji_4 = ji.getImage_idx();
			String Image4 = "http://localhost:8060/BucketTree/bucket/" + ji_4 + "/image";
			Image img4 = Image.getInstance(Image4);
			img4.scaleAbsolute(300, 300);
			img4.setAbsolutePosition(0, 0);
			document.add(img4);

			under_line.setColorStroke(blue);
			under_line.moveTo(336, 36);
			under_line.lineTo(564, 36);
			under_line.closePathStroke();
			
			bjv=bjl.get(4);
			contents=bjv.getTitle();
			
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(350, 50);
	        cb.setFontAndSize(cfont, 12);
	        cb.showText(contents);
	        cb.endText();
	        cb.restoreState();

			// 네번째 페이지 설정
			document.newPage();

			ji = jil.get(4);
			int ji_5 = ji.getImage_idx();
			String Image5 = "http://localhost:8060/BucketTree/bucket/" + ji_5 + "/image";
			Image img5 = Image.getInstance(Image5);
			img5.scaleAbsolute(600, 400);
			img5.setAbsolutePosition(0, 200);
			document.add(img5);

			String ImageCali = "C:/Users/JY/Documents/buckeTree/BucketTree/src/main/webapp/WEB-INF/views/resources/images/cali.jpg";
			Image cali = Image.getInstance(ImageCali);
			cali.scaleAbsolute(280, 80);
			cali.setAbsolutePosition(300, 15);
			document.add(cali);
			
			bjv=bjl.get(3);
			contents=bjv.getTitle();
			
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(460, 160);
	        cb.setFontAndSize(cfont, 12);
	        cb.showText(contents);
	        cb.endText();
	        cb.restoreState();

			// 다섯번쨰 페이지 설정
			document.newPage();

			ji = jil.get(5);
			int ji_6 = ji.getImage_idx();
			String Image6 = "http://localhost:8060/BucketTree/bucket/" + ji_6 + "/image";
			Image img6 = Image.getInstance(Image6);
			img6.scaleAbsolute(400, 600);
			img6.setAbsolutePosition(0, 0);
			document.add(img6);
			
			bjv=bjl.get(2);
			contents=bjv.getTitle();
			
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(420, 30);
	        cb.setFontAndSize(cfont, 12);
	        cb.showText(contents);
	        cb.endText();
	        cb.restoreState();

			// 여섯번쨰 페이지 설정
			document.newPage();

			ji = jil.get(6);
			int ji_7 = ji.getImage_idx();
			String Image7 = "http://localhost:8060/BucketTree/bucket/" + ji_7 + "/image";
			Image img7 = Image.getInstance(Image7);
			img7.scaleAbsolute(450, 300);
			img7.setAbsolutePosition(0, 300);
			document.add(img7);
			

			bjv=bjl.get(1);
			contents=bjv.getTitle();
			
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(455, 330);
	        cb.setFontAndSize(cfont, 12);
	        cb.showText(contents);
	        cb.endText();
	        cb.restoreState();

			ji = jil.get(7);
			int ji_8 = ji.getImage_idx();
			String Image8 = "http://localhost:8060/BucketTree/bucket/" + ji_8 + "/image";
			Image img8 = Image.getInstance(Image8);
			img8.scaleAbsolute(450, 300);
			img8.setAbsolutePosition(150, 0);
			document.add(img8);
			
			bjv=bjl.get(0);
			contents=bjv.getTitle();
			
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(15, 30);
	        cb.setFontAndSize(cfont, 12);
	        cb.showText(contents);
	        cb.endText();
	        cb.restoreState();

			writer.close();

		} catch (Exception e) {
			throw e;
		}

	}
}