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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBConnector dbConnector = new DBConnector();
        int topping = 0;
        int bund = 0;

        String topping_id = request.getParameter("chooseTopping");


        String bund_id = request.getParameter("chooseBund");


        try {
            topping = Integer.parseInt(topping_id);
        } catch (NumberFormatException e) {
            e.printStackTrace();

        }


        try {
            bund = Integer.parseInt(bund_id);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        List<String> toppingList = (List<String>) session.getAttribute("toppingList");
        if (toppingList == null) {
            toppingList = new ArrayList<>();

        }
        if (toppingList != null) {
            toppingList.clear();
        }
        String toppingName = Initializer.findToppingName(topping);
        toppingList.add(toppingName);

        List<String> bundeList = (List<String>) session.getAttribute("bundeList");
        if (bundeList == null) {
            bundeList = new ArrayList<>();
        }
        if (bundeList != null) {
            bundeList.clear();
        }
        String bundeName = Initializer.findBundeName(bund);
        bundeList.add(bundeName);

        List<Cupcake> cupcakeList = (List<Cupcake>) session.getAttribute("cupcakeList");
        if (cupcakeList == null) {
            cupcakeList = new ArrayList<>();
        }

        Cupcake cupcake = new Cupcake(bund, topping);
        cupcakeList.add(cupcake);

        session.setAttribute("bundeList", bundeList);
        session.setAttribute("toppingList", toppingList);
        session.setAttribute("cupcakeList", cupcakeList);


        request.getRequestDispatcher("/WEB-INF/Checkout.jsp").forward(request, response);
    }
}
