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
                        <h4 class="card-title">Kundens Information</b></h4>
                        <h6 class="text-muted card-subtitle mb-2 my-auto" style="display:inline-block">Her kan du se kundens informationer</h6>
                    </div>
                    <div class="col-6" style="float: right;">
                        <h4 class="card-title">Alle ordre for kunden</b></h4>
                        <h6 class="text-muted card-subtitle mb-2 my-auto" style="display:inline-block">Her kan du se kundens ordre</h6>
                    </div>
                </div>
            </div>
            <div class="row">

            <div class="col-md-6" id="customer-info">
                <b>Kunde: </b> <% out.print(foundCustomer.getName()); %> <br>
                <b>Email: </b> <% out.print(foundCustomer.getEmail()); %> <br>
                <b>Addresse: </b> <% out.println(foundCustomer.getAdress()); %> - <%out.println(foundCustomer.getZipcode());%> - <%out.println(foundCustomer.getCity());%> <br>
                <b>Tlf.: </b> <% out.print(foundCustomer.getPhone()); %> <br>
                <b>Rolle: </b><% if (foundCustomer.getRole() > 0) { out.print("Medarbejder"); } else { out.print("Kunde"); } %>
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
                        <tr>
                            <th scope="row">97</th>
                            <td>Jesper</td>
                            <td><span class="badge badge-secondary" style="height:20px;">I gang</span></td>
                            <td>13/5-2019</td>
                            <td><button class="btn btn-dark btn-xs" type="button"><span style="font-size:12px;">Se Ordre</span></button></td>
                        </tr>
                        <tr>
                            <th scope="row">96</th>
                            <td>Jesper</td>
                            <td><span class="badge badge-secondary" style="height:20px;">I gang</span></td>
                            <td>13/5-2019</td>
                            <td><button class="btn btn-dark btn-xs" type="button"><span style="font-size:12px;">Se Ordre</span></button></td>
                        </tr>
                        <tr>
                            <th scope="row">95</th>
                            <td>Jesper</td>
                            <td><span class="badge badge-success" style="height:20px;">Godkendt</span></td>
                            <td>13/5-2019</td>
                            <td><button class="btn btn-dark btn-xs" type="button"><span style="font-size:12px;">Se Ordre</span></button></td>
                        </tr>
                        <tr>
                            <th scope="row">94</th>
                            <td>Jesper</td>
                            <td><span class="badge badge-danger" style="height:20px;">Afvist</span></td>
                            <td>13/5-2019</td>
                            <td><button class="btn btn-dark btn-xs" type="button"><span style="font-size:12px;">Se Ordre</span></button></td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>