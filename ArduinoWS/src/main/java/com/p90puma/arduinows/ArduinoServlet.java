/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p90puma.arduinows;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sjakubowski
 */
public class ArduinoServlet extends HttpServlet {

    private ArduinoWS ws = new ArduinoWS();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<h2>Servlet ArduinoServlet at " + request.getContextPath() + "</h2>");

            //TODO do all the other webservices

            String msg = request.getParameter("serial");
            
            if (msg == null) {
                out.println("<br/>");
                out.println("No serial input found, use ?serial=YOURINPUTHERE");

            } else {

                String result = ws.sendSerialInput(msg);

                out.println("<br/>");
                out.println("Result:");
                out.println(result);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            out.println(e.toString());
        } finally {
            out.close();
        }
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    @Override
    public String getServletInfo() {
        return "Arduino Servlet";
    }
}
