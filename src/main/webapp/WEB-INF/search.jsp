<div class="row">

    <!-- Ordre -->
    <div class="col-md-12">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Alle ordre for kunden <b><% out.println(foundCustomer.getName()); %></b></h4>
                <h6 class="text-muted card-subtitle mb-2 my-auto" style="display:inline-block">Her kan du se kundens ordre</h6><button class="btn btn-primary float-right" type="button" style="display:inline-block;margin-top: 10px;">Se alle</button></div>

            <div id="table-found">
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