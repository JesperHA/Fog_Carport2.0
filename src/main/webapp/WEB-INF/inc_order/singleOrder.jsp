<%@ page import="Model.Order" %>

<%
    Customer customerInQuestion = (Customer) request.getAttribute("customerIQ");
    Order order = (Order) request.getAttribute("foundOrder");
%>
<main class="page pricing-table-page">
    <h1 style="margin-bottom: 50px;margin-top: 120px;">Ordren blev fundet afgivet af kunden <b><%out.print(customerInQuestion.getName());%></b></h1>
</main>
<div>
    <div class="container" style="margin-bottom: 50px;">
        <div class="row">

            <!-- Søgning -->
            <div class="col-md-12" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Ordre</h4>
                        <h6 class="text-muted card-subtitle mb-2">Du kan enten søge efter en ordre med et ordre id eller med kundens navn, eller du kan se en komplet liste over alle ordre.</h6>
                        <hr>
                        <div class="row" style="margin-top:35px;">
                            <div class="col mx-auto">
                                <form action="FrontController" method="post">
                                    <input type="hidden" name="source" value="search" />
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="kunde" id="kunde" placeholder="søg vh.a. ordrens id eller kundens mail" autocomplete="off" required>
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

            <!-- Ordren Fundet -->

            <div class="col-md-6" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">ORDREN</h4>
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
                                        <label class="form-control" for="length" style="max-width:150px">Længde:</label>
                                        <input type="text" class="form-control" name="length" id="length" value="<% out.print(order.getLength()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="height" style="max-width:150px">Højde:</label>
                                        <input type="text" class="form-control" name="height" id="height" value="<% out.print(order.getHeight()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="width" style="max-width:150px">Bredde:</label>
                                        <input type="text" class="form-control" name="width" id="width" value="<% out.print(order.getWidth()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="roof" style="max-width:150px">Tag:</label>
                                        <input type="text" class="form-control" name="roof" id="roof" value="<% out.print(order.getRoof()); %>" autocomplete="off" >
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="shed" style="max-width:150px">Redskabskur:</label>
                                        <input type="text" class="form-control" name="shed" id="shed" value="<% out.print(order.getShed()); %>" autocomplete="off" <% if (order.getShed() == 0) { out.print("disabled"); } %>>
                                    </div> <br>

                                    <div class="input-group">
                                        <label class="form-control" for="shedtype" style="max-width:150px">Skurtype:</label>
                                        <input type="text" class="form-control" name="shedtype" id="shedtype" value="<% out.print(order.getShedtype()); %>" autocomplete="off" <% if (order.getShed() == 0) { out.print("disabled"); } %>>
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

                                    <div class="input-group-btn float-right">
                                        <button class="btn btn-primary" type="button" onclick="document.getElementById('order_id').disabled=false;document.getElementById('customer_id').disabled=false;document.getElementById('shed').disabled=false;document.getElementById('shedtype').disabled=false;document.getElementById('date').disabled=false;document.getElementById('hiddenButton').click()">Gem Ændringer</button>
                                        <button type="submit" id="hiddenButton"></button>
                                    </div>

                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
</div>

<script>
    $(document).ready(function(){
        $('#myTable').dataTable();
    });
</script>