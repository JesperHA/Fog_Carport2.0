﻿<%@ page import="Model.Order" %>

<%
    Customer customerInQuestion = (Customer) request.getAttribute("customerIQ");
    Order order = (Order) request.getAttribute("foundOrder");

    int status = order.getOrder_status();
    String statusPrint;

    if (status == 0) {
        // Afventer
        statusPrint = "<span class='badge badge-secondary' style='height:20px;'>Afventer</span>";
    } else if (status == 1) {
        // Godkendt
        statusPrint = "<span class='badge badge-success' style='height:20px;'>Godkendt</span>";
    } else if (status == 2) {
        // Afvist
        statusPrint = "<span class='badge badge-danger' style='height:20px;'>Afvist</span>";
    } else {
        // Ukendt
        statusPrint = "<span class='badge badge-warning' style='height:20px;'>Ukendt</span>";
    }
%>
<main class="page pricing-table-page">
    <% if (login != null && login.getRole() == 1) {%>
    <h1 style="margin-bottom: 50px;margin-top: 120px;">Ordren blev fundet afgivet af kunden <b><%out.print(customerInQuestion.getName());%></b></h1>
    <% } else { %>
    <h1 style="margin-bottom: 50px;margin-top: 120px;">Din ordre med ordre nummer <b><%out.print(order.getOrder_id());%></b></h1>
    <% } %>
