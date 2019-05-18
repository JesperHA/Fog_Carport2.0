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
        <div class="row">

            <div class="col-md-12" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Alle ordre</h4>
                        <h6 class="text-muted card-subtitle mb-2">Nedenunder ses en komplet ordreliste</h6>
                        <hr>
                        <div class="row" style="margin-top:35px;">
                            <div class="col mx-auto">
                                <table id="myTable" class="table table-striped" >
                                    <thead>
                                    <tr>
                                        <th>ENO</th>
                                        <th>EMPName</th>
                                        <th>Country</th>
                                        <th>Salary</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>001</td>
                                        <td>Anusha</td>
                                        <td>India</td>
                                        <td>10000</td>
                                    </tr>
                                    <tr>
                                        <td>002</td>
                                        <td>Charles</td>
                                        <td>United Kingdom</td>
                                        <td>28000</td>
                                    </tr>
                                    <tr>
                                        <td>003</td>
                                        <td>Sravani</td>
                                        <td>Australia</td>
                                        <td>7000</td>
                                    </tr>
                                    <tr>
                                        <td>004</td>
                                        <td>Amar</td>
                                        <td>India</td>
                                        <td>18000</td>
                                    </tr>
                                    <tr>
                                        <td>005</td>
                                        <td>Lakshmi</td>
                                        <td>India</td>
                                        <td>12000</td>
                                    </tr>
                                    <tr>
                                        <td>006</td>
                                        <td>James</td>
                                        <td>Canada</td>
                                        <td>50000</td>
                                    </tr>

                                    <tr>
                                        <td>007</td>
                                        <td>Ronald</td>
                                        <td>US</td>
                                        <td>75000</td>
                                    </tr>
                                    <tr>
                                        <td>008</td>
                                        <td>Mike</td>
                                        <td>Belgium</td>
                                        <td>100000</td>
                                    </tr>
                                    <tr>
                                        <td>009</td>
                                        <td>Andrew</td>
                                        <td>Argentina</td>
                                        <td>45000</td>
                                    </tr>

                                    <tr>
                                        <td>010</td>
                                        <td>Stephen</td>
                                        <td>Austria</td>
                                        <td>30000</td>
                                    </tr>
                                    <tr>
                                        <td>011</td>
                                        <td>Sara</td>
                                        <td>China</td>
                                        <td>750000</td>
                                    </tr>
                                    <tr>
                                        <td>012</td>
                                        <td>JonRoot</td>
                                        <td>Argentina</td>
                                        <td>65000</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <!-- Kunder -->


            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Nyeste kunder</h4>
                        <h6 class="text-muted card-subtitle mb-2 my-auto" style="display:inline-block">Her er de nyeste kunder</h6><button class="btn btn-primary float-right" type="button" style="display:inline-block;margin-top: 10px;">Se alle</button></div>

                    <div id="table-in-card">
                        <form action="FrontController" method="post">
                            <table class="table">
                                <thead class="thead-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Kunde</th>
                                    <th scope="col">Tlf</th>
                                    <th scope="col">By</th>
                                    <th scope="col">Handling</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
/*
                                    if (customerList.size() > 0) {

                                        int start = customerList.size()-1;
                                        int stop = customerList.size()-4;

                                        for (int i = start; i >= stop; i=i-1) {

                                            out.println("<tr>\n" +
                                                    "<th scope=\"row\"> " + customerList.get(i).getCustomer_id() + "</th>\n" +
                                                    "<td> " + customerList.get(i).getName() + "</td>\n" +
                                                    "<td> " + customerList.get(i).getPhone() + "</td>\n" +
                                                    "<td> " + customerList.get(i).getCity() + "</td>\n" +
                                                    "<td><button class=\"btn btn-dark btn-xs\" type=\"submit\" name='search' value='" + customerList.get(i).getCustomer_id() + "'><span style=\"font-size:12px;\">Se Kunde</span></button></td>\n" +
                                                    "</tr>");
                                        }
                                    } */ %>
                                </tbody>
                            </table>
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