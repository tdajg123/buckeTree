/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2016-09-26 05:47:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/D:/bc/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BucketTree/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/tiles-jsp-3.0.5.jar", Long.valueOf(1472260439477L));
    _jspx_dependants.put("jar:file:/D:/bc/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BucketTree/WEB-INF/lib/tiles-jsp-3.0.5.jar!/META-INF/tld/tiles-jsp.tld", Long.valueOf(1411309930000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1472260418994L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      out.write(" \r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_tiles_005finsertAttribute_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Form Module-->\r\n");
      out.write("\t<div class=\"module form-module\">\r\n");
      out.write("\t\t<!-- 회원가입창으로 이동하는 아이콘  -->\r\n");
      out.write("\t\t<div class=\"toggle\">\r\n");
      out.write("\t\t\t<i class=\"fa fa-times\"></i>\r\n");
      out.write("\t\t\t<div class=\"tooltip\">JOIN US</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 로그인부분  -->\r\n");
      out.write("\t\t<div class=\"form\">\r\n");
      out.write("\t\t\t<div class=\"login_logo\">\r\n");
      out.write("\t\t\t\t<img id=\"logo\" src=\"/BucketTree/images/BUCKET_LOGO.png\"\r\n");
      out.write("\t\t\t\t\tonmouseover=\"this.src='/BucketTree/images/BUCKET_LOGO_HOVER.png'\"\r\n");
      out.write("\t\t\t\t\tonmouseout=\"this.src='/BucketTree/images/BUCKET_LOGO.png'\"\r\n");
      out.write("\t\t\t\t\tstyle=\"border: 0 solid\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<form method=\"POST\" action=\"/BucketTree/login_processing\">\r\n");
      out.write("\t\t\t\t<input name=\"email\" id=\"login_email\" type=\"text\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"Email Address\" /> <input name=\"password\"\r\n");
      out.write("\t\t\t\t\tid=\"login_pw\" type=\"password\" placeholder=\"Password\" />\r\n");
      out.write("\t\t\t\t<button>Login</button>\r\n");
      out.write("\t\t\t\t<div id=\"joinus\">JOIN US</div>\r\n");
      out.write("\t\t\t\t<div class=\"fpw\">Forgot your password?</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 회원가입부분  -->\r\n");
      out.write("\t<div class=\"form1\">\r\n");
      out.write("\t\t<h2>CREATE AN ACCOUNT</h2>\r\n");
      out.write("\t\t<form method=\"POST\" action=\"user/create\" onsubmit=\"return validate()\" name=\"join\"> \r\n");
      out.write("\t\t\t<input id=\"create_email\" name=\"create_email\" type=\"email\" placeholder=\"Email Address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${UserVO.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/> \r\n");
      out.write("\t\t\t<span id=\"duplicateResult1\">        \r\n");
      out.write("        \t</span>\r\n");
      out.write("\t\t\t<input id=\"create_pw\" name=\"create_pw\" type=\"password\" placeholder=\"Password\" /> \r\n");
      out.write("\t\t\t<span id=\"duplicateResult2\">\r\n");
      out.write("\t\t\t\t* 8~20자의 영문,숫자,특수문자 혼합\r\n");
      out.write("        \t</span>\r\n");
      out.write("        \t<input id=\"create_pw2\" name=\"create_pw2\" type=\"password\" placeholder=\"Password identify\" /> \r\n");
      out.write("\t\t\t<span id=\"duplicateResult3\">        \r\n");
      out.write("        \t</span>\r\n");
      out.write("\t\t\t<input id=\"create_name\" name=\"create_name\" type=\"text\"\tplaceholder=\"Username\" /> \r\n");
      out.write("\t\t\t<input id=\"create_birth\" name=\"create_birth\" type=\"date\" placeholder=\"BIRTH DAY\" />\r\n");
      out.write("\t\t\t<div class=\"g-recaptcha\" data-sitekey=\"6LdPxigTAAAAADwG8VjJoQfXux6HIIZpr6vzEwrc\"></div>\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"idcheck\" name=\"idcheck\" value=\"N\" />\r\n");
      out.write("\t\t\t<button id=\"register\" type=\"submit\">Register</button>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 비밀번호찾기부분  -->\r\n");
      out.write("\t\t<div class=\"form2\">\r\n");
      out.write("\t\t\t<h2>FORGOT PASSWORD</h2>\r\n");
      out.write("\t\t\t<form method=\"post\">\r\n");
      out.write("\t\t\t\t<input id=\"password_email\" name=\"password_email\" type=\"email\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"Email Address\" /> <input id=\"password_name\"\r\n");
      out.write("\t\t\t\t\tname=\"password_name\" type=\"text\" placeholder=\"Name\" />\r\n");
      out.write("\t\t\t\t<button type=\"button\" id=\"search\">Search</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 누르면 비밀번호 찾기로 넘어가는 부분  -->\r\n");
      out.write("\t\t<div class=\"cta\">\r\n");
      out.write("\t\t\t<div id=\"result\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- JS  -->\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$('#search').click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"/BucketTree/user/searchUserAjax\",\r\n");
      out.write("\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\tpassword_email : $('#password_email').val(),\r\n");
      out.write("\t\t\t\t\tpassword_name : $('#password_name').val()\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tif (data) {\r\n");
      out.write("\t\t\t\t\t\t$('#result').text(\"이메일로 임시비밀번호를 보냈습니다.\")\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$('#result').text(\"유효하지않은 이메일입니다.\")\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//회원가입\r\n");
      out.write("\t\t$('.toggle').attr('on', 'false');\r\n");
      out.write("\t\t$('.form').attr('on', 'true');\r\n");
      out.write("\t\t$('.form1').attr('on', 'false');\r\n");
      out.write("\t\t$('.form2').attr('on', 'false');\r\n");
      out.write("\r\n");
      out.write("\t\t$('.toggle').click(\r\n");
      out.write("\t\t\t\tfunction() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t$('.toggle').attr('on', 'true');\r\n");
      out.write("\t\t\t\t\t$('#result').text(\"\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif ($('.form').attr('on') == 'false'\r\n");
      out.write("\t\t\t\t\t\t\t&& $('.form1').attr('on') == 'true') {\r\n");
      out.write("\t\t\t\t\t\t$('.form1').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\t\t\t\t\t\t$('.form').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t$('.form').attr('on', 'true');\r\n");
      out.write("\t\t\t\t\t\t$('.form1').attr('on', 'false');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif ($('.form').attr('on') == 'false'\r\n");
      out.write("\t\t\t\t\t\t\t&& $('.form2').attr('on') == 'true') {\r\n");
      out.write("\t\t\t\t\t\t$('.form2').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\t\t\t\t\t\t$('.form').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t$('.form').attr('on', 'true');\r\n");
      out.write("\t\t\t\t\t\t$('.form2').attr('on', 'false');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif ($('.toggle').attr('on') == 'true') {\r\n");
      out.write("\t\t\t\t\t\t$('.toggle').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$('#joinus').click(\r\n");
      out.write("\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t$('.toggle').attr('on', 'false');\r\n");
      out.write("\t\t\t\t\t$('#result').text(\"\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif ($('.toggle').attr('on') == 'false') {\r\n");
      out.write("\t\t\t\t\t\t$('.toggle').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t$('.form').attr('on', 'false');\r\n");
      out.write("\t\t\t\t\t$('.form1').attr('on', 'true');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif ($('.form').attr('on') == 'false'\r\n");
      out.write("\t\t\t\t\t\t\t&& $('.form1').attr('on') == 'true') {\r\n");
      out.write("\t\t\t\t\t\t$('.form').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\t\t\t\t\t\t$('.form1').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t//비밀번호찾기\r\n");
      out.write("\t\t$('.fpw').click(\r\n");
      out.write("\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t$('.toggle').attr('on', 'false');\r\n");
      out.write("\t\t\t\t\t$('#result').text(\"\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif ($('.toggle').attr('on') == 'false') {\r\n");
      out.write("\t\t\t\t\t\t$('.toggle').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t$('.form').attr('on', 'false');\r\n");
      out.write("\t\t\t\t\t$('.form2').attr('on', 'true');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif ($('.form').attr('on') == 'false'\r\n");
      out.write("\t\t\t\t\t\t\t&& $('.form2').attr('on') == 'true') {\r\n");
      out.write("\t\t\t\t\t\t$('.form').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\t\t\t\t\t\t$('.form2').animate({\r\n");
      out.write("\t\t\t\t\t\t\theight : \"toggle\",\r\n");
      out.write("\t\t\t\t\t\t\t'padding-top' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\t'padding-bottom' : 'toggle',\r\n");
      out.write("\t\t\t\t\t\t\topacity : \"toggle\"\r\n");
      out.write("\t\t\t\t\t\t}, \"slow\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$('#find').click(function() {\r\n");
      out.write("\t\t\t$('.al').attr('.al');\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif($('#create_email').val() != \"\"){\r\n");
      out.write("\t\t   \t$('#create_email').keyup();\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t$('#create_email').keyup(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tvar email = $('#create_email').val();\r\n");
      out.write("\t\t\tvar regex=/^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$/;\r\n");
      out.write("\t\t\tif(regex.test(email)==false){\r\n");
      out.write("\t\t\t\t document.getElementById(\"create_pw\").style.marginTop=\"20px\";\r\n");
      out.write("\t\t\t\t $('#duplicateResult1').text(\"* 올바르지 않은 형식입니다\")\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\tvar result = $('#duplicateResult').val();\r\n");
      out.write("\t\t\t$.post('");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("'\r\n");
      out.write("\t\t            ,{'create_email' : $('#create_email').val()}\r\n");
      out.write("\t\t            , function(data){\r\n");
      out.write("\t\t            console.log(data);\r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        if(data ==\"true\"){\r\n");
      out.write("\t\t        \t document.getElementById(\"create_pw\").style.marginTop=\"20px\";\r\n");
      out.write("\t\t        \t $('#idcheck').val('N');\r\n");
      out.write("\t\t        \t $('#duplicateResult1').text(\"* 이미사용중인 이메일입니다.\")\r\n");
      out.write("\t\t            \r\n");
      out.write("\t\t        }else{\r\n");
      out.write("\t\t        \t document.getElementById(\"create_pw\").style.marginTop=\"20px\";\r\n");
      out.write("\t\t        \t $('#idcheck').val('Y');\r\n");
      out.write("\t\t        \t $('#duplicateResult1').text(\"* 사용가능한 이메일입니다.\")\r\n");
      out.write("\t\t            \r\n");
      out.write("\t\t        }  \t\r\n");
      out.write("\t\t            })};\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\tif($('#create_pw').val() != \"\"){\r\n");
      out.write("\t\t   \t$('#create_pw').keyup();\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tif($('#create_pw2').val() != \"\"){\r\n");
      out.write("\t\t   \t$('#create_pw2').keyup();\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t$('#create_pw').keyup(function(){\r\n");
      out.write("\r\n");
      out.write("\t\t\t var pw = $('#create_pw').val();\r\n");
      out.write("\t\t\t var num = pw.search(/[0-9]/g);\r\n");
      out.write("\t\t\t var eng = pw.search(/[a-z]/ig);\r\n");
      out.write("\t\t\t var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩\";:₩/?]/gi);\r\n");
      out.write("\r\n");
      out.write("\t\t\t \r\n");
      out.write("\r\n");
      out.write("\t\t\t if((pw.length < 8 )||( pw.length > 20)){\r\n");
      out.write("\r\n");
      out.write("\t\t\t  $('#duplicateResult2').text(\"* 8 ~ 20자리 이내로 입력해주세요.\");\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\r\n");
      out.write("\t\t\t }else\r\n");
      out.write("\r\n");
      out.write("\t\t\t if(pw.search(\" \") != -1){\r\n");
      out.write("\t\t\t\t  document.getElementById(\"create_pw2\").style.marginTop=\"20px\";\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t }else if(num < 0 || eng < 0 || spe < 0 ){\r\n");
      out.write("\t\t\t\t  document.getElementById(\"create_pw2\").style.marginTop=\"20px\";\r\n");
      out.write("\t\t\t\t  $('#duplicateResult2').text(\"* 영문, 숫자, 특수문자를 혼합하세요.\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t }else{\r\n");
      out.write("\t\t\t\t   \r\n");
      out.write("\t\t\t $('#duplicateResult2').text(\"* 사용가능한 비밀번호입니다.\");\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t$('#create_pw2').keyup(function(){\r\n");
      out.write("\t\t\t var pass1 = document.getElementById('create_pw');\r\n");
      out.write("\t\t     var pass2 = document.getElementById('create_pw2');\r\n");
      out.write("\t\t     if(pass1.value!=pass2.value) {\r\n");
      out.write("\t\t    \t document.getElementById(\"create_name\").style.marginTop=\"20px\";\r\n");
      out.write("\t\t    \t $('#duplicateResult3').text(\"* 비밀번호가 일치하지 않습니다.\");\r\n");
      out.write("\t\t  \t}else{\r\n");
      out.write("\t\t  \t\t document.getElementById(\"create_name\").style.marginTop=\"20px\";\r\n");
      out.write("\t\t    \t $('#duplicateResult3').text(\"* 비밀번호가 일치합니다.\");\r\n");
      out.write("\t\t  \t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\t// 회원가입 폼 검사  (controller로 값을 넘겨주기 전에 이 부분에서 검사를 실시한다.)\r\n");
      out.write("\t\tfunction validate() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t/**\r\n");
      out.write("\t\t\t\t    회원가입 form 태그 내부 input 태그 값을 추출\r\n");
      out.write("\t\t\t\t  form : id가 join인 태그\r\n");
      out.write("\t\t\t\t  val  : id가 idcheck인 태그의 value\t\t\r\n");
      out.write("\t\t\t\t**/\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar email = document.getElementById('create_email');\r\n");
      out.write("\t\t        var pass1 = document.getElementById('create_pw');\r\n");
      out.write("\t\t        var pass2 = document.getElementById('create_pw2');\r\n");
      out.write("\t\t        var name = document.getElementById('create_name');\r\n");
      out.write("\t\t        var birth = document.getElementById('create_birth');\r\n");
      out.write("\t\t \t    var form = document.join;\r\n");
      out.write("\t\t \t    var val = $('#idcheck').val();\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t \t    /**\r\n");
      out.write("\t\t \t       pass1.value의 정규식과 일치하는 문자의 자릿수를 리턴\r\n");
      out.write("\t\t \t\t   num : 숫자 , eng : 영문 , spe : 특수문자 \r\n");
      out.write("\t\t \t       test : 이메일 중복체크를 위한 값 , Y면 사용 가능한 이메일\r\n");
      out.write("\t\t \t\t **/\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t    var num = pass1.value.search(/[0-9]/g); \r\n");
      out.write("\t\t \t\tvar eng = pass1.value.search(/[a-z]/ig);\r\n");
      out.write("\t\t \t\tvar spe = pass1.value.search(/[`~!@@#$%^&*|₩₩₩'₩\";:₩/?]/gi);\r\n");
      out.write("\t\t        var test = \"Y\";\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t/** 이메일 유효성,중복 검사\r\n");
      out.write("\t\t           4글자 이상(\\w = [a-zA-Z0-9_], [\\w-\\.]) @가 나오고\r\n");
      out.write("\t\t           1글자 이상(주소). 글자 가 1~3번 반복됨\r\n");
      out.write("\t\t        **/\r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        if(!chk(/^[\\w]{4,}@[\\w]+(\\.[\\w-]+){1,3}$/, email, \"이메일 형식에 어긋납니다.\")){\r\n");
      out.write("\t\t               return false;}\r\n");
      out.write("\t\t        else  if(val != test ){\r\n");
      out.write("\t\t     \t\talert(\"중복된 이메일입니다.\")\r\n");
      out.write("\t\t     \t\treturn false;\t\r\n");
      out.write("\t\t     \t}\r\n");
      out.write("\t\t       \r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t \t\t/** \r\n");
      out.write("\t\t \t\t\t비밀번호 유효성 검사 , 스팸방지 코드 검사\r\n");
      out.write("\t\t \t\t**/\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t        if(num < 0 || eng < 0 || spe < 0 ){\r\n");
      out.write("\t\t\t\t\talert(\"영문, 숫자, 특수문자를 혼합하여 입력해주세요.\");\r\n");
      out.write("\t\t\t\t\tform.create_pw.focus();\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t  \t\t  \r\n");
      out.write("\t\t  \t \t}else if((pass1.value.length < 8 )||( pass1.value.length > 20)){\r\n");
      out.write("\t\t\t\t\talert(\"8~ 20자리 이내로 입력해주세요.\");\r\n");
      out.write("\t\t\t\t\tform.create_pw.focus();\r\n");
      out.write("\t\t  \t\t  return false;\r\n");
      out.write("\r\n");
      out.write("\t\t  \t\t }else if(pass1.value.search(\" \") != -1){\r\n");
      out.write("\t\t\t\t\talert(\"비밀번호는 공백없이 입력해주세요.\");\r\n");
      out.write("\t\t\t\t\tform.create_pw.focus();백\r\n");
      out.write("\t\t  \t\t  return false;\r\n");
      out.write("\r\n");
      out.write("\t\t  \t\t }else if(pass1.value!=pass2.value) {\r\n");
      out.write("\t\t            alert(\"비밀번호가 일치하지 않습니다\");\r\n");
      out.write("\t\t        \tform.create_pw2.focus();\r\n");
      out.write("\t\t            return false;\r\n");
      out.write("\t\t     \t}else if (typeof(grecaptcha) != 'undefined') {\r\n");
      out.write("\t\t            //캡차가 체크되지 않았을 경우\r\n");
      out.write("\t\t            if (grecaptcha.getResponse() == \"\") {\r\n");
      out.write("\t\t                alert(\"스팸방지코드를 확인해 주세요.\");\r\n");
      out.write("\t\t                return false;\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t\t     \t}\t\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t        /** \r\n");
      out.write("\t\t        \t이름 유효성 검사       \r\n");
      out.write("\t\t        **/               \r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t           if(!chk(/^[가-힝]{2,}$/, name, \"이름은 2글자 이상이여야 합니다\")) {\r\n");
      out.write("\t\t               return false;\r\n");
      out.write("\t\t               }\r\n");
      out.write("\t\t       \r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        /**\r\n");
      out.write("\t\t     \t\t유효성 체크를 위한 함수 작성\r\n");
      out.write("\t\t        **/   \r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        function chk(re, e, msg) {\r\n");
      out.write("\t\t               if (re.test(e.value)) {\r\n");
      out.write("\t\t                       return true;\r\n");
      out.write("\t\t               }\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t               alert(msg);\r\n");
      out.write("\t\t               e.value = \"\";\r\n");
      out.write("\t\t               e.focus();\r\n");
      out.write("\t\t               return false;\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t     }\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_tiles_005finsertAttribute_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f0 = (new org.apache.tiles.jsp.taglib.InsertAttributeTag());
    _jsp_getInstanceManager().newInstance(_jspx_th_tiles_005finsertAttribute_005f0);
    _jspx_th_tiles_005finsertAttribute_005f0.setJspContext(_jspx_page_context);
    // /WEB-INF/views/home/login.jsp(8,0) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f0.setName("header");
    _jspx_th_tiles_005finsertAttribute_005f0.doTag();
    _jsp_getInstanceManager().destroyInstance(_jspx_th_tiles_005finsertAttribute_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/views/home/login.jsp(252,11) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/user/checkDuplicateEmailAjax");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
