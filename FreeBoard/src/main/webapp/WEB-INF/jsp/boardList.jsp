<%@page import="com.yedam.commom.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includs/header.jsp"></jsp:include>

<h3>글 목록</h3>
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<table class="table">
	<thead>
		<tr>
			<th>글번호</th><th>제목</th><th>작성자</th><th>작성일자</th>
		</tr>
	</thead>
	<tbody>
	<%for (BoardVO board : list){ 
	  //date포맷(20204-10-09 12:22:33)
	  String wdate = sdf.format(board.getWriteDate());	
	%>
	<tr>
		<td><%=board.getBoardNo() %></td>
		<td><a href='board.do?bno=<%=board.getBoardNo() %>'><%=board.getTitle() %></td>
		<td><%=board.getWriter() %></td>
		<td><%=wdate %></td>
	</tr>
	<%} %>
	</tbody>
</table>

<%
	PageDTO paging = (PageDTO) request.getAttribute("page");
%>
<%=paging %>
<!-- paging -->

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  
    <li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
    
    <%for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {%>
    <li class="page-item"><a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a></li>
    <%} %>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>

<jsp:include page="../includs/footer.jsp"></jsp:include>
