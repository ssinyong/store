package org.example.store;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.example.store.common.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/cart")
@Log4j2
public class CartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mnostr = req.getParameter("mno");

        Integer mno = StringUtil.getInt(mnostr,-1);

        HttpSession session = req.getSession();

        Object wanted = session.getAttribute("wanted");
        if (wanted == null) {
            List<Integer> wantednew = new ArrayList<>();
            wantednew.add(mno);
            session.setAttribute("wanted", wantednew);
        } else {
            List<Integer> wantedold = (List<Integer>) session.getAttribute("wanted");
            wantedold.add(mno);
            session.setAttribute("wanted", wantedold);
        }
        resp.sendRedirect("/cartpage");
    }
}