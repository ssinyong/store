package org.example.store;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.example.store.dao.GoodsDAO;
import org.example.store.vo.GoodsVO;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/cartpage")
@Log4j2
public class CartPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session.getAttribute("wanted") != null) {

            List<Integer> wantedList = (List<Integer>) session.getAttribute("wanted");

            try {
                List<GoodsVO> wantedGoods = GoodsDAO.INSTANCE.getWantedList(wantedList);

                req.setAttribute("wantedGoods", wantedGoods);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        req.getRequestDispatcher("/WEB-INF/cartpage.jsp").forward(req, resp);
    }
}
