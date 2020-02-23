<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>LigneCommandeSortie</title>
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
                    <h3 class="text-center">Détails de la commande de sortie</h3>
                    <hr>
                    <div class="container text-left">

                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Materiel</th>
                                <th>Prix</th>
                                <th>quantite</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ligneCommandeSortie" items="${ligneCommandeSorties}">
                                <tr>
                                    <td>
                                        <c:out value="${ligneCommandeSortie.materiel.nomMateriel}" />
                                    </td>
									<td>
                                        <c:out value="${ligneCommandeSortie.materiel.prixUnitaire} MAD" />
                                    </td>
                                    <td>
                                        <c:out value="${ligneCommandeSortie.quantite}" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>