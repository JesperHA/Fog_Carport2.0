<%@include file="include/header.jsp"%>
<style>
    .clean-block.clean-form-danger form{
        border-top:2px solid #f35e5e !important;
        background-color:#fff !important;
        max-width:500px !important;
        margin:auto !important;
        padding:20px !important;
        box-shadow:0 2px 10px rgba(0,0,0,.075);
    }
</style>

<%
    // Redirect til brugerside hvis man er logget ind
    if (login != null) {
        request.getRequestDispatcher("FrontController?source=profil").forward(request,response);
    }
%>

    <main class="page login-page">
        <section class="clean-block clean-form dark">
            <div class="container" style="margin-top: 50px;">
                <div class="block-heading">
                    <h2 class="text-info">Log ind</h2>
                    <p>Velkommen til kundeportalen</p>
                </div>
                <form action="FrontController" method="post">
                    <input type="hidden" name="source" value="login"/>
                    <div class="form-group"><label for="email">Email</label><input class="form-control item" type="email" name="email" id="email"></div>
                    <div class="form-group"><label for="password">Adgangskode</label><input class="form-control" type="password" name="password" id="password"></div>
                    <button class="btn btn-primary btn-block" type="submit">Log ind</button>
                    <div class="block-heading" style="padding-top:25px; margin-bottom:0 !important;"><a href="registration.jsp" style="text-align:center;">Opret en bruger her</a></div>
                </form>
            </div>
        </section>
        <%
            String fail;
            fail = (String) request.getAttribute("fail");

            if (fail != null && fail.equals("failed")) { %>

        <section class="clean-block clean-form-danger dark" style="margin-top:-60px;text-align:center">
            <div class="container">
                <form>
                    <h6>Kombinationen af email og kodeord er forkert!</h6>
                    <small>Prøv igen!</small>
                </form>
            </div>
        </section>

        <%   }
        %>
    </main>

<%@include file="include/footer.jsp"%>