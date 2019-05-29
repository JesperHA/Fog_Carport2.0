<%@include file="include/header.jsp"%>

<%
    // Dette er så vi kan gemme en person's carport konfiguration i session, så hvis han går væk fra den midt i at lave den kan han gå tilbage og stadig lave videre på den.
    // Kriteriet er at han har trykket på bestil og har været på bestillings siden, tænker at bestillingssiden skal være den sidste man trykker på før man trykker på "Aflæg bestilling" - agtig.

    boolean sessionTrue = false;

    String sessionSize;
    String sessionShed;
    String sessionShedtype;
    String sessionLength;
    String sessionWidth;
    String sessionHeight;
    String sessionShedlength;
    String sessionShedwidth;
    String sessionRooftype;

    sessionSize = (String) session.getAttribute("sessionSize");
    sessionShed = (String) session.getAttribute("sessionShed");
    sessionShedtype = (String) session.getAttribute("sessionShedtype");
    sessionLength = (String) session.getAttribute("sessionLength");
    sessionWidth = (String) session.getAttribute("sessionWidth");
    sessionHeight = (String) session.getAttribute("sessionHeight");
    sessionShedlength = (String) session.getAttribute("sessionShedlength");
    sessionShedwidth = (String) session.getAttribute("sessionShedwidth");
    sessionRooftype = (String) session.getAttribute("sessionRooftype");

    if (sessionSize != null && sessionShed != null && sessionShedtype != null  && sessionLength != null  && sessionWidth != null  && sessionHeight != null  && sessionShedlength != null  && sessionShedwidth != null  && sessionRooftype != null) {
        sessionTrue = true;
    }
