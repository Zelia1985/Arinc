
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    
    <body>
        
        <h1>map with markers</h1>
        
        <div id="map" style="height: 800px; width: 1500px;"></div>
        
        <!-- jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        
        <!-- Leaflet -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.6.0/leaflet.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.6.0/leaflet.js"></script>

        <script>
            var map = L.map('map').setView([-16.50629, -68.12703], 2);
            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
            subdomains: ['a','b','c']}).addTo(map);

            <% List <String> coordinat = (List<String>) request.getAttribute("coordinat"); %>
            <% for(int i = 0 ; i < coordinat.size();i++){ %>      
                   L.marker( [ <%=coordinat.get(i)%>] ).addTo(map);
             <%}%>       
        </script>
        
    </body>
    
</html>
