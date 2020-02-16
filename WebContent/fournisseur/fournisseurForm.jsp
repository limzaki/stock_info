<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Fournisseur</title>
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
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">Fournisseurs</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${fournisseur != null}">
					<form
						action="<%=request.getContextPath()%>/FournisseurServlet?action=edit"
						method="post">
					<c:set var="action" value="Modifier"/>
				</c:if>
				<c:if test="${fournisseur == null}">
					<form
						action="<%=request.getContextPath()%>/FournisseurServlet?action=add"
						method="post">
						<c:set var="action" value="Ajouter"/>
				</c:if>

				<caption>
					<h2>
						<c:if test="${fournisseur != null}">
                                    Modifier Fournisseur
                                </c:if>
						<c:if test="${fournisseur == null}">
                                    Ajouter Nouvelle Fournisseur
                                </c:if>
					</h2>
				</caption>

				<c:if test="${fournisseur != null}">
					<input type="hidden" name="id"
						value="<c:out value='${fournisseur.idFournisseur}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nom</label> <input type="text"
						value="<c:out value='${fournisseur.nom}' />"
						class="form-control" name="nom" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Telephone</label> <input type="text"
						value="<c:out value='${fournisseur.telephone}' />"
						class="form-control" name="telephone" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${fournisseur.email}' />"
						class="form-control" name="email" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">${action}</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>