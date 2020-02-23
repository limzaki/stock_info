<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Commande Sortie</title>
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
                    <h3 class="text-center">List Des Commandes d'Entrée</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/CommandeSortieServlet?action=new" class="btn btn-success">Ajouter
     Nouvelle Commande Sortie</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Date</th>
                                <th>Montant</th>
                                <th>Client</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="commandeSortie" items="${commandeSorties}">
                                <tr>
                                    <td>
                                        <c:out value="${commandeSortie.idCommandeSortie}" />
                                    </td>
                                    <td>
                                        <c:out value="${commandeSortie.dateCommandeSortie}" />
                                    </td>
                                    <td>
                                        <c:out value="${commandeSortie.montant}" />
                                    </td>
                                    <td>
                                        <c:out value="${commandeSortie.client.nomComplet}" />
                                    </td>
                                    <td><a href="LigneCommandeSortieServlet?action=list&id=<c:out value='${commandeSortie.idCommandeSortie}' />">Details</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>