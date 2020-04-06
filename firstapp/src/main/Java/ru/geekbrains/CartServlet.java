package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Order;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class CartServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(CartServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New Get request /cart");
        ProductList productList = new ProductList();
        List<Order> orders = new ArrayList<>();
        String name = req.getParameter("id");
        double num = Double.parseDouble(req.getParameter("num"));
        for (Product prod : productList.getProducts()) {
            if(prod.getName().equals(name)) {
                orders.add(new Order(name, prod.getPrice(), num));
            }
        }
        req.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").include(req, resp);
    }
}
