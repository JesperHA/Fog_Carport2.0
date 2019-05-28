<%@ page import="Model.Material" %>
<%@ page import="FunctionLayer.MaterialCalculator" %><%--
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

    <form action="FrontController" method="post">
        <input type="hidden" name="source" value="complete"/>

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
        <div class="row" id="fullscreen" style="display:none;margin-bottom:50px;">
            <div class="col-md-12">
                <div class="card niceBackground">
                    <div class="card-body">
                        <h4 class="card-title">Plantegning</h4>
                        <h6 class="text-muted card-subtitle mb-2">Fuldstørrelse</h6>

                        <%
                            String svgString = "0";

                            svgString = (String) session.getAttribute("svg");

                            if (!svgString.equals("0")) {
                                out.println(svgString);
                            }
                        %>
                        <button type="button" class="btn btn-primary" onclick="document.getElementById('fullscreen').style.display = 'none';document.getElementById('planogmat').style.display = 'flex'" style="float:right;">Luk plantegning </button>

                    </div>
                </div>
            </div>
        </div>
        <div class="row" id="planogmat">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Plantegning</h4>
                        <h6 class="text-muted card-subtitle mb-2">Her kan du se tegning</h6>
                        <div class="box niceBackground" style="margin-top:30px;margin-bottom:40px;max-height: 300px;">
                            <div class="ribbon ribbon-top-right"><span>Eksempel</span></div>
                                <div style="opacity: 0.2;">
                                <%

                                    svgString = (String) session.getAttribute("svg");

                                    if (!svgString.equals("0")) {
                                        out.println(svgString);
                                    }
                                %>
                                </div>
                        </div>
                        <button class="btn btn-primary" type="button" onclick="document.getElementById('fullscreen').style.display = 'block';document.getElementById('planogmat').style.display = 'none'" style="float:right;">Se plantegning </button>

                    </div>
                </div>
            </div>



            <div class="col-md-8">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Materialeliste</h4>
                        <h6 class="text-muted card-subtitle mb-2">Her kan du se materialer og priser</h6>

                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Varenr.</th>
                                    <th>Produkt</th>
                                    <th>Beskrivelse</th>
                                    <th>Enhed</th>
                                    <th>Antal</th>
                                    <th>Pris</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    double prisIalt = 0;

                                    for (int i = 0; i < materials.size(); i++) {

                                    %>
                                <tr>
                                    <td><% out.println(materials.get(i).getProduct_id()); %></td>
                                    <td><% out.println(materials.get(i).getProduct_name()); %></td>
                                    <td><% out.println(materials.get(i).getProduct_description()); %></td>
                                    <td><% out.println(materials.get(i).getUnit());%></td>
                                    <td><% out.println(materials.get(i).getAmount());%></td>
                                    <td><% out.println(materials.get(i).getPrice());%></td>
                                </tr>
                                <% prisIalt = prisIalt + materials.get(i).getPrice();
                                    }%>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><b>Ialt: <%out.println(MaterialCalculator.round(prisIalt, 2));%>kr.</b></td>
                                </tr>
                                </tbody>
                            </table>
                            <button style="float: right" class="btn btn-success" name="complete" type="submit">Fuldfør bestilling</button>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </div>
    </section>
    </form>
</main>

<%@include file="include/footer.jsp"%>
