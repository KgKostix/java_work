<%@page import="THMedia.JsonMediaParser"%>
<%@page import="javax.print.attribute.standard.Media"%>
<%@page import="java.util.ListIterator"%>
<%@page import="lib.MediaInfo"%>
<%@page import="java.util.LinkedList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
    Document   : browseListTV
    Created on : Mar 15, 2013, 9:58:26 PM
    Author     : Konstantin Goncharov
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Telehouse TV</title>
	</head>
	<body>
		<jsp:useBean id="browseTv" scope="session" class="THMedia.Logon" />
		<jsp:setProperty name="browseTv" property="login"/>
		<jsp:setProperty name="browseTv" property="password"/>
		<%--<h1>Login: <jsp:getProperty name="browseTv" property="login" />!</h1> --%>
		<table style="text-align: left; width: 80%;" border="0"
				 cellpadding="2" cellspacing="2">
			<tbody>
			<%
			JsonMediaParser jsonMediaParser = new JsonMediaParser();
			LinkedList<MediaInfo> mediaList = jsonMediaParser.GetUserMediaList(
					browseTv.getLogin(), browseTv.getPassword());
			ListIterator<MediaInfo> mediaListIterator = mediaList.listIterator();
			while (mediaListIterator.hasNext()) {
				MediaInfo mediaInfo = mediaListIterator.next();%>

		<tr>
		<td style="width: 1493px;">
			<big style="font-family: Arial Narrow;">
				<big>Название:
					<span style="color: black;">
						<%=mediaInfo.getTitle()%>
					</span>
				</big>
			</big>
		</td>
		<td style="width: 113px; text-align: right;">
			<a href="<%=mediaInfo.getAurl()%>">Просмотр</a>
		</td>
		</tr>
		<tr>
			<td style="text-align: justify; width: 1493px;">
				<span	style="font-family: Arial;">Жанр: </span>
				<span style="color: rgb(0, 0, 153);">
					<%=mediaInfo.getGenre()%>
				</span>
			</td>
			<td style="width: 113px; text-align: right;">
				<a	href="<%=mediaInfo.getIurl()%>">Плей-лист для iOS/MacOs
				</a>
			</td>
		</tr>
		<tr>
			<td>
				<span	style="font-family: Arial;">Исполнитель:
					<span style="color: rgb(0, 0, 153);">
						<%=mediaInfo.getArtist()%>
					</span>
				</span>
			</td>
			<td style="width: 113px;"></td>
		</tr>
		<tr style="background-color: rgb(0,0,153); height: 5px;">
			<td></td>

		</tr>
		<%}%>
</tbody>
</table>

</body>
</html>
