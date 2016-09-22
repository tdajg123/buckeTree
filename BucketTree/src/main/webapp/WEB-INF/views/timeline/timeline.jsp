<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	$(function() {
		$(".timeline-title").click(function() {
			self.location = $(this).attr("data-url");
		});
	});

	//짝수번째 li는 오른쪽으로 보이기
	$(function() {
		$("ul.timeline>li:nth-child(even)").addClass('timeline-inverted');
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
						<h4 class="timeline-title" data-url="${TimelineVO.url}">${TimelineVO.message}</h4>
						<p>
							<small class="text-muted  f_right"><i
								class="glyphicon glyphicon-time"></i> ${TimelineVO.date}</small>
						</p>
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>
