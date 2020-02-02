<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Categorie</title>
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
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">Categories</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${categorie != null}">
					<form
						action="<%=request.getContextPath()%>/CategorieServlet?action=edit"
						method="post">
					<c:set var="action" value="Modifier"/>
				</c:if>
				<c:if test="${categorie == null}">
					<form
						action="<%=request.getContextPath()%>/CategorieServlet?action=add"
						method="post">
						<c:set var="action" value="Ajouter"/>
				</c:if>

				<caption>
					<h2>
						<c:if test="${categorie != null}">
                                    Modifier Categorie
                                </c:if>
						<c:if test="${categorie == null}">
                                    Ajouter Nouvelle Categorie
                                </c:if>
					</h2>
				</caption>

				<c:if test="${categorie != null}">
					<input type="hidden" name="idCategorie"
						value="<c:out value='${categorie.idCategorie}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Designation</label> <input type="text"
						value="<c:out value='${categorie.designation}' />"
						class="form-control" name="designation" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">${action}</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>