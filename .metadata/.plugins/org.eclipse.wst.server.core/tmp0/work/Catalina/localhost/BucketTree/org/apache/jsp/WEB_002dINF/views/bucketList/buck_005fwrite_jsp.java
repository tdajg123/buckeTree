/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2016-09-26 06:50:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.bucketList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class buck_005fwrite_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"//code.jquery.com/jquery.min.js\"></script>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"//apis.daum.net/maps/maps3.js?apikey=c979b1f9a00bdf157a46346b59a630f4&libraries=services\"></script>\r\n");
      out.write("<script src=\"/BucketTree/se2/js/HuskyEZCreator.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/BucketTree/se2/init.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t<form action=\"/BucketTree/bucketList/bucketCreate\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t<div class=\"x_panel\">\r\n");
      out.write("\t\t\t\t<div class=\"x_title_m\">\r\n");
      out.write("\t\t\t\t\t<span class=\"tag\">20대</span> <span class=\"tag\">혼자</span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"tag\">여행</span>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"right\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-success\">작성하기</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-default\">취소하기</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" onclick=\"popupOpen()\">장소지정</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"x_title\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"title\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"버킷리스트 타이틀을 입력해주세요.\" name=\"title\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<textarea id=\"body\" name=\"body\" class=\"smarteditor2\"></textarea>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"positionX\" name=\"x\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"positionY\" name=\"y\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 팝업 레이어 -->\r\n");
      out.write("<div id=\"popup\" style=\"position:absolute;  visibility:hidden; height:535px; background-color:white\";>\r\n");
      out.write("\t<div class=\"map_wrap\">\r\n");
      out.write("    <div id=\"map\" style=\"width:100%;height:100%;position:relative;overflow:hidden;\"></div>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"menu_wrap\" class=\"bg_white\" style=\"font-weight:100px;\">\r\n");
      out.write("        <div class=\"option\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <form onsubmit=\"searchPlaces(); return false;\">\r\n");
      out.write("                    키워드 : <input type=\"text\" value=\"이태원 맛집\" id=\"keyword\" size=\"15\"> \r\n");
      out.write("                    <button type=\"submit\">검색하기</button> \r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <hr>\r\n");
      out.write("        <ul id=\"placesList\"></ul>\r\n");
      out.write("        <div id=\"pagination\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<h1 style=\"margin-top:5px\">현재 선택한 장소 : <input type=\"text\" readOnly=\"readOnly\" id=\"title2\"> <span style=\"text-align:right\">마커나 검색 목록을 클릭하여 선택하세요</span></h1>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- //팝업 레이어 -->\r\n");
      out.write("<script type=\"text/javascript\"\tsrc=\"/BucketTree/js/bucketList/bucketWrite.js\"></script>\r\n");
      out.write("\t");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
