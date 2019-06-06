<%
    ArrayList<Order> orderList = (ArrayList<Order>) request.getAttribute("orderlist");
%>
<main class="page pricing-table-page">
    <h1 style="margin-bottom: 50px;margin-top: 120px;">Velkommen til admin panelet</h1>
</main>
<div>
    <div class="container" style="margin-bottom: 50px;width: 100%;">
        <% if (login.getRole() == 1) { %>
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
        </div>
        <% } %>
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
                <div class="col-lg-12" style="margin-bottom: 30px;">
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
                                            <th>Størrelse</th>
                                            <th>Længde</th>
                                            <th>Bredde</th>
                                            <th>Højde</th>
                                            <th>Tagtype</th>
                                            <th>Tagmateriale</th>
                                            <th>Redskabsskur</th>
                                            <th>Skurtype</th>
                                            <th>Skurlængde</th>
                                            <th>Skurbredde</th>
                                            <th>Dato</th>
                                            <th>Status</th>
                                            <th>Handling</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            if (orderList != null) {
                                                int listSize = orderList.size() - 1;

                                                for (int i = listSize; i >= 0; i--) {
                                                    String stringSize;
                                                    if (orderList.get(i).getSize() == 0) {
                                                        stringSize = "Enkelt";
                                                    } else {
                                                        stringSize = "Dobbelt";
                                                    }

                                                    String stringRooftype;
                                                    if (orderList.get(i).getRoof_type() == 0) {
                                                        stringRooftype = "Uden Rejsning";
                                                    } else {
                                                        stringRooftype = "Med Rejsning";
                                                    }

                                                    String stringRoofsort;
                                                    if (orderList.get(i).getRoof_sort() == 0) {
                                                        stringRoofsort = "Trapez";
                                                    } else if (orderList.get(i).getRoof_sort() == 1) {
                                                        stringRoofsort = "Eternit";
                                                    } else {
                                                        stringRoofsort = "Tagpap";
                                                    }

                                                    String stringShed;
                                                    if (orderList.get(i).getShed() == 0) {
                                                        stringShed = "Uden Redskabsskur";
                                                    } else {
                                                        stringShed = "Med Redskabsskur";
                                                    }

                                                    String stringShedtype;
                                                    if (orderList.get(i).getShedtype() == 0) {
                                                        stringShedtype = "Ingen";
                                                    } else if (orderList.get(i).getShedtype() == 1) {
                                                        stringShedtype = "En-på-to beklædning";
                                                    } else {
                                                        stringShedtype = "Klinkbeklædning";
                                                    }

                                                    out.print(
                                                                    "<tr>" +
                                                                    "<td>" + orderList.get(i).getOrder_id() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getCustomer_id() + "</td>\n" +
                                                                    "<td>" + stringSize + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getLength() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getWidth() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getHeight() + "</td>\n" +
                                                                    "<td>" + stringRooftype + "</td>\n" +
                                                                    "<td>" + stringRoofsort + "</td>\n" +
                                                                    "<td>" + stringShed + "</td>\n" +
                                                                    "<td>" + stringShedtype + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getShed_length() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getShed_width() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getOrder_status() + "</td>\n" +
                                                                    "<td>" + orderList.get(i).getDate() + "</td>\n" +
                                                                    "<td><form method='post' action='FrontController' style='display:inline'><input type='hidden' name='source' value='searchorders' /><input type='hidden' name='type' value='single' /><button class=\"btn btn-sm btn-primary\" type=\"submit\" name=\"order_id\" value='" + orderList.get(i).getOrder_id() + "'>Se Ordre</button></form></td>" +
                                                                    "</tr>"
                                                    );
                                                }
                                            } else {
                                                out.print(
                                                        "<tr>" +
                                                                "<td> Ingen </td>\n" +
                                                                "<td> Ordre </td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>\n" +
                                                                "<td></td>" +
                                                                "</tr>"
                                                );
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