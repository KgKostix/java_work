<%--
    Document   : index
    Created on : Mar 15, 2013, 9:18:26 PM
    Author     : Konstantin Goncharov
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Теле-хаус TV </title>
	</head>
	<body>

		<form name="login" action="browseListTV.jsp">
			<div style="text-align: center; width: 80%">
				Авторизируйтесь для просмотра медиа роликов
			</div>
			<div style="text-align: center">
				<table style="text-align: left; width: 80%;" border="0"
						 cellpadding="2" cellspacing="2">
					<tbody>
						<tr>
							<td style="text-align: right; width: 45%;">Логин:
							</td>
							<td style="text-align: left; width: 50%;">
								<input type="text" name="login" atribute ="login"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 45%;"> Пароль:</td>
							<td style="text-align: left; width: 50%;">
								<input type="password" name="password" atribute="password"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div style="text-align: center; width: 80%">
				<input type="submit" value="Вход" name="btnLogon"/>
			</div>
		</form>
	</body>
</html>