</main>
<div>
    <div class="container" style="margin-bottom: 50px;">

        <%
            String failed = null;
            failed = (String) request.getAttribute("failed");

            if (failed != null && failed.equals("failed")) {
        %>
        <div style="text-align: center;margin: auto:">
            <div class="alert alert-danger" role="alert">
                <h5 style="margin-top: 4px;">Der skete en fejl og status er uændret, kontakt administrator.</h5>
            </div>
        </div>
        <% } %>

        <div class="row">

            <% if (login != null && login.getRole() == 1) {%>
            <!-- Søgning -->
            <div class="col-md-12" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Ordre</h4>
                        <h6 class="text-muted card-subtitle mb-2">Du kan søge efter en ordre med et ordre id.</h6>
                        <hr>
                        <div class="row" style="margin-top:35px;">
                            <div class="col mx-auto">
                                <form action="FrontController" method="post">
                                    <input type="hidden" name="source" value="searchorders" />
                                    <input type="hidden" name="type" value="single" />
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="order_id" placeholder="Indtast ordrens id" autocomplete="off" required>
                                        <span class="input-group-btn">
                                                <button class="btn btn-primary" type="button">Søg</button>
                                           </span>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <% } %>

            <!-- Tegning -->
            <div class="col-md-6" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">TEGNING</h4>
                        <hr>
                        <div class="row" style="margin-top:35px;">
                            <div class="col" style="text-align: center">
                                <p>Vis Tegning Her</p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <% if (login != null && login.getRole() == 1) {%>
            <!-- Ordren Fundet ADMIN-->

            <div class="col-md-6" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card-body">
                        <h4 class="float-left">ORDREN</h4>
                        <span class="float-right">Status: <% out.print(statusPrint); %></span>
                        <br>
                        <hr>
                        <div class="row" style="margin-top:35px;">
                            <div class="col mx-auto">
                                <form action="FrontController" method="post">
                                    <input type="hidden" name="source" value="changeOrder" />
                                    <input type="hidden" name="changetype" value="order" />

                                    <div class="input-group">
                                        <label class="form-control" for="order_id" style="max-width:150px">Order ID:</label>
                                        <input type="text" class="form-control" name="order_id" id="order_id" value="<% out.print(order.getOrder_id()); %>" autocomplete="off" disabled>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="customer_id" style="max-width:150px">Kunde ID:</label>
                                        <input type="text" class="form-control" name="customer_id" id="customer_id" value="<% out.print(order.getCustomer_id()); %>" autocomplete="off" disabled>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="size" style="max-width:150px">Størrelse:</label>
                                        <select class="form-control" name="size" id="size">
                                            <option value="0" <% if (order.getSize() == 0) { out.print("selected"); } %>>Enkelt</option>
                                            <option value="1" <% if (order.getSize() == 1) { out.print("selected"); } %>>Dobbelt</option>
                                        </select>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="length" style="max-width:150px">Længde:</label>
                                        <input type="text" class="form-control" name="length" id="length" value="<% out.print(order.getLength()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="width" style="max-width:150px">Bredde:</label>
                                        <input type="text" class="form-control" name="width" id="width" value="<% out.print(order.getWidth()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="height" style="max-width:150px">Højde:</label>
                                        <input type="text" class="form-control" name="height" id="height" value="<% out.print(order.getHeight()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="roof_type" style="max-width:150px">Tag type:</label>
                                        <select class="form-control" name="roof_type" id="roof_type">
                                            <option value="0" <% if (order.getRoof_type() == 0) { out.print("selected"); } %>>Uden Rejsning</option>
                                            <option value="1" <% if (order.getRoof_type() == 1) { out.print("selected"); } %>>Med Rejsning</option>
                                        </select>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="roof_sort" style="max-width:150px">Tag materiale:</label>
                                        <select class="form-control" name="roof_sort" id="roof_sort">
                                            <option value="0" <% if (order.getRoof_sort() == 0) { out.print("selected"); } %>>Trapez</option>
                                            <option value="1" <% if (order.getRoof_sort() == 1) { out.print("selected"); } %>>Eternit</option>
                                            <option value="2" <% if (order.getRoof_sort() == 2) { out.print("selected"); } %>>Tagpap</option>
                                        </select>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="shed" style="max-width:150px">Redskabsskur:</label>
                                        <select class="form-control" name="shed" id="shed">
                                            <option value="0" <% if (order.getShed() == 0) { out.print("selected"); } %>>Uden Redskabsskur</option>
                                            <option value="1" <% if (order.getShed() == 1) { out.print("selected"); } %>>Med Redskabsskur</option>
                                        </select>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="shedtype" style="max-width:150px">Skurtype:</label>
                                        <select class="form-control" name="shedtype" id="shedtype" <% if (order.getShed() == 0) { out.print("disabled"); } %>>
                                            <option value="0" <% if (order.getShedtype() == 0) { out.print("selected"); } %>>Ingen</option>
                                            <option value="1" <% if (order.getShedtype() == 1) { out.print("selected"); } %>>En-på-to beklædning</option>
                                            <option value="2" <% if (order.getShedtype() == 1) { out.print("selected"); } %>>Klinkbeklædning</option>
                                        </select>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="shed_length" style="max-width:150px">Skurlængde:</label>
                                        <input type="text" class="form-control" name="shed_length" id="shed_length" value="<% out.print(order.getShed_length()); %>" autocomplete="off" <% if (order.getShed() == 0) { out.print("disabled"); } %>>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="shed_width" style="max-width:150px">Skurbredde:</label>
                                        <input type="text" class="form-control" name="shed_width" id="shed_width" value="<% out.print(order.getShed_width()); %>" autocomplete="off" <% if (order.getShed() == 0) { out.print("disabled"); } %>>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="date" style="max-width:150px">Dato:</label>
                                        <input type="text" class="form-control" name="date" id="date" value="<%
                                         // Parse date YYYY-mm-dd
                                        String dateToParse = order.getDate();
                                        char[] dateCharArray = dateToParse.toCharArray();

                                        String dateFormatted = "" + dateCharArray[0] + dateCharArray[1] + dateCharArray[2] + dateCharArray[3] + "-" + dateCharArray[4] + dateCharArray[5] + "-" + dateCharArray[6] + dateCharArray[7];
                                        out.print(dateFormatted); %>" autocomplete="off" disabled>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="order_status" style="max-width:150px">Status:</label>
                                        <select class="form-control" name="order_status" id="order_status">
                                            <option value="0" <% if (order.getOrder_status() == 0) { out.print("selected"); } %>>Afventer</option>
                                            <option value="1" <% if (order.getOrder_status() == 1) { out.print("selected"); } %>>Godkendt</option>
                                            <option value="2" <% if (order.getOrder_status() == 2) { out.print("selected"); } %>>Afvist</option>
                                            <option value="3" <% if (order.getOrder_status() == 3) { out.print("selected"); } %>>Ukendt</option>
                                        </select>
                                    </div>

                                        <hr>

                                    <div class="input-group-btn float-right" style="margin-left:-12px;">
                                        <button class="btn btn-danger" type="button" data-toggle="modal" data-target="#deleteModal">Slet</button>
                                    </div>
                                    <div class="input-group-btn float-right">
                                        <button class="btn btn-primary" type="button" onclick="document.getElementById('order_id').disabled=false;document.getElementById('customer_id').disabled=false;document.getElementById('shed').disabled=false;document.getElementById('shedtype').disabled=false;document.getElementById('date').disabled=false;document.getElementById('shed_length').disabled=false;document.getElementById('shed_width').disabled=false;document.getElementById('hiddenButton').click()">Gem Ændringer</button>
                                        <button type="submit" id="hiddenButton" style="visibility: hidden;"></button>
                                    </div>
                                </form>

                                <% if (order.getOrder_status() != 1) { %>

                                <form action="FrontController" method="post">
                                    <input type="hidden" name="source" value="changeOrder" />
                                    <input type="hidden" name="changetype" value="status" />
                                    <input type="hidden" name="order_id" value="<%out.print(order.getOrder_id());%>" />
                                    <div class="input-group-btn float-left">
                                        <button type="submit" name="status" id="godkend-button" value="1" style="margin-top: 5px;">Godkend</button>
                                    </div>
                                </form>

                                <% } %>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <% } else { %>

            <!-- Ordren Fundet KUNDE -->

            <div class="col-md-6" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card-body">
                        <h4 class="float-left">ORDREN</h4>
                        <span class="float-right">Status: <% out.print(statusPrint); %></span>
                        <br>
                        <hr>
                        <div class="row" style="margin-top:35px;">
                            <div class="col mx-auto">
                                <form action="FrontController" method="post">
                                    <input type="hidden" name="source" value="changeOrder" />
                                    <input type="hidden" name="changetype" value="order" />

                                    <div class="input-group">
                                        <label class="form-control" for="order_id" style="max-width:150px">Order ID:</label>
                                        <input type="text" class="form-control" name="order_id" id="order_id" value="<% out.print(order.getOrder_id()); %>" autocomplete="off" disabled>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="customer_id" style="max-width:150px">Kunde ID:</label>
                                        <input type="text" class="form-control" name="customer_id" id="customer_id" value="<% out.print(order.getCustomer_id()); %>" autocomplete="off" disabled>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="size" style="max-width:150px">Enkelt eller dobbelt:</label>
                                        <input type="text" class="form-control" name="size" id="size" value="<% out.print(order.getSize()); %>" autocomplete="off" disabled>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="length" style="max-width:150px">Længde:</label>
                                        <input type="text" class="form-control" name="length" id="length" value="<% out.print(order.getLength()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="width" style="max-width:150px">Bredde:</label>
                                        <input type="text" class="form-control" name="width" id="width" value="<% out.print(order.getWidth()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="height" style="max-width:150px">Højde:</label>
                                        <input type="text" class="form-control" name="height" id="height" value="<% out.print(order.getHeight()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="roof_type" style="max-width:150px">Taghældning:</label>
                                        <input type="text" class="form-control" name="roof_type" id="roof_type" value="<% out.print(order.getRoof_type()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="roof_sort" style="max-width:150px">Tag materiale:</label>
                                        <input type="text" class="form-control" name="roof_sort" id="roof_sort" value="<% out.print(order.getRoof_sort()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="shed" style="max-width:150px">Redskabsskur:</label>
                                        <input type="text" class="form-control" name="shed" id="shed" value="<% out.print(order.getShed()); %>" autocomplete="off">
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="shedtype" style="max-width:150px">Skurtype:</label>
                                        <input type="text" class="form-control" name="shedtype" id="shedtype" value="<% out.print(order.getShedtype()); %>" autocomplete="off" <% if (order.getShed() == 0) { out.print("disabled"); } %>>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="shed_length" style="max-width:150px">Skurtype:</label>
                                        <input type="text" class="form-control" name="shed_length" id="shed_length" value="<% out.print(order.getShed_length()); %>" autocomplete="off" <% if (order.getShed() == 0) { out.print("disabled"); } %>>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="shed_width" style="max-width:150px">Skurtype:</label>
                                        <input type="text" class="form-control" name="shed_width" id="shed_width" value="<% out.print(order.getShed_width()); %>" autocomplete="off" <% if (order.getShed() == 0) { out.print("disabled"); } %>>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="date" style="max-width:150px">Dato:</label>
                                        <input type="text" class="form-control" name="date" id="date" value="<%
                                         // Parse date YYYY-mm-dd
                                        String dateToParse = order.getDate();
                                        char[] dateCharArray = dateToParse.toCharArray();

                                        String dateFormatted = "" + dateCharArray[0] + dateCharArray[1] + dateCharArray[2] + dateCharArray[3] + "-" + dateCharArray[4] + dateCharArray[5] + "-" + dateCharArray[6] + dateCharArray[7];
                                        out.print(dateFormatted); %>" autocomplete="off" disabled>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="order_status" style="max-width:150px">Status:</label>
                                        <select class="form-control" name="order_status" id="order_status" disabled>
                                            <option value="0" <% if (order.getOrder_status() == 0) { out.print("selected"); } %>>Afventer</option>
                                            <option value="1" <% if (order.getOrder_status() == 1) { out.print("selected"); } %>>Godkendt</option>
                                            <option value="2" <% if (order.getOrder_status() == 2) { out.print("selected"); } %>>Afvist</option>
                                            <option value="3" <% if (order.getOrder_status() == 3) { out.print("selected"); } %>>Ukendt</option>
                                        </select>
                                    </div>

                                    <hr>

                                    <div class="input-group float-right" style="margin-left:-12px;">
                                        <span>For ændringer kontakt FOG Administrationen</span>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <% } %>
</div>


        <!-- Slet Ordre Modal -->
        <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">SLET ORDREN</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Du er i gang med at slette ordren, dette kan ikke gøres om og alt data der tilhører ordren vil også blive slettet!
                        <br><br>
                        Er du sikker på at du vil slette ordren?
                    </div>
                    <div class="modal-footer">

                        <form action="FrontController" method="post">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fortryd</button>

                            <input type="hidden" name="source" value="changeOrder" />
                            <input type="hidden" name="changetype" value="delete" />

                            <button type="submit" class="btn btn-danger" name="order_id" value="<% out.print(order.getOrder_id()); %>">Slet</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>