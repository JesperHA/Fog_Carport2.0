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
                                        <input type="hidden" name="source" value="adminSearch" />
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="search" placeholder="søg vh.a. kundens id eller kundens mail" autocomplete="off" required>
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
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Seneste Ordre</h4>
                            <h6 class="text-muted card-subtitle mb-2 my-auto" style="display:inline-block">Her kan du se et udtag af de seneste ordre</h6><button class="btn btn-primary float-right" type="button" style="display:inline-block;margin-top: 10px;">Se alle</button></div>

                        <div style="margin:auto;width:100%;">
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