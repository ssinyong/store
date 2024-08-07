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

@WebServlet(value = "/goods")
@Log4j2
public class GoodsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String anoStr = req.getParameter("ano");
        String cnoStr = req.getParameter("cno");

        Integer ano = StringUtil.getInt(anoStr, 1);
        int cno = StringUtil.getInt(cnoStr, 1);


        try {

            log.info("ano :" + ano);
            log.info("cno :" + cno);

            List<GoodsVO> GoodsVOArrayList = GoodsDAO.INSTANCE.list(ano, cno);

            req.setAttribute("goodslist", GoodsVOArrayList);
            req.getRequestDispatcher("/WEB-INF/goods.jsp").forward(req, resp);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}