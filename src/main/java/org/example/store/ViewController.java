package org.example.store;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.example.store.common.StringUtil;
import org.example.store.dao.GoodsDAO;
import org.example.store.vo.GoodsVO;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/view")
@Log4j2
public class ViewController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mnoStr = req.getParameter("mno");

        Integer mno = StringUtil.getInt(mnoStr, 1);


        try {
            log.info("mno :" + mno);

            GoodsVO vo = GoodsDAO.INSTANCE.select(mno);

            req.setAttribute("goods",vo);
            req.getRequestDispatcher("/WEB-INF/view.jsp").forward(req, resp);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}