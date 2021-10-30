/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fragment, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import rws.ReturnData;
import static rws.ReturnData.fileName;


/**
 *
 * @author valdai
 */
@WebServlet(name = "DemoRS", urlPatterns = {"/DemoRS"})
public class DemoRS extends HttpServlet {
    
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Client client = ClientBuilder.newClient();
        
        String showSumAir = request.getParameter("showSumAir");
        String showSumHel = request.getParameter("showSumHel");
        String showAerodrom = request.getParameter("showAerodrom");
        String showHelidrom = request.getParameter("showHelidrom");
        String map = request.getParameter("map");
        
        ReturnData rd = client.target("http://localhost:8080/J210Lab3RS/webresources/dir/").request()
        .get(ReturnData.class);
    
        ArrayList <String> airportInfo = new ArrayList<>();
        airportInfo = rd.getAirport();
        ArrayList <String> heliportInfo = new ArrayList<>();
        heliportInfo = rd.getHeliport();
        ArrayList <String> coordinat = new ArrayList<>();
        coordinat = rd.getCoordinat();

        int countAirport = 0;
        int count = rd.getCount();

        countAirport = rd.getCountAirport();
    
     
       
        if(showSumAir!=null){
            request.setAttribute("countAirport", countAirport);
            request.setAttribute("count", count);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        int countHeliport;
        countHeliport = rd.getCountHeliport();
        if(showSumHel!=null){
            request.setAttribute("countHeliport", countHeliport);
            request.setAttribute("count", count);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DemoRS</title>");            
            out.println("</head>");
            out.println("<body>");

            if(showAerodrom!=null){
                for(int i = 0 ; i < airportInfo.size();i++){
                    out.println("<li>" + airportInfo.get(i) + "</li>");    
                }
            }

            if(showHelidrom!=null){
                for(int i = 0 ; i < heliportInfo.size();i++){
                    out.println("<li>" + heliportInfo.get(i) + "</li>");    
                }
            }
            
            if(map!=null){
                request.setAttribute("coordinat", coordinat);
                request.getRequestDispatcher("map2.jsp").forward(request, response);                 
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
