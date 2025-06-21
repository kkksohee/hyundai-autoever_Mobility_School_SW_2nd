package com.hd.sample_jpa_mysql_0605.dao;

import com.hd.sample_jpa_mysql_0605.dto.MemberResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberDao {
    private final JdbcTemplate jdbcTemplate; //쿼리 관련 메서드들 포함, 연결 관련 된 것
    //전체 조회
    private static final String SELECT_ALL = "select *from member";

//    public List<MemberResDto> findAll(){
//        return jdbcTemplate.query(SELECT_ALL,new MemberRowMapper());
//    }
//    private static class MemberRowMapper implements RowMapper<MemberResDto> {
//        public MemberResDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//            return new MemberResDto( //DB의 컬럼명
//                    rs.getString("email"),
//                    rs.getString("name"),
//                    rs.getString("pwd"),
//                    rs.getString("image"),
//                    rs.getTimestamp("reg_date").toLocalDateTime()
//            );
//        }
//    }
}
