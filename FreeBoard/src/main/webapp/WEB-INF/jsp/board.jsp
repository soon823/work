<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../includs/header.jsp"></jsp:include>

<h3>상세페이지(board.jsp)</h3>
<%
BoardVO bvo = (BoardVO) request.getAttribute("boardvo");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String wdate = sdf.format(bvo.getWriteDate());
%>

<table class="table">

  <tr>
    <th>글번호</th><td><%=bvo.getBoardNo() %></td>
    <th>조회수</th><td><%=bvo.getViewCnt() %></td>
  </tr>
  <tr>
    <th>제목</th>
    <td colspan="3"><%=bvo.getTitle() %></td>
  </tr>
  <tr>
  	<th>내용</th>
  	<td colspan="3"><textarea class="form-control" name="content" rows="3" cols="30"><%=bvo.getContent() %></textarea></td>
  </tr>
  <tr>
  	<th>작성자</th><td colspan="3"><%=bvo.getWriter() %></td>
  </tr>
  <tr>
  	<th>작성일시</th><td colspan="3"><%=wdate %></td>
  </tr>
  <tr>
  	<td align="center" colspan="4">
  		<input type="button" value="수정" class="btn btn-warning">
  		<input type="button" value="삭제" class="btn btn-warning">
  	</td>
  </tr>
</table>



<jsp:include page="../includs/footer.jsp"></jsp:include>

<script>
	document.querySelector('input[value="수정"]').addEventListener('click', function(e){
		location.href = 'modifyBoard.do?bno=<%=bvo.getBoardNo() %>'
	});
	
	document.querySelector('input[value="삭제"]').addEventListener('click', function(e){
		location.href = 'removeBoard.do?bno=<%=bvo.getBoardNo() %>'
	});
</script>
		
		

