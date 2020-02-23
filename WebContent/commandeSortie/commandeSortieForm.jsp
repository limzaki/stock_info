<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>CommandeSortie</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato"> 
			<div>
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">CommandeSorties</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/CommandeSortieServlet?action=add" method="post">
					<c:set var="action" value="Ajouter"/>
					<caption>
						<h2>
							Ajouter Nouvelle Commande Sortie
						</h2>
					</caption>
					<fieldset class="form-group">
						<label>Client</label> 
						<select class="form-control" name="idClient" >
	  						<c:forEach var="client" items="${clients}">
	  							<option value="${client.idClient}">${client.nomComplet}</option>
	  						</c:forEach>
	  					</select>
					</fieldset>
					<fieldset class="form-group">
						<label>Date</label> <input type="date"
							class="form-control" name="date" required="required">
					</fieldset>
					
					<button type="submit" class="btn btn-success">${action}</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>