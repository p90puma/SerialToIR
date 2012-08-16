/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p90puma.arduinows;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author sjakubowski
 */
//@WebServlet(name = "ArduinoServlet", urlPatterns = {"/ArduinoServlet"})
public class ArduinoServlet extends HttpServlet {

//    @Inject
//    ArduinoWS ws;
    @Resource
    protected WebServiceContext context;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<h2>Servlet ArduinoServlet at " + request.getContextPath() + "</h2>");



            String i = request.getParameter("arduino_msg");

            String result = "hello";// ws.sendSerialInput(i);



            out.println("<br/>");
            out.println("Result:");
            out.println(result);

        } catch (Exception e) {
            System.out.println(e.toString());
            out.println(e.toString());
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        return "Short description";
    }
    // </editor-fold>
}
