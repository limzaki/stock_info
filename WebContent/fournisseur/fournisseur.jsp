<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Fournisseur</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="<%=request.getContextPath()%>/HomeServlet" class="navbar-brand"> Home </a>
                    </div>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List Des Fournisseurs</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/FournisseurServlet?action=new" class="btn btn-success">Ajouter
     Nouveau Fournisseur</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nom</th>
                                <th>Telephone</th>
                                <th>Email</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="fournisseur" items="${fournisseurs}">
                                <tr>
                                    <td>
                                        <c:out value="${fournisseur.idFournisseur}" />
                                    </td>
                                    <td>
                                        <c:out value="${fournisseur.nom}" />
                                    </td>
                                    <td>
                                        <c:out value="${fournisseur.telephone}" />
                                    </td>
                                    <td>
                                        <c:out value="${fournisseur.email}" />
                                    </td>
                                    <td><a href="FournisseurServlet?action=modify&id=<c:out value='${fournisseur.idFournisseur}' />">Modifier</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="<%=request.getContextPath()%>/FournisseurServlet?action=delete&id=<c:out value='${fournisseur.idFournisseur}' />">Supprimer</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>