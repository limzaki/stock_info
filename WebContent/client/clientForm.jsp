<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Client</title>
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
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">Clients</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${client != null}">
					<form
						action="<%=request.getContextPath()%>/ClientServlet?action=edit"
						method="post">
					<c:set var="action" value="Modifier"/>
				</c:if>
				<c:if test="${client == null}">
					<form
						action="<%=request.getContextPath()%>/ClientServlet?action=add"
						method="post">
						<c:set var="action" value="Ajouter"/>
				</c:if>

				<caption>
					<h2>
						<c:if test="${client != null}">
                                    Modifier Client
                                </c:if>
						<c:if test="${client == null}">
                                    Ajouter Nouvelle Client
                                </c:if>
					</h2>
				</caption>

				<c:if test="${client != null}">
					<input type="hidden" name="id"
						value="<c:out value='${client.idClient}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nom</label> <input type="text"
						value="<c:out value='${client.nomComplet}' />"
						class="form-control" name="nom" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Telephone</label> <input type="text"
						value="<c:out value='${client.telephone}' />"
						class="form-control" name="telephone" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${client.email}' />"
						class="form-control" name="email" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">${action}</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>