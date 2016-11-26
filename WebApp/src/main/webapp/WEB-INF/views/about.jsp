<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="shared/_header.jsp"/>
<c:import url="shared/_nav.jsp"/>

<div class="container" id="about-page">
    <section class="row">
        <div>
            <h1 class="title_1">${title_1}</h1>
            <p class="body_1">
                ${body_1}
            </p>
        </div>
    </section>

    <section class="row">
        <div>
            <h1 class="title_2">${title_2}</h1>
            <p class="body_2">
                ${body_2}
            </p>
        </div>
    </section>
    <section class="row">
        <div>
            <h1 class="title_3">${title_3}</h1>
            <p class="body_3">
                ${body_3}
            </p>
        </div>
    </section>
    <section class="row">
        <div>
            <h1 class="title_4">${title_4}</h1>
            <p class="body_4">
                ${body_4}
            </p>
            <div id="map"></div>

            <script type="text/javascript">
                $(function() {
                    // Handler for .ready() called.
                    var mapDiv = document.getElementById('map');
                    var googleMap = '<iframe width="600" height="450" frameborder="0" style="border:0" \
                src="https://www.google.com/maps/embed/v1/view?zoom=11&center=36.3487,-82.2107&key=${google_map_api_key}" \
                allowfullscreen></iframe>';
                    var fallbackMap = '<img src="resources/img/${map_image_name}" class="img-responsive">';

                    var useGoogleMap = "${use_google_map}";
                    if (useGoogleMap === "true") mapDiv.innerHTML += googleMap;
                    else mapDiv.innerHTML += fallbackMap;
                });
            </script>

        </div>
    </section>
</div><!--/.container-->

<c:import url="shared/_footer.jsp"/>