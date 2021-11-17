package com.example.cupcakedemoeksamen;

import business.entities.Bunde;
import business.entities.Cupcake;
import business.entities.Topping;
import business.exceptions.UserException;
import business.persistence.DBConnector;
import business.services.CupCakeUtil.Initializer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CheckoutServlet", value = "/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Checkout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Cupcake> cupcakeList = Cupcake.cupcakeList;

        String act = request.getParameter("orderAct");

        if(act.equals("addToBasket"))
        {
            Topping topping;
            Bunde bund;

            int antal = Integer.parseInt(request.getParameter("Antal"));

            String toppingNavn = request.getParameter("chooseTopping");

            String bundNavn = request.getParameter("chooseBund");

            bund = new Bunde(bundNavn);
            topping= new Topping(toppingNavn);

            Cupcake cupcake = new Cupcake(topping, bund);

            if(cupcakeList != null)
            {
                cupcakeList.add(cupcake);
                session.setAttribute("cupcakeList", cupcakeList);
            }
            if (cupcakeList == null)
            {
                cupcakeList = Cupcake.cupcakeList;
                cupcakeList.add(cupcake);
                session.setAttribute("cupcakeList", cupcakeList);
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    }



