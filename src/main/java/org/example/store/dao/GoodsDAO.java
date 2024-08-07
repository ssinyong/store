package org.example.store.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.example.store.common.ConnectionUtil;
import org.example.store.vo.GoodsVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum GoodsDAO {
    INSTANCE;

    public List<GoodsVO> list(Integer ano, int cno) throws Exception{

        log.info("list");

        String query = """
             select
                mno,
                mname,
                mprice,
                mquantity,
                img1,
                img2,
                sell
             from
                 tbl_merchandise
             where 
                 ano=? and cno=?

             order by
                 mno
             """;

        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, ano);
        ps.setInt(2, cno);
        @Cleanup ResultSet rs = ps.executeQuery();

        ArrayList<GoodsVO> list = new ArrayList<>();

        while (rs.next()) {
            GoodsVO vo = GoodsVO.builder()
                    .mno(rs.getInt("mno"))
                    .mname(rs.getString("mname"))
                    .mprice(rs.getInt("mprice"))
                    .mquantity(rs.getInt("mquantity"))
                    .img1(rs.getString("img1"))
                    .img2(rs.getString("img2"))
                    .sell(rs.getBoolean("sell"))
                    .build();

            list.add(vo);
        }

        return list;

    }

    public GoodsVO select(Integer mno) throws Exception{
        String query = """
             select
                mno,
                mname,
                mprice,
                mquantity,
                img1,
                img2,
                sell
             from
                 tbl_merchandise
             where 
                 mno=? 
             """;
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, mno);
        @Cleanup ResultSet rs = ps.executeQuery();

        GoodsVO vo= null;

        while (rs.next()) {
            vo = GoodsVO.builder()
                    .mno(rs.getInt("mno"))
                    .mname(rs.getString("mname"))
                    .mprice(rs.getInt("mprice"))
                    .mquantity(rs.getInt("mquantity"))
                    .img1(rs.getString("img1"))
                    .img2(rs.getString("img2"))
                    .sell(rs.getBoolean("sell"))
                    .build();
        }
        return vo;
    }

    public List<GoodsVO> getWantedList(List<Integer> wanted)throws Exception {

        String queryPrefix = "select * from tbl_merchandise where mno IN (";

        String result = wanted.stream()
                .map(n -> "?") // 각 요소를 "?"로 변환
                .collect(Collectors.joining(",")); // 쉼표로 결합

        String query = queryPrefix + result +" ) ";

        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);

        int idx = 1;

        for (Integer mno : wanted) {
            ps.setInt(idx++, mno);
        }

        @Cleanup ResultSet rs = ps.executeQuery();

        ArrayList<GoodsVO> list = new ArrayList<>();

        while (rs.next()) {
            GoodsVO vo = GoodsVO.builder()
                    .mno(rs.getInt("mno"))
                    .mname(rs.getString("mname"))
                    .mprice(rs.getInt("mprice"))
                    .mquantity(rs.getInt("mquantity"))
                    .img1(rs.getString("img1"))
                    .img2(rs.getString("img2"))
                    .sell(rs.getBoolean("sell"))
                    .build();

            list.add(vo);
        }

        return list;



    }

}
