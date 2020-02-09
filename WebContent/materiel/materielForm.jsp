<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Materiel</title>
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
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">Materiels</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${materiel != null}">
					<form
						action="<%=request.getContextPath()%>/MaterielServlet?action=edit"
						method="post">
					<c:set var="action" value="Modifier"/>
				</c:if>
				<c:if test="${materiel == null}">
					<form
						action="<%=request.getContextPath()%>/MaterielServlet?action=add"
						method="post">
						<c:set var="action" value="Ajouter"/>
				</c:if>

				<caption>
					<h2>
						<c:if test="${materiel != null}">
                                    Modifier Materiel
                                </c:if>
						<c:if test="${materiel == null}">
                                    Ajouter Nouvelle Materiel
                                </c:if>
					</h2>
				</caption>

				<c:if test="${materiel != null}">
					<input type="hidden" name="idMateriel"
						value="<c:out value='${materiel.idMateriel}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nom_Materiel</label> <input type="text"
						value="<c:out value='${materiel.nomMateriel}' />"
						class="form-control" name="nomMateriel" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Quantité_Stock</label> <input type="text"
						value="<c:out value='${materiel.quantiteStock}' />"
						class="form-control" name="quantiteStock" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Prix_Unitaire</label> <input type="text"
						value="<c:out value='${materiel.prixUnitaire}' />"
						class="form-control" name="prixUnitaire" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Categorie</label> 
					<select class="form-control" name="idCategorie" >
						<option value="${materiel.categorie.idCategorie}">${materiel.categorie.designation}</option>
  						<c:forEach var="categorie" items="${categories}">
  							<option value="${categorie.idCategorie}">${categorie.designation}</option>
  						</c:forEach>
  					</select>
				</fieldset>

				<button type="submit" class="btn btn-success">${action}</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>