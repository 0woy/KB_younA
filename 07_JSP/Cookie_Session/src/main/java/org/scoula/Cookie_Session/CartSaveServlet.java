package org.scoula.Cookie_Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_save")
public class CartSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        // get input parameter
        String product = req.getParameter("product");

        // get session Instance
        HttpSession session = req.getSession();
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");

        if (list == null) {
            list = new ArrayList<>();
            session.setAttribute("product", list);
        }

        // it can add null value (before exception handle)
        if(product != null){
            list.add(product);
        }

        out.print("<html><body>");
        out.print("Product 추가! <br>");
        out.print("<a href='session_product.jsp'> 상품 선택 페이지</a><br>");
        out.print("<a href='cart_view'>장바구니 보기</a>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req, resp);
    }
}
