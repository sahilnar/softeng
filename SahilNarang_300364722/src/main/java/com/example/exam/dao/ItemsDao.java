package com.example.exam.dao;

import com.example.exam.model.Salesman;
import com.example.exam.model.Items;
import com.example.exam.model.Items;
import com.example.exam.model.Salesman;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ItemsDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Salesman> findAll() {
        String query = "SELECT * FROM salesman";
        return jdbcTemplate.query(query, (rs, row) ->
                Salesman.builder()
                        .id(rs.getInt(1))
                        .amount(rs.getDouble(2))
                        .date(rs.getDate(3))
                        .item(rs.getString(4))
                        .name(rs.getString(5))
                        .build()
        );
    }

    public List<Items> getCategories() {
        String sql = "SELECT * FROM items";
        return jdbcTemplate.query(sql, (rs, row) ->
                Items.builder()
                        .itemdesc(rs.getString(1))
                        .build());
    }
}
