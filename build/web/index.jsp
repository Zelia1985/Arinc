
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RWS Client</title>
        <style>
            td,th{
                text-align: center;
                 }
        </style>
        
    </head>
    
    <body>
        
        <h1>Данные из файла Arinc424</h1>
        
        <form action="DemoRS">
            
            <table border="1">
                
                <thead>
                    <tr>
                        <th>кол-во аэродромов</th>
                        <th>кол-во вертодромов</th>
                        <th>параметры аэродромов </th>
                        <th>параметры вертодромов </th>
                        <th>карта с маркерами аэропортов</th>
                    </tr>
                </thead>
                
                <tbody>
                    <tr>
                        <td>
                            <input type="submit" value="push" name="showSumAir" />
                        </td>
                        <td>
                            <input type="submit" value="push" name="showSumHel" />
                        </td>
                        <td>
                            <input type="submit" value="push" name="showAerodrom" />
                        </td>
                        <td>
                            <input type="submit" value="push" name="showHelidrom" />
                        </td>
                        <td>
                            <input type="submit" value="push" name="map" />
                        </td>
                    </tr>
                </tbody>
                
            </table>
            
        </form>
        
        <% Integer countAirport = (Integer) request.getAttribute("countAirport");
            if(countAirport!=null){%>
                <h1></h1>
                <h2> <th> Количество аэродромов из скрипта Arinc 424:  <%=countAirport %> </th></h2>  
            <% } %>
            
        <% Integer countHeliport = (Integer) request.getAttribute("countHeliport");
            if(countHeliport!=null){%>
                <h1></h1>
                <h2> <th> Количество вертодромов из скрипта Arinc 424:  <%=countHeliport %> </th></h2>  
            <% } %>      
            
        <% Integer count = (Integer) request.getAttribute("count");
            if(count!=null){%>
                <h1></h1>
                <h2> <th> Счетчик экземпляров класса:  <%=count%> </th></h2>  
            <% } %>   
        
    </body>
    
</html>
