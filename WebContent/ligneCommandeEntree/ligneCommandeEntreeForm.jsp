<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>LigneCommandeEntree</title>
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
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">LigneCommandeEntrees</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/LigneCommandeEntreeServlet?action=add" method="post">
					<c:set var="action" value="Ajouter"/>
					<caption>
						<h2>
							Ajouter Nouvelle Ligne Commande Entree
						</h2>
					</caption>
					<fieldset class="form-group">
						<input type="hidden"
							class="form-control" name="idCommandeEntree" value="${commandeEntree.idCommandeEntree}">
					</fieldset>
					<fieldset class="form-group">
						<label>Materiel</label> 
						<select class="form-control" name="idMateriel" >
	  						<c:forEach var="materiel" items="${materiels}">
	  							<option value="${materiel.idMateriel}">${materiel.nomMateriel}</option>
	  						</c:forEach>
	  					</select>
					</fieldset>
					<fieldset class="form-group">
						<label>Quantite</label> <input type="number"
							class="form-control" name="quantite" required="required">
					</fieldset>
					
					<button type="submit" class="btn btn-success">${action}</button>
					<button type="submit" class="btn btn-success">Finaliser la commande</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>