package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.jsp_servlet_jdbc.dao.ClienteDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.ClienteDAOImpl;
import org.iesvdm.jsp_servlet_jdbc.model.Cliente;


import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListadoClientesServlet", value = "/ListadoClientesServlet")
public class ListadoClientesServlet extends HttpServlet {

    private ClienteDAO clienteDAO = new ClienteDAOImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listarClientes.jsp");

        List<Cliente> listado = this.clienteDAO.getAll();
        request.setAttribute("clientes", listado);

        dispatcher.forward(request, response);
    }
}