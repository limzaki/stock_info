<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Materiel</title>
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
                    <h3 class="text-center">List Des Materiels</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/MaterielServlet?action=new" class="btn btn-success">Ajouter
     Nouvelle Materiel</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Nom_Materiel</th>
                                <th>Categorie</th>
                                <th>Quantite_Stock</th>
                                <th>Prix_Unitaire</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="materiel" items="${materiels}">
                                <tr>
                                    <td>
                                        <c:out value="${materiel.nomMateriel}" />
                                    </td>
                                    <td>
                                        <c:out value="${materiel.categorie.designation}" />
                                    </td>
                                    <td>
                                        <c:out value="${materiel.quantiteStock}" />
                                    </td>
                                    <td>
                                        <c:out value="${materiel.prixUnitaire}" />
                                    </td>
                                    <td><a href="MaterielServlet?action=modify&id=<c:out value='${materiel.idMateriel}' />">Modifier</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="<%=request.getContextPath()%>/MaterielServlet?action=delete&id=<c:out value='${materiel.idMateriel}' />">Supprimer</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>