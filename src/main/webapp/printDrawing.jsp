<%@include file="include/header.jsp"%>
    <main class="page login-page">
        <section class="clean-block clean-form dark">
            <div class="container" style="margin-top: 50px;">
                <div class="block-heading">
                    <h2 class="text-info">SVG tegning</h2>
                    <p>Vi har genereret din plantegningen for dig</p>
                </div>

                <%
                    String svgString = "0";

                    svgString = (String) session.getAttribute("svg");

                    if (!svgString.equals("0")) {
                        out.println(svgString);
                    }
                %>
            </div>
        </section>
    </main>

<%@include file="include/footer.jsp"%>