%>

    <main class="page contact-us-page"></main>
    <h1 style="margin-top: 120px;margin-bottom: 50px;">Byg din egen carport</h1>
    <div>
        <div class="container" style="margin-bottom: 50px;">
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body"><img id="PicturePreview" style="width:100%;height: 15vw;object-fit: cover;" src="assets\img\garager\enkelt.jpg"></div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card"></div>
                    <div class="card">
                        <div class="card-header">
                            <ul class="nav nav-tabs card-header-tabs" id="tabs" role="tablist">
                                <li class="nav-item"><a class="nav-link active" id="carport-tab" data-toggle="tab" href="#carport">Carport</a></li>
                                <li class="nav-item"><a class="nav-link" id="taget-tab" data-toggle="tab" href="#taget">Taget</a></li>
                                <li class="nav-item"><a class="nav-link" id="afslut-tab" data-toggle="tab" onclick="Confirm()" href="#afslut">Bekræftelse</a></li>
                            </ul>
                        </div>


                        <form action="FrontController" method="post">
                            <input type="hidden" name="source" value="bygcarport"/>

                            <input class="form-control" type="hidden" name="size" id="size" value="0" />
                            <input class="form-control" type="hidden" name="shed" id="shed" value="0" />
                            <input class="form-control" type="hidden" name="shedtype" id="shedtype" value="0" />
                            <input class="form-control" type="hidden" name="rooftype" id="rooftype" value="0" />

                            <div class="tab-content" id="tabContent">

                                <!-- Carport -->
                            <div class="card-body tab-pane fade show active" id="carport" role="tabpanel" aria-labelledby="carport-tab">
                                <label><b>Angiv størrelse på carport</b></label>
                                <div class="row" style="margin-bottom: 35px;">
                                    <div class="col-xl-6" style="min-height: 50px;"><button class="btn btn-primary" id="Enkeltknap" type="button" onclick="Enkelt()" style="min-width: 100%;">Enkelt</button></div>
                                    <div class="col"><button class="btn btn-primary" id="Dobbeltknap" type="button" onclick="Dobbelt()" style="min-width: 100%;">Dobbelt</button></div>
                                </div>

                                <label><b>Angiv om du ønsker skur.</b></label>
                                <div class="row" style="margin-bottom: 35px;">
                                    <div class="col-xl-6" style="min-height: 50px;">
                                        <button class="btn btn-primary" id="Medskurknap" type="button" onclick="MedSkur()" style="min-width: 100%;">Med skur</button>
                                    </div>
                                    <div class="col">
                                        <button class="btn btn-primary" id="Udenskurknap" type="button" onclick="UdenSkur()" style="min-width: 100%;">Uden skur</button>
                                    </div>
                                </div>

                                <div id="skurCover" style="display:none">
                                    <label><b>Vælg skurbeklædning</b></label>
                                    <div class="row" style="margin-bottom: 35px;">
                                        <div class="col-xl-6" style="min-height: 50px;">
                                            <button class="btn btn-primary" id="EnPåToKnap" onclick="EnPåTo()" type="button" style="min-width: 100%;">En på to</button>
                                        </div>
                                        <div class="col">
                                            <button class="btn btn-primary" id="KlinkKnap" onclick="Klink()" type="button" style="min-width: 100%;">Klinkbeklædning</button>
                                        </div>
                                    </div>
                                </div>




                                <label><b>Angiv mål på carport</b></label>
                                <div class="row">
                                    <div class="col"><label>Længde (cm):</label><input class="form-control" name="length" id="length" type="text" style="min-width: 100%;margin-bottom: 15px;"></div>
                                </div>
                                <div class="row" style="margin-bottom: 15px;">
                                    <div class="col"><label>Bredde (cm):</label><input class="form-control" name="width" id="width" type="text" style="min-width: 100%;"></div>
                                </div>
                                <div class="row" style="margin-bottom: 15px;">
                                    <div class="col"><label>Højde (cm):</label><input class="form-control" name="height" id="height" type="text" style="min-width: 100%;"></div>
                                </div>


                                <div id="skurCM" style="display:none">
                                    <label><b>Angiv mål på skur</b></label>
                                    <div class="row">
                                        <div class="col"><label>Længde (cm):</label>
                                            <input class="form-control" value="0" name="shed_length" type="text" style="min-width: 100%;margin-bottom: 15px;">
                                        </div>
                                    </div>
                                    <div class="row" style="margin-bottom: 15px;">
                                        <div class="col"><label>Bredde (cm):</label>
                                            <input class="form-control" value="0" name="shed_width" id="shed_width" type="text" style="min-width: 100%;">
                                        </div>
                                    </div>
                                </div>

                                <button class="btn btn-primary" type="button" style="float: right;" onclick="getElementById('taget-tab').click()">Næste</button>
                                <br>
                            </div>




                            <!-- Taget -->
                            <div class="card-body tab-pane fade" id="taget" role="tabpanel" aria-labelledby="taget-tab">
                                <label><b>Angiv tagets type</b></label>
                                <div class="row" style="margin-bottom: 35px;">
                                    <div class="col-xl-6" style="min-height: 50px;">
                                        <button class="btn btn-primary" id="medrejsning" onclick="medRejsning()" type="button"  style="min-width: 100%;">m/Rejsning</button>
                                    </div>
                                    <div class="col">
                                        <button class="btn btn-primary" id="udenrejsning" onclick="udenRejsning()" type="button"  style="min-width: 100%;">u/Rejsning</button>
                                    </div>
                                </div>
                                <div class="row" style="margin-bottom: 20px">
                                    <div class="col-md-12">
                                        <select name="roofsort" id="roofsort" class="form-control">
                                            <option selected disabled>Vælg tagtype</option>
                                            <option value="1">Trapezplader</option>
                                            <option value="2">Eternit</option>
                                            <option value="3">Tagpap</option>
                                        </select>
                                    </div>
                                </div>
                                <button class="btn btn-light" type="button" style="float: left;" onclick="getElementById('carport-tab').click()">Tilbage</button>
                                <button class="btn btn-primary" type="button" style="float: right;" onclick="getElementById('afslut-tab').click()">Næste</button>
                                <br>
                            </div>

                            <!-- Afslut -->
                            <div class="card-body tab-pane fade" id="afslut" role="tabpanel" aria-labelledby="afslut-tab">
                                <label><b>Du har valgt følgende</b></label>
                                    <div class="row" style="margin-bottom: 15px;">
                                        <div class="col"><label>Størrelse: &nbsp;</label><label id="getStorrelse"> </label>
                                    </div>
                                </div>

                                <div class="row" style="margin-bottom: 15px;">
                                        <div class="col"><label>Skur: &nbsp;</label><label id="getSkur"> </label>
                                        </div>
                                </div>

                                <div id="displaySkurStatus" style="margin-bottom: 35px;display:none">
                                    <label style="color:red" id="getSkurStatus"></label>

                                        <div class="row">
                                            <div class="col-xl-6" style="min-height: 50px;">
                                                <button class="btn btn-primary" type="button"  style="min-width: 100%;">Højre side</button>
                                            </div>
                                            <div class="col">
                                                <button class="btn btn-primary" type="button"  style="min-width: 100%;">Venstre side</button>
                                            </div>
                                        </div>
                                </div>

                                <label><b>Carport Mål</b></label>
                                <div class="row" style="margin-bottom: 15px;">
                                    <div class="col"><label>Længde (cm): &nbsp;</label><label id="getLength"></label>

                                    </div>
                                </div>
                                <div class="row" style="margin-bottom: 15px;">
                                    <div class="col"><label>Bredde (cm): &nbsp;</label><label id="getWidth"></label>

                                    </div>
                                </div>
                                <div class="row" style="margin-bottom: 15px;">
                                    <div class="col"><label>Højde (cm): &nbsp;</label><label id="getHeight"></label>

                                    </div>
                                </div>




                                <label><b>Carport Tag</b></label>
                                <div class="row" style="margin-bottom: 15px;">
                                    <div class="col"><label>Rejsning: &nbsp;</label><label id="getTaget"> </label>
                                    </div>
                                </div>
                                <div class="row" style="margin-bottom: 15px;">
                                    <div class="col"><label>Tagtype: &nbsp;</label><label id="getRoofsort"></label>
                                    </div>
                                </div>

                                <button class="btn btn-light" type="button" style="float: left;" onclick="getElementById('taget-tab').click()">Tilbage</button>
                                <button class="btn btn-success" type="submit" style="float: right;">Bestil</button>
                                <br>
                            </div>

                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<script>
    var variableEnkelt = 0;
    var variableDobbelt = 0;
    var variableSkur = 0;
    var variableEnPåTo = 0;
    var variableKlink = 0;
    var variableMedrejsning = 0;
    var variableUdenrejsning = 0;



    function Enkelt() {
        document.getElementById('Enkeltknap').style.backgroundColor = "#074180";
        document.getElementById('Dobbeltknap').style.backgroundColor = "#007bff";

        document.getElementById('Medskurknap').style.backgroundColor = "#007bff";
        document.getElementById('Udenskurknap').style.backgroundColor = "#007bff";
        if (variableDobbelt == 1){
            variableDobbelt = 0;
            variableEnkelt = 1;
        }else{
            variableEnkelt = 1;
        }
        document.getElementById('size').value = "0";
        document.getElementById('PicturePreview').src = "assets/img/garager/enkelt.jpg";
    }

    function Dobbelt() {
        document.getElementById('Enkeltknap').style.backgroundColor = "#007bff";
        document.getElementById('Dobbeltknap').style.backgroundColor = "#074180";

        document.getElementById('Medskurknap').style.backgroundColor = "#007bff";
        document.getElementById('Udenskurknap').style.backgroundColor = "#007bff";


        if(variableEnkelt == 1){
            variableEnkelt = 0;
            variableDobbelt = 1;
        }else{
            variableDobbelt = 1;
        }
        document.getElementById('size').value = "1";
        document.getElementById('PicturePreview').src = "assets/img/garager/dobbelt.jpg";
    }

    function MedSkur() {

        document.getElementById("skurCover").style.display = "block";
        document.getElementById("skurCM").style.display = "block";

        document.getElementById('Medskurknap').style.backgroundColor = "#074180";
        document.getElementById('Udenskurknap').style.backgroundColor = "#007bff";

        if(variableEnkelt == 1){
            variableSkur = 1;
            document.getElementById('PicturePreview').src = "assets/img/garager/enkeltmskur.jpg";
        }else{
            variableSkur = 1;
            document.getElementById('PicturePreview').src = "assets/img/garager/dobbeltmskur.jpg";
        }
        document.getElementById('shed').value = "1";
    }

    function UdenSkur() {

        document.getElementById("skurCover").style.display = "none";
        document.getElementById("skurCM").style.display = "none";

        document.getElementById('Medskurknap').style.backgroundColor = "#007bff";
        document.getElementById('Udenskurknap').style.backgroundColor = "#074180";
        if(variableEnkelt == 1){
            variableSkur = 0;
            document.getElementById('PicturePreview').src = "assets/img/garager/enkelt.jpg";
        }else{
            document.getElementById('PicturePreview').src = "assets/img/garager/dobbelt.jpg";
        }
        document.getElementById('shed').value = "0";
    }

    function EnPåTo() {
        document.getElementById('EnPåToKnap').style.backgroundColor = "#074180";
        document.getElementById('KlinkKnap').style.backgroundColor = "#007bff";
        if (variableEnPåTo == 1){
            variableKlink = 0;
            variableEnPåTo = 1;
        }else{
            variableKlink = 1;
        }
        document.getElementById('shedtype').value = "1";

    }

    function Klink() {
        document.getElementById('EnPåToKnap').style.backgroundColor = "#007bff";
        document.getElementById('KlinkKnap').style.backgroundColor = "#074180";
        if (variableKlink == 1){
            variableEnPåTo = 0;
            variableKlink = 1;
        }else{
            variableEnPåTo = 1;
        }
        document.getElementById('shedtype').value = "2";

    }

    function medRejsning(){
        document.getElementById('udenrejsning').style.backgroundColor = "#007bff";
        document.getElementById('medrejsning').style.backgroundColor = "#074180";
        if(variableUdenrejsning == 1) {
            variableUdenrejsning = 0;
            variableMedrejsning = 1;
        }else {
            variableMedrejsning = 1;
        }
        document.getElementById('rooftype').value = "1";
    }

    function udenRejsning(){
        document.getElementById('medrejsning').style.backgroundColor = "#007bff";
        document.getElementById('udenrejsning').style.backgroundColor = "#074180";
        if(variableMedrejsning == 1) {
            variableMedrejsning = 0;
            variableUdenrejsning = 1;
        }else {
            variableUdenrejsning = 1;
        }
        document.getElementById('rooftype').value = "0";
    }

    function Confirm() {
        if(variableDobbelt == 1){
            document.getElementById("getStorrelse").innerHTML = "Dobbelt";
        }else{
            document.getElementById("getStorrelse").innerHTML = "Enkelt";
        }

        if(variableSkur == 1){

            var getSkurWidth = document.getElementById("shed_width").value;
            var getCarportWidth = document.getElementById("width").value;

            if(getSkurWidth < getCarportWidth){
                document.getElementById("getSkurStatus").innerHTML = "Dit skur er mindre end din Carport. Vælg venligst side.";
                document.getElementById("displaySkurStatus").style.display = "block";
            }

            document.getElementById("getSkur").innerHTML = "Ja";

        }else{
            document.getElementById("getSkur").innerHTML = "Nej";
        }



        if(variableMedrejsning == 1){
            document.getElementById("getTaget").innerHTML = "Ja";
        }else{
            document.getElementById("getTaget").innerHTML = "Nej";
        }
        document.getElementById("getWidth").innerHTML = document.getElementById("width").value;
        document.getElementById("getHeight").innerHTML = document.getElementById("height").value;
        document.getElementById("getLength").innerHTML = document.getElementById("length").value;

        var getDropdown = document.getElementById("roofsort");
        var getDropdown_value = getDropdown.options[getDropdown.selectedIndex].innerHTML;
        document.getElementById("getRoofsort").innerHTML = getDropdown_value;
    }


</script>

<%@include file="include/footer.jsp"%>