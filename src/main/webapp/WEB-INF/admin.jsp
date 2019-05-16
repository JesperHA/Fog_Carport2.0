<%@ page import="Model.Customer" %>
<%@ page import="java.util.ArrayList" %>

<%

    ArrayList<Customer> customer = (ArrayList<Customer>) session.getAttribute("login");

%>

<%@include file="../include/header.jsp"%>

<style>
    .btn-group-xs > .btn, .btn-xs {
        padding: .25rem .4rem;
        font-size: 20px;
        line-height: .85;
        border-radius: .2rem;
    }
    .table td {
        text-align: center;
    }
    .table th {
        text-align: center;
    }
    #table-orders {
        margin:auto;
        width:100%;
        padding: 20px;
    }
    #table-customers {
        margin:auto;
        width:100%;
        padding: 20px;
    }
    #table-found {
        margin:auto;
        width:100%;
        padding: 20px;
    }
</style>

<main class="page pricing-table-page">
    <h1 style="margin-bottom: 50px;margin-top: 120px;">Velkommen til admin panelet, <%out.println(customer.get(0).getName());%>!</h1>
</main>
<div>
    <div class="container" style="margin-bottom: 50px;">
        <div class="row">
            <div class="col-md-12" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Adgang</h4>
                        <h6 class="text-muted card-subtitle mb-2">Du har adgang til administrator funktionerne for brugeren <%out.println("<i>" + customer.get(0).getEmail() + "</i>");%></h6>
                        <hr>
                        <div class="row" style="margin-top:35px;">
                            <div class="col mx-auto">
                                <form action="FrontController" method="post">
                                    <input type="hidden" name="source" value="search" />
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="kunde" id="kunde" placeholder="søg vh.a. kundens id eller kundens mail" autocomplete="off" required>
                                        <span class="input-group-btn">
                                                <button class="btn btn-primary" type="submit">Søg</button>
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
            // Tjek om der er søgt

            String searched = null;
            searched = (String) request.getAttribute("searched");

            if (searched != null) {

            Customer foundCustomer;

            foundCustomer = (Customer) request.getAttribute("foundCustomer");

            if (foundCustomer != null) {
                %>
            <%@include file="search.jsp"%>
        <%
                } else { %>
                    <div class="row" style="text-align:center">
                        <h3 style="padding-left:100px">Ingen kunde blev fundet for søgeterm <i>"<%String searchTerm = (String) request.getAttribute("searchterm");
                        out.print(searchTerm);%>"!</i></h3>
                    </div>
                <% }
            }

        %>

        <br>

        <div class="row">

            <!-- Ordre -->
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Seneste Ordre</h4>
                        <h6 class="text-muted card-subtitle mb-2 my-auto" style="display:inline-block">Her kan du se et udtag af de seneste ordre</h6>
                        <form method="post" action="FrontController" style="display:inline">
                            <input type="hidden" name="source" value="searchorders">
                            <input type="hidden" name="type" value="all">
                            <button class="btn btn-primary float-right" type="submit" style="display:inline-block;margin-top: 10px;">Se alle</button>
                        </form>
                    </div>
                    <div id="table-orders">
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
                            <tr>
                                <th scope="row">97</th>
                                <td>Jesper</td>
                                <td><span class="badge badge-secondary" style="height:20px;">I gang</span></td>
                                <td>13/5-2019</td>
                                <td><button class="btn btn-dark btn-xs" type="button"><span style="font-size:12px;">Se Ordre</span></button></td>
                            </tr>
                            <tr>
                                <th scope="row">96</th>
                                <td>Marcus</td>
                                <td><span class="badge badge-secondary" style="height:20px;">I gang</span></td>
                                <td>13/5-2019</td>
                                <td><button class="btn btn-dark btn-xs" type="button"><span style="font-size:12px;">Se Ordre</span></button></td>
                            </tr>
                            <tr>
                                <th scope="row">95</th>
                                <td>Per</td>
                                <td><span class="badge badge-success" style="height:20px;">Godkendt</span></td>
                                <td>13/5-2019</td>
                                <td><button class="btn btn-dark btn-xs" type="button"><span style="font-size:12px;">Se Ordre</span></button></td>
                            </tr>
                            <tr>
                                <th scope="row">94</th>
                                <td>Jon</td>
                                <td><span class="badge badge-danger" style="height:20px;">Afvist</span></td>
                                <td>13/5-2019</td>
                                <td><button class="btn btn-dark btn-xs" type="button"><span style="font-size:12px;">Se Ordre</span></button></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Kunder -->

            <%
                ArrayList<Customer> customerList = (ArrayList<Customer>) request.getAttribute("customers");
            %>

            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Nyeste kunder</h4>
                        <h6 class="text-muted card-subtitle mb-2 my-auto" style="display:inline-block">Her er de nyeste kunder</h6><button class="btn btn-primary float-right" type="button" style="display:inline-block;margin-top: 10px;">Se alle</button></div>

                    <div id="table-customers">
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

                                    if (customerList.size() > 0) {

                                        int start = customerList.size()-1;
                                        int stop = customerList.size()-4;

                                        for (int i = start; i >= stop; i=i-1) {

                                            out.println("<tr>\n" +
                                                    "<th scope=\"row\"> " + customerList.get(i).getCustomer_id() + "</th>\n" +
                                                    "<td> " + customerList.get(i).getName() + "</td>\n" +
                                                    "<td> " + customerList.get(i).getPhone() + "</td>\n" +
                                                    "<td> " + customerList.get(i).getCity() + "</td>\n" +
                                                    "<td><form method='post' action='FrontController' style='display:inline'><input type='hidden' name='source' value='search' /><button class='btn btn-dark btn-xs' type='submit' name='kunde' value='" + customerList.get(i).getCustomer_id() + "'><span style='font-size:12px;'>Se Kunde</span></button></form></td>\n" +
                                                    "</tr>");
                                        }
                                    } %>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../include/footer.jsp"%>