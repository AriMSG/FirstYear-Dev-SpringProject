<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<html lang="en">
<title>기초제작</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<body>

<!-- Navbar -->
<%@ include file="/WEB-INF/views/top_nav.jsp"%>
<!-- Sidebar -->


<form name=""> 
<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main" style="margin-left:250px">




  <div class="w3-row w3-padding-64">
  
  
	<h1 style="text-align: center;"> 자유주제 게시판</h1>
	  <table class="w3-table w3-striped" style="text-align: center;">
		<tr class="w3-red" style="text-align: center;" >
		  <th style="width: 100px;">번호</th>
		  <th style="width: 600px;">제목</th>
		  <th style="width: 200px;">작성자</th>
		  <th style="width: 100px;">작성일자</th>
		</tr>
		<tr>
		  <td>1</td>
		  <td>안녕하세요</td>
		  <td>민순기</td>
		  <td>2019-03-12</td>
		</tr>
		<tr>
		  <td>2</td>
		  <td>안녕하세요</td>
		  <td>민순기</td>
		  <td>2019-03-12</td>
		</tr>
		<tr>
		  <td>3</td>
		  <td>안녕하세요</td>
		  <td>민순기</td>
		  <td>2019-03-12</td>
		</tr>
		<tr>
		  <td>4</td>
		  <td>안녕하세요</td>
		  <td>민순기</td>
		  <td>2019-03-12</td>
		</tr>
		<tr>
		  <td>5</td>
		  <td>안녕하세요</td>
		  <td>민순기</td>
		  <td>2019-03-12</td>
		</tr>
		<tr>
		  <td>6</td>
		  <td>안녕하세요</td>
		  <td>민순기</td>
		  <td>2019-03-12</td>
		</tr>
		<tr>
		  <td>7</td>
		  <td>안녕하세요</td>
		  <td>민순기</td>
		  <td>2019-03-12</td>
		</tr>
		</table>
  </div>
  		
		<div class="w3-bar w3-red w3-right" style="width: 100px; margin-right: 50px; margin-top: -50px">
			<button class="w3-bar-item w3-button " style="width: 100%;">글쓰기</button>
		</div>


  <!-- Pagination -->
  <div class="w3-center w3-padding-32">
    <div class="w3-bar">
      <a class="w3-button w3-black" href="#">1</a>
      <a class="w3-button w3-hover-black" href="#">2</a>
      <a class="w3-button w3-hover-black" href="#">3</a>
      <a class="w3-button w3-hover-black" href="#">4</a>
      <a class="w3-button w3-hover-black" href="#">5</a>
      <a class="w3-button w3-hover-black" href="#">»</a>
    </div>
  </div>

  <footer id="myFooter">
    <div class="w3-container w3-theme-l2 w3-padding-32">
      <h4>Footer</h4>
    </div>

    <div class="w3-container w3-theme-l1">
      <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </div>
  </footer>

<!-- END MAIN -->
</div>
</form>



</body>
</html>
