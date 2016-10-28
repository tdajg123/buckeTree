<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
a {
	color: #2aa09a;
}
</style>

<div class="container">
	<div class="col-md-6 col-md-offset-3" style="margin-top: 70px;">
		<!-- Widget: user widget style 1 -->
		<div class="box box-widget widget-point">
			<!-- Add the bg color to the header using any of the bg-* classes -->
			<div class="widget-header">
				<h5 class="widget-desc">BUCKET POINT</h5>
				<h1 class="widget-point-info">${user.getPoint()}P</h1>
			</div>
			<div class="box-footer no-padding">
				<ul class="nav nav-stacked">
					<c:forEach items="${pointList}" var="PointVO">
						<li><input type="hidden" value="${PointVO.state}" id="state">
							<a class="f_left pointDate"><fmt:formatDate
									value="${PointVO.date}" type="DATE" pattern="yyyy.MM.dd" /> </a><a>${PointVO.contents}
								<span class="pull-right badge" id="point">${PointVO.point}</span>
						</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!-- /.widget-user -->
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$('ul.nav.nav-stacked>li').each(function(index) {
			if ($(this).children('input[id=state]').val() == 1) {
				$(this).children().children('span#point').addClass('bg-green');
			}
		})
	})
</script>

