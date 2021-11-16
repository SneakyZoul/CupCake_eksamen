package web.filter;

import business.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();

        //TODO: Lav en if der checker om email og password er i databasen. Hvis den finder et match,
        // så fører den bare brugeren videre
        // pseudo kode:
        // for (User u: DB.GetAllUsers())
        // {
        //  if(userEmail == u.getEmail() && userPassword == u.getPassword())
        //  {
        //      Du er logget ind! Top dollar!
        //   }
        // }

        //Basically skønne drenge, den her servlet er den der dealer med al trafik på indexSiden.
        //Hvis en bruger trykker på kurv, kunde info, odrer osv. Så går det gennem her
        // Hvis det ikke giver mening, så skrot det :P


        request.getRequestDispatcher("/WEB-INF/kunde.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        request.getRequestDispatcher("/webapp/index.jsp").forward(request,response);
    }
}
