<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	$(function() {
		$(".timeline-title").click(function() {
			location.href = $(this).attr("data-url");
		});
	});
</script>


<div class="container">
	<div class="page-header">
		<h1 id="timeline">타임라인</h1>
	</div>
	<ul class="timeline">
		<c:forEach items="${list}" var="TimelineVO">
			<li>
				<div class="timeline-badge"></div>
				<div class="timeline-panel">
					<div class="timeline-heading">
						<h4 class="timeline-title" data-url="${TimelineVO.url}">${TimelineVO.message }</h4>
						<p>
							<small class="text-muted"><i
								class="glyphicon glyphicon-time"></i> <fmt:formatDate
									pattern="yyyy-MM-dd HH:mm" value="${TimelineVO.date}" /></small>
						</p>
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>

