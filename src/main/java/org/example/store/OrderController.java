package org.example.store;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.example.store.common.StringUtil;
import org.example.store.dao.OrderDAO;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/order")
@Log4j2
public class OrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



//        Integer[] goodsmnos = {3,4,5};



        // 주문 정보 가져오기
        String[] mnosString = req.getParameterValues("mnos"); // 파라미터로부터 상품 번호를 문자열 배열로 가져오기

        // Stream API를 사용하여 문자열 배열을 Integer 배열로 변환
        Integer[] goodsmnos = Arrays.stream(mnosString)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);



        try {
            OrderDAO.INSTANCE.insertOrder(goodsmnos);
        } catch (Exception e) {
           e.printStackTrace();
        }

        // 세션 무효화 또는 특정 속성 제거
        HttpSession session = req.getSession();
        session.invalidate(); // 전체 세션을 무효화

        // 주문 완료 페이지로 리다이렉트
        req.getRequestDispatcher("/WEB-INF/orderconfirmation.jsp").forward(req, resp);



    }
}
