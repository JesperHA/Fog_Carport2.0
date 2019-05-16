<%@ page import="Model.Customer" %>
<%@ page import="java.util.ArrayList" %>

<%

    ArrayList<Customer> customer = (ArrayList<Customer>) session.getAttribute("login");

    Customer foundCustomer = (Customer) request.getAttribute("foundCustomer");

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
    #table-in-card {
        margin:auto;
        width:100%;
        padding: 20px;
    }
</style>

<%@include file="includes/allOrders.jsp"%>

<%@include file="../include/footer.jsp"%>