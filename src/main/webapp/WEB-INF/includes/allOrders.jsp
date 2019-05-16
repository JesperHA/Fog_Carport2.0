<main class="page pricing-table-page">
    <h1 style="margin-bottom: 50px;margin-top: 120px;">Velkommen til admin panelet</h1>
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
        </div>
            <div class="row">
                <div class="col-md-12" style="margin-bottom: 30px;">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Alle ordre</h4>
                            <h6 class="text-muted card-subtitle mb-2">Nedenunder ses en komplet ordreliste</h6>
                            <div class="row" style="margin-top:35px;">
                                <div class="col mx-auto">
                                    <table id="myTable" class="table table-striped" >
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Kunde ID</th>
                                            <th>Længde</th>
                                            <th>Højde</th>
                                            <th>Bredde</th>
                                            <th>Tag</th>
                                            <th>Redskabsskur</th>
                                            <th>Redskabsskurtype</th>
                                            <th>Status</th>
                                            <th>Dato</th>
                                            <th>Handling</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>

                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td>Kunde ID</td>
                                            <td>Længde</td>
                                            <td>Højde</td>
                                            <td>Bredde</td>
                                            <td>Tag</td>
                                            <td>Redskabsskur</td>
                                            <td>Redskabsskurtype</td>
                                            <td>Status</td>
                                            <td>Dato</td>
                                            <td><button class="btn btn-sm btn-primary" type="button" name="orderid" value="0">Se Ordre</button></td>
                                        </tr>
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