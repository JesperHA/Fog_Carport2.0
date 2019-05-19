<div class="row">

    <!-- Ordre -->
    <div class="col-md-12">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-12">
                        <h3><b><% out.print(foundCustomer.getCustomer_id() + ". " + foundCustomer.getName());%></b></h3>
                        <hr>
                    </div>
                    <div class="col-6" style="float: left;">
                        <h4 class="card-title"><b>Kundens Information</b></h4>
                        <h6 class="text-muted card-subtitle mb-2 my-auto" style="display:inline-block">Her kan du se kundens informationer</h6>
                    </div>
                    <div class="col-6" style="float: right;">
                        <h4 class="card-title"><b>Alle ordre for kunden</b></h4>
                        <h6 class="text-muted card-subtitle mb-2 my-auto" style="display:inline-block">Her kan du se kundens ordre</h6>
                    </div>
                </div>
            </div>
            <div class="row">

            <div class="col-md-6" id="customer-info" style="padding-bottom:15px;">
                <b>Kunde: </b> <% out.print(foundCustomer.getName()); %> <br>
                <b>Email: </b> <% out.print(foundCustomer.getEmail()); %> <br>
                <b>Addresse: </b> <% out.println(foundCustomer.getAdress()); %> - <%out.println(foundCustomer.getZipcode());%> - <%out.println(foundCustomer.getCity());%> <br>
                <b>Tlf.: </b> <% out.print(foundCustomer.getPhone()); %> <br>
                <b>Rolle: </b><% if (foundCustomer.getRole() > 0) { out.print("Medarbejder"); } else { out.print("Kunde"); } %>
                <br>
            </div>

            <div class="col-md-6" id="table-found">
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Kunde</th>
                            <th scope="col">Status</th>
                            <th scope="col">Dato</th>
                            <th scope="col">Handling</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%

                            ArrayList<Order> customerOrders = (ArrayList<Order>) request.getAttribute("foundCustomerOrders");

                            if (customerOrders.size() > 0) {

                                int start = customerOrders.size()-1;

                                for (int i = start; i >= 0; i=i-1) {

                                    // Check status
                                    int status = customerOrders.get(i).getOrder_status();
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

                                    // Parse date YYYY-mm-dd
                                    String dateToParse = customerOrders.get(i).getDate();
                                    char[] dateCharArray = dateToParse.toCharArray();

                                    String dateFormatted = "" + dateCharArray[0] + dateCharArray[1] + dateCharArray[2] + dateCharArray[3] + "-" + dateCharArray[4] + dateCharArray[5] + "-" + dateCharArray[6] + dateCharArray[7];

                                    out.println("<tr>\n" +
                                            "<th scope=\"row\"> " + customerOrders.get(i).getOrder_id() + "</th>\n" +
                                            "<td> " + customerOrders.get(i).getCustomer_id() + "</td>\n" +
                                            "<td> " + statusPrint + "</td>\n" +
                                            "<td> " + dateFormatted + "</td>\n" +
                                            "<td><form method='post' action='FrontController' style='display:inline'><input type='hidden' name='source' value='searchorders' /><input type='hidden' name='type' value='single' /><button class='btn btn-dark btn-xs' type='submit' name='order_id' value='" + customerOrders.get(i).getOrder_id() + "'><span style='font-size:12px;'>Se Ordre</span></button></form></td>\n" +
                                            "</tr>");
                                }
                            } else {
                                out.print("<tr><td><h5>Ingen</h5></td><td><h5>eksisterende</h5></td><td><h5>ordre</h5></td></tr>");
                            }%>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>