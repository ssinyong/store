package org.example.store.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.example.store.common.ConnectionUtil;
import org.example.store.vo.AniVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Log4j2
public enum AniDAO {
    INSTANCE;

    public List<AniVO> list() throws Exception{

        log.info("list");

        String query = """
            select
                *
            from
                tbl_ani
            order by
                ano desc
        """;

        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        @Cleanup ResultSet rs = ps.executeQuery();

        ArrayList<AniVO> list = new ArrayList<>();

        while (rs.next()){
            AniVO vo = AniVO.builder()
                    .ano(rs.getInt("ano"))
                    .aname(rs.getString("aname"))
                    .build();

            list.add(vo);
        }
               return list;
    }
}