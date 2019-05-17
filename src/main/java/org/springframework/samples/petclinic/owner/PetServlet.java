package org.springframework.samples.petclinic.owner;

import com.petclinic.springpetclinicsoap.gen.GetOwnerPetsResponse;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
    name = "PetServlet",
    description = "This is a Web service client act as proxy",
    urlPatterns = {"/getPetsByOwner"}
)
public class PetServlet extends HttpServlet {
    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        int ownerId = Integer.parseInt(request.getParameter("ownerId"));

        PetBO petBO=new PetBO();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Owner has "+petBO.invokeWebService(ownerId)+" number of Pets</p>");
    }

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
