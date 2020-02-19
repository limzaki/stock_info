<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>CommandeEntree</title>
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
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">CommandeEntrees</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/CommandeEntreeServlet?action=add" method="post">
					<c:set var="action" value="Ajouter"/>
					<caption>
						<h2>
							Ajouter Nouvelle Commande Entree
						</h2>
					</caption>
					<fieldset class="form-group">
						<label>Fournisseur</label> 
						<select class="form-control" name="idFournisseur" >
	  						<c:forEach var="fournisseur" items="${fournisseurs}">
	  							<option value="${fournisseur.idfournisseur}">${fournisseur.nom}</option>
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