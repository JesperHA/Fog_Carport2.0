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
    #table-in-card {
        margin: auto;
        width: 100%;
        padding: 20px;
    }
    #godkend-button {
        background: none!important;
        border: none!important;
    }
    #godkend-button:hover {
        color: #4e555b;
        text-decoration: underline;
        transition: all 0.7s;
    }
    #godkend-button:after {
        color: #000000;
        text-decoration: none;
        transition: all 0.7s;
    }
</style>

<%@ page import="Model.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<Customer> customerList = (ArrayList<Customer>) request.getAttribute("customerlist");
%>
<main class="page pricing-table-page">
    <h1 style="margin-bottom: 50px;margin-top: 120px;">Velkommen til admin panelet</h1>
</main>
<div>
    <div class="container" style="margin-bottom: 50px;">
        <div class="row">
            <div class="col-md-12" style="margin-bottom: 30px;">
                <div class="card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Adgang</h4>
                            <h6 class="text-muted card-subtitle mb-2">Du har adgang til administrator funktionerne for brugeren <%out.println("<i>" + login.getEmail() + "</i>");%></h6>
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
        </div>

            <div class="row">
                <div class="col-md-12" style="margin-bottom: 30px;">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Alle kunder</h4>
                            <h6 class="text-muted card-subtitle mb-2">Nedenunder ses en komplet liste af kunder</h6>
                            <div class="row" style="margin-top:35px;">
                                <div class="col mx-auto">
                                    <table id="myTable" class="table table-striped" >
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Navn</th>
                                            <th>Email</th>
                                            <th>Tlf</th>
                                            <th>Adresse</th>
                                            <th>Post Nr</th>
                                            <th>By</th>
                                            <th>Rolle</th>
                                            <th>Handling</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            if (customerList != null) {
                                                int listSize = customerList.size() - 1;

                                                for (int i = listSize; i >= 0; i--) {

                                                    String currentRole = "";

                                                    if (customerList.get(i).getRole() > 0) {
                                                        currentRole = "Medarbejder";
                                                    } else {
                                                        currentRole = "Kunde"; }

                                                    out.print(
                                                                    "<tr>" +
                                                                    "<td>" + customerList.get(i).getCustomer_id() + "</td>\n" +
                                                                    "<td>" + customerList.get(i).getName() + "</td>\n" +
                                                                    "<td>" + customerList.get(i).getEmail() + "</td>\n" +
                                                                    "<td>" + customerList.get(i).getPhone() + "</td>\n" +
                                                                    "<td>" + customerList.get(i).getAdress() + "</td>\n" +
                                                                    "<td>" + customerList.get(i).getZipcode() + "</td>\n" +
                                                                    "<td>" + customerList.get(i).getCity() + "</td>\n" +
                                                                    "<td>" + currentRole + "</td>\n" +
                                                                    "<td><form method='post' action='FrontController' style='display:inline'><input type='hidden' name='source' value='search' /><input type='hidden' name='type' value='single' /><button class=\"btn btn-sm btn-primary\" type=\"submit\" name=\"kunde\" value='" + customerList.get(i).getCustomer_id() + "' style='min-width: 84px;'>Se kunde</button></form></td>" +
                                                                    "</tr>"
                                                    );
                                                }
                                            } else {
                                                out.print(
                                                        "<tr>" +
                                                                "<td> Ingen </td>\n" +
                                                                "<td> Kunder </td>\n" +
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

<%@include file="../include/footer.jsp"%>