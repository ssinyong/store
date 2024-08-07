package org.example.store.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.example.store.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

@Log4j2
public enum OrderDAO {

    INSTANCE;

    public void insertOrder(Integer[] mnoArr) throws Exception{

        //주문 테이블에 insert
        String sql = "insert into tbl_order(state) values('대기')";

        String sql2 = "insert into tbl_order_detail (ono, mno, qty) values (last_insert_id(),?,1)";

        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();


        con.setAutoCommit(false);

        @Cleanup PreparedStatement ps = con.prepareStatement(sql);

        int orderInsert = ps.executeUpdate();


        //mnoArr만큼 루프 돌면서 insert 주문 상세 추가
        for(Integer mno : mnoArr){
            ps = con.prepareStatement(sql2);
            ps.setInt(1, mno);
            int count = ps.executeUpdate();
            log.info("count: " + count);
            ps.close();
        }

        con.commit();
        con.setAutoCommit(true);

    }
}
