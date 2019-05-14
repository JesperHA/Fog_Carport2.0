<%@ page import="Model.Customer" %>
<%@ page import="java.util.ArrayList" %>

<%

    ArrayList<Customer> customer = (ArrayList<Customer>) session.getAttribute("login");

%>

<%@include file="../include/header.jsp"%>



    <main class="page pricing-table-page">
        <h1 style="margin-bottom: 50px;margin-top: 120px;">Velkommen <%out.println(customer.get(0).getName());%>!</h1>
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
                                <div class="col"><label class="col-form-label"><b>Kundenummer: </b><%out.println(customer.get(0).getCustomer_id());%></label></div>
                            </div>
                            <div class="row">
                                <div class="col"><label class="col-form-label"><b>Navn: </b><%out.println(customer.get(0).getName());%></label></div>
                            </div>
                            <div class="row">
                                <div class="col"><label class="col-form-label"><b>Email: </b><%out.println(customer.get(0).getEmail());%></label></div>
                            </div>
                            <div class="row">
                                <div class="col"><label class="col-form-label"><b>Telefon: </b><%out.println(customer.get(0).getPhone());%></label></div>
                            </div>
                            <div class="row">
                                <div class="col"><label class="col-form-label"><b>Adresse: </b><%out.println(customer.get(0).getAdress()); %> - <%out.println(customer.get(0).getZipcode());%> - <%out.println(customer.get(0).getCity());%></label></div>
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
                            <h6 class="text-muted card-subtitle mb-2">Her kan du se dit nuværende Carport projekt</h6><button class="btn btn-primary" type="button" style="margin-top: 10px;">Klik her</button></div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Dine ordrer</h4>
                            <h6 class="text-muted card-subtitle mb-2">Her kan du se dine ordrer.</h6><button class="btn btn-primary" type="button" style="margin-top: 10px;">Klik her</button></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@include file="../include/footer.jsp"%>