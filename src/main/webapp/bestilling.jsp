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
<main class="page login-page">
    <section class="clean-block clean-form dark">
        <div class="container" style="margin-top: 50px;">
            <div class="block-heading">
                <h2 class="text-info">Din bestilling</h2>
                <p>Din bestilling blev gennemført!</p>
            </div>
        <div class="row">
            <div class="col-md-12" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Din carport er næsten klar!</h4>
                        <p>Vi har genereret en materialeliste og en plantegning til dig.</p>
                        <p>Din materialeliste afventer i øjeblikket godkendelse. </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Plantegning</h4>
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
                                    <th>Column 1</th>
                                    <th>Column 2</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Cell 1</td>
                                    <td>Cell 2</td>
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
    </section>
</main>

<%@include file="include/footer.jsp"%>
