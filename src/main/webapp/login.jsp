<%@include file="include/header.jsp"%>
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
                    <div class="form-group"><label for="password">Adgangskode</label><input class="form-control" type="password" name="password" id="password"></div><button class="btn btn-primary btn-block" type="submit">Log ind</button>
                    <div class="block-heading" style="padding-top:25px; margin-bottom:0 !important;"><a href="registration.jsp" style="text-align:center;">Opret en bruger her</a></div>
                </form>
            </div>
        </section>
    </main>

<%@include file="include/footer.jsp"%>
