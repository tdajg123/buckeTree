/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2016-09-26 05:47:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menubar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/bc/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BucketTree/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/BucketTree/js/menu/jquery.dlmenu.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/BucketTree/js/menu/menu.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<nav id=\"header\" class=\"navbar navbar-fixed-top\">\r\n");
      out.write("\t<!-- /.container -->\r\n");
      out.write("\t<div id=\"header-container\" class=\"container navbar-container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\"\r\n");
      out.write("\t\t\t\taria-controls=\"navbar\">\r\n");
      out.write("\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\r\n");
      out.write("\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("\t\t\t\t\tclass=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<a id=\"brand\" class=\"navbar-brand\" href=\"/BucketTree/bucketList/list\"> <img id=\"logo\"\r\n");
      out.write("\t\t\t\tsrc=\"/BucketTree/images/BUCKET_LOGO.png\"\r\n");
      out.write("\t\t\t\tonmouseover=\"this.src='/BucketTree/images/BUCKET_LOGO_HOVER.png'\"\r\n");
      out.write("\t\t\t\tonmouseout=\"this.src='/BucketTree/images/BUCKET_LOGO.png'\"\r\n");
      out.write("\t\t\t\tstyle=\"border: 0 solid\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"navbar\" class=\"collapse navbar-collapse\">\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t<li id=\"dl-menu-1\" class=\"dl-menuwrapper\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\tclass=\"dl-trigger\">버킷리스트</a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dl-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/BucketTree/bucketList/mylist\">마이버킷리스트</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/BucketTree/bucketList/list\">전체버킷리스트</a></li>\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t<li id=\"dl-menu-2\" class=\"dl-menuwrapper\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\tclass=\"dl-trigger\">버킷트리</a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dl-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">마이버킷트리</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">전체버킷트리</a></li>\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t<li id=\"dl-menu-3\" class=\"dl-menuwrapper\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\tclass=\"dl-trigger\">버킷쉐어</a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dl-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/BucketTree/bucketShare/mylist\">마이버킷쉐어</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/BucketTree/bucketShare/list\">전체버킷쉐어</a></li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"navbar-custom-menu\">\r\n");
      out.write("\t\t\t\t<!-- NAVBAR 오른쪽  -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-left\">\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown user user-menu\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"dropdown-toggle\" data-toggle=\"dropdown\"> <img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"/BucketTree/images/PROFILE_image.png\" class=\"user-image\"\r\n");
      out.write("\t\t\t\t\t\t\talt=\"User Image\"> USER <b class=\"caret\"></b></a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-fw fa-user\"></i> 타임라인</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/BucketTree/Friend/searchFriendList\"><i class=\"fa fa-fw fa-group\"></i> 친구</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/BucketTree/mypage\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-fw fa-gear\"></i> 정보관리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/BucketTree/logout\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-fw fa-power-off\"></i> 로그아웃</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-left\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/BucketTree/point\"> 1500 <i class=\"fa fa-tree\"></i></a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-left\">\r\n");
      out.write("\t\t\t\t\t<li id=\"showRight\"><a><i class=\"fa fa-comments-o\"></i></a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.nav-collapse -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.nav-collapse -->\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<div class=\"cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right\"\r\n");
      out.write("\tid=\"cbp-spmenu-s2\">\r\n");
      out.write("\t<div class=\"box\">\r\n");
      out.write("\t\t<div class=\"box-header with-border\">\r\n");
      out.write("\t\t\t<h3 class=\"box-title\">NOTICE</h3>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.box-header -->\r\n");
      out.write("\t\t<div class=\"box-body\">공지사항입니다.</div>\r\n");
      out.write("\t\t<!-- /.box-body -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"box box-solid box-default\">\r\n");
      out.write("\t\t<div class=\"box-header\">\r\n");
      out.write("\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t<input name=\"q\" class=\"form-control friend_search search\"\r\n");
      out.write("\t\t\t\t\ttype=\"text\"> <span class=\"input-group-btn\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" name=\"search\" id=\"search-btn\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"btn btn-flat\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-search\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.box-header -->\r\n");
      out.write("\t\t<div class=\"box-list MessengerFriendList\">\r\n");
      out.write("\t\t\t<!--새로운 메세지를 보낸 친구 목록-->\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!--메신저에서 쓸 친구 목록(새로운메세지 보낸 친구 제외)  -->\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Modal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"message_modal\" role=\"dialog\"  style=\"z-index: 999999;\">\r\n");
      out.write("\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t<!-- Modal content-->\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\" style=\"padding: 15px 50px;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\" style=\"padding: 40px 50px;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"btn btn-default\" data-dismiss=\"modal\">\r\n");
      out.write("\t\t\t\t\t<span class=\"fa fa-check\"></span> 확인\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$('#dl-menu-1').dlmenu();\r\n");
      out.write("\t});\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$('#dl-menu-2').dlmenu();\r\n");
      out.write("\t});\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$('#dl-menu-3').dlmenu();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tvar menuRight = document.getElementById('cbp-spmenu-s2'), showRight = document\r\n");
      out.write("\t\t\t.getElementById('showRight'), body = document.body;\r\n");
      out.write("\r\n");
      out.write("\tshowRight.onclick = function() {\r\n");
      out.write("\t\tclassie.toggle(this, 'active');\r\n");
      out.write("\t\tclassie.toggle(menuRight, 'cbp-spmenu-open');\r\n");
      out.write("\t\tdisableOther('showRight');\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\tfunction disableOther(button) {\r\n");
      out.write("\t\tif (button !== 'showRight') {\r\n");
      out.write("\t\t\tclassie.toggle(showRight, 'disabled');\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("    $(function() {\r\n");
      out.write("\r\n");
      out.write("        $('#showRight').click(function() {\r\n");
      out.write("\r\n");
      out.write("            if ($('#cbp-spmenu-s2').hasClass('cbp-spmenu-open')) {\r\n");
      out.write("                messenger.from_user_idx = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.idx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("                connect();\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            if ($('#cbp-spmenu-s2').hasClass('cbp-spmenu-open') == false) {\r\n");
      out.write("                disconnect();\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\t }); \r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/include/menubar.jsp(108,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("friend");
    // /WEB-INF/views/include/menubar.jsp(108,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/include/menubar.jsp(108,3) '${flist1}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${flist1}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<div class=\"box-body addClass newMessenegerFriend\"\r\n");
          out.write("\t\t\t\t\tdata-id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${friend.idx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t<img src=\"/BucketTree/images/user1-128x128.jpg\" class=\"user-image\"\r\n");
          out.write("\t\t\t\t\t\talt=\"User Image\">\r\n");
          out.write("\t\t\t\t\t<div class=\"chat_info\">\r\n");
          out.write("\t\t\t\t\t\t<span class=\"chat_name\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${friend.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(" </span> <span\r\n");
          out.write("\t\t\t\t\t\t\tclass=\"badge bg-green right\">NEW</span>\r\n");
          out.write("\t\t\t\t\t\t<p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${friend.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /WEB-INF/views/include/menubar.jsp(122,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("friend");
    // /WEB-INF/views/include/menubar.jsp(122,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/include/menubar.jsp(122,3) '${flist2}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${flist2}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<div class=\"box-body addClass MessenegerFriend\"\r\n");
          out.write("\t\t\t\t\tdata-id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${friend.idx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t<img src=\"/BucketTree/images/user1-128x128.jpg\" class=\"user-image\"\r\n");
          out.write("\t\t\t\t\t\talt=\"User Image\">\r\n");
          out.write("\t\t\t\t\t<div class=\"chat_info\">\r\n");
          out.write("\t\t\t\t\t\t<span class=\"chat_name\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${friend.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(" </span>\r\n");
          out.write("\t\t\t\t\t\t<p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${friend.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }
}
