<%@ page import="Model.Material" %><%--
  Created by IntelliJ IDEA.
  User: Jesper
  Date: 13-05-2019
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="include/header.jsp"%>


<%
    ArrayList<Material> materials = (ArrayList<Material>) session.getAttribute("materials");

%>

<%--<main class="page">--%>
    <%--<section class="clean-block features">--%>
        <%--<div class="card"></div>--%>
    <%--</section>--%>
<%--</main>--%>
<main class="page pricing-table-page">
    <h1 style="margin-bottom: 50px;margin-top: 120px;">Din bestilling!</h1>
</main>
<div>
    <div class="container" style="margin-bottom: 50px;">
        <div class="row">
            <div class="col-md-12" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Her kan du se materialeliste samt en plantegning af din carport</h4>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Din Carport</h4>
                        <h6 class="text-muted card-subtitle mb-2">Her kan du se tegning</h6>

                        <%
                            String svgString = "0";

                            svgString = (String) session.getAttribute("svg");

                            if (!svgString.equals("0")) {
                                out.println(svgString);
                            }
                        %>



                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Materialeliste</h4>
                        <h6 class="text-muted card-subtitle mb-2">Her kan du se materialer og priser</h6>

                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>stolper</th>
                                    <th>længde</th>
                                    <th>antal</th>
                                    <th>pris</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><% out.println(materials.get(0).getProduct_description()); %></td>
                                    <td><% out.println(materials.get(0).getUnit());%></td>
                                    <td><% out.println(materials.get(0).getAmount());%></td>
                                    <td><% out.println((((materials.get(0).getPrice() * materials.get(0).getUnit()) * materials.get(0).getAmount())) / 100);%></td>
                                </tr>
                                <tr>
                                    <td>Cell 3</td>
                                    <td>Cell 4</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="include/footer.jsp"%>
