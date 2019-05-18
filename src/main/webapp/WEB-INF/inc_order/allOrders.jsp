
<%
    ArrayList<Order> orderList = (ArrayList<Order>) request.getAttribute("orderlist");
%>
<main class="page pricing-table-page">
    <h1 style="margin-bottom: 50px;margin-top: 120px;">Velkommen til admin panelet</h1>
</main>
<div>
    <div class="container" style="margin-bottom: 50px;">
        <div class="row">
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
                                        <input type="text" class="form-control" name="order_id" id="order_id" placeholder="ordrens id" autocomplete="off" required>
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
        </div>
        <%
            String order_id = (String) request.getAttribute("deletedOrder_id");
            String success = (String) request.getAttribute("deletedOrder");

            if (order_id != null && success != null) {
        %>
        <div class="row" style="text-align:center">
            <h3 style="padding-left:100px">Ordren med ordre id <% out.print(order_id); %> blev <% if (success.equals("success")) { out.print("slettet."); } else { out.print("ikke slettet pga. en fejl."); }%></h3>
        </div>
        <% } %>
            <div class="row">
                <div class="col-md-12" style="margin-bottom: 30px;">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Alle ordre</h4>
                            <h6 class="text-muted card-subtitle mb-2">Nedenunder ses en komplet ordreliste</h6>
                            <div class="row" style="margin-top:35px;">
                                <div class="col mx-auto">
                                    <table id="myTable" class="table table-striped" >
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Kunde ID</th>
                                            <th>Længde</th>
                                            <th>Højde</th>
                                            <th>Bredde</th>
                                            <th>Tag</th>
                                            <th>Redskabsskur</th>
                                            <th>Redskabsskurtype</th>
                                            <th>Status</th>
                                            <th>Dato</th>
                                            <th>Handling</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            if (orderList != null) {
                                                int listSize = orderList.size() - 1;

                                                for (int i = listSize; i >= 0; i--) {
                                                    out.print(
                                                                    "<tr>" +
                                                                    "<td>" + orderList.get(i).getOrder_id() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getCustomer_id() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getLength() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getHeight() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getWidth() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getRoof() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getShed() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getShedtype() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getOrder_status() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getDate() + "</td>\n" +
                                                                    "<td><form method='post' action='FrontController' style='display:inline'><input type='hidden' name='source' value='searchorders' /><input type='hidden' name='type' value='single' /><button class=\"btn btn-sm btn-primary\" type=\"submit\" name=\"order_id\" value='" + orderList.get(i).getOrder_id() + "'>Se Ordre</button></form></td>" +
                                                                    "</tr>"
                                                    );
                                                }
                                            }
                                        %>
                                        </tbody>
                                    </table>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>