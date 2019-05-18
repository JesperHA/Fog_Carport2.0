<%@ page import="Model.Customer" %>
<%@ page import="java.util.ArrayList" %>

<%

    Customer customer = (Customer) session.getAttribute("login");

%>

<%@include file="../include/header.jsp"%>



    <main class="page pricing-table-page">
        <h1 style="margin-bottom: 50px;margin-top: 120px;">Velkommen <%out.println(customer.getName());%>!</h1>
    </main>
    <div>
        <div class="container" style="margin-bottom: 50px;">
            <div class="row">
                <div class="col-md-12" style="margin-bottom: 30px;">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Konto</h4>
                            <h6 class="text-muted card-subtitle mb-2">Her kan du se dine kontooplysninger</h6>
                            <hr>
                            <div class="row">
                                <div class="col"><label class="col-form-label"><b>Kundenummer: </b><%out.println(customer.getCustomer_id());%></label></div>
                            </div>
                            <div class="row">
                                <div class="col"><label class="col-form-label"><b>Navn: </b><%out.println(customer.getName());%></label></div>
                            </div>
                            <div class="row">
                                <div class="col"><label class="col-form-label"><b>Email: </b><%out.println(customer.getEmail());%></label></div>
                            </div>
                            <div class="row">
                                <div class="col"><label class="col-form-label"><b>Telefon: </b><%out.println(customer.getPhone());%></label></div>
                            </div>
                            <div class="row">
                                <div class="col"><label class="col-form-label"><b>Adresse: </b><%out.println(customer.getAdress()); %> - <%out.println(customer.getZipcode());%> - <%out.println(customer.getCity());%></label></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Din Carport</h4>
                            <h6 class="text-muted card-subtitle mb-2">Her kan du se dit nuværende Carport projekt</h6><button class="btn btn-primary" type="button" ahref="bygcarport.jsp" style="margin-top: 10px;">Klik her</button></div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Dine ordrer</h4>
                            <h6 class="text-muted card-subtitle mb-2">Her kan du se dine ordrer.</h6>
                        <form method="post" action="FrontController" style="display:inline">
                            <input type="hidden" name="source" value="searchorders">
                            <input type="hidden" name="type" value="all">
                            <button class="btn btn-primary" type="submit" style="margin-top: 10px;">Klik her</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@include file="../include/footer.jsp"%>